package com.bitacademy.svc;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.dao.GoodDAO;
import com.bitacademy.vo.Good;

@Controller
public class GoodService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("goodDAO")
	private GoodDAO goodDAO;

	@Inject
	@Named("fileRename")
	private FileRename fileRename;

	// 물건 전체 리스트를 들고 viewGoodList로 이동
	@RequestMapping("/viewGoodList.do")
	public ModelAndView viewGoodList()
	{
		mav.addObject("goodList", goodDAO.findAll());
		mav.setViewName("/viewGoodList.jsp");
		return mav;
	}

	// 사용자가 원하는 물건 1개의 정보를 가지고 viewGood로 이동
	@RequestMapping("/viewGood.do")
	public ModelAndView viewGood(Long gnum)
	{
		mav.addObject("good", goodDAO.findOne(gnum));
		mav.setViewName("/viewGood.jsp");
		return mav;
	}

	// addGoodForm 이동
	@RequestMapping("/addGoodForm.do")
	public String addGoodForm()
	{
		return "/addGoodForm.jsp";
	}

	// 물건을 저장하고 물건 전체 리스트로 이동..?? 물건 한개 리스트로 이동하는게 아니고?
	@RequestMapping("/addGood.do")
	public ModelAndView addGood(Good good, @RequestParam("uploadFile") MultipartFile file,HttpSession session) throws IllegalStateException, IOException
	{
		// uploadFile이 있는 지 없는 지 체크
		// file != null / spring 2.x
		// file.isEmpty() == false / spring 3.x 이상
		// 그래서 둘 다 조건문에 넣어 준 것이다.
		if (file != null && file.isEmpty() == false)
		{
			// 업로드한 파일이 저장될 폴더 경로
			String savePath =  "C:/Users/BIT/workspace/exam_20170221/WebContent/photo";
			// 업로드할 파일의 진짜 이름
			String originName = file.getOriginalFilename(); // file.getName()하면 file의 내가 주어준 가짜이름을 가져와버린다. 화난다 
			File waitUploadFile = new File(savePath+"/"+originName);
			System.out.println(waitUploadFile.getName());
			// 파일 중복이름있는 지 딴데 가서 확인하고 그걸로 바꿔치기함
			waitUploadFile = fileRename.rename(waitUploadFile);
			
			file.transferTo(waitUploadFile);
			// 이미지 이름을 good에 넣어주기
			good.setImg(waitUploadFile.getName());
			
			// 문제 6 구현
			// 톰캣 리얼 경로 받기
			String realPath = session.getServletContext().getRealPath("photo");
			// 리얼 경로로 된 File 객체 만들기
			File realPathFile = new File(realPath+"/"+waitUploadFile.getName());
			// 파일 복사
			// waitUploadFile를 복사해서 realPathFile경로에 붙여넣기
			FileUtils.copyFile(waitUploadFile, realPathFile);
			
		}

		// 데이터가 들어간 good을 DB에 저장
		goodDAO.save(good);
		
		mav.setViewName("redirect:/viewGoodList.do"); // 안되면 forward해봐
		return mav;
	}

}

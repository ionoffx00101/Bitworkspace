package com.bitacademy.good;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.util.FileRename;
/*
 * 물건 전체조회,물건조회, 물건추가, 물건수정, 물건 삭제를 처리할 클래스
	컨트롤러 클래스 설정 필요
 */
@Controller
public class GoodService {
	/*
	 ModelAndView 타입의 속성
	주입받도록 설정
	주입 받는 Scope 은 request 로 각 사용자 별로 실행할때마다 각각의 객체를 주입 받도록 설정할것
    * */
	@Inject
	@Named("mav")	
	private ModelAndView mav;
	//GoodDAO 객체를 주입 받도록 설정
	@Autowired
	private GoodDAO goodDAO;
	/*
	 * 같은 이름의 파일이 존재 했을 때 파일명에 번호를 붙이는 객체
		FileRename 클래스에 주입 받을수 있도록 설정
		GoodService의 속성에 주입 받도록 설정 

	 */
	@Autowired
	FileRename fileRename;
	
	@RequestMapping("/viewGoodList.do")
	public ModelAndView viewGoodList() {
		/*
		 * 전체 물건정보를 조회해서
			JSP 로 전송하도록 설정하고
			viewGoodList.jsp로 이동
		 */
		List<Good> goodList = goodDAO.findAll();
		mav.addObject("GOOD_LIST", goodList);
		mav.setViewName("/good/viewGoodList.jsp");
		return mav;
	}
	/*
	 * 물건 1개를 조회하는 메서드
		매개변수 gnum에 조회하고자 하는 물건 번호가 저장되 있음

	 */
	@RequestMapping("/viewGood.do")
	public ModelAndView viewGood(Long gnum) {
		/*
		 * goodDAO의 메서드를 이용해서 gnum이 일치하는 물건정보를 조회하고
			조회한 물건 정보를 JSP로 전송하도록 설정
			viewGood.jsp 로 이동
		 */
		Good good = goodDAO.findOne(gnum);
		mav.addObject("GOOD", good);
		mav.setViewName("/good/viewGood.jsp");
		return mav;
	}
	/*
	 * 물건 추가 화면으로 이동
		/addGoodForm.do 일때 실행되도록 설정 필요
		addGoodForm.jsp 로 페이지 이동
	 */
	@RequestMapping("/addGoodForm.do")
	public String addGoodForm(){
		return "/good/addGoodForm.jsp";
	}
	/*
	 * 업로드한 물건 이미지를 저장하고 물건정보를 데이터베이스에 저장하는 메서드
		/addGood.do 일때 실행되도록 설정 필요
업로드된 이미지 파일의 정보가 매개변수 file에 저장되도록 @RequestParam 설정 필요
	 */
	@RequestMapping("/addGood.do")
	public ModelAndView addGood(Good good,
			@RequestParam("upImg")MultipartFile file, HttpSession session) throws Exception, IOException{
		//1.업로드한 파일이 존재 한다면 file!=null 그리고 (&&)  file.isEmpty()==false
		if(file!=null && file.isEmpty()==false){
			//1.1.업로드한 물건 이미지를  저장할 폴더명 C://이클립스워크스페이스/exam_20170221/WebContent/photo 폴더의 경로를 String 타입 변수에 저장
			String uploadPath="C:/JavaWorkspace2/result_20170221/WebContent/photo";
			//1.2 업로드한 파일의 원래 이름을 변수에 저장
			String originalFileName=file.getOriginalFilename();
			//1.3 1.1의 경로와 1.2의 파일명을 저장하고 있는 File 객체 생성
			File uploadFile = new File(uploadPath+"/"+originalFileName);
			//1.4 1.3과 같은 이름의 파일이 존재한다면  파일명 뒤에 번호를 붙이도록 RenameFile 객체의 rename 메서드를 호출해서 리턴된 값을 1.3 변수에 저장
			uploadFile=fileRename.rename(uploadFile);
			//1.5 파일을 1.4에 저장된 경로와 파일명으로 이동
			file.transferTo(uploadFile);
			//1.5 매개변수 good의 img 속성에 업로드한 파일의 이름을 대입한다. 파일의 이름은 1.4객체.getName()
			good.setImg(uploadFile.getName());
			/*
			 * 실행중에 톰캣서버가 photo 폴더의 파일을 보관하는 폴더 
				(서버를 재시작하면 파일은 삭제되고 워크스페이스\프로젝트\..\photo 폴더의 내용으로 갱신됨 -임시폴더)의 경로를 변수에 저장) 를 String 변수에 저장

			 */
			
			String realPath=
					session.getServletContext().getRealPath("photo");
			//1.6의 경로와 업로드한 파일 이름을 포함하는 File객체를 생성해서 File 변수에 저장
			File uploadFile2=new File(realPath+"/"+uploadFile.getName());
			//1.6폴더로 파일을 복사
			FileUtils.copyFile(uploadFile, uploadFile2);
		}
		
		goodDAO.save(good);
		
		mav.setViewName("redirect:/viewGoodList.do");
		return mav;
	}
}

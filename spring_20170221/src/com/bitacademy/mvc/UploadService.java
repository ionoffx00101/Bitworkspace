package com.bitacademy.mvc;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
//이미 오리지날 이름과 같은 이름의 파일이 있으면 번호를 붙여서 구분되게 만들어야한다.
// 번호 붙은 새 이름을 부여한 후 그 이름으로 저장
// 이미 있는 번호면 그 다음 번호.. 그런 식임
// 그냥 날짜로 해도 편하지 않을까 크킄 
// 난수 6자리로 설정해도 ㄱㅊ겠 아니다 설정하는게 더 귀찮겠다 

// 내가 저장하려는 폴더에 있는 파일 목록 이름들을 다 알아내야하는 것 같다.
// DB연동 빨리 되었으면 좋겠다 너므 귀찮다 DB검색해서 알아내는게 최고다
// DB검색하는 것도 하이버로 바뀌고 쉬워졌다 findOne()하면 된다. ㅎ

// 파일이름.확장자명
// lastIndexOf(".")를 이용해서 확장자와 파일이름의 경계를 찾는다.
// 0부터 끝에서부터 찾는 .의 위치까지가 이름의 길이다.

@Controller
public class UploadService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;
	
	@Inject
	@Named("fileRename")
	private FileRename fileRename;

	@RequestMapping("/upload.do")
	public ModelAndView upload(Board board, @RequestParam("up") MultipartFile file) throws Exception
	{
		System.out.println("board=" + board);
		System.out.println("임시 파일 정보:" + file);
		String originalFileName = file.getOriginalFilename();
		System.out.println("원래 파일의 이름=" + originalFileName);
		String movePath = "C:/uploadFolder";
		String movePathAndName = movePath + "/" + originalFileName;
		File moveFile = new File(movePathAndName);
		// 같은 이름이 있으면 바뀌어서 그 자리로 들어감 ㅎㅎ..
		moveFile=fileRename.rename(moveFile);
		
		file.transferTo(moveFile);
		mav.setViewName("hello.jsp");
		mav.addObject("MSG", "파일 업로드 완료");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
		return mav;
	}
}

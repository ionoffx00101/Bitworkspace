package com.bitacademy.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("fileRename")
	private FileRename fileRename;

	// HttpServletResponse response
	// response는 stream(데이터 통로)를 이용하기 위해서 받는 것 뿐이다.
	// 그래서 response.getOutputStream 으로 이용하는 것이ㅏ.
	// 다른 곳에선 안 씀 ㅇㅇ
	@RequestMapping("/download.do")
	public void download(HttpServletResponse response) throws Exception
	{
		// 브라우저마다 안되는 브라우저가 있을 수있다.
		response.setContentType("text/plain;charset=UTF-8");
		
		// 파일명이 한글일 경우에는 문제가 또 생긴다.
		String filename = "easy.jpg";
		String encodingFileName = URLEncoder.encode(filename,"UTF-8");
		
		// response의 헤더를 설정해줘야한다.
		response.setHeader("Content-Disposition", "attachment;filename="+encodingFileName);
		

		// 다운 받을 파일 객체 만들어주기
		File downFile = new File("C:/uploadFolder/easy.jpg");
		// 파일 크기 리턴
		long fileSize = downFile.length();

		// 파일 크기만큼 byte배열
		byte[] fileContent = new byte[(int) fileSize]; // int형으로 byte에 넣어줄수 있다
		// 다운 받을 파일을 읽어서 fileContent에 파일을 저장해줄 스트림 객체
		FileInputStream fi = new FileInputStream(downFile);
		// downFile 읽어서 내용을 fileContent에 저장
		fi.read(fileContent);

		// out = toClient.. 아니왜 객체명 다르게 썼냐
		OutputStream out = response.getOutputStream();
		out.write(fileContent); // out.write(byte[] b);
		out.flush();
		out.close();
		fi.close();
		// 열린 스트림 다 꺼주기
		// 세상이 좋아져서 아무일도 안 오고 3초뒤쯤 다 디스패쳐서블렛이 자동으로 close시키긴 한다는데
		// 그래도 일 덜어주는게 나으니까 close 시켜주는 것이다.
		// 그래서 경고가 아니고 주의 표시로 뜨는 것 같다.

		// 다운로드 한 경우에는 페이지 이동을 할 수는 없다
		// 둘 중 하나만 할 수 있다.
		// 그래서 다운로드 페이지는 리턴 타입이 void다. 
		// mav.setViewName("hello.jsp");
		// return mav;
	}
}

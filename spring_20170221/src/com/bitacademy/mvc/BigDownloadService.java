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
public class BigDownloadService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("fileRename")
	private FileRename fileRename;

	@RequestMapping("/bigdownload.do")
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
		
		// 큰 사이즈의 파일을 받기 위한 노오력
		// 1메가씩 1메가씩 쪼갠 후 반복해서 보내는 것이다.
		// 1메가가 적으면 다른 단위로 바꾸면 되는 것이다 그렇다 
		byte[] fileContent = new byte[1024];
		FileInputStream fi = new FileInputStream(downFile);
		// response한테 클라이언트에게 보낼 통로를 가져온다
		OutputStream toClient = response.getOutputStream();
		
		int dataSize = 0; // 얼마나 읽는지 궁금하니까 체크용으로 넣어보는 것이다.
		
		while ((dataSize=fi.read(fileContent))!=-1) // 바이트 배열이 끝날때까지 반복시킨다. 돌리고 1메가 빼고 돌리고 1메가 빠지고 
		{
			toClient.write(fileContent,0,dataSize); // 쓴다
			toClient.flush();            // 배출한다
		}
		toClient.close();                // 끈다
		fi.close();                      // 끈다

		System.out.println(dataSize);
	}
}

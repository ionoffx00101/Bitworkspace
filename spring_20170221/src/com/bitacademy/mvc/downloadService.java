package com.bitacademy.mvc;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class downloadService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("fileRename")
	private FileRename fileRename;

	@RequestMapping("/download.do")
	public ModelAndView download(HttpServletResponse response) throws Exception
	{
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
		
		OutputStream out = response.getOutputStream();
		out.write(fileContent); // out.write(byte[] b);
		out.flush();
		out.close();
		fi.close();
		
		return mav;
	}
}

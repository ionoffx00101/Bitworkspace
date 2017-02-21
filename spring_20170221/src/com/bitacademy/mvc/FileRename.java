package com.bitacademy.mvc;

import java.io.File;

import org.springframework.stereotype.Component;

// 이 클래스는 싱글톤입니다.
@Component("fileRename")
public class FileRename
{
	public File rename(File newFile)
	{
		if (newFile.exists() == false)
		{
			return newFile;
		}
		// 새로 업로드된 파일의 이름을 가져온다
		String name = newFile.getName();
		// 새로 업로드된 파일의 이름에서 .위치를 찾아낸다
		int dotIndex = name.lastIndexOf(".");
		// body와 ext 스트링 속성의 비어있는 객체를 만들어둔다.
		String body = "";
		String ext = "";
		//.위치가 -1이 아닐때 > 이름이 있을때 실행한다는 말인가
		// 아 확장자가 있고 없고를 확인하는 거구나
		if (dotIndex != -1)
		{
			body = name.substring(0, dotIndex);
			ext = name.substring(dotIndex);
		}
		else
		{
			body = name;
		}
		int count = 0;

		while (newFile.exists())
		{
			count++;
			String newName = body + count + ext;
			newFile = new File(newFile.getParent(), newName);
		}
		return newFile;
	}
}

package com.coffee.util;

import java.io.File;

import org.springframework.stereotype.Component;

@Component(value="fileRename")
public class FileRename {
	public File rename(File newFile){
		if(newFile.exists()==false){
			return newFile;
		}
		
		String name=newFile.getName();
		int dotIndex=name.lastIndexOf(".");
		String body="";
		String ext="";
		if(dotIndex!=-1){
			body=name.substring(0,dotIndex);
			ext=name.substring(dotIndex);
		}else{
			body=name;
		}
		int count=0;
		while(newFile.exists()==true){
			count++;
			String newName=body+count+ext;
			newFile=new File(newFile.getParent(),
					newName);
		}
		
		
		return newFile;
	}
}

package bitjava.day01_06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterStream
{

	public static void main(String[] args) throws IOException
	{
		PrintWriter out = new PrintWriter(new FileWriter("Printf.txt"));
		//out.printf("������ %d/%d(%c) %s ������ ��", 1, 6, '��', "java args");

		out.println();
		
		//out.print("�����");
		out.close();
	}

}

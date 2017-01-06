package bitjava.day01_06.SocketEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain
{

	public static void main(String[] args)
	{
		new Client("localhost");
	}

}

class Client
{
	Socket socket = null;
	static final int PORT = 3000;

	Scanner kb = new Scanner(System.in);

	InputStream in;
	OutputStream out;
	BufferedReader reader;
	PrintWriter writer;

	String strSendData;
	String strReceiveData;

	public Client(String strMyIpAddress)
	{
		try
		{
			System.out.println("Ŭ���̾�Ʈ�� ������ ������");
			//3. ���� ����
			//4. ���� ������ ���� �õ�
			socket = new Socket(strMyIpAddress, PORT);

			//6. �������κ��� ��ǲ��Ʈ���� �ƿ�ǲ ��Ʈ���� �̿��� ���
			out = socket.getOutputStream();
			in = socket.getInputStream();
			writer = new PrintWriter(new OutputStreamWriter(out));
			reader = new BufferedReader(new InputStreamReader(in));

			System.out.print("input : ");

			//7. ��ǲ��Ʈ���� �ƿ�ǲ ��Ʈ���� �̿��� ���
			//8. ������ ������������ ���
			while ((strSendData = kb.nextLine()) != null)
			{
				writer.println(strSendData);
				writer.flush();

				if (strSendData.equals("quit"))
				{
					break;
				}
				strReceiveData = strSendData;

		
					System.out.println(socket.getInetAddress() + " : " + strReceiveData);
					System.out.print("input : ");
			
			}
			//9. ���� ����
			socket.close();
			in.close();
			out.close();
			reader.close();
			writer.close();
		} catch (Exception e)
		{
			System.out.println("error");
			//System.out.print("input : ");
		}
	}

}
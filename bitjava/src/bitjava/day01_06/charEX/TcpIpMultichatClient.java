package bitjava.day01_06.charEX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class TcpIpMultichatClient
{
	public static final int PORT = 3000;
	public static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("USAGE : TcpIpMultichatClient ��ȭ��");
			System.exit(-1);
		}
		try
		{
			// 3 ���� ����
			// 4 ���� ���� > ���� ����
			// ���ӵǸ� ���� �� / ������ �ȵǸ� ���� �޼���
			Socket socket = new Socket(SERVER_IP, PORT);

			Thread sender = new ClientSender(socket, args[0]);
			Thread receive = new ClientReceiver(socket);

			sender.start();
			receive.start();

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

class ClientSender extends Thread
{
	Socket socket;
	PrintWriter writer;
	String name;

	ClientSender(Socket socket, String name)
	{
		this.socket = socket;
		this.name = name;
		try
		{
			// 6. �������� ���� ��ǲ��Ʈ�� �ƿ�ǲ ��Ʈ���� ����
			writer = new PrintWriter(socket.getOutputStream());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		Scanner kb = new Scanner(System.in);
		if (writer != null)
		{
			writer.println(name);
			writer.flush();
		}
		//7 ��ǲ �ƿ�ǲ�� �̿��� ���
		//8 ������ ������������
		while (writer != null)
		{
			writer.println(name + " : " + kb.nextLine());
			writer.flush();
		}
		// 9 socket close
		try
		{
			socket.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		kb.close();
	}

}

class ClientReceiver extends Thread
{
	Socket socket;
	BufferedReader reader;

	public ClientReceiver(Socket socket)
	{
		this.socket = socket;
		try
		{
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run()
	{
		//7 ��ǲ �ƿ�ǲ�� �̿��� ���
		//8 ���� ���������� ��� 
		while (reader != null)
		{
			try
			{
				System.out.println(reader.readLine());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			// 9. ���� ����
			try
			{
				socket.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
	}
}
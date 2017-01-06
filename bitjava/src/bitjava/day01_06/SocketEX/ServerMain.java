package bitjava.day01_06.SocketEX;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{

	public static void main(String[] args)
	{
		new Server();
	}

}

class Server
{
	static final int PORT = 3000;
	ServerSocket serverSocket = null;
	Socket socket = null;

	InputStream in;
	OutputStream out;
	BufferedReader reader;
	PrintWriter writer;

	String strSendData;
	String strReceiveData;

	public Server()
	{
		try
		{
			// 1. ���� ���� ����
			serverSocket = new ServerSocket(PORT); // �� ���� ���� ����
			System.out.println("������ Ŭ���̾�Ʈ�� ������ ��ٸ�");

			// 2. ���� ������ accept() . Ŭ���̾�Ʈ�� ������ ���������� ���
			// 5. Ŭ���̾�Ʈ�� ���� �����ϸ� �׼�Ʈ�� Ŭ���̾�Ʈ�� ������ ������
			socket = serverSocket.accept(); // ������ �������� ����Ʈ�� �������� ���� ����
			System.out.println(socket.getInetAddress() + "���� ���� ��û");

			// 6. �������κ��� ��ǲ ��Ʈ���� �ƿ�ǲ��Ʈ���� ����
			in = socket.getInputStream();
			out = socket.getOutputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			writer = new PrintWriter(new OutputStreamWriter(out));

			// 7. ��ǲ ��Ʈ���� �ƿ�ǲ ��Ʈ���� �̿��Ͽ� ���
			// 8 ������ ������������ ���
			while ((strReceiveData =reader.readLine()) != null)
			{
				if (strReceiveData.equals("quit"))
					break;
				writer.println(strReceiveData);
				writer.flush();

			}
			// 9. ���� ����
			socket.close();
			in.close();
			out.close();
			reader.close();
			writer.close();
		} catch (Exception e)
		{
			e.printStackTrace();

		}

	}
}
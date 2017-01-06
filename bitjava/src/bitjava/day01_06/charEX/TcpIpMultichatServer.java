package bitjava.day01_06.charEX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class TcpIpMultichatServer
{
	public static final int PORT = 3000;
	public static HashMap<String, PrintWriter> clients;

	public TcpIpMultichatServer()
	{
		clients = new HashMap<String, PrintWriter>();

		// 1. ���� ���� ����
		ServerSocket serverSocket = null;
		Socket socket = null;
		try
		{
			serverSocket = new ServerSocket(PORT);
			System.out.println("��������");
			while (true)
			{
				// 2. ���� ������ ����Ʈ ���� �� ��� .. Ŭ���̾�Ʈ�� �����Ҷ�����..
				// 5. Ŭ���̾�Ʈ�� ������ �õ��ϸ� ����Ʈ �޼ҵ尡 Ŭ���̾�Ʈ�� ������ ������
				socket = serverSocket.accept();
				System.out.println(serverSocket.getInetAddress() + " : " + socket.getPort());

				serverReceiver thread = new serverReceiver(socket, clients);
				thread.start();
			}

		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args)
	{
		new TcpIpMultichatServer();
	}

}

class serverReceiver extends Thread
{
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	HashMap<String, PrintWriter> clients;

	public serverReceiver(Socket socket, HashMap<String, PrintWriter> clients)
	{

		this.socket = socket;
		this.clients = clients;
		try
		{
			// 6. �������κ��� ��ǲ��Ʈ�� �ƿ�ǲ��Ʈ���� ����
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	void sendToAll(String msg)
	{
		Iterator<String> itr = clients.keySet().iterator();
		while (itr.hasNext())
		{
			PrintWriter writer = clients.get(itr.next());
			writer.println(msg);
			writer.flush();
		}
	}

	@Override
	public void run()
	{
		String name = "";

		try
		{
			name = reader.readLine();

			clients.put("name", writer);
			sendToAll(name + "���� ����");
			System.out.println(clients.size() + "�� ������");

			// 7. ��ǲ��Ʈ���� �ƿ�ǲ��Ʈ���� �̿��� ���
			// 8. ������ ������������ ���
			while (reader != null)
			{
				sendToAll(reader.readLine());
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			sendToAll(name + "���� ����");
			clients.remove(name);
			System.out.println(socket.getInetAddress() + " : " + socket.getPort() + "���� ����");
			System.out.println(clients.size() + "�� ������");
		}
		try
		{
			// 9. ���� ����
			socket.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
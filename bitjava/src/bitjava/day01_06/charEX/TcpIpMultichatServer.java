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

		// 1. 서버 소켓 생성
		ServerSocket serverSocket = null;
		Socket socket = null;
		try
		{
			serverSocket = new ServerSocket(PORT);
			System.out.println("서버시작");
			while (true)
			{
				// 2. 서버 소켓의 엑셉트 실행 및 대기 .. 클라이언트가 접속할때까지..
				// 5. 클라이언트가 접속을 시도하면 엑셉트 메소드가 클라이언트의 소켓을 리턴함
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
			// 6. 소켓으로부터 인풋스트림 아웃풋스트림을 얻음
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
			sendToAll(name + "님이 들어옴");
			System.out.println(clients.size() + "명 접속중");

			// 7. 인풋스트림과 아웃풋스트림을 이용한 통신
			// 8. 연결이 끊어질때까지 통신
			while (reader != null)
			{
				sendToAll(reader.readLine());
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			sendToAll(name + "님이 나감");
			clients.remove(name);
			System.out.println(socket.getInetAddress() + " : " + socket.getPort() + "에서 종료");
			System.out.println(clients.size() + "명 접속중");
		}
		try
		{
			// 9. 소켓 닫음
			socket.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
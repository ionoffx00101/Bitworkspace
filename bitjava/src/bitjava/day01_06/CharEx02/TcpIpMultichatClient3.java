package bitjava.day01_06.CharEx02;

/**
 * @file name : TcpIpMultichatClient.java
 * @date : 2013. 9. 29.
 * @discription : ä�� ���α׷� - Ŭ���̾�Ʈ
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

class ClientSender extends Thread {
    Socket socket;
	PrintWriter writer;
    String name;
    
    ClientSender(Socket socket, String name) {
        this.socket = socket;
        try {
        	//************* 6. Socket���κ��� InputStream, OutputStream�� ����
        	writer = new PrintWriter(socket.getOutputStream());
            this.name = name;
        } catch (Exception e) {
        }
    }
    @Override
    public void run() {
        Scanner kb = new Scanner(System.in);
        if (writer != null) {
            writer.println(name);
            writer.flush();
        }
        //***************** 7. InputStream, OutputStream�� �̿��� ���
    	//***************** 8. ������ ������ ������ ���
        while (writer != null) {
        	writer.println("[" + name + "]" + kb.nextLine());
            writer.flush();
        }
        kb.close();
        //***************** 9. Socket close()
        try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    } 
}

class ClientReceiver extends Thread {
    Socket socket;
    BufferedReader reader;
    ClientReceiver(Socket socket) {
        this.socket = socket;
        try {
        	//************* 6. Socket���κ��� InputStream, OutputStream�� ����
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
        }
    }
    @Override
    public void run() {
        //***************** 7. InputStream, OutputStream�� �̿��� ���
    	//***************** 8. ������ ������ ������ ���
    	while (reader != null) {
            try {
                System.out.println(reader.readLine());
            } catch (IOException e) {
            }
        }
    	//***************** 9. Socket close()
        try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}

public class TcpIpMultichatClient3 {
	public static final int PORT = 3000;
	public static final String SERVER_IP = "127.0.0.1";
	
    public static void main(String args[]) {

    	if (args.length != 1) {
            System.out.println("USAGE: java TcpIpMultichatClient ��ȭ��");
            System.exit(0);
        }
        
    	try {
    		//****************** 3. Socket ����
    		//****************** 4. Socket ���� -> ������ �õ� (���� ����). ���ӵǸ� ������ / ���ӾȵǸ� Exception.
            Socket socket = new Socket(SERVER_IP, PORT);

            System.out.println("������ ����Ǿ����ϴ�.");

            Thread sender = new ClientSender(socket, args[0]);
            Thread receiver = new ClientReceiver(socket);
            
            sender.start();
            receiver.start();
        } catch (ConnectException e) {
            e.printStackTrace();
        } catch (Exception e) { }
    }
    
    
}
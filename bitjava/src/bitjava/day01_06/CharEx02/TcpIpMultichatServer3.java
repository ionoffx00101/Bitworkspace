package bitjava.day01_06.CharEx02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

class ServerReceiver extends Thread {
    Socket socket;
    BufferedReader reader;
    PrintWriter writer;
    HashMap<String, PrintWriter> clients;
    
    public ServerReceiver(Socket socket, HashMap<String, PrintWriter> clients) {
        this.socket = socket;
        this.clients = clients;
        try {
        	//********************** 6. Socket���κ��� InputStream, OutputStream �� ����.
        	reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
        }
    }
    void sendToAll(String msg) {
        Iterator<String> it = clients.keySet().iterator();
        while (it.hasNext()) {
            PrintWriter writer = clients.get(it.next());
            writer.println(msg);
            writer.flush();
        } 
    } 
    
    @Override
    public void run() {
        String name = "";
        try {
            //name = in.readUTF();
        	name = reader.readLine();

        	clients.put(name, writer);
            sendToAll("*** " + name + "���� �����̽��ϴ�. ***");
            System.out.println("*** ���� ���������� ���� " 
                    + clients.size() + "�Դϴ�. ***");
            
            //*********************** 7. InputStream�� OutputStream�� �̿��� ���
            //*********************** 8. ������ ������ ������ ���
            while (reader != null) {
            	sendToAll(reader.readLine());
            }
        } catch (IOException e) {
            // ignore
        } finally {
            sendToAll("*** " + name + "���� �����̽��ϴ�. ***");
            clients.remove(name);
            System.out.println("*** [" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "���� ������ �����Ͽ����ϴ�. ***");
            System.out.println("*** ���� ���������� ���� " + clients.size() + "�Դϴ�. ***");

        }
        
        try {
        	//*********************** 9. Socket�� close() ȣ��
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

    } 
} 

public class TcpIpMultichatServer3 {
	public static final int PORT = 3000;
	public static HashMap<String, PrintWriter> clients;
    public TcpIpMultichatServer3() {
        clients = new HashMap<String, PrintWriter>();
        //Collections.synchronizedMap(clients);
        
        //********************** 1. ServerSocket ����
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("������ ���۵Ǿ����ϴ�. \nŬ���̾�Ʈ�� ������ ��ٸ��ϴ�.");
            while (true) {
            	//************** 2. ServerSocket�� accept() ��� (Ŭ���̾�Ʈ�� ������ ������ ���)
            	//************** 5. Ŭ���̾�Ʈ�� ������ �õ��ϸ� accept() �޼ҵ尡 Ŭ���̾�Ʈ�� socket�� ��ȯ
            	socket = serverSocket.accept();
                System.out.println("[" + socket.getInetAddress() + ":"
                        + socket.getPort() + "]" + "���� �����Ͽ����ϴ�.");

                ServerReceiver thread = new ServerReceiver(socket, clients);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String args[]) {
        new TcpIpMultichatServer3();
    }
    
    
}
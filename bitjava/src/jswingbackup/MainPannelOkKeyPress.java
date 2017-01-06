package jswingbackup;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPannelOkKeyPress extends JFrame implements ActionListener, KeyListener
{
	// ���� ������
	JFrame mainFrame = new JFrame("");

	// ���� �г�
	JPanel gameFrame = new JPanel();

	//�����̳�
	Container container;

	//�簢�� ��ü ��Ʈ�� ��� JsonArr
	public JSONArray squreArr = new JSONArray();

	//�簢�� ��ü �ϳ��� ��� jsonObj
	public JSONObject squreObj;

	//�簢�� ��ü ���� ����  -- ��� �ɰͰ���.
	int squreCont;

	//Ÿ�̸� 
	Timer downtime;

	// ��ư �Ѱ�
	JButton startBtn = new JButton("start");

	public static void main(String[] args)
	{
		new MainPannelOkKeyPress(); // ���� �г� ����
	}

	public MainPannelOkKeyPress()
	{

		// ���� ������ ����
		mainFrame.setSize(600, 600); // ������ ũ�� ����
		mainFrame.setVisible(true); // ������ ���̰� ����
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���� ��ư ����

		// ���� ������ ��ġ ����
		Dimension frameSize = mainFrame.getSize(); // ���� ������ ũ�� ���ϱ�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ȭ�� ũ�� ���ϱ�

		mainFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // ����� ��ġ ����

		// �����̳� ����
		container = mainFrame.getContentPane();
		container.setLayout(null);

		// ��ŸƮ ��ư ��ġ ����
		startBtn.setSize(70, 30);
		startBtn.setLocation(350, 180);
		container.add(startBtn);

		// ��ŸƮ ��ư �̺�Ʈ ����
		startBtn.addActionListener(this);

		// ���� �г� ����
		gameFrame.setSize(300, 500);
		gameFrame.setLocation(5, 25);
		gameFrame.setVisible(true);
		gameFrame.setBackground(Color.white);
		container.add(gameFrame);

		// Ű ������ �̺�Ʈ ����
		mainFrame.addKeyListener(this); // this�� keyPressed�� ����Ŵ

	}

	//��ư,Ÿ�̸� �̺�Ʈ ó��
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//��ŸƮ ��ư ó��
		if (e.getSource().equals(startBtn))
		{
			//game ��ŸƮ �Լ� ����
			GameStart();
			mainFrame.requestFocusInWindow(); //Ű �������� ���� ��Ŀ���� ������ ��û�ؼ� ���� �޼ҵ�
		}

		//Ÿ�̸� ó��
		else if (e.getSource().equals(downtime))
		{
			//�ٿ� Ÿ�� �̶� ������ ������ ���� �簢�� �������� �Լ� ����
			//���� ������ �ٲ�� �޼ҵ�
			GameGo();
			
			
			
			
		} else
		{
			System.out.println("���� �߸� �Ǿ���" + e.getSource());

		}

	}

	//���� �����ϴ� �޼ҵ�1 - �ݺ����� ������ �޼ҵ带 �����ϰ� �гο� �ʿ��� ���� �߰��Ѵ�.
	public void GameStart()
	{

		//�簢�� ��ü���� ���� �迭�� ����, �� ��ü���� �ٸ� y���� ������ �����ؾ���

		//�簢�� ��ü ���ڼ���  -- ��� �ɰͰ���.
		squreCont = 1;

		//�� �簢�� ��ü �ִ� �޼ҵ�
		InputSqureArr();

		int squreY = 0;
		// while�� ������ ���� ��ü
		boolean end = false;
		
		
		
		
		
		
		downtime = new Timer(1000, this);

		//1�ʸ��� Ÿ�� ����
		downtime.start();

	}

	private void InputSqureArr()
	{
		squreObj = new JSONObject(); //Obj �ʱ�ȭ
		squreObj.put("squreNum", squreCont++); // �簢�� ��ü �з� ��ȣ..?????  -- ��� �ɰͰ���.
		squreObj.put("X", 120); //�簢���� X��
		squreObj.put("Y", 500); //�簢���� Y��
		squreObj.put("line", 0); //�簢���� ��� ���ο� �ִ� �� ��Ÿ���� �ǵ� ������ ���� ��ĭ�� �������ϱ� Y���� �����̶� ���� ����ؼ� ����� �͵� ��������
		squreObj.put("stopX", 300); //�簢���� ���� X��
		squreObj.put("stopY", 300); //�簢���� ���� Y��
		//ȸ�� ��
		squreObj.put("control", 1);//���� ���� ��� �ִ���
		squreArr.add(squreObj); //Arr�̿� �־���
	}

	//���� �г� �ٽ� �׷��ִ� �޼ҵ�
	public void regameFrame()
	{
		gameFrame.revalidate();
		gameFrame.repaint();
	}

	//���ӿ��� �ݺ��Ǵ� ������ ó���Ѵ�
	private void GameGo()
	{
		int X= Integer.parseInt(squreObj.get("X").toString()); // ���޾ƿ��� �� ��Ȯ�� �Ǹ� ������ ��
		int Y = Integer.parseInt(squreObj.get("Y").toString());

		// ���� ������ �� ���ϱ� Ű �����ʹ����� �� �ٲ��ֱ�

		//�����̴� �簢������ Y�� �����ֱ�
		if (squreObj.get("control").toString().equals("1"))
		{
			squreObj.replace("Y", Y -= 50);
		}

		// �簢���� �׸���
		System.out.println("Ÿ��" +X+","+ Y);

		// ȭ�� �ٽ� �׷��ֱ�9
		regameFrame();

		//Ÿ���� �����ֱ�if(���������)
		if (Y == 0)
		{
			downtime.stop();
			System.out.println("��");
		}

	}

	//�簢���� �׷��ִ� �޼ҵ� �߰� �ؾ���

	// Ű�� �޾Ƽ� ó���ϴ� �޼ҵ��
	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("keyPressed" + e.getKeyCode());
		squreMove(e.getKeyCode()); //obj�� ���� �������ϳ�..
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		//System.out.println("keyReleased"+e.getKeyCode());
	}

	// Ű�� �޾Ƽ� ó���ϴ� �޼ҵ�� ��

	// Ű �� �޾Ƽ� �簢�� �����̰� �ϴ� �޼ҵ�
	private void squreMove(int keyCode)
	{
		if (keyCode == 65)
		{
			//System.out.println("����");
			if (squreObj.get("control").toString().equals("1"))
			{
				int X= Integer.parseInt(squreObj.get("X").toString());
				squreObj.replace("X",X-10);
			}

		} else if (keyCode == 68)
		{
			//System.out.println("������");
			int X= Integer.parseInt(squreObj.get("X").toString());
			squreObj.replace("X",X+10);

		} else if (keyCode == 83)
		{
			//System.out.println("�Ʒ�");
			int Y= Integer.parseInt(squreObj.get("Y").toString());
			squreObj.replace("Y",Y-10);
		} else
		{
			//System.out.println("�ƹ��ų�");
		}
	}
}
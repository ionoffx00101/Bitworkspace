package jswingspilt;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class MainPannel extends JPanel implements ActionListener, KeyListener //jfram ����ϴ��� jpanel�� �ٲ�
{
	// ���� ������
	JFrame mainFrame = new JFrame("");

	GamePannel gamepannel; //= new GamePannel();

	//�����̳�
	Container container;

	// ��ư �Ѱ�
	JButton startBtn = new JButton("start");

	public static void main(String[] args)
	{
		new MainPannel(); // ���� �г� ����
	}

	public MainPannel()
	{
		gamepannel = new GamePannel();
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
		container.add(gamepannel);

		// Ű ������ �̺�Ʈ ����
		mainFrame.addKeyListener(this);
		// this�� keyPressed�� ����Ŵ

		/*DrawSqure drawSqure = new DrawSqure();
		mainFrame.add(drawSqure);*/
	}

	//��ư,Ÿ�̸� �̺�Ʈ ó��
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//��ŸƮ ��ư ó��
		if (e.getSource().equals(startBtn))
		{
			//game ��ŸƮ �Լ� ����

			gamepannel.GameStart();
			mainFrame.requestFocusInWindow(); //Ű �������� ���� ��Ŀ���� ������ ��û�ؼ� ���� �޼ҵ�
		}

		//Ÿ�̸� ó��
		else
		{
			System.out.println("���� �߸� �Ǿ���" + e.getSource());

		}

	}

	// Ű�� �޾Ƽ� ó���ϴ� �޼ҵ��
	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//System.out.println("main" + e.getKeyCode());
		gamepannel.squreMove(e.getKeyCode()); //obj�� ���� �������ϳ�..

	}

}
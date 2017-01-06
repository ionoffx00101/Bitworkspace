package jswingspilt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GamePannel extends JPanel implements ActionListener
{
	// ���� �г�
	//static JPanel gameFrame;

	//�簢�� ��ü ��Ʈ�� ��� JsonArr
	public JSONArray squreArr = new JSONArray();

	//�簢�� ��ü �ϳ��� ��� jsonObj
	public JSONObject squreObj;

	//�簢�� ��ü ���� ����  -- ��� �ɰͰ���. //�ʿ��Ѱ� ����.. �簢�� �з��� �ؾ��ϴµ� ��ȣ���� ���� �Ұ��ֳ�.  �̸� ��ü���� �������� �ϳ��� ������ ������, �ʿ��Ҷ� �� ��ü�� ���� �̾� ������..
	int squreCont;
	DrawSqure drawSqure = new DrawSqure();
	//Ÿ�̸� 
	Timer downtime;

	public GamePannel()
	
	{
		//DrawSqure drawSqure = new DrawSqure();
		this.setSize(300, 500);
		this.setLocation(5, 25);
		this.setVisible(true);
		this.setBackground(Color.white);
		
		//this.addKeyListener(this);
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
		this.removeAll();//gameFrame.removeAll();
		this.revalidate(); //gameFrame.revalidate();
		this.repaint(); //gameFrame.repaint();

	}

	//���ӿ��� �ݺ��Ǵ� ������ ó���Ѵ�
	private void GameGo()
	{
		Graphics g;
		int X = Integer.parseInt(squreObj.get("X").toString()); // ���޾ƿ��� �� ��Ȯ�� �Ǹ� ������ ��
		int Y = Integer.parseInt(squreObj.get("Y").toString());

		// ���� ������ �� ���ϱ� Ű �����ʹ����� �� �ٲ��ֱ�

		//�����̴� �簢������ Y�� �����ֱ�
		if (squreObj.get("control").toString().equals("1"))
		{
			squreObj.replace("Y", Y -= 50);
			// �簢���� �׸��� // ȭ�� �ٽ� �׷��ֱ�9
			this.add(drawSqure);
			regameFrame();

		}

		System.out.println("Ÿ��" + X + "," + Y);

		//Ÿ���� �����ֱ�if(���������)
		if (Y <= 0)
		{
			downtime.stop();
			System.out.println("��");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(downtime))
		{
			//�ٿ� Ÿ�� �̶� ������ ������ ���� �簢�� �������� �Լ� ����
			//���� ������ �ٲ�� �޼ҵ�
			GameGo();

		}
	}

	// Ű �� �޾Ƽ� �簢�� �����̰� �ϴ� �޼ҵ�
	void squreMove(int keyCode)
	{
		if (squreArr.size() > 0)
		{ //squreArr �ȿ� ��ü�� �Ѱ��� ���� Ű ������ ���� Ȱ��ȭ��
			if (keyCode == 65)
			{

				if (squreObj.get("control").toString().equals("1"))
				{
					//System.out.println("����");
					int X = Integer.parseInt(squreObj.get("X").toString());
					if (X >= 10)
					{ // X�� 0���Ϸ� �� �������̴� --���������� �ٲ����� game�������� Y������ �̵��Ÿ��� ���� ��, �׷����� X�� Y�� �̵��Ÿ� ����?�� ������ ����������� 
						squreObj.replace("X", X - 10);
					}
					// �簢�� �׸��� ȭ�� �ٽ� �׸���

					regameFrame();

				}
			} else if (keyCode == 68)
			{

				if (squreObj.get("control").toString().equals("1"))
				{
					//System.out.println("������");
					int X = Integer.parseInt(squreObj.get("X").toString());
					if (X <= 490)
					{ // X�� 490�̻�� �� �������̴� --���������� �ٲ����� game�������� Y��ũ�⿡�� �̵��Ÿ��� �� ��, �׷����� X�� Y�� �̵��Ÿ� ����?�� ������ ����������� 
						squreObj.replace("X", X + 10);
					}
					// �簢�� �׸��� ȭ�� �ٽ� �׸���

					regameFrame();

				}

			} else if (keyCode == 83)
			{
				if (squreObj.get("control").toString().equals("1"))
				{
					//System.out.println("�Ʒ�");
					int Y = Integer.parseInt(squreObj.get("Y").toString());
					squreObj.replace("Y", Y - 10);
				}
				// �簢�� �׸��� ȭ�� �ٽ� �׸���

				regameFrame();
			} else
			{
				//System.out.println("�ƹ��ų�");
			}
			
			//regameFrame(); // �ٽ� �׸���
		}//squreArr �ȿ� ��ü�� �Ѱ��� ���� Ű ������ ���� Ȱ��ȭ�� ��
	}


}
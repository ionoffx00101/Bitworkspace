package jswing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPannelOutGameGo extends JFrame implements ActionListener
{
	// 메인 프레임
	JFrame mainFrame = new JFrame("");

	// 게임 패널
	JPanel gameFrame = new JPanel();

	//컨테이너
	Container container;

	//게임 컨테이너

	// 버튼 한개
	JButton startBtn = new JButton("start");

	// 움직이는 사각형 하나.. 나중에 여기서 사라져야함

	public static void main(String[] args)
	{
		new MainPannelOutGameGo(); // 메인 패널 실행
	}

	public MainPannelOutGameGo()
	{
		// 메인 프레임 설정
		mainFrame.setSize(600, 600); // 프레임 크기 지정
		mainFrame.setVisible(true); // 프레임 보이게 설정
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료 버튼 설정

		// 메인 프레임 위치 설정
		Dimension frameSize = mainFrame.getSize(); // 메인 프레임 크기 구하기
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 화면 크기 구하기

		mainFrame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 가운데로 위치 설정

		// 컨테이너 설정
		container = mainFrame.getContentPane();
		container.setLayout(null);

		// 스타트 버튼 위치 설정
		startBtn.setSize(70, 30);
		startBtn.setLocation(350, 180);
		container.add(startBtn);

		// 스타트 버튼 이벤트 설정
		startBtn.addActionListener(this);

		// 게임 패널 설정
		gameFrame.setSize(300, 500);
		gameFrame.setLocation(5, 25);
		gameFrame.setVisible(true);
		gameFrame.setBackground(Color.white);
		container.add(gameFrame);
	}

	//버튼 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(startBtn))
		{
			//JOptionPane.showMessageDialog(this, "스타트 버튼");
			//game 스타트 함수 실행

			GameStart();

		}
	}

	//게임 시작하는 메소드
	public void GameStart()
	{

		JLabel startlabel = new JLabel("시작합니다..");

		startlabel.setSize(5, 25);
		startlabel.setLocation(100, 100);
		startlabel.setBackground(Color.red);
		gameFrame.add(startlabel);

		//다시 그려줌
		regameFrame(gameFrame);

		// 1초 뒤에 
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		//문자 삭제 > 안보임으로 설정해두었는데 아예 삭제하는게 나을 거같다. 근데 삭제하는 법도 있었나
		//startlabel.setVisible(false); 안된다 걍 시작이고 뭐고 빼버릴까봐

		//게임 실행
		new GameGo();

	}

	//게임 패널 다시 그려주는 메소드
	public void regameFrame(JPanel repaint)
	{
		repaint.revalidate();
		repaint.repaint();
	}

}

class GameGo extends MainPannelOutGameGo
{


	private void GameGo()
	{

		//사각형 객체들을 생성 배열로 생성, 그 객체마다 다른 y값을 가지게 설정해야함
		int squreY = 0;
		int[][] squArr = new int[1][4];
		for (int i = 0; i < squArr.length; i++)
		{
			squArr[i][0] = 250;
			squArr[i][1] = 0;
			squArr[i][2] = 50;
			squArr[i][3] = 50;
		}
		Graphics g = getGraphics();
		//g.drawRect(squArr[0][0], squArr[0][1], squArr[0][2], squArr[0][3]);
		g.drawRect(250, squreY, 50, 50);
		regameFrame(gameFrame);

		// while문 돌리기 위한 객체
		boolean end = false;

		//for나 while을 이용해서 게임 끝날때까지 반복시킴
		while (!end)
		{
			System.out.println("5"); //--------------------
			//다시 그려줌 밑으로 내려가야할듯
			//g.drawRect(squArr[0][0], squArr[0][1], squArr[0][2], squArr[0][3]);
			g.drawRect(250, squreY, 50, 50);
			//0.5초 뒤에 사각형 내려가는 것을 표현
			try
			{
				Thread.sleep(500);
				//사각형이 내려감!
				squreY += 100;

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			regameFrame(gameFrame);

			//게임 끝나는 조건 설정
			if (squreY > 700)
			{
				end = true;
			}

		}
	}
}
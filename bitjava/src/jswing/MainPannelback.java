package jswing;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class MainPannelback extends JFrame implements ActionListener, KeyListener //jfram 상속하던거 jpanel로 바꿈
{
	// 메인 프레임
	JFrame mainFrame = new JFrame("");

	// 게임 패널
	JPanel gameFrame = new JPanel();

	//컨테이너
	Container container;

	//사각형 객체 세트를 담는 JsonArr
	public JSONArray squreArr = new JSONArray();

	//사각형 객체 하나를 담는 jsonObj
	public JSONObject squreObj;

	//사각형 객체 숫자 세기  -- 없어도 될것같다.
	int squreCont;

	//타이머 
	Timer downtime;

	// 버튼 한개
	JButton startBtn = new JButton("start");

	public static void main(String[] args)
	{
		new MainPannelback(); // 메인 패널 실행
	}

	public MainPannelback()
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

		// 키 리스너 이벤트 설정
		mainFrame.addKeyListener(this); // this는 keyPressed를 가르킴

	}

	//버튼,타이머 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//스타트 버튼 처리
		if (e.getSource().equals(startBtn))
		{
			//game 스타트 함수 실행
			GameStart();
			mainFrame.requestFocusInWindow(); //키 프레스의 메인 포커스를 강제로 요청해서 얻어내는 메소드
		}

		//타이머 처리
		else if (e.getSource().equals(downtime))
		{
			//다운 타임 이랑 같은게 들어오면 게임 사각형 내려가는 함수 실행
			//게임 데이터 바뀌는 메소드
			GameGo();

		} else
		{
			System.out.println("무언가 잘못 되었다" + e.getSource());

		}

	}

	//게임 시작하는 메소드1 - 반복문을 돌리는 메소드를 실행하고 패널에 필요한 것을 추가한다.
	public void GameStart()
	{

		//사각형 객체들을 생성 배열로 생성, 그 객체마다 다른 y값을 가지게 설정해야함

		//사각형 객체 숫자세기  -- 없어도 될것같다.
		squreCont = 1;

		//새 사각형 객체 넣는 메소드
		InputSqureArr();

		int squreY = 0;
		// while문 돌리기 위한 객체
		boolean end = false;

		downtime = new Timer(1000, this);

		//1초마다 타임 ㄱㄱ
		downtime.start();

	}

	private void InputSqureArr()
	{
		squreObj = new JSONObject(); //Obj 초기화
		squreObj.put("squreNum", squreCont++); // 사각형 객체 분류 번호..?????  -- 없어도 될것같다.
		squreObj.put("X", 120); //사각형의 X값
		squreObj.put("Y", 500); //사각형의 Y값
		squreObj.put("line", 0); //사각형이 어느 라인에 있는 지 나타내는 건데 어차피 라인 한칸씩 내려가니까 Y값을 라인이랑 연결 계산해서 만드는 것도 괜찮을듯
		squreObj.put("stopX", 300); //사각형이 멈춘 X값
		squreObj.put("stopY", 300); //사각형이 멈춘 Y값
		//회전 값
		squreObj.put("control", 1);//현재 내가 잡고 있는지
		squreArr.add(squreObj); //Arr이에 넣어줌
	}

	//게임 패널 다시 그려주는 메소드
	public void regameFrame()
	{
		gameFrame.removeAll();
		gameFrame.revalidate();
		gameFrame.repaint();
	}

	//게임에서 반복되는 영역을 처리한다
	private void GameGo()
	{
		Graphics g;
		int X = Integer.parseInt(squreObj.get("X").toString()); // 값받아오는 거 ㅂ확인 되면 지워도 됨
		int Y = Integer.parseInt(squreObj.get("Y").toString());

		// 내가 움직인 값 더하기 키 리스너받을때 값 바꿔주기

		//움직이는 사각형에만 Y값 더해주기
		if (squreObj.get("control").toString().equals("1"))
		{
			squreObj.replace("Y", Y -= 50);
			// 사각형들 그리기 // 화면 다시 그려주기9
			regameFrame();

		}

		System.out.println("타임" + X + "," + Y);

		//타임이 멈춰주기if(게임종료면)
		if (Y <= 0)
		{
			downtime.stop();
			System.out.println("끝");
		}

	}

	// 키값 받아서 처리하는 메소드들
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
		//System.out.println("keyPressed" + e.getKeyCode());
		squreMove(e.getKeyCode()); //obj도 같이 보내야하나..
	}

	// 키값 받아서 처리하는 메소드들 끝

	// 키 값 받아서 사각형 움직이게 하는 메소드
	private void squreMove(int keyCode)
	{
		if (squreArr.size() > 0)
		{ //squreArr 안에 객체가 한개라도 들어야 키 프레스 값이 활성화됨
			if (keyCode == 65)
			{

				if (squreObj.get("control").toString().equals("1"))
				{
					//System.out.println("왼쪽");
					int X = Integer.parseInt(squreObj.get("X").toString());
					if (X >= 10)
					{ // X를 0이하로 안 보낼것이다 --유동적으로 바뀌어야함 game프레임의 Y값에서 이동거리를 더한 값, 그러려면 X랑 Y의 이동거리 변수?를 위에서 지정해줘야함 
						squreObj.replace("X", X - 10);
					}
					// 사각형 그리고 화면 다시 그리기

					regameFrame();

				}
			} else if (keyCode == 68)
			{

				if (squreObj.get("control").toString().equals("1"))
				{
					//System.out.println("오른쪽");
					int X = Integer.parseInt(squreObj.get("X").toString());
					if (X <= 490)
					{ // X를 490이상로 안 보낼것이다 --유동적으로 바뀌어야함 game프레임의 Y값크기에서 이동거리를 뺀 값, 그러려면 X랑 Y의 이동거리 변수?를 위에서 지정해줘야함 
						squreObj.replace("X", X + 10);
					}
					// 사각형 그리고 화면 다시 그리기

					regameFrame();

				}

			} else if (keyCode == 83)
			{
				if (squreObj.get("control").toString().equals("1"))
				{
					//System.out.println("아래");
					int Y = Integer.parseInt(squreObj.get("Y").toString());
					squreObj.replace("Y", Y - 10);
				}
				// 사각형 그리고 화면 다시 그리기

				regameFrame();
			} else
			{
				//System.out.println("아무거나");
			}
		}//squreArr 안에 객체가 한개라도 들어야 키 프레스 값이 활성화됨 끝
	}
}


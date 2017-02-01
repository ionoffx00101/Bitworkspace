package Additional;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

// AWT. Tetris. ROTATE 완성 문제.

public class AwtTetrisController5 {
	private static final int BLOCK_WIDTH = 30;
	private static final int BLOCK_HEIGHT = 30;
	private static final int GROUND_SIZE_WIDTH = 12;
	private static final int GROUND_SIZE_HEIGHT = 24;
	private static final int DEFAULT_PLAYER_X = 4;
	private static final int DEFAULT_PLAYER_Y = 0;
	
	private Frame mainFrame;
	private Panel controlPanel;
	private Panel canvasPanel;
	private Canvas canvas;

	private int playerX = DEFAULT_PLAYER_X;	// CAUTION! : can be a minus value. Do not use this as an array index.
	private int playerY = DEFAULT_PLAYER_Y;	// CAUTION! : can be a minus value. Do not use this as an array index.
	private int playerBlockNum;
	private byte[][] playerBlocks = { 
		{0,0,0,0},
		{0,0,0,0},
		{0,0,0,0},
		{0,0,0,0}
	};
	private byte[][] backgroundBlocks = new byte[GROUND_SIZE_HEIGHT][GROUND_SIZE_WIDTH];
	
	private int gameScore = 0;
	
	private float timeInterval = 1500f;		// 타이머(playerY증가) 시간 초기값
	private float rate = 0.99f;				// 타이머 시간 조정 계수
	
	

	
	public AwtTetrisController5() {
		/* 4Testing *********************/
		for(int j=0; j<=GROUND_SIZE_WIDTH-1-5; j++) {
			backgroundBlocks[GROUND_SIZE_HEIGHT-1][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-2][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-3][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-4][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-5][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-6][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-7][j] = 1;
			backgroundBlocks[GROUND_SIZE_HEIGHT-8][j] = 1;
		}
		/********************************/
		prepare();
		newBlocks();	// generate a new block_num and a rotated(random times) blocks.
		compensateY();		// 새 블럭이 놓일 때 맨위에 건너뛰고 그 아래 놓였다면 이를 보정.
		createTimer();
	}
	
	private void createTimer() {
		
		Runnable runnable = new Runnable() {
			public void run() {
				
				for(int i=1; ; i++) {
					try {
						Thread.sleep( (long)timeInterval );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
					if(canMoveDown()) {
						playerY++;
						canvas.repaint();
					}
					else {
						moveDrop();
						moveNext();
					}
					
					
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
	}
	
	private void prepare() {
		// Frame 셋팅
		mainFrame = new Frame("Tetris 01");
		mainFrame.setSize(395, 790);
		mainFrame.setLayout(new BorderLayout());
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
	            switch (keyCode) {
	            case KeyEvent.VK_UP:
	            	moveRotate();
	            	break;
	            case KeyEvent.VK_LEFT:
	            	moveLeft();
	            	break;
	            case KeyEvent.VK_RIGHT:
	            	moveRight();
	                break;
	            case KeyEvent.VK_DOWN:
	            	moveDrop();
					moveNext();
					break;
	            }				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());

		canvas = new AwtCanvasTetris();
		canvasPanel = new Panel();
		canvasPanel.setLayout(new GridLayout(1, 1, 0, 0));
		canvasPanel.add(canvas);
		
		mainFrame.add(controlPanel, "North");
		mainFrame.add(canvasPanel, "Center");
		mainFrame.setVisible(true);
	}
	
	private void newBlocks() {
		Random rand = new Random(System.currentTimeMillis());
		
		// generates a number 0 ~ 5(=NUM_OF_BLOCKS).
		playerBlockNum = rand.nextInt(AwtTetrisBlocks.NUM_OF_BLOCKS);   
		
		// getting from static class BLOCKS
		for(int i=0; i<=3; i++)
			for(int j=0; j<=3; j++)
				playerBlocks[i][j] = AwtTetrisBlocks.BLOCKS[playerBlockNum][i][j];
		
		// rotate
		for(int i=1; i<=rand.nextInt(); i++) {
			rotateBlocks();
		}
	}
	
	private void rotateBlocks() {
		// TODO : complete 1/15(월요일) 저녁 실습까지.
		byte[][] newBlocks = { {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0} };
		for(int i=0; i<=3; i++)
			for(int j=0; j<=3; j++) 
				newBlocks[j][3-i] = playerBlocks[i][j];
		playerBlocks = newBlocks;
//		for(int i=0; i<=3; i++) 
//			for(int j=0; j<=3; j++)
//				playerBlocks[i][j] = newBlocks[i][j];
	}
	
	// 블럭이 좌/우의 경계를 넘어설 경우 x값을 보정.
	private void compensateX() {
		// to compensate when player's block is beyond the borders.
		int leftBorderIndex = -1;  	// 초기값이 -1일뿐, 0~3의 값을 가짐.
		int rightBorderIndex = 4;	// 초기값이 4일뿐, 0~3의 값을 가짐.
		for(int i=0; i<=3; i++) {
			if(playerBlocks[0][i] + playerBlocks[1][i] + playerBlocks[2][i] + playerBlocks[3][i] > 0) {
				// something is on this line!
				leftBorderIndex = i;
				break;
			}
		}
		for(int i=3; i>=0; i--) {
			if(playerBlocks[0][i] + playerBlocks[1][i] + playerBlocks[2][i] + playerBlocks[3][i] > 0) {
				// something is on this line!
				rightBorderIndex = i;
				break;
			}
		}
		if(leftBorderIndex+playerX < 0) playerX = 0;
		if(rightBorderIndex+playerX > 11) playerX = 11-rightBorderIndex;
		
	}
	
	// 새 블럭이 놓일 때 맨윗줄을 건너뛰고 두번째줄에 놓였다면, y값을 보정.
	private void compensateY() {
		int topBorderIndex = -1;  // 초기값이 -1일분, 0~3의 값을 가짐.
		for(int i=0; i<=3; i++) {
			if(playerBlocks[i][0] + playerBlocks[i][1] + playerBlocks[i][2] + playerBlocks[i][3] > 0) {
				topBorderIndex = i;
				break;
			}
		}
		if(playerY<=0) playerY = -topBorderIndex;
	}
	
	private boolean canMoveLeft() {
		int leftBorderIndex = -1;
		for(int i=0; i<=3; i++) {
			if(playerBlocks[0][i] + playerBlocks[1][i] + playerBlocks[2][i] + playerBlocks[3][i] > 0) {
				// something is on this line!
				leftBorderIndex = i;
				break;
			}
		}
		
		if(leftBorderIndex+playerX-1 < 0) return false;
		
		// CHECK background blocks
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				if(playerX+j-1<0) continue;
				if(playerBlocks[i][j]==1 && backgroundBlocks[playerY+i][playerX+j-1]==1) return false;
			}
		}
		return true;
	}
	
	private boolean canMoveRight() {
		int rightBorderIndex = 4;
		for(int i=3; i>=0; i--) {
			if(playerBlocks[0][i] + playerBlocks[1][i] + playerBlocks[2][i] + playerBlocks[3][i] > 0) {
				// something is on this line!
				rightBorderIndex = i;
				break;
			}
		}
		if(rightBorderIndex+playerX >GROUND_SIZE_WIDTH-1-1) return false;
		
		// CHECK background blocks
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				if(playerX+j+1>GROUND_SIZE_WIDTH-1) continue;
				if(playerBlocks[i][j]==1 && backgroundBlocks[playerY+i][playerX+j+1]==1) return false;
			}
		}
		return true;
	}
	
	private boolean canMoveDown() {
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				if(playerX+j<0) continue;
if(playerY+i+1==24) System.out.println("exception - playerY+i=24! playerY : " + playerY + ", i : " + i);
				if(playerBlocks[i][j]==1 && backgroundBlocks[playerY+i+1][playerX+j]==1) return false;
			}
		}
		return true;
	}
	
	private void moveLeft() {
		if(canMoveLeft()) playerX--;
		canvas.repaint();
	}
	private void moveRight() {
		if(canMoveRight()) playerX++;
		canvas.repaint();
	}
	private void moveRotate() {
		rotateBlocks();
		compensateX();		// 블럭이 좌/우 경계를 넘어선 경우 이를 보정.
		compensateY();		// 새 블럭이 놓일 때 맨위에 건너뛰고 그 아래 놓였다면 이를 보정.
		canvas.repaint();
	}
	private void moveNext() {
		playerY = DEFAULT_PLAYER_Y;
		playerX = DEFAULT_PLAYER_X;
		newBlocks();
		compensateX();		// 블럭이 좌/우 경계를 넘어선 경우 이를 보정.
		compensateY();		// 새 블럭이 놓일 때 맨위에 건너뛰고 그 아래 놓였다면 이를 보정.
		canvas.repaint();
	}
	private void moveDrop() {
		int bottomBorderIndex = 4;  // 초기값이 4일뿐. 실제 로직에서는 0~3의 값을 가진다.
		for(int i=3; i>=0; i--) {
			if(playerBlocks[i][0] + playerBlocks[i][1] + playerBlocks[i][2] + playerBlocks[i][3] > 0) {
				// something is on this line!
				bottomBorderIndex = i;
				break;
			}
		}
		
		// check the bottom of the blocks.
		for(; playerY<GROUND_SIZE_HEIGHT; playerY++) {
			if(bottomBorderIndex+playerY >= GROUND_SIZE_HEIGHT-1) break;
			if(!canMoveDown()) break;
			
		}
		
		// freeze the blocks.
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				if( playerBlocks[i][j]==1
					&& playerX+j>=0 && playerX+j<=GROUND_SIZE_WIDTH-1
					&& playerY+i>=0 && playerY+i<=GROUND_SIZE_HEIGHT-1) {
					backgroundBlocks[playerY+i][playerX+j] = playerBlocks[i][j];
				}
				
			}
		}
		
		// check if there's lines to break.
		breakLines();
		
		canvas.repaint();
		
		// timer interval
		timeInterval *= rate;
		
		/* 4Testing ***************************/
//		for(int i=0; i<=GROUND_SIZE_HEIGHT-1; i++) {
//			for(int j=0; j<=GROUND_SIZE_WIDTH-1; j++) {
//				System.out.print(backgroundBlocks[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		/**************************************/
	}
	private void breakLines() {
		for(int i=GROUND_SIZE_HEIGHT-1; i>=0; i--) {
			int count=0;
			for(int j=0; j<=GROUND_SIZE_WIDTH-1; j++) {
				if(backgroundBlocks[i][j]==1) count++;			
			}
			if(count==GROUND_SIZE_WIDTH) {
				// break this line.
				while(true) {
					for(int k=i; k>=1; k--) {
						for(int j=0; j<=GROUND_SIZE_WIDTH-1; j++) {
							backgroundBlocks[k][j] = backgroundBlocks[k-1][j];
							if(backgroundBlocks[k][j]==1) count++;
						}
						
					}
					// check if the bottom line is full.
					count=0;
					for(int j=0; j<=GROUND_SIZE_WIDTH-1; j++) 
						if(backgroundBlocks[i][j]==1) count++;
					if(count!=GROUND_SIZE_WIDTH) break;
				}
				gameScore++;
			}
		}
	}
	
	private void createButtons() {
/*
		Button btnLeft = new Button("◀");
		Button btnRight = new Button("▶");
		Button btnDown = new Button("▼");
		Button btnRotate = new Button("Ro");
		Button btnNext = new Button("Nx");
		
		btnLeft.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : complete
				//if(--playerX<0) playerX=0;	// TODO : improve -- 보다 정교한 계산이 필요
				moveLeft();
			}
		});
		
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO : complete
				//if(++playerX>=12-3) playerX=11-3;	// TODO : improve -- 보다 정교한 계산이 필요
				moveRight();
			}
		});
		
		btnDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveDrop();
				moveNext();
			}
		});
		
		btnRotate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveRotate();
			}
		});
		
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveNext();
			}
		});
		
		
		controlPanel.add(btnLeft);
		controlPanel.add(btnRight);
		controlPanel.add(btnDown);
		controlPanel.add(btnRotate);
		controlPanel.add(btnNext);
*/	
		mainFrame.setVisible(true);
	}
	

	class AwtCanvasTetris extends Canvas {
		public AwtCanvasTetris() {
			setBackground(Color.DARK_GRAY);
		}
		public void paint(Graphics g) {
			Graphics2D g2;
			g2 = (Graphics2D) g;
			g2.setColor(Color.WHITE);
			g2.drawString("SCORE : " + gameScore, 10, 10);
			
			// draw playerBlocks
			//g2.fillRect(10+playerX*BLOCK_WIDTH, 10+playerY*BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
			for(int i=0; i<=3; i++)
				for(int j=0; j<=3; j++)
					if(playerBlocks[i][j]==1)
						g2.fillRect(10+(playerX+j)*BLOCK_WIDTH, 10+(playerY+i)*BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
					
			
			// draw backgroundBlocks
			g2.setColor(Color.LIGHT_GRAY);
			for(int i=0; i<=GROUND_SIZE_HEIGHT-1; i++)
				for(int j=0; j<=GROUND_SIZE_WIDTH-1; j++)
					if(backgroundBlocks[i][j]==1)
						g2.fillRect(10+j*BLOCK_WIDTH, 10+i*BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
			
		}
	}

	
	public static void main(String[] args) {
		AwtTetrisController5 tetrisDemo = new AwtTetrisController5();
		tetrisDemo.createButtons();

		
				
	}



	
}

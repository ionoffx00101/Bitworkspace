package Additional;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

// AWT. Tetris. ROTATE 완성 문제.

public class AwtTetrisController2 {
	private static final int BLOCK_WIDTH = 30;
	private static final int BLOCK_HEIGHT = 30;
	
	private Frame mainFrame;
	private Panel controlPanel;
	private Panel canvasPanel;
	private Canvas canvas;

	private int playerX = 4;	// CAUTION! : can be a minus value. Do not use this as an array index.
	private int playerY = 0;	// CAUTION! : can be a minus value. Do not use this as an array index.
	private int playerBlockNum;
	private byte[][] playerBlocks = { 
		{0,0,0,0},
		{0,0,0,0},
		{0,0,0,0},
		{0,0,0,0}
	};
	
	public AwtTetrisController2() {
		prepare();
		newBlocks();	// generate a new block_num and a rotated(random times) blocks.
	}
	
	private void prepare() {
		// Frame 셋팅
		mainFrame = new Frame("Tetris 01");
		mainFrame.setSize(400, 800);
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
	            	System.out.println("down");
	                break;
case KeyEvent.VK_ENTER:
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
	
	private void compensateX() {
		// to compensate when player's blocks is beyond the borders.
		int leftBorderIndex = -1;
		int rightBorderIndex = 4;
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
	
	private boolean canMoveLeft() {
		int leftBorderIndex = -1;
		for(int i=0; i<=3; i++) {
			if(playerBlocks[0][i] + playerBlocks[1][i] + playerBlocks[2][i] + playerBlocks[3][i] > 0) {
				// something is on this line!
				leftBorderIndex = i;
				break;
			}
		}
		
		if(leftBorderIndex+playerX >=1) return true; 
		else return false;
		// TODO : CHECK background blocks
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
		if(rightBorderIndex+playerX <=11-1) return true; 
		else return false;
		// TODO : CHECK background blocks
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
		System.out.println("Rotate!");
		rotateBlocks();
		compensateX();
		canvas.repaint();
	}
	private void moveNext() {
		newBlocks();
		compensateX();
		canvas.repaint();
	}
	private void createButtons() {
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
				System.out.println("DOWN");
				// TODO : complete
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
		
		mainFrame.setVisible(true);
	}
	

	class AwtCanvasTetris extends Canvas {
		public AwtCanvasTetris() {
			setBackground(Color.DARK_GRAY);
		}
		public void paint(Graphics g) {
			System.out.println("paint()");
			Graphics2D g2;
			g2 = (Graphics2D) g;
			g2.setColor(Color.WHITE);
			g2.drawString("Canvas", 10, 10);
			
			// draw playerBlocks
			//g2.fillRect(10+playerX*BLOCK_WIDTH, 10+playerY*BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
			for(int i=0; i<=3; i++)
				for(int j=0; j<=3; j++)
					if(playerBlocks[i][j]==1)
						g2.fillRect(10+(playerX+j)*BLOCK_WIDTH, 10+(playerY+i)*BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
					
			
			// draw backgroundBlocks
			// TODO : complete
			
		}
	}

	
	public static void main(String[] args) {
		AwtTetrisController2 tetrisDemo = new AwtTetrisController2();
		tetrisDemo.createButtons();
		
	}


	
}

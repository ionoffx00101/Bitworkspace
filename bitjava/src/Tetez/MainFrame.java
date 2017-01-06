package Tetez;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
 
import javax.swing.*;
 
public class MainFrame extends JFrame{
 
    MyPanel mp;
     
    public static void main(String[] args) {
 
        MainFrame mf = new MainFrame("Swing Test");
 
    }
     
    MainFrame(String title) {
        super(title);
        this.setLayout(null);
        this.setBounds(100, 100, 800, 600); // 윈도우의 위치와 크기 지정
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        JButton btn = new JButton("이동");
        btn.setBounds(100, 50, 100, 30);
        this.getContentPane().add(btn);
        btn.addActionListener(new ActionListener() {
            Random rd = new Random();
            @Override
            public void actionPerformed(ActionEvent e) {
                // MyPanel의 x, y 변수에 값을 설정하고 MyPanel을 다시 그린다
                mp.x = rd.nextInt(mp.getWidth());
                mp.y = rd.nextInt(mp.getHeight());
                 
                mp.c = new Color(rd.nextInt(255)+1,rd.nextInt(255)+1,rd.nextInt(255)+1);
 
                mp.repaint();
            }
        });
 
        mp = new MyPanel();
        this.getContentPane().add(mp); //패널을 더한 것이다....
 
        this.setVisible(true);
    }
 
}
 
class MyPanel extends JPanel {
 
    int x, y;   // Frame 내의 버튼을 누르면 이들 변수의 값이 할당됨
    Color c;    // Frame 내의 버튼을 누르면 색상이 결정됨
 
    MyPanel() {
        this.setBackground(Color.ORANGE);
        this.setBounds(100, 100, 500, 400);
    }
     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 기존에 그려진 화면을 지정된 배경색으로 지우는 역할을 한다
 
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
 
        g2d.setColor(Color.ORANGE); // 배경색 지정
 
        g2d.setColor(Color.BLACK);
        g2d.drawOval(100, 100, 100, 100);
         
        g2d.setColor(Color.RED);
        g2d.fillOval(200, 100, 100, 100);
         
        if(x!=0 && y!=0) {
            g2d.setColor(c);
            g2d.fillRoundRect(x, y, 50, 50, 10, 10);
        }
    }
 
}
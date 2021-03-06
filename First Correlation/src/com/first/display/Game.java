package com.first.display;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
	
	public JFrame frame;
	
	public static final int WIDTH = 1400,HEIGHT = WIDTH *9 /16;
	public static final Dimension SIZE = new Dimension(WIDTH,HEIGHT);
	
	public boolean running;
	
	public Game(){
		setPreferredSize(SIZE);
		setMinimumSize(SIZE);
		setMaximumSize(SIZE);
		
		frame = new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
	}

	
	public void run() {
		while(running){
			render();
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.GREEN);
		Font f = new Font("sansserif", Font.BOLD, 32);
		g.setFont(f);
		g.drawString("Hi Kyle", getWidth()/2,getHeight()/2);
		g.dispose();
		bs.show();
	}


	


	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void stop(){
		running = false;
	}
	
	public static void main(String[] a){
		new Game().start();
	}

}

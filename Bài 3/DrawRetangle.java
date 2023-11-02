package Btcuoiky;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DrawRetangle extends JFrame {
	public void paint(Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		// Draw retangle
		Rectangle rect = new Rectangle(100, 100, 300, 200);
		graphics2D.fill(rect);
		graphics2D.setColor(Color.BLACK);
	}

	// JFrame
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawRetangle frame = new DrawRetangle();
		frame.setVisible(true);
	}

	public DrawRetangle() {
		setTitle("Main Window");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setFocusable(true);
		setVisible(true);
		setResizable(false);

	}
}

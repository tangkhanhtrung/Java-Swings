package Btcuoiky;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;

public class Star extends JFrame {

	public void paint(Graphics g) {

		Graphics2D graphic = (Graphics2D) g;
		// Help star shape not defective edge
		graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw star
		int[] posX = { 50, 125, 150, 175, 250, 200, 210, 150, 90, 100, 50 };
		int[] posY = { 135, 125, 60, 125, 135, 175, 240, 200, 240, 175, 135 };

		graphic.setColor(Color.PINK);
		graphic.fillPolygon(posX, posY, 11);

	}

	// JFrame
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Star frame = new Star();
		frame.setVisible(true);
	}

	public Star() {
		setTitle("Main Window");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setFocusable(true);
		setVisible(true);
		setResizable(false);
	}
}

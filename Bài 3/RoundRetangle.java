package Btcuoiky;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;



public class RoundRetangle extends JFrame {
	public void paint (Graphics graphics) {
		Graphics2D graphics2D = (Graphics2D)graphics;
		//Draw rounded Retangle
		RoundRectangle2D roundRetangle = new RoundRectangle2D.Float(100, 100, 240, 160, 40, 40);
		graphics2D.fill(roundRetangle);
		graphics2D.setColor(Color.BLACK);
	}
		// JFrame
		public static void main(String[] args) {
			RoundRetangle frame = new RoundRetangle();
			frame.setVisible(true);
		}

		public RoundRetangle() {
			setTitle("Main Window");
			setSize(800, 600);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setFocusable(true);
			setVisible(true);
			setResizable(false);
	}
}


package Btcuoiky;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RunAuto extends JPanel {
	int posX = 60;
	int posY = 60;
	int width = 60;
	int height = 60;

	int velX = 40;
	int velY = 40;

	public RunAuto() {
		setFocusable(false);
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				move();
				repaint();
			}
		};
		new Timer(100, action).start();
	}

	private void move() {
		// TODO Auto-generated method stub
		posX += velX;
		posY += velY;
		
		if (posX < 15 || posX > 400) {
			velX = -velX;
		}
		if (posY < 15 || posY > 280) {
			velY = -velY;
		}

		repaint();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.PINK);
		g.fillOval(posX, posY, width, height);
		g.setColor(Color.yellow);
		g.drawOval(posX, posY, width, height);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.add(new RunAuto());
		frame.setTitle("Run Automatically");
		frame.setResizable(false);
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {
        	
        }

	}

}


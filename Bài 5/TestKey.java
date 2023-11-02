package Btcuoiky;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TestKey extends JFrame implements KeyListener {
	int posX = 100;
	int posY = 100;
	int width = 100;
	int height = 100;

//-------------------------------------------------------------------
	public static void main(String[] agrs) {
		// TODO Auto-generated method stub
		TestKey test = new TestKey();
		test.setVisible(true);
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {
        	
        }
	}

//-------------------------------------------------------------------
	public TestKey() {
		setTitle("Test Key Listener");
		setSize(700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
		setResizable(false);
	}

	ActionListener action = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int speed = 100;
			// TODO Auto-generated method stub
			posX += speed;
			if (posX >= 490) {
				speed *= 50;
			}
			if (posX <= 0) {
				speed *= 50;
			}
			repaint();
		}
	};

//-------------------------------------------------------------------------
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

//--------------------------------------------------------------------------
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.GREEN);
		g.fillOval(posX, posY, width, height);
	}

//---------------------------------------------------------------------------
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (posY >= 35) {
				posY -= 5;
				repaint();
			} else {
				JOptionPane.showMessageDialog(null, "You touch screen frame");
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (posY <= 689) {
				posY += 5;
				repaint();
			} else {
				JOptionPane.showMessageDialog(null, "You touch screen frame");
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (posX >= 15) {
				posX -= 5;
				repaint();
			} else {
				JOptionPane.showMessageDialog(null, "You touch screen frame");
			}
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (posX <= 590) {
				posX += 5;
				repaint();
			} else {
				JOptionPane.showMessageDialog(null, "You touch screen frame");
			}
		}
	}

//------------------------------------------------------------------------------
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

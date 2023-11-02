package Btcuoiky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLights extends JFrame {

	int width = 120;
	int height = 120;
	private Color lightRed = Color.GRAY;
	private Color lightYellow = Color.GRAY;
	private Color lightGreen = Color.GREEN;
	String status = "Green";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrafficLights tL = new TrafficLights();
		tL.setVisible(true);
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {
        	
        }
	}

	public TrafficLights() {
		setTitle("Traffic Lights");
		setSize(250, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		Timer time = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				discoloration();
			}
		});
		time.start();
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(lightRed);
		g.fillOval(65, 50, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 50, width, height);

		g.setColor(lightYellow);
		g.fillOval(65, 180, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 180, width, height);

		g.setColor(lightGreen);
		g.fillOval(65, 310, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(65, 310, width, height);
	}

	public void discoloration() {
		lightRed = Color.GRAY;
		lightYellow = Color.GRAY;
		lightGreen = Color.GRAY;
		if (status.equals("Green")) {
			lightYellow = Color.YELLOW;
			status = "Yellow";
		} else if (status.equals("Yellow")) {
			lightRed = Color.RED;
			status = "Red";
		} else if (status.equals("Red")) {
			lightGreen = Color.GREEN;
			status = "Green";
		}
		repaint();
	}

}

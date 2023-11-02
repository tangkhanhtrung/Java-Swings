package Btcuoiky;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;

public class Times {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		        catch (ClassNotFoundException e) {}
		        catch (InstantiationException e) {}
		        catch (IllegalAccessException e) {}
		        catch (UnsupportedLookAndFeelException e) {
		        	
		        }
				try {
					Times window = new Times();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Times() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Clock");
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 40));
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("Clock");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(124, 42, 182, 46);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(124, 117, 182, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		TimerTask taskTime = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				textField.setText(new Date().toString());
			}
		};
		Timer timer = new Timer();
		timer.schedule(taskTime, 0, 1000);
	
	}
}

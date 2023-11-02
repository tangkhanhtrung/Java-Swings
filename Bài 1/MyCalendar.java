package Btcuoiky;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;
import java.awt.*;

public class MyCalendar {

	private static int MONTH;
	
	private JFrame frame;

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
					MyCalendar window = new MyCalendar();
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
	public MyCalendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JLabel[] listDay = null;
	JLabel[] listMonth = null;
	int month = 0;

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		// Tieu de
		JLabel lblNewLabel = new JLabel("CALENDAR");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 0, 153, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		// Dung de chuyen sang thang truoc
		JButton btnNewButton = new JButton("|<");
		btnNewButton.setBounds(222, 27, 89, 23);
		frame.getContentPane().add(btnNewButton);
		// Dung de chuyen sang thang sau
		JButton btnNewButton_1 = new JButton(">|");
		btnNewButton_1.setBounds(317, 27, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		// Thang
		JLabel lblNewLabel_Month = new JLabel("MONTH");
		lblNewLabel_Month.setBackground(Color.WHITE);
		lblNewLabel_Month.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_Month.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Month.setBounds(10, 31, 76, 14);
		frame.getContentPane().add(lblNewLabel_Month);
		// Nam
		JLabel lblNewLabel_Year = new JLabel("2020");
		lblNewLabel_Year.setBounds(96, 34, 48, 14);
		lblNewLabel_Year.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Year.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblNewLabel_Year.setBackground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_Year);
		// Thu
		JLabel lblNewLabel_Mon = new JLabel("MON");
		lblNewLabel_Mon.setBounds(10, 61, 48, 14);
		lblNewLabel_Mon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Mon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Mon);

		JLabel lblNewLabel_Tue = new JLabel("Tue");
		lblNewLabel_Tue.setBounds(68, 61, 48, 14);
		lblNewLabel_Tue.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Tue.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Tue);

		JLabel lblNewLabel_Wed = new JLabel("Wed");
		lblNewLabel_Wed.setBounds(126, 61, 48, 14);
		lblNewLabel_Wed.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Wed.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Wed);

		JLabel lblNewLabel_Thu = new JLabel("Thu");
		lblNewLabel_Thu.setBounds(184, 61, 48, 14);
		lblNewLabel_Thu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Thu.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Thu);

		JLabel lblNewLabel_Fri = new JLabel("Fri");
		lblNewLabel_Fri.setBounds(242, 61, 48, 14);
		lblNewLabel_Fri.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Fri.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Fri);

		JLabel lblNewLabel_Sat = new JLabel("Sat");
		lblNewLabel_Sat.setBounds(300, 61, 48, 14);
		lblNewLabel_Sat.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Sat.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Sat);

		JLabel lblNewLabel_Sun = new JLabel("Sun");
		lblNewLabel_Sun.setBounds(358, 61, 48, 14);
		lblNewLabel_Sun.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Sun.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_Sun);
		// Ngay
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 417, 311);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		// -----------------------------------------------------------------------------
		JLabel lblNewLabel_15 = new JLabel("label 1");
		lblNewLabel_15.setBounds(10, 86, 48, 14);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_15);
		panel.add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel("label 2");
		lblNewLabel_16.setBounds(68, 86, 48, 14);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_16);
		panel.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("label 3");
		lblNewLabel_17.setBounds(126, 86, 48, 14);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_17);
		panel.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("label  4");
		lblNewLabel_18.setBounds(184, 86, 48, 14);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_18);
		panel.add(lblNewLabel_18);

		JLabel lblNewLabel_1 = new JLabel("label 5");
		lblNewLabel_1.setBounds(242, 86, 48, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_1);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("label 6");
		lblNewLabel_2.setBounds(300, 86, 48, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_2);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("label 7");
		lblNewLabel_3.setBounds(358, 86, 48, 14);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_3);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("label 8");
		lblNewLabel_4.setBounds(10, 111, 48, 14);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_4);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("label 9");
		lblNewLabel_5.setBounds(68, 111, 48, 14);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_5);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("label 10");
		lblNewLabel_6.setBounds(126, 111, 48, 14);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_6);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("label 11");
		lblNewLabel_7.setBounds(184, 111, 48, 14);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_7);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_19 = new JLabel("label 12");
		lblNewLabel_19.setBounds(242, 111, 48, 14);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_19);
		panel.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("label 13");
		lblNewLabel_20.setBounds(300, 111, 48, 14);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_20);
		panel.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("label 14");
		lblNewLabel_21.setBounds(358, 111, 48, 14);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_21);
		panel.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("label 15");
		lblNewLabel_22.setBounds(10, 136, 48, 14);
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_22);
		panel.add(lblNewLabel_22);

		JLabel lblNewLabel_23 = new JLabel("label 16");
		lblNewLabel_23.setBounds(68, 136, 48, 14);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_23);
		panel.add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("label 17");
		lblNewLabel_24.setBounds(126, 136, 48, 14);
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_24.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_24);
		panel.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("label 18");
		lblNewLabel_25.setBounds(184, 136, 48, 14);
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_25.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_25);
		panel.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("label 19");
		lblNewLabel_26.setBounds(242, 136, 48, 14);
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_26);
		panel.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("label 20");
		lblNewLabel_27.setBounds(300, 136, 48, 14);
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_27);
		panel.add(lblNewLabel_27);

		JLabel lblNewLabel_28 = new JLabel("label 21");
		lblNewLabel_28.setBounds(358, 136, 48, 14);
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_28);
		panel.add(lblNewLabel_28);

		JLabel lblNewLabel_29 = new JLabel("label 22");
		lblNewLabel_29.setBounds(10, 161, 48, 14);
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_29);
		panel.add(lblNewLabel_29);

		JLabel lblNewLabel_30 = new JLabel("New label");
		lblNewLabel_30.setBounds(68, 161, 48, 14);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_30);
		panel.add(lblNewLabel_30);

		JLabel lblNewLabel_31 = new JLabel("New label");
		lblNewLabel_31.setBounds(126, 161, 48, 14);
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_31);
		panel.add(lblNewLabel_31);

		JLabel lblNewLabel_32 = new JLabel("New label");
		lblNewLabel_32.setBounds(184, 161, 48, 14);
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_32);
		panel.add(lblNewLabel_32);

		JLabel lblNewLabel_33 = new JLabel("New label");
		lblNewLabel_33.setBounds(242, 161, 48, 14);
		lblNewLabel_33.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_33.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_33);
		panel.add(lblNewLabel_33);

		JLabel lblNewLabel_34 = new JLabel("New label");
		lblNewLabel_34.setBounds(300, 161, 48, 14);
		lblNewLabel_34.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_34.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_34);
		panel.add(lblNewLabel_34);

		JLabel lblNewLabel_35 = new JLabel("New label");
		lblNewLabel_35.setBounds(358, 161, 48, 14);
		lblNewLabel_35.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_35.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_35);
		panel.add(lblNewLabel_35);

		JLabel lblNewLabel_36 = new JLabel("New label");
		lblNewLabel_36.setBounds(10, 186, 48, 14);
		lblNewLabel_36.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_36.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_36);
		panel.add(lblNewLabel_36);

		JLabel lblNewLabel_37 = new JLabel("New label");
		lblNewLabel_37.setBounds(68, 186, 48, 14);
		lblNewLabel_37.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_37.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_37);
		panel.add(lblNewLabel_37);

		JLabel lblNewLabel_38 = new JLabel("New label");
		lblNewLabel_38.setBounds(126, 186, 48, 14);
		lblNewLabel_38.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_38.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_38);
		panel.add(lblNewLabel_38);

		JLabel lblNewLabel_39 = new JLabel("New label");
		lblNewLabel_39.setBounds(184, 186, 48, 14);
		lblNewLabel_39.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_39.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_39);
		panel.add(lblNewLabel_39);

		JLabel lblNewLabel_40 = new JLabel("New label");
		lblNewLabel_40.setBounds(242, 186, 48, 14);
		lblNewLabel_40.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_40.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_40);
		panel.add(lblNewLabel_40);

		JLabel lblNewLabel_41 = new JLabel("New label");
		lblNewLabel_41.setBounds(300, 186, 48, 14);
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_41.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_41);
		panel.add(lblNewLabel_41);

		JLabel lblNewLabel_42 = new JLabel("New label");
		lblNewLabel_42.setBounds(358, 186, 48, 14);
		lblNewLabel_42.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_42.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_42);
		panel.add(lblNewLabel_42);

		listDay = new JLabel[] { lblNewLabel_15, lblNewLabel_16, lblNewLabel_17, lblNewLabel_18, lblNewLabel_1,
				lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7,
				lblNewLabel_19, lblNewLabel_20, lblNewLabel_21, lblNewLabel_22, lblNewLabel_23, lblNewLabel_24,
				lblNewLabel_25, lblNewLabel_26, lblNewLabel_27, lblNewLabel_28, lblNewLabel_29, lblNewLabel_30,
				lblNewLabel_31, lblNewLabel_32, lblNewLabel_33, lblNewLabel_34, lblNewLabel_35, lblNewLabel_36,
				lblNewLabel_37, lblNewLabel_38, lblNewLabel_39, lblNewLabel_40, lblNewLabel_41, lblNewLabel_42 };
		String[] listMonth = new String[] { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST",
				"SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER" };
		Calendar curtime = Calendar.getInstance();
		int curmonth = curtime.get(MyCalendar.MONTH);
		month = curmonth;
		theCalendar(curmonth);

		switch (curmonth) {
		case 0:
			lblNewLabel_Month.setText("JANUARY");
			break;
		case 1:
			lblNewLabel_Month.setText("FEBRUARY");
			break;
		case 2:
			lblNewLabel_Month.setText("MARCH");
			break;
		case 3:
			lblNewLabel_Month.setText("APRIL");
			break;
		case 4:
			lblNewLabel_Month.setText("MAY");
			break;
		case 5:
			lblNewLabel_Month.setText("JUNE");
			break;
		case 6:
			lblNewLabel_Month.setText("JULY");
			break;
		case 7:
			lblNewLabel_Month.setText("AUGUST");
			break;
		case 8:
			lblNewLabel_Month.setText("SEPTEMBER");
			break;
		case 9:
			lblNewLabel_Month.setText("OCTOBER");
			break;
		case 10:
			lblNewLabel_Month.setText("NOVEMBER");
			break;
		case 11:
			lblNewLabel_Month.setText("DECEMBER");
			break;
		default:
			throw new IllegalArgumentException("Value: " + curmonth);
		}
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == btnNewButton_1) {

					lblNewLabel_Month.setText(listMonth[month + 1]);
					theCalendar(month + 1);
					month++;
				}

				else if (e.getSource() == btnNewButton) {
					lblNewLabel_Month.setText(listMonth[month - 1]);
					theCalendar(month - 1);
					month--;
				}
			}
		};
		btnNewButton.addActionListener(listener);
		btnNewButton_1.addActionListener(listener);

	}

	private void theCalendar(int numberOfmonth) {
		// TODO Auto-generated method stub
		DateUtil util = new DateUtil();
		int days = util.getDays(2020, numberOfmonth);
		String theFirstDay = util.getDayOfWeek(2020, numberOfmonth + 1, 1);
		int startday = getBegin_day(theFirstDay);
		int startOfday = 1;
		for (int i = 0; i < listDay.length; i++) {
			if (i < startday || startOfday > days) {
				listDay[i].setText("");
			} else {
				listDay[i].setText(String.valueOf(startOfday));
				startOfday++;
			}
		}
	}

	private int getBegin_day(String theFirstDay) {
		// TODO Auto-generated method stub
		int startDay = 0;
		switch (theFirstDay) {
		case "Monday":
			startDay = 0;
			break;
		case "Tuesday":
			startDay = 1;
			break;
		case "Wednesday":
			startDay = 2;
			break;
		case "Thursday":
			startDay = 3;
			break;
		case "Friday":
			startDay = 4;
			break;
		case "Saturday":
			startDay = 5;
			break;
		case "Sunday":
			startDay = 6;
			break;
		default:
			throw new IllegalArgumentException("Value: " + theFirstDay);
		}
		return startDay;
	}

}


package Btcuoiky;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SlideShow {
	// ===============================================================================
	private JFrame frame;

	// ===============================================================================
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
					SlideShow window = new SlideShow();
					window.frame.setVisible(true);
					window.frame.setTitle("SLIDE SHOW");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ===============================================================================
	public SlideShow() {
		initialize();
	}

	// ===============================================================================
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1287, 782);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		// ===============================================================================
		JLabel lblNewLabel_1 = new JLabel("SLIDE SHOW");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(23, 11, 599, 32);
		frame.getContentPane().add(lblNewLabel_1);
		// ===============================================================================
		JLabel lblImage = new JLabel();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(33, 54, 906, 667);
		frame.getContentPane().add(lblImage);
		// ===============================================================================
		JButton btnNext = new JButton("<<");
		btnNext.setForeground(Color.BLACK);
		btnNext.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		btnNext.setBounds(1048, 54, 89, 32);
		frame.getContentPane().add(btnNext);
		// ===============================================================================
		JButton btnBack = new JButton(">>");
		btnBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		btnBack.setBounds(1147, 54, 89, 32);
		frame.getContentPane().add(btnBack);
		// ===============================================================================
		JButton btnLoad = new JButton("Load");
		btnLoad.setForeground(Color.BLACK);
		btnLoad.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnLoad.setBounds(949, 54, 89, 119);
		frame.getContentPane().add(btnLoad);
		// ==============================================================================
		Object[][] image = {};
		String[] title = { "Number", "Link" };
		DefaultTableModel model = new DefaultTableModel(image, title);
		JTable table = new JTable(model);
		JScrollPane srcoll = new JScrollPane(table);
		srcoll.setBounds(949, 188, 311, 533);
		table.setModel(model);
		frame.getContentPane().add(srcoll);
		// ===============================================================================
		JButton btnShow = new JButton("Show");
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnShow.setBounds(1048, 97, 188, 76);
		frame.getContentPane().add(btnShow);

		// ===============================================================================
		ActionListener listen = new ActionListener() {
			JTextField linkFolder = new JTextField();

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// (LOAD)=====================================================================
				if(e.getSource() == btnLoad) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "jpeg");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					model.setDataVector(image, title);
					linkFolder.setText(chooser.getSelectedFile().getAbsolutePath());
					try {
						File fileFolder = new File(linkFolder.getText());
						File[] list = fileFolder.listFiles();
						for (int i = 0; i < list.length; i++) {
							model.addRow(new Object[] { "Image " + (i + 1), list[i].getName() });
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "File error!!" + ex.getMessage());
					}
					}
				// (SHOW)===============================================================================
				} else if (e.getSource() == btnShow) {
					int selImageTable = table.getSelectedRow();
					if (selImageTable >= 0) {
						String selImage = linkFolder.getText() + "\\" + table.getValueAt(selImageTable, 1).toString();
						try {
							 ImageIcon imageIcon = new ImageIcon(String.valueOf(selImage));

		                        Image imageFit = imageIcon.getImage();

		                        Image imgFit = imageFit.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

		                        ImageIcon imageIcon1 = new ImageIcon(imgFit);
		                        lblImage.setIcon(imageIcon1);
						} catch (Exception ew) {
							// TODO: handle exception
							ew.getStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "You have not selected the picture","Notification",2);
					}
				//(BACK)====================================================================================================
				}else if(e.getSource() == btnBack){
					int selImageTable = table.getSelectedRow();
					if (selImageTable >= 0) {
					String selcImage = linkFolder.getText() +"\\"+ table.getValueAt(selImageTable+1, 1).toString(); //Hiển thị hình tiếp theo
					table.setRowSelectionInterval(selImageTable+1, selImageTable+1); //Chọn hình tiếp theo để hiển thị
					table.removeRowSelectionInterval(selImageTable, selImageTable);
					try {
						 ImageIcon imageIcon = new ImageIcon(String.valueOf(selcImage));

	                      Image imageFit = imageIcon.getImage();

	                      Image imgFit = imageFit.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

	                        ImageIcon imageIcon1 = new ImageIcon(imgFit);
	                        lblImage.setIcon(imageIcon1);
					} catch (Exception ew) {
						// TODO: handle exception
						ew.getStackTrace();
					}
					}
				// (Next)=====================================================================================================
				}else if(e.getSource() == btnNext) {
					int selImageTable = table.getSelectedRow();
					if (selImageTable >= 0) {
						String seleImage = linkFolder.getText() +"\\"
												+table.getValueAt(selImageTable-1, 1).toString(); //Hiển thị hình trước đó
						table.setRowSelectionInterval(selImageTable-1, selImageTable-1); //Chọn hình trước đó để hiển thị
						table.removeRowSelectionInterval(selImageTable, selImageTable);
					try {
						 ImageIcon imageIcon = new ImageIcon(String.valueOf(seleImage));

	                      Image imageFit = imageIcon.getImage();

	                      Image imgFit = imageFit.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);

	                      ImageIcon imageIcon1 = new ImageIcon(imgFit);
	                      lblImage.setIcon(imageIcon1);
					} catch (Exception ew) {
						// TODO: handle exception
						ew.getStackTrace();
					}
					}
				}
			}
		};
		btnLoad.addActionListener(listen);
		btnShow.addActionListener(listen);
		btnNext.addActionListener(listen);
		btnBack.addActionListener(listen);
	}
}

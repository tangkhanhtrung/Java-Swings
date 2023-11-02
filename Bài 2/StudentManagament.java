package Bt;

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class StudentManagament {
	private int height = 55;
	private int width = 155;
	private int editInfo;
	private String fileName;

	private JFrame frame;
	JTextField control = new JTextField();

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
					StudentManagament window = new StudentManagament();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws ParseException
	 */
	public StudentManagament() throws ParseException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize() throws ParseException {
		frame = new JFrame();
		frame.setTitle("Student Management System");
		frame.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		// --------------------------------------------------------------------
		Object[][] data = {};
		String[] title = { "Student ID", "Student Name", "D.O.B", "Contact Info" };
		JTable table = new JTable(data, title);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(30, 50, 575, 300);
		frame.getContentPane().add(scroll);
		// --------------------------------------------------------------------
		JTextField textFld1 = new JTextField();
		textFld1.setBounds(200, 471, 405, 30);
		textFld1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(textFld1);

		JTextField textFld = new JTextField();
		textFld.setBounds(200, 430, 405, 30);
		textFld.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(textFld);

		MaskFormatter dateMaskFormatter = new MaskFormatter("##/##/####");
		JFormattedTextField textFld2 = new JFormattedTextField(dateMaskFormatter);
		textFld2.setBounds(200, 512, 405, 30);
		textFld2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(textFld2);

		JTextField textFld3 = new JTextField();
		textFld3.setBounds(200, 553, 405, 30);
		textFld3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(textFld3);
		// --------------------------------------------------------------------
		JLabel label1 = new JLabel("STUDENT MANAGEMENT");
		label1.setBounds(250, 10, 300, 24);
		label1.setForeground(Color.PINK);

		label1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		frame.getContentPane().add(label1);

		JLabel label2 = new JLabel("ADD NEW STUDENT");
		label2.setBounds(250, 390, 300, 24);
		label2.setForeground(Color.GREEN);
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		frame.getContentPane().add(label2);

		JLabel label3 = new JLabel("Student ID: ");
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		label3.setBounds(30, 430, 160, 30);
		label3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		frame.getContentPane().add(label3);

		JLabel label4 = new JLabel("Student Name: ");
		label4.setHorizontalAlignment(SwingConstants.LEFT);
		label4.setBounds(30, 471, 160, 30);
		label4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		frame.getContentPane().add(label4);

		JLabel label5 = new JLabel("Date Of Birth: ");
		label5.setHorizontalAlignment(SwingConstants.LEFT);
		label5.setBounds(30, 512, 160, 30);
		label5.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		frame.getContentPane().add(label5);

		JLabel label6 = new JLabel("Contact Information: ");
		label6.setHorizontalAlignment(SwingConstants.LEFT);
		label6.setBounds(30, 553, 160, 30);
		label6.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		frame.getContentPane().add(label6);

		// -----------------------------------------------------------
		JButton bt1 = new JButton();
		bt1.setText("Load");
		bt1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt1.setBounds(620, 50, width, height);
		frame.getContentPane().add(bt1);

		JButton bt2 = new JButton();
		bt2.setText("Add New");
		bt2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt2.setBounds(620, 120, width, height);
		frame.getContentPane().add(bt2);

		JButton bt3 = new JButton();
		bt3.setText("Edit");
		bt3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt3.setBounds(620, 190, width, height);
		frame.getContentPane().add(bt3);

		JButton bt4 = new JButton();
		bt4.setText("Delete");
		bt4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt4.setBounds(620, 260, width, height);
		frame.getContentPane().add(bt4);

		JButton bt5 = new JButton();
		bt5.setText("<<<");
		bt5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt5.setBounds(440, 360, 70, 25);
		frame.getContentPane().add(bt5);

		JButton bt6 = new JButton();
		bt6.setText(">>>");
		bt6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt6.setBounds(525, 360, 70, 25);
		frame.getContentPane().add(bt6);

		JButton bt7 = new JButton();
		bt7.setText("Save");
		bt7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt7.setBounds(215, 600, width, height);
		frame.getContentPane().add(bt7);

		JButton bt8 = new JButton();
		bt8.setText("Cancel");
		bt8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt8.setBounds(430, 600, width, height);
		frame.getContentPane().add(bt8);

		JButton bt9 = new JButton();
		bt9.setText("Exit");
		bt9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bt9.setBounds(600, 680, width, height);
		frame.getContentPane().add(bt9);

		// --------------------------------------------------------
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(data, title);
		table.setModel(model);
		textFld.setEditable(false);
		textFld1.setEditable(false);
		textFld2.setEditable(false);
		textFld3.setEditable(false);

		// ---------------------------------------------------------
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// (ADD NEW)---------------------------------------------------------------------------------------------
				if (e.getSource() == bt2) { // Add new
					textFld.setEditable(true);
					textFld1.setEditable(true);
					textFld2.setEditable(true);
					textFld3.setEditable(true);
					control.setText("add");
					// (CANCEL)---------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt8) { // Cancel
					textFld.setText("");
					textFld1.setText("");
					textFld2.setText("");
					textFld3.setText("");
					// (|<)-------------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt5) { // '|<' Move to the first row
					table.setRowSelectionInterval(0, 0);
					// (>|)-------------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt6) { // '>|' Move to the last row
					int lastRow = table.getRowCount() - 1;
					table.setRowSelectionInterval(lastRow, lastRow);
					// (DELETE)---------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt4) { // Delete
					int erase = table.getSelectedRow();
					if (erase > -1) {
						if (erase == -1) {
							JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Notification",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						} else {
							int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
									"Confirm", JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.OK_OPTION) {
								model.removeRow(erase);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please select one line to delete!", "Notification",
								JOptionPane.DEFAULT_OPTION);
					}
					// (EDIT)---------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt3) { // Edit
					editInfo = table.getSelectedRow();
					System.out.println(editInfo);
					if (editInfo > -1) {
						textFld.setEditable(false);
						textFld1.setEditable(true);
						textFld2.setEditable(true);
						textFld3.setEditable(true);

						textFld.setText((String) model.getValueAt(editInfo, 0));
						textFld1.setText((String) model.getValueAt(editInfo, 1));
						textFld2.setText((String) model.getValueAt(editInfo, 2));
						textFld3.setText((String) model.getValueAt(editInfo, 3));
					} else {
						JOptionPane.showMessageDialog(null, "Please select one line to edit!", "Notification",
								JOptionPane.DEFAULT_OPTION);
					}
					control.setText("edit");
					// (SAVE)-----------------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt7) { // Save
					if (control.getText().equals("add")) {
						String[] array = { textFld.getText(), textFld1.getText(), textFld2.getText(),
								textFld3.getText() };
						model.addRow(array);
						textFld.setEditable(false);
						textFld1.setEditable(false);
						textFld2.setEditable(false);
						textFld3.setEditable(false);
					} else if (control.getText().equals("edit")) {
						int contantNum = table.getSelectedRow();
						model.setValueAt(textFld1.getText(), contantNum, 1);
						model.setValueAt(textFld2.getText(), contantNum, 2);
						model.setValueAt(textFld3.getText(), contantNum, 3);
						textFld1.setEditable(false);
						textFld2.setEditable(false);
						textFld3.setEditable(false);
					}
					// (LOAD)--------------------------------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt1) {// Load
					String content = "";
					JFileChooser file = new JFileChooser();
					var result = file.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						model.setRowCount(0);
						fileName = file.getSelectedFile().getAbsolutePath();
						try {
							content = new String(Files.readAllBytes(Paths.get(fileName)));
						} catch (IOException er) {
							er.printStackTrace();
						}
					}
					String[] split = content.split(",");
					try {
						for (int i = 0; i < split.length; i += 4) {
							model.addRow(new Object[] { split[i], split[i + 1], split[i + 2], split[i + 3] });
						}
					} catch (Exception ex) {

					}			
					// (EXIT)--------------------------------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt9) {
					int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Notification",
							JOptionPane.OK_CANCEL_OPTION, 3);
					if (result == JOptionPane.OK_OPTION) {
						try {
							FileWriter write = new FileWriter(fileName);
							int count = model.getRowCount();
							for (int i = 0; i < count; i++) {
								write.write(model.getValueAt(i, 0) + "," 
											+ model.getValueAt(i, 1) + ","
											+ model.getValueAt(i, 2) + "," 
											+ model.getValueAt(i, 3) + ",");
							}
							write.close();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Listing Error!\n" + ex.getLocalizedMessage());
						}
						System.exit(0);
					}

				}
			}
		};
		bt1.addActionListener(listener);
		bt2.addActionListener(listener);
		bt3.addActionListener(listener);
		bt4.addActionListener(listener);
		bt5.addActionListener(listener);
		bt6.addActionListener(listener);
		bt7.addActionListener(listener);
		bt8.addActionListener(listener);
		bt9.addActionListener(listener);
	}
}

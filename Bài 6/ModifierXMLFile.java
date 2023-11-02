package Btcuoiky;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class ModifierXMLFile extends JFrame {
	private String link;
	private int editInfo;
	JTextField control = new JTextField();
	public static void main(String[] args) {
		new ModifierXMLFile().setVisible(true);
		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
	}

	public ModifierXMLFile() {
		setTitle("WINDOW RUN XML");
		setSize(800, 700);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// (JLABEL)============================================================
		JLabel label = new JLabel();
		label.setBounds(370, 20, 100, 30);
		add(label);

		JLabel idLabel = new JLabel("ID");
		idLabel.setBounds(50, 400, 50, 30);
		add(idLabel);

		JLabel nameLabel = new JLabel("NAME");
		nameLabel.setBounds(50, 480, 120, 30);
		add(nameLabel);

		JLabel salaryLabel = new JLabel("SALARY($)");
		salaryLabel.setBounds(50, 560, 100, 30);
		add(salaryLabel);
		
		// (BUTTON)===============================================================
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setBounds(590, 70, 130, 30);
		add(btnLoad);

		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(590, 120, 130, 30);
		add(btnEdit);
		
		JButton btnNew = new JButton("ADD NEW");
		btnNew.setBounds(590, 170, 130, 30);
		add(btnNew);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(590, 600, 130, 30);
		add(btnSave);

		// (TEXTFIELD)===============================================================
		JTextField textfieldID = new JTextField();
		textfieldID.setBounds(50, 440, 500, 30);
		add(textfieldID);

		JTextField textfldName = new JTextField();
		textfldName.setBounds(50, 520, 500, 30);
		add(textfldName);

		JTextField textfldSalary = new JTextField();
		textfldSalary.setBounds(50, 600, 500, 30);
		add(textfldSalary);

		// (JTABLE)==============================================================
		Object [][] data = {};
		String[] cols = {"ID", "NAME", "SALARY($)"};
		JTable table = new JTable(data,cols);
		table.setSelectionBackground(Color.PINK);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(50, 70, 500, 300);
		add(scroll);
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(data, cols);
		table.setModel(model);
		textfieldID.setEditable(false);
		textfldName.setEditable(false);
		textfldSalary.setEditable(false);
		
		// (ACTIONLISTENER)=============================================================
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//(LOAD)================================================================
				if (e.getSource() == btnLoad) {
					JFileChooser fileChooser = new JFileChooser();
					int result = fileChooser.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						model.setRowCount(0);
						link = fileChooser.getSelectedFile().getAbsolutePath();
						try {
							File file = new File(link);
							DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
							Document document = documentBuilder.parse(file);
							
							NodeList nodeList = document.getElementsByTagName("employee");
							
							for (int i = 0; i < nodeList.getLength(); i++) {
								Node currentNode = nodeList.item(i);
								Element element = (Element) currentNode;
								
								String id = element.getAttribute("id");
								String name = element.getElementsByTagName("name").item(0).getTextContent();
								String salary = element.getElementsByTagName("salary").item(0).getTextContent();
							
								model.addRow(new Object[] {id, name, salary});
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				//(EDIT)===============================================================
				}else if(e.getSource() == btnEdit) {
					editInfo = table.getSelectedRow();
					if (editInfo > -1) {
						textfieldID.setEditable(false);
						textfldName.setEditable(true);
						textfldSalary.setEditable(true);
					
						textfieldID.setText((String) model.getValueAt(editInfo, 0));
						textfldName.setText((String) model.getValueAt(editInfo, 1));
						textfldSalary.setText((String) model.getValueAt(editInfo, 2));
					} else {
						JOptionPane.showMessageDialog(null, "Please select one line to edit!", "Notification",
								JOptionPane.DEFAULT_OPTION);
					}
					control.setText("edit");
				//(ADD NEW)===========================================================
				}else if(e.getSource() == btnNew) {
					textfieldID.setEditable(true);
					textfldName.setEditable(true);
					textfldSalary.setEditable(true);
					control.setText("add");
				// (SAVE)===============================================================
				}else if(e.getSource() == btnSave) {
					if (control.getText().equals("add")) {
						String[] array = { textfieldID.getText(),
												textfldName.getText(), 
												textfldSalary.getText(),};
						model.addRow(array);
						textfieldID.setEditable(false);
						textfldName.setEditable(false);
						textfldSalary.setEditable(false);
					} else if (control.getText().equals("edit")) {
						int contantNum = table.getSelectedRow();
						model.setValueAt(textfieldID.getText(), contantNum, 0);
						model.setValueAt(textfldName.getText(), contantNum, 1);
						model.setValueAt(textfldSalary.getText(), contantNum, 2);
						textfieldID.setEditable(false);
						textfldName.setEditable(false);
						textfldSalary.setEditable(false);
					}
					writeXML(link);
				}
			}
			private void writeXML(String link) {
				// TODO Auto-generated method stub
				try {
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					
					Document document = builder.newDocument();
					
					Element element = document.createElement("company");
					document.appendChild(element);
					 	 
					int row = model.getRowCount();
					for (int i = 0; i < row; i++) {
						
						Element elm = document.createElement("employee");
						element.appendChild(elm);
						elm.setAttribute("id", (String)model.getValueAt(i, 0));
						
						Element name = document.createElement("name");
						name.appendChild(document.createTextNode((String)model.getValueAt(i, 1)));
						elm.appendChild(name);
						
						Element salary = document.createElement("salary");
						salary.appendChild(document.createTextNode((String)model.getValueAt(i, 2)));
						elm.appendChild(salary);
						
						
					}
					TransformerFactory transFactory = TransformerFactory.newInstance();
					Transformer transformer = transFactory.newTransformer();
					DOMSource source = new DOMSource(document);
					
					File xmlFile = new File(link);
					StreamResult result = new StreamResult(xmlFile);
					transformer.transform(source, result);
					System.out.println("Successfully!");
				} catch (Exception ex) {
					// TODO: handle exception
					 ex.printStackTrace();
				}
			}
		};
		btnLoad.addActionListener(listener);
		btnEdit.addActionListener(listener);
		btnNew.addActionListener(listener);
		btnSave.addActionListener(listener);
		
	}
}

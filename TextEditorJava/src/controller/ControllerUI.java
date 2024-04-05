package controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.TextString;
import view.UITextEditor;

public class ControllerUI implements ActionListener {
	private UITextEditor uiTextEditor;
	private TextString txtString;
	String fileName=null;
	String fileAddress=null;

	public ControllerUI(UITextEditor uiTextEditor) {
		this.uiTextEditor = uiTextEditor;
		uiTextEditor.getFileExit().addActionListener(this);
		uiTextEditor.getFileNew().addActionListener(this);
		uiTextEditor.getFileOpen().addActionListener(this);
		uiTextEditor.getFileSave().addActionListener(this);
		uiTextEditor.getFileSaveAs().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == uiTextEditor.getFileExit()) {
			System.exit(0);
		}else if(e.getSource()==uiTextEditor.getFileNew()) {
			uiTextEditor.getTxtArea().setText(null);
			uiTextEditor.setTitle("New");
		}else if (e.getSource() == uiTextEditor.getFileOpen()) {
			FileDialog fd = new FileDialog(uiTextEditor, "Open", FileDialog.LOAD);
			fd.setVisible(true);
			if (fd.getFile() != null) {
				fileName = fd.getFile();
				fileAddress = fd.getDirectory();

				//chỉ được mở file txt(mở file khác bị treo)
				if (fileName.toLowerCase().endsWith(".txt")) {
					uiTextEditor.setTitle(fileName);
					try (BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName))) {
						uiTextEditor.getTxtArea().setText("");
						String line=txtString.getLine();
						while ((line = br.readLine()) != null) {
							uiTextEditor.getTxtArea().append(line + "\n"); 
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(uiTextEditor, "File mở không thành công: " + ex.getMessage(),
								"Mở file bị lỗi", JOptionPane.ERROR_MESSAGE);
					}
				} else {

					JOptionPane.showMessageDialog(uiTextEditor, "Chỉ có thể mở các file với định dạng .txt",
							"Mở file bị lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else if (e.getSource() == uiTextEditor.getFileSave()) {
			if(fileName==null) {
				saveAs();
				uiTextEditor.setTitle(fileName);
			}
			else {
				try {

					FileWriter fw=new FileWriter(fileAddress+fileName);
					fw.write(uiTextEditor.getTxtArea().getText());

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lưu thất bại");
				}

			}

		}else if (e.getSource() == uiTextEditor.getFileSaveAs()) {
			saveAs();
		}
	}

	private void saveAs() {
		FileDialog fd = new FileDialog(uiTextEditor, "Save", FileDialog.SAVE);
		fd.setVisible(true);		
		if (fd.getFile() != null) {
			fileName = fd.getFile();
			fileAddress = fd.getDirectory();

		}
		try {
			FileWriter fw=new FileWriter(fileAddress+fileName);
			fw.write(uiTextEditor.getTxtArea().getText());
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lưu thất bại");
		}

	}
}

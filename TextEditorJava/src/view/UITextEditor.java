package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UITextEditor extends JFrame{
	private JMenuBar menuBar;
	private JMenuItem fileNew,fileOpen,fileSave,fileSaveAs,fileExit;
	private JTextArea txtArea;
	

	public UITextEditor() {
		addControls();
		windows();

	}

	public JMenuItem getFileNew() {
		return fileNew;
	}


	public void setFileNew(JMenuItem fileNew) {
		this.fileNew = fileNew;
	}


	public JMenuItem getFileOpen() {
		return fileOpen;
	}


	public void setFileOpen(JMenuItem fileOpen) {
		this.fileOpen = fileOpen;
	}


	public JMenuItem getFileSave() {
		return fileSave;
	}


	public void setFileSave(JMenuItem fileSave) {
		this.fileSave = fileSave;
	}


	public JMenuItem getFileSaveAs() {
		return fileSaveAs;
	}


	public void setFileSaveAs(JMenuItem fileSaveAs) {
		this.fileSaveAs = fileSaveAs;
	}


	public JMenuItem getFileExit() {
		return fileExit;
	}


	public void setFileExit(JMenuItem fileExit) {
		this.fileExit = fileExit;
	}


	public JTextArea getTxtArea() {
		return txtArea;
	}


	public void setTxtArea(JTextArea txtArea) {
		this.txtArea = txtArea;
	}


	private void addControls() {
		Container conn=getContentPane();
		conn.setLayout(new BorderLayout());

		conn.add(addMenu(),BorderLayout.NORTH);
		conn.add(addTxtArea(),BorderLayout.CENTER);


	}

	private JScrollPane addTxtArea() {
		txtArea=new JTextArea();
		JScrollPane jsp=new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		return jsp;
	}

	private JMenuBar addMenu() {
		menuBar=new JMenuBar();
		JMenu menuFile=new JMenu("File");
		menuBar.add(menuFile);

		fileNew=new JMenuItem("New");
		fileOpen=new JMenuItem("Open");
		fileSave=new JMenuItem("Save");
		fileSaveAs=new JMenuItem("Save as");
		fileExit=new JMenuItem("Exit");

		menuFile.add(fileNew);
		menuFile.add(fileOpen);
		menuFile.add(fileSave);
		menuFile.add(fileSaveAs);
		menuFile.add(fileExit);
		return menuBar;
	}

	private void windows() {
		this.setTitle("Text editor");
		this.setSize(700,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}

package controller;

import view.UITextEditor;

public class run {
	public static void main(String[] args) {
		UITextEditor uiTextEditor=new UITextEditor();
		uiTextEditor.setVisible(true);
		ControllerUI controllerUI=new ControllerUI(uiTextEditor);
	}

}

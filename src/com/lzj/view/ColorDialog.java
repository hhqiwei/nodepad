package com.lzj.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorDialog extends JFrame {
	JButton jButton;

	public ColorDialog() {
		setLayout(new FlowLayout());
		setVisible(true);
		Color color = JColorChooser.showDialog(ColorDialog.this, "Ñ¡É«°å", getContentPane().getBackground());
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}

package com.lzj.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * ��������������
 * 	����
 * 		helpabout		��������Ĺ����ӽ���
 * @author zx583
 *
 */
public class HelpDialog extends JDialog implements ActionListener{
	//ActionCommand����
	private static final String ActionCommand_about = "about";
	private static final String ActionCommand_info = "info";

	private JPanel helpabout, helpinfo;
	
	/**
	 * ���캯���Խ�����в���
	 */
	public HelpDialog(JFrame frame) {
		//����Frame����Ĳ���ΪBorderLayout
		getContentPane().setLayout(new BorderLayout());
		
		//�½�һ��JMenuBar
		JMenuBar menu = new JMenuBar();
		
		//�½�һ��JMenuItem
		JMenuItem aboutItem = new JMenuItem("����");
		//Ϊ��MenuItem����ActionCommand
		aboutItem.setActionCommand(ActionCommand_about);
		//Ϊ��MenuItem����ActionCommand
		aboutItem.addActionListener(this);
		//����MenuItem������ɫΪ��ɫ
		aboutItem.setBackground(Color.white);
		
		
		//����MenuItem����MenuBar��
		menu.add(aboutItem);
		//����MenuBar����ΪFlowLayout(FlowLayout.LEFT)
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		//����MenuBar����Ϊ��ɫ
		menu.setBackground(Color.white);
		
		//��MenuBar����Frame��BorderLayout.NORTHλ��
		getContentPane().add(menu, BorderLayout.NORTH);
		
		//ʵ����helpinfo����
		helpinfo = new HelpInfo();

		getContentPane().add(helpinfo, BorderLayout.CENTER);

		//���øô��ڴ�С���ɸı�
		setResizable(false);
		//���øô��ڴ�С
		setBounds(0, 0, 500, 400);
		//���øô��ڳ�������Ļ�м�
		setLocationRelativeTo(frame);
		//���øô��ڿ���
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

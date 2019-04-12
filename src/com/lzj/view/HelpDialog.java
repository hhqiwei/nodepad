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
 * 帮助界面的主框架
 * 	属性
 * 		helpabout		帮助界面的关于子界面
 * @author zx583
 *
 */
public class HelpDialog extends JDialog implements ActionListener{
	//ActionCommand常量
	private static final String ActionCommand_about = "about";
	private static final String ActionCommand_info = "info";

	private JPanel helpabout, helpinfo;
	
	/**
	 * 构造函数对界面进行布局
	 */
	public HelpDialog(JFrame frame) {
		//设置Frame界面的布局为BorderLayout
		getContentPane().setLayout(new BorderLayout());
		
		//新建一个JMenuBar
		JMenuBar menu = new JMenuBar();
		
		//新建一个JMenuItem
		JMenuItem aboutItem = new JMenuItem("关于");
		//为该MenuItem设置ActionCommand
		aboutItem.setActionCommand(ActionCommand_about);
		//为该MenuItem设置ActionCommand
		aboutItem.addActionListener(this);
		//设置MenuItem背景颜色为白色
		aboutItem.setBackground(Color.white);
		
		
		//将该MenuItem加入MenuBar中
		menu.add(aboutItem);
		//设置MenuBar布局为FlowLayout(FlowLayout.LEFT)
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		//设置MenuBar背景为白色
		menu.setBackground(Color.white);
		
		//将MenuBar置入Frame的BorderLayout.NORTH位置
		getContentPane().add(menu, BorderLayout.NORTH);
		
		//实例化helpinfo界面
		helpinfo = new HelpInfo();

		getContentPane().add(helpinfo, BorderLayout.CENTER);

		//设置该窗口大小不可改变
		setResizable(false);
		//设置该窗口大小
		setBounds(0, 0, 500, 400);
		//设置该窗口出现在屏幕中间
		setLocationRelativeTo(frame);
		//设置该窗口可视
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}

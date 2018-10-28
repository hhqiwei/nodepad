package com.lzj.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;

import com.lzj.MainFrame;
import com.lzj.bean.NTextArea;
import com.lzj.inter.ResourceMgmt;
import com.lzj.server.ConfigServer;
import com.lzj.server.TextAreaMgmtServer;
import com.lzj.util.AlertWindows;
import com.lzj.view.ColorDialog;
import com.lzj.view.ConfigMenu;

/**
 * 设置菜单监听逻辑 属性 resourceMgmt 公有资源接口 textArea 操作的文本域对象 configServer 设置服务实例
 * textAreaMgmtServer 文本域管理服务对象
 * 
 * @author lzj
 *
 */
public class ConfigListener implements ActionListener {
	private ResourceMgmt resourceMgmt;
	private NTextArea textArea;
	private TextAreaMgmtServer textAreaMgmtServer;
	private ConfigServer configServer;

	/**
	 * 构造函数 直接传参实例化公有资源接口resourceMgmt，实例化textArea文本域对象
	 * 
	 * @param resourceMgmt
	 */
	public ConfigListener(ResourceMgmt resourceMgmt) {
		super();

		// 实例化公有资源接口resourceMgmt
		this.resourceMgmt = resourceMgmt;

		// 实例化textAreaMgmtServer对象
		this.textAreaMgmtServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");

		// 实例化configServer对象
		this.configServer = (ConfigServer) resourceMgmt.getAResource("configServer");

		// 是否自动换行

	}

	/**
	 * ActionCommand监听逻辑函数
	 */
	public void actionPerformed(ActionEvent e) {
		// 获得ACtionCommand值
		String actionCommand = e.getActionCommand();

		// 获得当前选中textArea对象
		textArea = textAreaMgmtServer.getUsingTextArea();

		// 判断ActionCommand对应的操作
		if (actionCommand.equals(ConfigMenu.ActionCommand_toUTF)) {
			// 点击了‘使用UTF-8编码’按钮
			// 判断当前文本域内是否有未保存的内容
			if (!textArea.isSaved()) {
				// 存在未保存内容,弹窗警告
				if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "继续操作可能会导致文档丢失", "警告:当前文档未保存")) {
					// 取消事件操作
					return;
				}
			}

			configServer.useUTF(true);

		} else if (actionCommand.equals(ConfigMenu.ActionCommand_toGBK)) {
			// 点击了‘使用GBK编码’按钮
			// 判断当前文本域内是否有未保存的内容
			if (!textArea.isSaved()) {
				// 存在未保存内容,弹窗警告
				if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "继续操作可能会导致文档丢失", "警告:当前文档未保存")) {
					// 取消事件操作
					return;
				}
			}

			configServer.useGBK(true);
		} else if (actionCommand.equals(ConfigMenu.ActionCommand_font)) {
			// 点击了‘字体’按钮
			configServer.setFont();
		} else if (actionCommand.equals(ConfigMenu.AUTO_NEWLINE)) {
			configServer.setAutoNewLine(resourceMgmt);
		} else if (actionCommand.equals(ConfigMenu.FONT_COLOR)) {
			MainFrame main = (MainFrame)resourceMgmt.getAResource("main");
			Color color = JColorChooser.showDialog(main, "选色板", null);
			NTextArea textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
			textArea.setForeground(color);
		}
	}

}

package com.lzj.view;

import javax.swing.JMenuBar;

import com.lzj.bean.NMenu;
import com.lzj.inter.ResourceMgmt;
import com.lzj.listener.ConfigListener;
import com.lzj.listener.EditorListener;
import com.lzj.listener.FileListener;
import com.lzj.listener.HelpListener;
import com.lzj.util.MenuFontUtil;

/**
 * 菜单条界面
 * 	属性
 * 		fileMenu, editorMenu, config, help		菜单条中的菜单
 * @author lzj
 *
 */
public class NMenuBar extends JMenuBar {
	private NMenu fileMenu, editorMenu, config, about;

	/**
	 * 构造方法中对菜单条进行布局
	 * @param resourceMgmt			上文传递来的公有资源管理接口    可从中获取公有资源
	 */
	public NMenuBar(ResourceMgmt resourceMgmt) {
		super();
		
		//新建一个菜单
		fileMenu = new FileMenu("文件", resourceMgmt);
		//设置该菜单的字体
		MenuFontUtil.setMenuFont(fileMenu);
		
		
		editorMenu = new EditorMenu("编辑", resourceMgmt);
		MenuFontUtil.setMenuFont(editorMenu);
		
		config = new ConfigMenu("设置", resourceMgmt);
		MenuFontUtil.setMenuFont(config);
	
		about = new NMenu("关于", resourceMgmt);
		MenuFontUtil.setMenuFont(about);
		
		//为该菜单添加对应的监听逻辑
		fileMenu.addActionListener(new FileListener(resourceMgmt));
		EditorListener editorListener = new EditorListener(resourceMgmt);
		editorMenu.addMenuListener(editorListener);
		editorMenu.addActionListener(editorListener);
		config.addActionListener(new ConfigListener(resourceMgmt));
		about.addMouseListener(new HelpListener(resourceMgmt));
		
		//将该菜单加到菜单条中
		add(fileMenu);
		add(editorMenu);
		add(config);
		add(about);
	}
}

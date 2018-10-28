package com.lzj.listener;

import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.lzj.bean.NTextArea;
import com.lzj.inter.ResourceMgmt;
import com.lzj.server.FileServer;
import com.lzj.util.AlertWindows;
import com.lzj.view.RightPopupMenu;

public class TextAreaListener extends DropTargetAdapter implements MouseListener {
	private NTextArea textArea;
	private ResourceMgmt resourceMgmt;
	private DropTarget dropTarget; 
	private FileServer fileServer;
	private RightPopupMenu rightPopupMenu;

	public TextAreaListener(ResourceMgmt resourceMgmt) {
		super();
		this.resourceMgmt = resourceMgmt;
		this.rightPopupMenu = (RightPopupMenu) resourceMgmt.getAResource("RightPopupMenu_rightPopupMenu");
		this.fileServer = (FileServer)resourceMgmt.getAResource("fileServer");
		this.textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
		//注册DropTarget，并将它与组件相连，处理哪个组件的相连    
        //即连通组件（textArea）和Listener(this)    
		this.dropTarget = new DropTarget(textArea, DnDConstants.ACTION_COPY_OR_MOVE, this);
	}

	//拖拽动作鼠标放开
	public void drop(DropTargetDropEvent dtde) {
		// 文本拖拽打开操作
		// 判断当前文本域内是否有未保存的内容
		if (!textArea.isSaved()) {
			// 存在未保存内容,弹窗警告
			if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "继续操作可能会导致文档丢失",
					"警告:当前文档未保存")) {
				// 取消事件操作
				dtde.rejectDrop();
				return;
			}
		}


	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			rightPopupMenu.show(textArea, e.getX(), e.getY());
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}


}

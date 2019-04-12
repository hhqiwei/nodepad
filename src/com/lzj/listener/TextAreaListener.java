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
		//ע��DropTarget������������������������ĸ����������    
        //����ͨ�����textArea����Listener(this)    
		this.dropTarget = new DropTarget(textArea, DnDConstants.ACTION_COPY_OR_MOVE, this);
	}

	//��ק�������ſ�
	public void drop(DropTargetDropEvent dtde) {
		// �ı���ק�򿪲���
		// �жϵ�ǰ�ı������Ƿ���δ���������
//		if (!textArea.isSaved()) {
//			// ����δ��������,��������
//			if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "�����������ܻᵼ���ĵ���ʧ",
//					"����:��ǰ�ĵ�δ����")) {
//				// ȡ���¼�����
//				dtde.rejectDrop();
//				return;
//			}
//		}


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

package com.lzj.inter;

/**
 * 设置功能接口
 * @author lzj
 *
 */
public interface ConfigInter {
	/**
	 * 使用UTF-8重载
	 */
	public int useUTF(boolean force);
	
	/**
	 * 使用GBK重载
	 */
	public int useGBK(boolean force);
	
	/**
	 * 设置字体
	 */
	public void setFont();
}

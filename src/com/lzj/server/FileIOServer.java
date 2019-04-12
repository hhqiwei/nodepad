package com.lzj.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.lzj.inter.FileIOInter;

/**
 * �ļ�������		ʵ��FileInter�ӿ�
 * ����
 * 		�ӿ���������δʵ�ֵķ���
 * @author lzj
 *
 */
public class FileIOServer implements FileIOInter {
	public FileIOServer() {
		super();
	}

	/**
	 * ��ȡ�ļ�����
	 * 
	 * FileName ��ȡ���ļ�·�� charset ��ȡ�ļ�ʹ�õ��ַ��� ��Ϊnull��ʹ���Զ������
	 * 
	 * ����String���� ÿ��String��ʾһ�� ����ԭ��ɾȥ�س� ���ִ���ʱ���ؿռ���
	 */
	public ArrayList<String> readCharFile(String fileName, String charset) {
		ArrayList<String> result = new ArrayList<String>();

		if (fileName == null)
			return result;

		return readCharFile(new File(fileName), charset);
	}

	/**
	 * д���ļ�����
	 * 
	 * fileName д����ļ�·�� 
	 * data д����ļ����ݼ��� ÿ��String��ʾһ������ ����Я���س��� 
	 * charset �Զ���д���ļ����ַ��� null��ʾ��ʹ���Զ����ַ���
	 * 
	 * ���ִ��󷵻�false ��������true
	 */
	public boolean wirteCharFile(String fileName, String[] data, String charset) {
		// TODO Auto-generated method stub
		if (fileName == null)
			return false;

		return wirteCharFile(new File(fileName), data, charset);
	}



	/**
	 * ��ȡ�ļ�����
	 * 
	 * file ��ȡ���ļ�
	 * 
	 * ����String���� ÿ��String��ʾһ�� ����ԭ��ɾȥ�س� ���ִ���ʱ���ؿռ���
	 */
	public ArrayList<String> readCharFile(File file) {
		// TODO Auto-generated method stub
		return readCharFile(file, null);
	}

	/**
	 * ��ȡ�ļ�����
	 * 
	 * FileName ��ȡ���ļ�·��
	 * 
	 * ����String���� ÿ��String��ʾһ�� ����ԭ��ɾȥ�س� ���ִ���ʱ���ؿռ���
	 */
	public ArrayList<String> readCharFile(String fileName) {
		// TODO Auto-generated method stub
		return readCharFile(fileName, null);
	}

	/**
	 * ��ȡ�ļ�����
	 * 
	 * file ��ȡ���ļ� charset ��ȡ�ļ�ʹ�õ��ַ��� ��Ϊnull��ʹ���Զ������
	 * 
	 * ����String���� ÿ��String��ʾһ�� ����ԭ��ɾȥ�س� ���ִ���ʱ���ؿռ���
	 */
	public ArrayList<String> readCharFile(File file, String charset) {
		ArrayList<String> result = new ArrayList<String>();

		if (file == null)
			return result;

		BufferedReader reader = null;
		try {
			if (charset != null) {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(file), charset));
			} else {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));
			}

			String tmp;


			while ((tmp = reader.readLine()) != null) {
				result.add(tmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ArrayList<String>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ArrayList<String>();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return result;
	}

	/**
	 * д���ļ�����
	 * 
	 * file д����ļ�
	 * data д����ļ����ݼ��� ÿ��String��ʾһ������ ����Я���س���
	 * 
	 * ���ִ��󷵻�false ��������true
	 */
	public boolean wirteCharFile(File file, String[] data) {
		// TODO Auto-generated method stub
		return wirteCharFile(file, data, null);
	}

	/**
	 * д���ļ�����
	 * 
	 * fileName д����ļ�·�� 
	 * data д����ļ����ݼ��� ÿ��String��ʾһ������ ����Я���س��� 
	 * 
	 * ���ִ��󷵻�false ��������true
	 */
	public boolean wirteCharFile(String fileName, String[] data) {
		return wirteCharFile(fileName, data, null);
	}

	/**
	 * д���ļ�����
	 * 
	 * file д����ļ�
	 * data д����ļ����ݼ��� ÿ��String��ʾһ������ ����Я���س��� 
	 * charset �Զ���д���ļ����ַ��� null��ʾ��ʹ���Զ����ַ���
	 * 
	 * ���ִ��󷵻�false ��������true
	 */
	public boolean wirteCharFile(File file, String[] data, String charset) {
		// TODO Auto-generated method stub
		if (file == null)
			return false;

		BufferedWriter writer = null;
		try {
			if (charset != null) {
				writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file), charset));
			} else {
				writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file)));
			}

			for (String tmp : data) {
				writer.write(tmp);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();

			return false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return true;
	}
}

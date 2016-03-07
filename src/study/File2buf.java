/**
 * java基础练习题-的第一小题
 * 
 * @author	zhyz
 * @creatdate	2016-03-01
 *  
 */
package study;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 该类用于将制定的文件，以字节数组的形式读取 拥有唯一file2buf方法，返回制定文件的字符数组
 * 
 * @author zhyz
 * @creatdate 20160301
 */
public class File2buf {
	/**
	 * 实现从把一个文件的内容写进一个字节数组。如果不存在或者为null，或者只是一个路径，则返回null
	 * 
	 * @param fobj
	 *            是一个文件对象参数。
	 * @return byte[] 是一位字节数组。
	 * @throws IOException
	 */
	public byte[] file2buf(File fobj) throws IOException {
		// 空判断要在最开始？
		if (fobj == null) {
			return null;
		}
		// 不存在或者只是一个路径，直接返回null
		if (!fobj.exists() || fobj.isDirectory()) {
			return null;
		}
		if (fobj.length() > 2 * Integer.MAX_VALUE + 1) {
			throw new IllegalArgumentException("不支持大小超过2G文件");
		}
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new FileInputStream(fobj);
			// 根据文件大小创建字节数组流的大小，防止内存浪费
			out = new ByteArrayOutputStream((int) fobj.length());
			byte[] bytes = new byte[4096];// 常用4096
			int len;
			while ((len = in.read(bytes)) != -1) {
				out.write(bytes, 0, len);
			}
			return out.toByteArray();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	}
}

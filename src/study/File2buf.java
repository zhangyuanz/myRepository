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
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 该类用于将制定的文件，以字节数组的形式读取
 * 拥有唯一file2buf方法，返回制定文件的字符数组
 * 可增加print方法，将读取的内容打印在控制台
 *
 * @author	zhyz
 * @creatdate	20160301
 */
public class File2buf {	
	/**
	 * 实现从把一个文件的内容写进一个字节数组。
	 * 
	 * @param fobj是一个文件对象参数。如果fobj不存在或者为null，则返回null
	 * @return byte[]
	 * @throws IOException	
	 */
	public byte[] file2buf(File fobj) throws IOException {
		if (fobj == null){
			return null ;		}	
		if (!fobj.exists()||fobj.isDirectory()){
			return null ;
		}
		FileInputStream in = new FileInputStream(fobj);
		//根据文件大小创建字节数组流的大小，防止内存浪费
		ByteArrayOutputStream out = new ByteArrayOutputStream((int)fobj.length());
		byte[] bytes = new byte[4096];//常用4096
		int len;
		try{
			while((len=in.read(bytes))!=-1){
				out.write(bytes, 0, len);
			}
		}finally{
			in.close();
			out.close();
		}
		return out.toByteArray();
	}
	/**
	 * Issues：在测试用例中避免所要打开的文件不存在的情况，不符合测试用例的规范原则
	 * 解决方案：本着怀疑一切用户输入的原则，故增加本方法保证file2buf的参数输入，
	 * 
	 * @param path是文件的路径
	 * @return 返回一个文件，如果打开失败，或者文件不存在，则返回null
	 */
	/*
	public File fileOpen(String path){
		File file = new File(path);
		if(!file.exists()){
			file = null;
		}
		return file;
	}
	*/
}

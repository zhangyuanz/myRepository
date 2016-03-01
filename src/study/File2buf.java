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
 * 该类用于将制定的文件，以字节数组的形式读取
 * 拥有唯一file2buf方法，返回制定文件的字符数组
 * 可增加print方法，将读取的内容打印在控制台
 *
 * @author	zhyz
 * @creatdate	20160301
 */
public class File2buf {	
	/**
	 * 通过从文件输入流按制定字节长度循环读取，然后写入到一个字节数组输出流中
	 * 利用字符数组输出流toByteArray()函数将缓冲区字节转换为数组返回
	 * 
	 * @param fobj是一个文件对象参数。如果fobj不存在或者为null，则返回null
	 * @return byte[]
	 * @throws IOException	
	 */
	public byte[] file2buf(File fobj) throws IOException {
		byte[] result = null;
		if (fobj == null){
			return null ;
		}	
		FileInputStream in = new FileInputStream(fobj);
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);//初始化制定长度，如果在写入过程中缓冲区大小不够，会自动扩容
		result = new byte[8];
		int len;
		while((len=in.read(result))!=-1){
			out.write(result, 0, len);
			/*
			 * write(byte[] b, int off, int len)就是将数组 b 中的 len 个字节按顺序写入输出流。
			 * 所以如果 b 为 null，则抛出 NullPointerException。
			 * 如果 off 为负，或 len 为负，又或者 off+len 大于数组 b 的长度，则抛出 IndexOutOfBoundsException。
			 * 如果 len 为零，则不写入字节。否则，首先写入字节 b[off]，然后写入字节 b[off+1]，依此类推；最后一个写入字节是 b[off+len-1]。
			 */
		}
		//释放资源
		in.close();
		out.close();
		result = out.toByteArray();
		return result;
	}
	/**
	 * Issues：在测试用例中避免所要打开的文件不存在的情况，不符合测试用例的规范原则
	 * 解决方案：本着怀疑一切用户输入的原则，故增加本方法保证file2buf的输入参数的有效性，
	 * 
	 * @return 返回一个文件，如果打开失败，或者文件不存在，则返回null
	 */
	public File fileOpen(String path){
		File file = new File(path);
		if(!file.exists()){
			file = null;
		}
		return file;
	}
}

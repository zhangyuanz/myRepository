package study;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class File2buf {
	/*
	 * 将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null
	 * 通过一个输入流指向文件，一个输出流指向字符数组
	 * 从文件中按字节数组制定长度读取，然后写入输出流
	 * 最后将输出流转换成数组
	 */
	public byte[] file2buf(File fobj) throws IOException {
		byte[] result = null;
		if (fobj == null){
			result = null;
		}	
		FileInputStream in = new FileInputStream(fobj);
		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		//以8个字节为单位读取文件
		result = new byte[8];
		int len;
		while((len=in.read(result))!=-1){
			out.write(result, 0, len);
		}
		in.close();
		out.close();
		result = out.toByteArray();
		return result;
	}
	
	/*
	 * 测试单元
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:/笔记.txt");
		File2buf F2B = new File2buf();
		byte[] ret;
		try {
			ret = F2B.file2buf(f);
			System.out.print(new String(ret));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

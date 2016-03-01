/**
 * 测试单元，测试从指定文件读取context到字节数组函数
 * 
 * @author	zhyz
 * @creatdate	20160301 
 */
package study;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
/**
 * 该类专门为测试File2buf类中的file2buf方法而设计
 * 该类拥有两个静态对象，一个是File2buf对象，是被测对象，一个是File对象，作为file2buf的参数 
 * @author zhyz
 *
 */
public class File2bufTests{
	private static File2buf obj = new File2buf();
	private static File file ;
	private static File file1;
	/**
	 * 20160301-12:50
	 * 在方法测试之前，要为file制定一个已经存在的文件，如果文件不存在，则为null
	 * 20160301-14:10
	 * 在测试单元做参数输入的异常处理不符合规范,所以修改为在被测类中添加fileopen方法，
	 * 在此before中调用
	 * <pre>
	 * file = new File("D:/test.txt");
	   if(!file.exists()){
		 file = null;
		}
	 * <pre>
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		file = obj.fileOpen("D:/test.txt");
		file1 = obj.fileOpen("D:/test1.txt");
	}
	/**
	 * 20160301-11:40
	 * 测试file2buf方法，定义array接受函数返回值，并断言是否是期望的结果
	 * 20160301-14:25
	 * 用array测试正常输入的结果，用array1测试异常：当文件不存在时的结果
	 * @throws IOException
	 */
	@Test
	public void testfile2buf() throws IOException {
		byte[] array = obj.file2buf(file);
		String text = "﻿这是一个测试用的文本，是为了测试java基础练习题一的file2buf函数的实现而存在的。";
		assertTrue(text.equals(new String(array)));
		byte[] array1 = obj.file2buf(file1);
		assertTrue(array1==null);
	}
	
	/**
	 * 释放测试用例所占用的资源
	 * 20160301-14:30
	 * 去掉@After中file与file1的释放，放在AfterClass中，因为本例只有一个函数测试，After与AfterClass没有必要分开写
	 * 但是当有很多个测试函数时，每次在After中关闭资源会比较浪费时间，都放在AfterClass中可以提高运行效率
	 */
	@AfterClass
	public static void destory(){
		obj = null;
	}
}

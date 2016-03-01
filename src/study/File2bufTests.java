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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
/**
 * 该类专门为测试File2buf类中的file2buf方法而设计
 * 该类拥有两个静态对象，一个是File2buf对象，是被测对象，一个是File对象，作为file2buf的参数
 * 
 * @author zhyz
 *
 */
public class File2bufTests{
	private static File2buf obj = new File2buf();
	private static File file = null;
	/**
	 * 在方法测试之前，要为file制定一个已经存在的文件，如果文件不存在，则为null
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		file = new File("D:/test.txt");
		if(!file.exists()){
			file = null;
		}
	}
	/**
	 * 测试file2buf方法，定义array接受函数返回值，并断言是否是期望的结果
	 * 
	 * @throws IOException
	 */
	@Test
	public void testfile2buf() throws IOException {
		byte[] array = obj.file2buf(file);
		String text = "﻿这是一个测试用的文本，是为了测试java基础练习题一的file2buf函数的实现而存在的。";
		if(file==null){
			assertTrue(array==null);
		}else{
			assertTrue(text.equals(new String(array)));
		}
	}
	
	@After
	public void down(){
		file = null;
	}
	/**
	 * 释放测试用例所占用的资源
	 */
	@AfterClass
	public static void destory(){
		obj = null;
	}
}

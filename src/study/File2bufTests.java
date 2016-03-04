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

import org.junit.Assert;
import org.junit.Test;
/**
 * 该类专门为测试File2buf类中的file2buf方法而设计
 * 该类拥有两个静态对象，一个是File2buf对象，是被测对象，一个是File对象，作为file2buf的参数 
 * @author zhyz
 *
 */
public class File2bufTests{
	private static File2buf obj = new File2buf();//首先创建一个被测试类的对象
	/**
	 * 测试file2buf方法正常输入
	 * @throws IOException
	 */
	@Test 
	public void testfile2buf() throws IOException {
		byte[] array = obj.file2buf(new File("d:/test.txt"));
		String text = "﻿这是一个测试用的文本，是为了测试java基础练习题一的file2buf函数的实现而存在的。";
		Assert.assertEquals(text, new String(array));
	}
	/**
	 * 测试文件不存在
	 * @throws IOException
	 */
	@Test
	public void testNotExist() throws IOException{
		byte[] array = obj.file2buf(new File("d:/test1.txt"));
		assertEquals(array,null);
	}
	/**
	 * 测试文件输入只是一个路径
	 * @throws IOException
	 */
	@Test 
	public void testIsDir() throws IOException{
		byte[] array = obj.file2buf(new File("d:/"));
		assertEquals(array,null);
	}
	/**
	 * 测试文件输入为空
	 * @throws IOException
	 */
	@Test 
	public void testNull() throws IOException{
		byte[] array = obj.file2buf(null);
		assertEquals(array,null);
	}
	/**
	 * 测试int长度，最大值最小值的
	 */
	/*
	@Test
	public void testint(){
		System.out.println("int长度："+Integer.SIZE);
		System.out.println("int最大值："+Integer.MAX_VALUE);
		System.out.println("int最小值："+Integer.MIN_VALUE);
	}
	*/
}

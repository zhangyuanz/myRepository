/**
 * 这是测试JUint，用于测试To16H类的int2Hex方法
 * @author	zhyz
 * @creatdate	20160301
 */
package study;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
/**
 * 该类是测试类，为测试int2Hex而存在
 * 拥有tearDownAfterClass，用于资源回收，testint2Hex测试int2Hex的运行结果
 * 一共给出负数，0，和正整数三类测试
 * 
 * @author zhyz
 *
 */
public class To16HTests {
	private static To16H obj = new To16H();
	/**
	 * 测试结束时释放资源
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		obj = null;
	}
	/**
	 * 测试intHex方法，通过断言给定不同的输入，看是否得到期望的结果
	 * 负数提示不能输入负数，0则是0x0H，整数就对应的十六进制字符串相等
	 */
	@Test
	public void testint2Hex() {
		Assert.assertTrue("不能输入负数！".equals(obj.int2Hex(-1)));
		Assert.assertTrue("0x0H".equals(obj.int2Hex(0)));
		Assert.assertTrue("0x1H".equals(obj.int2Hex(1)));
		Assert.assertTrue("0xAH".equals(obj.int2Hex(10)));
		Assert.assertTrue("0xBH".equals(obj.int2Hex(11)));
		Assert.assertTrue("0xFH".equals(obj.int2Hex(15)));
		Assert.assertTrue("0x10H".equals(obj.int2Hex(16)));
		Assert.assertTrue("0x11H".equals(obj.int2Hex(17)));
		Assert.assertTrue("0x64H".equals(obj.int2Hex(100)));
		Assert.assertTrue("0xC8H".equals(obj.int2Hex(200)));
		Assert.assertTrue("0xFFFFH".equals(obj.int2Hex(65535)));
		Assert.assertTrue("0x1869FH".equals(obj.int2Hex(99999)));
	}

}

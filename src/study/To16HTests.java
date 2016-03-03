/**
 * 这是测试JUint，用于测试To16H类的int2Hex方法
 * @author	zhyz
 * @creatdate	20160301
 */
package study;

import org.junit.Assert;
import org.junit.Test;
/**
 * 测试用例
 * @author zhyz
 *
 */
public class To16HTests {
	private static To16H obj = new To16H();
	/**
	 * 测试intHex方法的一般正常输入
	 */
	@Test
	public void testint2Hex() {
		test("-0x1H",-1);
		test("0x0H",0);
		test("0x1H",1);
		test("0xAH",10);
		test("-0xAH",-10);
		test("0xBH",11);
		test("0xFH",15);
		test("0x10H",16);
		test("0x64H",100);
		test("0xFFFFH",65535);
	}
	/**
	 * 测试intHex方法参数的边界值
	 */
	@Test
	public void testBoundary(){
		test("0x7FFFFFFFH",2147483647);
		test("-0x(0000000H",-2147483648);
		
	}
	public void test(String exp,int ori){
		Assert.assertEquals(exp,obj.int2Hex(ori));
	}
}

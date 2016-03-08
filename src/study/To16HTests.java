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
		test("-1",-1);
		test("0",0);
		test("1",1);
		test("A",10);
		test("-A",-10);
		test("B",11);
		test("F",15);
		test("10",16);
		test("64",100);
		test("FFFF",65535);
	}
	/**
	 * 测试intHex方法参数的边界值
	 */
	@Test
	public void testBoundary(){
		test("7FFFFFFF",2147483647);
		test("-7FFFFFFF",-2147483647);
		test("-800000000",-2147483648);
		
	}
	public void test(String exp,int ori){
		Assert.assertEquals(exp,obj.int2Hex(ori));
	}
}

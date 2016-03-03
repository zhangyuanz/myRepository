/**
 * java基础练习题一的第二小题
 * @author zhyz
 * @creatdate	20160301
 */
package study;
/**
 * 该类用于将一个整型数值转换成对应的十六进制字符串而设计
 * 其拥有唯一方法int2Hex
 */
public class To16H {
	/**
	 * 将一个整数转换成字符串，如果输入的整数不合法，则抛出异常，否则返回该整数对应的字符串
	 * <pre>
	 * eg:"0x0H"==0;"0xAH"==10;"-0xAH"==-10;
	 * </pre>
	 * @param	a 一个32有符号整数
	 * @return  str 是转换后得到的字符串 			
	 */
	public  String int2Hex(int a){
		String str = null;
		//java整数范围检查
		if(a < -2147483648||a > 2147483647){
			throw new IllegalArgumentException("整数越界");
			//throw 抛出异常？
		}else{
			if(a==0){
				return "0x0H";
			}
			
			StringBuilder hex = new StringBuilder();
			if(a < 0){//负数处理
				a = a*(-1);
				while(a!=0){
					int x = a%16;
					char c = (x<10)?(char)(x+48):(char)(x+55);
					hex.append(c);
					a=a/16;
				}
				str = "-0x"+hex.reverse().toString()+'H';
			}else{//正数处理
				while(a!=0){
					int x = a%16;
					char c = (x<10)?(char)(x+48):(char)(x+55);
					hex.append(c);
					a=a/16;
				}
				str = "0x"+hex.reverse().toString()+'H';
			}
		}
		return str;
	}
}

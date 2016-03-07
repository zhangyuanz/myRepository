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
	 * @param	a 一个int型整数
	 * @return  str 是转换后得到的字符串 			
	 */
	public  String int2Hex(int a){
		//String str = null;
		//java整数范围检查
		if(a < Integer.MIN_VALUE||a > Integer.MAX_VALUE){
			throw new IllegalArgumentException("整数参数溢出");
		}else{
			//0做特殊处理，按此方法得到的是0xH不是预期的0x0H，所以作此处理
			if(a==0){
				return "0x0H";
			}
			if(a == Integer.MIN_VALUE){
				return "-080000000H";
			}else{
				StringBuilder hex = new StringBuilder();
				if(a < 0){//负数处理
					a = a*(-1);
					_int2hex(hex,a);
					return "-0x"+hex.reverse().toString()+'H';
				}else{//正数处理
					_int2hex(hex,a);
					return "0x"+hex.reverse().toString()+'H';
				}
			}	
		}
	}
	/**
	 * 对正整数处理，且小于等于最大值的整数，将其转换为StringBuilder
	 * @param str
	 * @param a
	 */
	public void _int2hex(StringBuilder str,int a){
		while(a!=0){
			int x = a%16;
			char c = (x<10)?(char)(x+48):(char)(x+55);
			str.append(c);
			a=a/16;
		}
	}
}

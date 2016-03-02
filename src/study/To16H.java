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
	 * 通过定义一个数组来存储参数a对16循环取得的余数
	 * 然后查找ASCII码表转换成字符，构造出字符串并返回
	 * 
	 * @param	a是一个无符号整数
	 * @return	如果a是负数，则返回提示信息，否则返回对应的十六进制字符串 			
	 */
	public  String int2Hex(int a){
		if(a<0){
			return "不能输入负数！";
		}
		/*
		 * 20160301-15：13
		 * Issues:在测试时发现其他用例正常，当a为0时，结果是0xH，不符合要求
		 * 因此添加此处判断预处理
		 */
		if(a==0){
			return "0x0H";
		}
		String hex = null;
		int n=0;
		char[] b = new char[8];
		while(a!=0){
			int x = a%16;//b是一个临时存放a余数的数组，初始化长度为8，有可能产生越界，需要根据a的最大可能值确定一个合理的size
			b[n] = (x<10)?(char)(x+48):(char)(x+55);
			a=a/16;
			n++;
		}
		//反序
		for(int i = 0;i < n/2;i++){
			char temp = b[i];
			b[i] = b[n-1-i];
			b[n-1-i] = temp;
		}
		/*char[] c = new char[n];//根据实际的长度初始化c，不浪费内存
		for(int i=0;i<n;i++){
			if(b[i]<10){
				c[n-i-1]=(char)(b[i]+48);
			}else{
				c[n-i-1]=(char)(b[i]+55);
			}
		}*/
		hex = new String(b);
		hex = "0x"+hex+"H";
		return hex;
		
	}
}

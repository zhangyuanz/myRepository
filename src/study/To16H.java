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
		String Hex = null;
		int n=0;
		int[] b = new int[8];
		while(a!=0){
			b[n]=a%16;//b是一个临时存放a余数的数组，初始化长度为8，有可能产生越界，需要根据a的最大可能值确定一个合理的size
			a=a/16;
			n++;
		}
		char[] c = new char[n];//根据实际的长度初始化c，不浪费内存
		for(int i=0;i<n;i++){
			if(b[i]<10){
				c[n-i-1]=(char)(b[i]+48);
			}else{
				c[n-i-1]=(char)(b[i]+55);
			}
		}
		Hex = new String(c);
		Hex = "0x"+Hex+"H";
		//释放临时占用的资源
		b = null;
		c = null;
		return Hex;
		
	}
}

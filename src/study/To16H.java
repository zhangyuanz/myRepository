package study;

/*
 * 2016-2-27
 * zhyz
 */
public class To16H {
	/*
	 * 定义一个数组来存储参数a对16循环取得的余数
	 * 然后查找ASCII码表转换成字符，构造出字符串
	 */
	public  String int2Hex(int a){
		if(a<0){
			return "请输入正整数！";
		}
		String Hex = null;
		int n=0;
		int[] b = new int[8];
		while(a!=0){
			b[n]=a%16;
			a=a/16;
			n++;
		}
		char[] c = new char[n];
		for(int i=0;i<n;i++){
			if(b[i]<10){
				c[n-i-1]=(char)(b[i]+48);
			}else{
				c[n-i-1]=(char)(b[i]+55);
			}
		}
		Hex = new String(c);
		Hex = "0x"+Hex+"H";
		return Hex;
		
	}
	/*
	 * 测试单元
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		To16H change = new To16H();
		System.out.println(change.int2Hex(-1));
		System.out.println(change.int2Hex(0));
		System.out.println(change.int2Hex(1));
		System.out.println(change.int2Hex(10));
		System.out.println(change.int2Hex(11));
		System.out.println(change.int2Hex(15));		
		System.out.println(change.int2Hex(16));
		System.out.println(change.int2Hex(17));
		System.out.println(change.int2Hex(100));
		System.out.println(change.int2Hex(200));
		System.out.println(change.int2Hex(65535));
		System.out.println(change.int2Hex(99999));
		
	}

}

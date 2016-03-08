package study;

public class WrongParamException extends Throwable {
	private static final long serialVersionUID = 1L;
	/**
	 * 默认构造函数
	 */
	public WrongParamException(){
		super();
	}
	/**
	 * 构造函数
	 * 
	 * @param arg
	 */
	public WrongParamException(String arg){
		super(arg);
	}
}

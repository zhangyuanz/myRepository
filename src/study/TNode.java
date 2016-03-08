package study;
/**
 * 节点类的数据结构，以及其构造方法
 * 
 * @author Administrator
 *
 */
public class TNode {
	private char value;
	private TNode left, right;
	/**
	 * 构造函数
	 * 
	 * @param v
	 * 			是构造节点对应的data
	 */
	public TNode(char v) {
		this.value = v;
		this.left = null;
		this.right = null;
	}
	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}
	
	/**
	 * @return the right
	 */
	public TNode getRight() {
		return right;
	}
	
	/**
	 * @return the left
	 */
	public TNode getLeft() {
		return left;
	}
	public void setLeft(TNode insert) {
		this.left = insert;
		
	}
	public void setRight(TNode insert) {
		this.right = insert;
		
	}
	
	
}
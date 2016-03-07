package study;
/**
 * 节点类的数据结构，以及其构造方法
 * 
 * @author Administrator
 *
 */
public class TNode {
	char value;
	TNode left, right;
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
}
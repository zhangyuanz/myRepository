package study;

import org.junit.Assert;
import org.junit.Test;
/**
 * 自动构造二叉树，并且通过先序遍历，中序遍历方法判断其准确性
 * @author Administrator
 *
 */
public class TreeDealTest {
	
	private static TreeDeal dealTree = new TreeDeal();
	/**
	 * 递归插入法向一个节点中插入新数据
	 * 
	 * @param t 是一个被插入的节点
	 * @param c 是一个待插入的数据
	 * @return 返回根节点
	 */
	public TNode insert(TNode t, char c) {
		if (t == null) {
			t = new TNode(c);
		} else {
			if (c > t.value) {
				t.left = insert(t.left, c);
			} else {
				t.right = insert(t.right, c);
			}
		}
		return t;
	}
	/**
	 * 根据字符串自动构造二叉树
	 * 
	 * @param str 字符串参数
	 * @return 返回二叉树的根节点
	 */
	public TNode creat(String str){
		char[] array = str.toCharArray();
		TNode root = null;
		for(int i = 0;i < array.length;i ++){
			
			root = insert(root,array[i]);
		}
		return root;
	}
	
	/**
	 * 测试获得二叉树的深度函数getLevel
	 */
	@Test
	public void testgetLevel() {
		Assert.assertEquals(4, dealTree.getLevel(creat("ABCD")));
	}
	/**
	 * 临时测试函数
	 */
	@Test
	public void test(){
		System.out.println();
		System.out.print("先序遍历：");
		foreach(creat("ABC"));
		System.out.print("中序遍历：");
		mid(creat("ABC"));
		System.out.println();
		System.out.print("先序遍历：");
		foreach(creat("ABCDEFGH"));
		System.out.print("中序遍历：");
		mid(creat("ABCDEFGH"));
	}
	
	/**
	 * 将节点数组的值连接成字符串
	 * @param nodes
	 * @return
	 */
	public String nodesToString(TNode[] nodes) {
		String str = "";
		try {
			for (int i = 0; i < nodes.length; i++) {
				if (nodes[i] != null) {
					str = str + nodes[i].value;
				}
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return str;

	}
	/**
	 * 先序遍历//检查二叉树正确与否
	 * 
	 * @param t
	 * 
	 */
	public void foreach(TNode t) {
		// 用于检查正确性
		System.out.print(t.value + "-");
		if (t.left != null) {
			foreach(t.left);
		}
		if (t.right != null) {
			foreach(t.right);
		}
	}
	/**
	 * 后序序遍历
	 */
	public void mid(TNode t){
		if (t.left != null) {
			foreach(t.left);
		}
		System.out.print(t.value + "-");
		if (t.right != null) {
			foreach(t.right);
		}
	}
}

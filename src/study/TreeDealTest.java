package study;

import org.junit.Assert;
import org.junit.Test;

/**
 * 自动构造二叉树，并且通过先序遍历，中序遍历方法判断其准确性
 * 
 * @author Administrator
 *
 */
public class TreeDealTest {

	private static TreeDeal dealTree = new TreeDeal();

	/**
	 * 递归插入法向一个节点中插入新数据
	 * 
	 * @param t
	 *            是一个被插入的节点
	 * @param c
	 *            是一个待插入的数据
	 * 
	 * @return 返回根节点
	 */
	public TNode insert(TNode t, char c) {
		if (t == null) {
			t = new TNode(c);
		} else {
			if (c <= t.value) {// 左节点永远小于右节点的规则
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
	 * @param str
	 *            字符串参数
	 * 
	 * @return 返回二叉树的根节点
	 */
	public TNode creat(String str) {
		char[] array = str.toCharArray();
		TNode root = null;
		for (int i = 0; i < array.length; i++) {
			root = insert(root, array[i]);
		}
		return root;
	}

	/**
	 * 测试用例ABCD,只有右节点的二叉树
	 * 
	 * <pre>
	 *   A
	 *    \
	 *     B
	 *      \
	 *       C
	 *        \
	 *         D
	 * </pre>
	 */
	@Test
	public void testABCD() {
		TNode tree = creat("ABCD");
		// 先通过3中遍历方法检查所创建的二叉树正确性
		Assert.assertEquals("ABCD", first(tree));
		Assert.assertEquals("ABCD", mid(tree));
		Assert.assertEquals("DCBA", last(tree));

		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("B", nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("C", nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertEquals("D", nodesToString(dealTree.TreeLevel(tree, 4)));
		Assert.assertNull(dealTree.TreeLevel(creat("ABCD"), 5));
	}

	/**
	 * 测试用例ABCD,只有右节点的二叉树
	 * 
	 * <pre>
	 *         D 
	 *        /
	 *       C
	 *      /
	 *     B
	 *    /
	 *   A
	 * </pre>
	 */
	@Test
	public void testDCBA() {
		TNode tree = creat("DCBA");
		// 先通过3中遍历方法检查所创建的二叉树正确性
		Assert.assertEquals("DCBA", first(tree));
		Assert.assertEquals("ABCD", mid(tree));
		Assert.assertEquals("ABCD", last(tree));

		Assert.assertEquals("D", nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("C", nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("B", nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(tree, 4)));
		Assert.assertNull(dealTree.TreeLevel(creat("DCBA"), 5));
	}

	/**
	 * 测试用例BACD，部分节点只有右子节点
	 * 
	 * <pre>
	 *    B
	 *   / \
	 *  A   C
	 *       \
	 *        D
	 * </pre>
	 */
	@Test
	public void testBACD() {
		TNode tree = creat("BACD");
		// 先通过3中遍历方法检查所创建的二叉树正确性
		Assert.assertEquals("BACD", first(tree));
		Assert.assertEquals("ABCD", mid(tree));
		Assert.assertEquals("ADCB", last(tree));

		Assert.assertEquals("B", nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("AC", nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("D", nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertNull(dealTree.TreeLevel(tree, 4));
	}

	/**
	 * 测试用例CBAD，部分节点只有左子节点
	 * 
	 * <pre>
	 *      C
	 *     / \
	 *    B   D
	 *   /    
	 *  A
	 * </pre>
	 */
	@Test
	public void testCBAD() {
		TNode tree = creat("CBAD");
		// 先通过3中遍历方法检查所创建的二叉树正确性
		Assert.assertEquals("CBAD", first(tree));
		Assert.assertEquals("ABCD", mid(tree));
		Assert.assertEquals("ABDC", last(tree));

		Assert.assertEquals("C", nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BD", nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertNull(dealTree.TreeLevel(tree, 4));
	}

	/**
	 * 测试用例,测一颗完全二叉树
	 * 
	 * <pre>
	 *       D
	 *      / \
	 *     B   F
	 *    /\   /\    
	 *   A  C E  G
	 * </pre>
	 */
	@Test
	public void testDBACFEG() {
		TNode tree = creat("DBACFEG");
		// 先通过3中遍历方法检查所创建的二叉树正确性
		Assert.assertEquals("DBACFEG", first(tree));
		Assert.assertEquals("ABCDEFG", mid(tree));
		Assert.assertEquals("ACBEGFD", last(tree));

		Assert.assertEquals("D", nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BF", nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("ACEG", nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertNull(dealTree.TreeLevel(tree, 4));
	}

	/**
	 * 将节点数组的值连接成字符串
	 * 
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
	 *            是需要遍历的二叉树的根节点
	 * 
	 */
	public String first(TNode t) {
		// 用于检查正确性
		StringBuilder str = new StringBuilder();
		str.append(t.value);
		if (t.left != null) {
			str.append(first(t.left));
		}
		if (t.right != null) {
			str.append(first(t.right));
		}
		return str.toString();
	}

	/**
	 * 中序序遍历
	 * 
	 * @param t
	 *            是需要遍历的二叉树的根节点
	 */
	public String mid(TNode t) {
		StringBuilder str = new StringBuilder();
		if (t.left != null) {
			str.append(mid(t.left));
		}
		str.append(t.value);
		if (t.right != null) {
			str.append(mid(t.right));
		}
		return str.toString();
	}

	/**
	 * 后序遍历
	 * 
	 * @param t
	 *            是需要遍历的二叉树的根节点
	 */
	public String last(TNode t) {
		StringBuilder str = new StringBuilder();
		if (t.left != null) {
			str.append(last(t.left));
		}
		if (t.right != null) {
			str.append(last(t.right));
		}
		str.append(t.value);
		return str.toString();
	}
}

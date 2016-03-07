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
			if (c <= t.value) {// 左节点永远小于右节点
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
		System.out.println("深度：" + dealTree.getLevel(creat("ABCD")));
		TNode tree = creat("ABCD");
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
	 * D / C / B / A
	 * </pre>
	 */
	@Test
	public void testDCBA() {
		TNode tree = creat("DCBA");
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
	public void first(TNode t) {
		// 用于检查正确性
		System.out.print(t.value + "-");
		if (t.left != null) {
			first(t.left);
		}
		if (t.right != null) {
			first(t.right);
		}
	}

	/**
	 * 中序序遍历
	 * 
	 * @param t
	 *            是需要遍历的二叉树的根节点
	 */
	public void mid(TNode t) {
		if (t.left != null) {
			mid(t.left);
		}
		System.out.print(t.value + "-");
		if (t.right != null) {
			mid(t.right);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param t
	 *            是需要遍历的二叉树的根节点
	 */
	public void last(TNode t) {
		if (t.left != null) {
			last(t.left);
		}
		if (t.right != null) {
			last(t.right);
		}
		System.out.print(t.value + "-");
	}
}

package study;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


/**
 * 测试用例，测试TreeDeal类的TreeLevel方法
 * 手动构造多颗二叉树，每棵树测试其所有n的取值情况
 * 
 * @Creatdate 20160303
 * @author Administrator
 *
 */
public class TreeDealTest0 {
	
	/**
	 * 手动构造ABCDEFGH二叉树，并返回根节点
	 * 
	 * <pre>
	 *            A
	 *          /   \
	 *         B     C
	 *        / \   /  \
	 *       D   E F    G
	 *      /
	 *     H
	 * </pre>
	 */
	public TNode creat2() {
		TNode t = new TNode('A');
		t.left = new TNode('B');
		t.right = new TNode('C');
		t.left.left = new TNode('D');
		t.left.right = new TNode('E');
		t.right.left = new TNode('F');
		t.right.right = new TNode('G');
		t.left.left.left = new TNode('H');
		return t;
	}

	/**
	 * 
	 * <pre>
	 *            A
	 *           /  \
	 *          B    C
	 *          \   /  \
	 *           E F    G
	 * </pre>
	 */
	public TNode creat3() {
		TNode t = new TNode('A');
		t.left = new TNode('B');
		t.right = new TNode('C');
		// t.left.left = new TNode('D');
		t.left.right = new TNode('E');
		t.right.left = new TNode('F');
		t.right.right = new TNode('G');
		return t;
	}

	/**
	 * 
	 * <pre>
	 *             A
	 *           /  \
	 *          B    C
	 *         /\   /  
	 *        D  E F
	 * </pre>
	 */
	public TNode creat4() {
		TNode t = new TNode('A');
		t.left = new TNode('B');
		t.right = new TNode('C');
		t.left.left = new TNode('D');
		t.left.right = new TNode('E');
		t.right.left = new TNode('F');
		// t.right.right = new TNode('G');
		return t;
	}

	/**
	 * <pre>
	 *            A
	 *           /  \
	 *          B    C
	 *         /\   
	 *        D  E
	 * </pre>
	 */
	public TNode creat5() {
		TNode t = new TNode('A');
		t.left = new TNode('B');
		t.right = new TNode('C');
		t.left.left = new TNode('D');
		t.left.right = new TNode('E');
		// t.right.left = new TNode('F');
		// t.right.right = new TNode('G');
		return t;
	}

	private static TreeDeal dealTree = new TreeDeal();

	/**
	 * 测试左右节点都有的二叉树
	 */
	@Ignore
	public void test1TreeLevel() {
		TNode tree = creat2();
		Assert.assertEquals("A",nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BC",nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertNull(dealTree.TreeLevel(tree, 3));
		Assert.assertNull(dealTree.TreeLevel(tree, 0));
	}

	/**
	 * 
	 * <pre>
	 *            A
	 *          /   \
	 *         B     C
	 *        / \   /  \
	 *       D   E F    G
	 *      /
	 *     H
	 * </pre>
	 */
	@Test
	public void test2TreeLevel() {
		TNode tree = creat2();
		System.out.println();
		System.out.print("先序遍历：");
		first(tree);
		System.out.println();
		
		Assert.assertEquals("A",nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BC",nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("DEFG",nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertEquals("H",nodesToString(dealTree.TreeLevel(tree, 4)));
		
		Assert.assertNull(dealTree.TreeLevel(tree, 5));
		
		Assert.assertNull(dealTree.TreeLevel(tree, 0));
	}

	/**
	 * <pre>
	 *            A
	 *           /  \
	 *          B    C
	 *          \   /  \
	 *           E F    G
	 * </pre>
	 */
	@Test
	public void test3TreeLevel() {
		TNode tree = creat3();
		System.out.println();
		System.out.print("先序遍历：");
		first(tree);
		System.out.println();
		Assert.assertEquals("A",nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BC",nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("EFG",nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertNull(dealTree.TreeLevel(tree, 4));
		Assert.assertNull(dealTree.TreeLevel(tree, 0));
	}

	/**
	 * <pre>
	 *             A
	 *           /  \
	 *          B    C
	 *         /\   /  
	 *        D  E F
	 * </pre>
	 */
	@Test
	public void test4TreeLevel() {
		TNode tree = creat4();
		System.out.println();
		System.out.print("先序遍历：");
		first(tree);
		System.out.println();
		Assert.assertEquals("A",nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BC",nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("DEF",nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertNull(dealTree.TreeLevel(tree, 4));
		Assert.assertNull(dealTree.TreeLevel(tree, 0));
	}

	/**
	 * <pre>
	 *            A
	 *           /  \
	 *          B    C
	 *         /\   
	 *        D  E
	 * </pre>
	 */
	@Test
	public void test5TreeLevel() {
		TNode tree = creat5();
		System.out.println();
		System.out.print("先序遍历：");
		first(tree);
		System.out.println();
		Assert.assertEquals("A",
				nodesToString(dealTree.TreeLevel(tree, 1)));
		Assert.assertEquals("BC",
				nodesToString(dealTree.TreeLevel(tree, 2)));
		Assert.assertEquals("DE",
				nodesToString(dealTree.TreeLevel(tree, 3)));
		Assert.assertNull(dealTree.TreeLevel(tree, 4));
		Assert.assertNull(dealTree.TreeLevel(tree, 0));
	}

	/**
	 * 将一个节点数据的数据连成字符串，方便测试
	 * 
	 * @param nodes
	 * @return
	 */
	public String nodesToString(TNode[] nodes) {
		String str = "";
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				str = str + nodes[i].value;
			}
		}

		return str;

	}
	
	/**
	 * 先序遍历//检查二叉树正确与否
	 * 
	 * @param t
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
}

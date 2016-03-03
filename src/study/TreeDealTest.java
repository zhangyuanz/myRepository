package study;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
/**
 * 测试用例，测试TreeDeal类的TreeLevel方法
 * @Creatdate 20160303
 * @author Administrator
 *
 */
public class TreeDealTest {
	private static TreeDeal dealTree = new TreeDeal();
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setup(){
		dealTree.root = null;
		dealTree.Level = 0;
	}
	/**
	 * 测试左右节点都有的二叉树
	 */
	@Ignore
	public void test1TreeLevel() {
		char[] array = {'A','B','C'};
		dealTree.creat1(array);
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(dealTree.root, 1)));
		Assert.assertEquals("BC", nodesToString(dealTree.TreeLevel(dealTree.root, 2)));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 3));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 0));
	}
	/**
	 * 测试缺少右节点的二叉树
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
	public void test2TreeLevel(){
		dealTree.creat2();
		dealTree.foreach(dealTree.root);
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(dealTree.root, 1)));
		Assert.assertEquals("BC", nodesToString(dealTree.TreeLevel(dealTree.root, 2)));
		Assert.assertEquals("DEFG", nodesToString(dealTree.TreeLevel(dealTree.root, 3)));
		Assert.assertEquals("H", nodesToString(dealTree.TreeLevel(dealTree.root, 4)));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 5));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 0));
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
	public void test3TreeLevel(){
		dealTree.creat3();
		dealTree.foreach(dealTree.root);
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(dealTree.root, 1)));
		Assert.assertEquals("BC", nodesToString(dealTree.TreeLevel(dealTree.root, 2)));
		Assert.assertEquals("EFG", nodesToString(dealTree.TreeLevel(dealTree.root, 3)));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 4));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 0));
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
	public void test4TreeLevel(){
		dealTree.creat4();
		dealTree.foreach(dealTree.root);
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(dealTree.root, 1)));
		Assert.assertEquals("BC", nodesToString(dealTree.TreeLevel(dealTree.root, 2)));
		Assert.assertEquals("DEF", nodesToString(dealTree.TreeLevel(dealTree.root, 3)));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 4));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 0));
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
	public void test5TreeLevel(){
		dealTree.creat5();
		dealTree.foreach(dealTree.root);
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(dealTree.root, 1)));
		Assert.assertEquals("BC", nodesToString(dealTree.TreeLevel(dealTree.root, 2)));
		Assert.assertEquals("DE", nodesToString(dealTree.TreeLevel(dealTree.root, 3)));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 4));
		Assert.assertNull(dealTree.TreeLevel(dealTree.root, 0));
	}
	/**
	 * 将一个节点数据的数据连成字符串，方便测试
	 * @param nodes
	 * @return
	 */
	public String nodesToString(TNode[] nodes){
		String str = "";
		for(int i = 0;i < nodes.length;i++){
			if(nodes[i] != null){
				str = str + nodes[i].value;
			}
		}
	
		return str;
		
	}
}

package study;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class TreeDealTest {
	private static TreeDeal dealTree = new TreeDeal();
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testTreeLevel() {
		char[] array = {'A','B','C'};
		dealTree.creat1(array);
		Assert.assertEquals("A", nodesToString(dealTree.TreeLevel(dealTree.root, 1)));
		Assert.assertEquals("BC", nodesToString(dealTree.TreeLevel(dealTree.root, 2)));
		Assert.assertEquals(null, nodesToString(dealTree.TreeLevel(dealTree.root, 3)));
		Assert.assertEquals(null, nodesToString(dealTree.TreeLevel(dealTree.root, 0)));
	}
	public String nodesToString(TNode[] nodes){
		String str = "";
		for(TNode t:nodes){
			if(t == null){
				break;
			}
			if(t != null){
				str = str + t.value;
			}
		}
	
		return str;
		
	}
	public void equals(){
		
	}
}

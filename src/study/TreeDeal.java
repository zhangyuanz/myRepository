package study;

import java.util.LinkedList;

/**
 * 由二叉树处理相关的操作封装的类 拥3个方法： TreeLevel返回n层节点 add2Array将节点插入数组末尾 getLevel获得树的深度
 * 
 * @author Administrator
 *
 */
public class TreeDeal {
	/**
	 * 将一颗二叉树的第n层节点以数组形式返回，如果层数大于二叉树深度，或者输入负数和0，则返回空
	 * 
	 * @param t
	 *            是二叉树根节点
	 * @param n
	 *            二叉树具体那一层
	 * 
	 * @return 返回一个节点数组
	 * @throws WrongParamException
	 */
	public TNode[] TreeLevel(TNode root, int n) throws WrongParamException {
		if (n <= 0) {
			throw new WrongParamException("n只能是正数");
		}
		LinkedList<TNode> parent = new LinkedList<TNode>();
		parent.add(root);
		int parentSize = 1;
		int childSize = 0;
		for (int level = 1; level < n; level++) {
			for (int i = 0; i < parentSize; i++) {
				if (parent.get(i).getLeft() != null) {// get方法比较耗时，仍需优化
					parent.add(parent.get(i).getLeft());
					childSize++;
				}
				if (parent.get(i).getRight() != null) {
					parent.add(parent.get(i).getRight());
					childSize++;
				}
			}
			if (childSize == 0) {
				// throw new WrongParamException("n大于二叉树root的深度");
				return null;
			} else {
				for (int i = 0; i < parentSize; i++) {
					parent.removeFirst();
				}
				parentSize = childSize;
				childSize = 0;
			}
		}
		return parent.toArray(new TNode[parentSize]);
	}
	/**
	 * 
	 * Issues:下面的方法效率非常低下
	 * 						 1，getLevel已遍历一次二叉树，浪费时间
	 * 						 2，使用数组结构，初始化不能确定元素的长度，操作极为不便，而且向其中添加元素是非常低效的
	 * 						 3，重复创建临时数组，当树的深度很大时，内存占用非常严重
	 * 解决方法：	用LinkedList，只创建一次parent
	 *
	public TNode[] TreeLevel(TNode t, int n) {
		if (n > getLevel(t) || n <= 0) {
			return null;
		}else{
			TNode[] TNodes = { t };// 第一层的节点
			for (int i = 1; i < n; i++) {// i是树的第i层数
				TNode[] temp = new TNode[(int) Math.pow(2, i)];
				for (int j = 0; j < TNodes.length; j++) {
					if (TNodes[j] != null) {
						if (TNodes[j].getLeft() != null) {// 如果左节点存在，就把左节点压入新的数组之中
							add2Array(temp, TNodes[j].getLeft());
						}
						if (TNodes[j].getRight() != null) {// 如果右节点存在，就把左节点压入新的数组之中
							add2Array(temp, TNodes[j].getRight());
						}
					}
				}
				TNodes = temp;
				temp = null;
			}
			return TNodes;
		}	
	}
   
	
	 * 将一个节点插入节点数组末尾
	 * 
	 * @param array
	 *            是被插入的数组
	 * @param t
	 *            是待插入的节点
	 
	public void add2Array(TNode[] array, TNode t) {
		for (int j = 0; j < array.length; j++) {// 找到数组第一个非空元素，插入其中
			if (array[j] == null) {
				array[j] = t;
				break;
			}
		}
	}
   
	
	 * 获得二叉树的深度
	 * 
	 * @param t
	 *            是二叉树的根节点
	 * @return level 是数的深度
	
	
	public int getLevel(TNode t) {
		int i = 0, j = 0;
		if (t == null) {
			return 0;
		}
		// 先遍历二叉树的左子树的深度，
		if (t.getLeft() != null) {
			i = getLevel(t.getLeft());
		} else {
			i = 0;
		}
		// 然后再遍历二叉树右子树的深度。
		if (t.getRight() != null) {
			j = getLevel(t.getRight());
		} else {
			j = 0;
		}
		// 最后判断左子树和右子树的深度，如果左子树比右子树深则返回左子树深度+1,否则返回右子树深度+1
		return (i > j) ? (i + 1) : (j + 1);
	}
    */
}

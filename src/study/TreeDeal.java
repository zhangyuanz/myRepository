package study;

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
	 */
	public TNode[] TreeLevel(TNode t, int n) {
		if (n > getLevel(t) || n <= 0) {
			return null;
		}
		TNode[] TNodes = { t };// 第一层的节点
		for (int i = 1; i < n; i++) {// i是树的第i层数
			TNode[] temp = new TNode[(int) Math.pow(2, i)];// 临时数组
			for (int j = 0;j < TNodes.length;j++) {
				if(TNodes[j] != null){
					if (TNodes[j].left != null) {// 如果左节点存在，就把左节点压入新的数组之中
						add2Array(temp,TNodes[j].left);
					}
					if (TNodes[j].right != null) {// 如果右节点存在，就把左节点压入新的数组之中
						add2Array(temp,TNodes[j].right);
					}
				}
			}
			TNodes = temp;
		}
		// 以上执行过后TNodes便是想要的结果
		return TNodes;
	}
	/**
	 * 将一个节点插入节点数组末尾
	 */
	public void add2Array(TNode[] array , TNode t){
		for (int j = 0; j < array.length; j++) {// 找到数组第一个非空元素，插入其中
			if (array[j] == null) {
				array[j] = t;
				break;
			}
		}
	}
	/**
	 * 获得二叉树的深度
	 * 
	 * @param t
	 *            是二叉树的根节点
	 * @return level 是数的深度
	 */

	public int getLevel(TNode t) {
		int i = 0, j = 0;
		if (t == null) {
			return 0;
		}
		// 先遍历二叉树的左子树的深度，
		if (t.left != null) {
			i = getLevel(t.left);
		} else {
			i = 0;
		}
		// 然后再遍历二叉树右子树的深度。
		if (t.right != null) {
			j = getLevel(t.right);
		} else {
			j = 0;
		}
		// 最后判断左子树和右子树的深度，如果左子树比右子树深则返回左子树深度+1,否则返回右子树深度+1
		return (i > j) ? (i + 1) : (j + 1);
	}
}

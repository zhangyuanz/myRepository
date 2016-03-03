package study;

public class TreeDeal extends Tree{
	/**
	 * 将一颗二叉树的第n层节点以数组形式返回，如果层数大于二叉树深度，或者输入负数和0，则返回空
	 * @param t 是二叉树根节点
	 * @param n 二叉树具体那一层
	 * @return 返回一个节点数组
	 */
	public TNode[] TreeLevel(TNode t,int n){
		if(n>Level){
			System.out.print("您输入的层数大于本二叉数的总层数！");
			return null;
		}
		if(n<=0){
			System.out.print("输入的层数必须要大于0！");
			return null;
		}
		TNode[] TNodes = {t};//第一层的节点
		for(int i = 1;i < n;i++){//i是树的层数
			TNode[] temp = new TNode[(int)Math.pow(2, i)];//临时数组	
			for(TNode node:TNodes){ 
				if(node.left != null){//如果左节点存在，就把左节点压入新的队列之中，即写入队列末尾
					for(int j = 0;j < temp.length;j++){//找到数组第一个非空元素，即队列末尾，插入其中
						if(temp[j] == null){
							temp[j] = node.left;
							break;//break跳出来节省时间
						}
					}
				}
				if(node.right != null){
					for(int j = 0;j < temp.length;j++){
						if(temp[j] == null){
							temp[j] = node.right;
							break;
						}
					}
				}
			}
			//让垃圾回收器自动回收无用资源
			TNodes = null;
			TNodes = temp;
		}
		//以上执行过后TNodes便是想要的结果
		System.out.print("第"+n+"层： ");
		for(int i = 0;i <TNodes.length;i++){
			if(TNodes[i]!=null){
				System.out.print(TNodes[i].value+"-");	
			}
		}
		return TNodes;
	}
	/**
	 * 中序遍历//检查二叉树正确与否
	 * @param t
	 * 
	 */
	public void foreach(TNode t){
		//用于检查正确性
		System.out.print(t.value+"-");
		if(t.left != null){
			foreach(t.left);
		}
		if(t.right != null){
			foreach(t.right);
		}
	}
}

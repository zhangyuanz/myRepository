package study;

public class TreeDeal extends Tree{
	/**
	 * 将
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
		TNode[] TNodes = {t};
		for(int i = 1;i<n;i++){//i是树的层数
			TNode[] tNodes = new TNode[(int)Math.pow(2, i)];//临时数组	
			for(TNode node:TNodes){ 
				if(node.left!=null){//如果左节点存在，就把左节点压入队列之中，即写入数组末尾
					for(int j=0;j<tNodes.length;j++){//找到数组第一个非空元素，即队列末尾，插入其中
						if(tNodes[j]==null){
							tNodes[j] =node.left;
							break;//break跳出来节省时间
						}
					}
				}
				if(node.right!=null){
					for(int j=0;j<tNodes.length;j++){
						if(tNodes[j]==null){
							tNodes[j] =node.right;
							break;
						}
					}
				}
			}
			//让垃圾回收器自动回收无用资源
			TNodes = null;
			TNodes = tNodes;
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

}

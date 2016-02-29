package study;

/*
 * 2016-2-29
 * zhyz
 */
public class Tree {
	
	private TNode root = null;
	/*
	 * 内部类：节点的数据结构
	 */
	class TNode{
		char value;
		TNode left,right;
		public TNode(char v){
			this.value = v;
			this.left = null;
			this.right = null;
		}
	} 
	/*
	 * 构造ABCDGHF二叉树，并赋值给根节点root
	 */
	public void creat(){
		TNode t = new TNode('A');
		t.left = new TNode('B');
		t.right = new TNode('D');
		t.left.left = new TNode('G');
		t.left.right = new TNode('H');
		t.right.left = new TNode('C');
		t.right.right = new TNode('F');
		root = t;
	}

	/*
	 * 首先判断输入的参数的格式，给出错误提示
	 * 通过新的数组来保存第n层的节点，最大长度是2的n次方
	 * 在遍历父节点队列时，完成子节点队列的构造，然后子节点序列复制给父节点序列进行循环
	 * 最终得到第n层的所有节点数组，打印输出
	 */
	public void TreeLevel(TNode t,int n){
		if(n>=4){
			System.out.print("您输入的层数大于本二叉数的总层数！");
			return;
		}
		if(n<=0){
			System.out.print("输入的层数必须要大于0！");
			return;
		}
		TNode[] TNodes = {t};
		for(int i = 1;i<n;i++){
			TNode[] tNodes = new TNode[(int)Math.pow(2, i)];	
			for(TNode node:TNodes){
				if(node.left!=null){
					for(int j=0;j<tNodes.length;j++){
						if(tNodes[j]==null){
							tNodes[j] =node.left;
							break;
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
			if(i==(TNodes.length-1)){
				//最后一个元素时，不使用-
				System.out.print(TNodes[i].value);
			}else{
				System.out.print(TNodes[i].value+"-");
			}	
		}
	}
		
	/*
	 * 测试单元
	 */
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.creat();
		tree.TreeLevel(tree.root, 1);
		System.out.println();
		tree.TreeLevel(tree.root, 2);
		System.out.println();
		tree.TreeLevel(tree.root, 3);
		System.out.println();
		//越界测试
		tree.TreeLevel(tree.root, 4);
		System.out.println();
		tree.TreeLevel(tree.root, -1);
	}

}

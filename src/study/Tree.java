/**
 * java基础练习题一之第三题
 * 
 * @author zhyz
 * @creat	20160301
 */
package study;
/**
 * 针对二叉树的创建，遍历等设计此类
 * @attr	用于一个属性root，初始值为null，作为一棵树的 根节点
 * @innerclass	一个内部类，定义节点的数据结构，并给出构造函数
 * @method	三个方法，creat构造制定二叉树，
  			insert方法，接受用户输入构造二叉树，
  			TreeLevel方法可以从左向右返回数的第n层的所有节点
 * 
 */
public class Tree {
	
	TNode root = null;
    int	Level = 0;
	/**
	 * 内部类：节点的数据结构，含有显示构造函数
	 * 默认构造函数将创建值为空格的节点
	 */
	class TNode{
		char value;
		TNode left,right;
		public TNode(char v){
			this.value = v;
			this.left = null;
			this.right = null;
		}
		public TNode(){
			this.value = ' ';
			this.left = null;
			this.right = null;
		}
	} 
	/**
	 * 手动构造ABCDGHF二叉树，并赋值给根节点root
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
		Level = 3;
	}
	/*
	 * 设计以下几个方法是想要用户能够根据需要自己构造出不同的满二叉树
	 * 构造原则：新数据value向已经节点t中插入数据，如果t为null，则直接构造以value为存储数据的新节点赋值t；
	 * 如果t不为null，则先填充t的左节点，如果左节点已经存在，则填充右节点
	 * 20160302
	 **/
	
	/**
	 * 向一个节点中插入新节点，先左后右的原则
	 * @param t是新节点
	 * @param value是节点对应的字符值
	 * @return	插入成功则返回新节点，否则返回null
	 */
	public TNode insert(TNode t,char value){
		TNode node = null;
		if(t.left == null){
			t.left = new TNode(value);
			node = t.left;
		}else if(t.right == null){
			t.right = new TNode(value);
			node = t.right;
		}
		return node;	
	}
	/**
	 * 判断一个节点的孩子是否已经满员
	 * @param boolean
	 * @return	
	 */
	public Boolean isFull(TNode node){
		if(node.left!=null&&node.right!=null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 向一个节点数组末尾加入一个新的节点
	 * @param t节点数组
	 * @param tv是新节点
	 * 
	 */
	public void add(TNode[] t,TNode tv){
		for(int i = 0;i < t.length;i++){
			if(t[i].value==' '){
				t[i] = tv;
				break;//break非常重要，保证只插入一次
			}
		}
	}
	/**
	 * 初始化一个节点数组，防止空指针异常
	 * @param c
	 */
	public void init(TNode[] c){
		for(int i=0;i<c.length;i++){
			c[i] = new TNode();
		}	
	}
	/**
	 * 通过给定数组，构造一个满二叉树
	 * @param array是指定的数据
	 */
	public void creatByArray(char[]array){
		int max = 0;//父数组下标最大值
		TNode[] parent = new TNode[1];//父数组，就是第一个节点，也是根节点root
		parent[0] = new TNode(array[0]);
		this.root = parent[0];
		Level++;
		TNode[] children = new TNode[2];//孩子数组用于存储父数组的子节点，开始时，根节点有两个孩子，因此创建长度为2的children
		init(children);
		Level++;
		/*
		 * 循环将节点插入，并且要按照顺序插入，先插入左孩子，再右
		 * 在父数组节点队列parent中，如果某个节点孩子满，将指针后移一位，直到把父数组遍历完，把父数组的所有孩子都从左到右添加到children孩子数组中
		 * 如果指针已经到最后一位，则父队列下降一层，即孩子节点数组变成新的父节点数组
		 */
		for(int i = 1;i<array.length;i++){
			
			if(!isFull(parent[max])){
				//add(children,insert(parent[max],array[i]));
				if(parent[max].left==null){
					parent[max].left = new TNode(array[i]);
					add(children,parent[max].left);
				}else if(parent[max].right==null){
					parent[max].right = new TNode(array[i]);
					add(children,parent[max].right);
				}
			}
			if(isFull(parent[max])){
				max++;System.out.println(max);
			}
			if(max==parent.length){
				parent = children;
				children = new TNode[2*max];
				init(children);
				Level++;
				max = 0;
			}
		}
	}
	/**
	 * 此方法输入一棵树的根节点，并指定层数，可以得到该层的所有节点数据
	 * 首先判断输入的参数的格式，给出错误提示
	 * 通过新的数组来保存第n层的节点，最大长度是2的n次方
	 * 在遍历父节点队列时，完成子节点队列的构造，然后子节点序列复制给父节点序列进行循环
	 * 最终得到第n层的所有节点数组，打印输出
	 */
	public void TreeLevel(TNode t,int n){
		if(n>Level){
			System.out.print("您输入的层数大于本二叉数的总层数！");
			return;
		}
		if(n<=0){
			System.out.print("输入的层数必须要大于0！");
			return;
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
	}
	
	/**
	 * 
	 * @param args
	 */
	public void foreach(TNode t){
		System.out.print(t.value+"-");
		if(t.left!=null){
			foreach(t.left);
		}
		if(t.right!=null){
			foreach(t.right);
		}
	}


}

/**
 * java基础练习题一之第三题
 * 
 * @author zhyz
 * @Create	20160301
 */
package study;

/**
 * 满二叉树类，拥有内部类定义数的节点的结构，与遍历方法
 * <pre>
 * 属性有两个：根节点root，与数的深度Level
 * 有两个构造方法：默认构造方法和一个根据数组创建的构造方法
 * </pre>
 * @author zhyz
 */
public class Tree {
	//二叉树类有用两个保护型属性，其子类可以用
	protected TNode root;
	protected int	Level;
	/**
	 * 构造函数,无参构造函数将创建一个深度为1，根节点为空的树
	 */
	public Tree() {
		this.root = null;
		this.Level = 0;
	}
	/**
	 * 通过给定数组，按层构造完全二叉树，只有当上一层的节点排满时，新节点才插入到下一层，而且按从左到右的顺序插入
	 * <pre>
	 *      A            A            A           A
	 *     / \          / \          / \         /  \
	 *    B   C        B   C        B   C       B    C
	 *                /            / \         / \  /
	 *                D           D   E       D   EF
	 * </pre>
	 * 构造完成的同时，就指定了根节点root与其深度Level
	 * @return
	 */
	public void creat1(char[]array){
		int max = 0;//父数组下标最大值
		TNode[] parent = new TNode[1];//父数组，就是第一个节点，也是根节点root
		parent[0] = new TNode(array[0]);
		root = parent[0];
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
			add(children,insert(parent[max],array[i]));
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
			if(children[0].value == ' '){
				Level = Level-1;
			}
		}
		
	}
	/**
	 * 判断一个节点的孩子是否已经满员
	 * @param boolean
	 * @return	
	 */
	private Boolean isFull(TNode node){
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
	private void add(TNode[] t,TNode tv){
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
	private void init(TNode[] c){
		for(int i=0;i<c.length;i++){
			c[i] = new TNode();
		}	
	}
	/**
	 * 向一个节点中插入新节点，先左后右的原则
	 * @param t是新节点
	 * @param value是节点对应的字符值
	 * @return	插入成功则返回新节点，否则返回null
	 */
	private TNode insert(TNode t,char value){
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
}

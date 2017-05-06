/**
 * 
 */
package com.hitesh.learn.ds.old;

/**
 * @author hitjoshi
 * @date Mar 14, 2016
 * Linked implementation
 */
public class BinaryTree
{
	private Node root;

	private static class Node{
		// Not generic
		int value;
		Node left;
		Node right;
		/**
		 * @param i
		 */
		public Node(int i)
		{
			this.value= i;
			this.left = null;
			this.right= null;
		}
		public int getValue()
		{
			return value;
		}
		public void setValue(int value)
		{
			this.value = value;
		}
		public Node getLeft()
		{
			return left;
		}
		public void setLeft(Node left)
		{
			this.left = left;
		}
		public Node getRight()
		{
			return right;
		}
		public void setRight(Node right)
		{
			this.right = right;
		}

	}

	public BinaryTree(){
		root = null;
	}

	private boolean search(Node node, int data){
		// tree empty 
		if (node==null) { 
			return(false); 
		}		
		if(node.getValue() == data){
			return true;
		}
		else if(data<node.getValue()) {
			return search(node.getLeft(), data);
		}
		else{
			return search(node.getRight(), data);
		}
	}
	public boolean search(int data){
		return search(root,data);
	}

	public void insert(int data){	
		root = insert(root,data);
//		System.out.println(root.getValue());
	}
	/**
	 * @param root2
	 * @param data
	 * @return
	 * @description 
	 * @return Node
	 */
	private Node insert(Node node, int data)
	{
		// Tree is empty
		if(node == null){
			node = new Node(data);
		}
		else{
			if(data <= node.getValue()){
				node.left = insert(node.left,data);
			}
			if(data > node.getValue()){
				node.right = insert(node.right,data);
			}
		}
		return node;
	}

	public void inOrderTraversal(){
		inOrderTraversal(root);
	}
// start from root and once traverse both left and right sub tree
	private void inOrderTraversal(Node node) {
		if(node != null){		
			inOrderTraversal(node.getLeft());
			System.out.println(node.getValue());
			inOrderTraversal(node.getRight());

		}
	}

	public void preOrderTraversal(){
		preOrderTraversal(root);
	}
	
	public void postOrderTraversal(){
		postOrderTraversal(root);
	}
	
//root-- right--left
	private  void postOrderTraversal(Node node){

		if(node !=null){
			postOrderTraversal(node.getLeft());
			postOrderTraversal(node.getRight());
			System.out.println(node.getValue());
		}
		
	}

	private void preOrderTraversal(Node node)
	{
		if(node !=null){
			System.out.println(node.getValue());
			preOrderTraversal(node.getLeft());
			preOrderTraversal(node.getRight());
		}
		
	}
	public int size(){
		return this.size(root);
	}

	/**
	 * @param root2
	 * @description 
	 * @return void
	 */
	private int size(Node node)
	{
		 int size = 0;
		if(node!=null){
			size = 1+(size(node.left))+(size(node.right));
		}
		return size;		
	}


	public static void main(String[] args) throws Exception
	{
		int a[] = new int[]{9,7,10,4,5,6,2,3,1,0};
		BinaryTree t = new BinaryTree();
		for( int i = 0; i<a.length; i++){
			t.insert(a[i]);
		}	
		System.out.println("IN  Order");
		t.inOrderTraversal();
		System.out.println("Pre Order root left right");
		t.preOrderTraversal();
		System.out.println("Post Order left right node ");
		t.postOrderTraversal();		
		System.out.println("Size "+t.size());
		System.out.println(t.search(10));
		System.out.println("Depth of root "+t.depth());
	
	}
	
	public int depth(){
		return depth(root);
	}
	
	private int depth(Node node){
		// for every level, depth of left or right subtree +1
		if(node!=null){
		int depthLeft = depth(node.left);
		int depthRight = depth(node.right);
		if(depthLeft >= depthRight){
			return depthLeft+1;
		}
		else{
		return depthRight+1;
		}
		}
		else{
			// No Node return -1
			return -1;
		}
	}
	
	

}

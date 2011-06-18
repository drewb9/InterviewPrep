package treesAndGraphs;

import java.util.Stack;

public class BinarySearchTree {

	BinaryNode root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public void add(int val)
	{
		if (root == null)
		{
			root = new BinaryNode(val);
		}
		else
		{
			addHelper(val, root);
		}
	}
	
	private void addHelper(int val, BinaryNode node)
	{
		if (val <= node.getValue())
		{
			if (node.getLchild() == null)
			{
				node.setLchild(new BinaryNode(val));
			}
			else
			{
				addHelper(val, node.getLchild());
			}
		}
		else
		{
			if (node.getRchild() == null)
			{
				node.setRchild(new BinaryNode(val));
			}
			else
			{
				addHelper(val, node.getRchild());
			}
		}
	}
	
	public void printTree() //inorder
	{
		printTreeHelper(root);
	}
	
	private static void printTreeHelper(BinaryNode node)
	{
		if (node == null)
		{
			return;
		}
		else
		{
			printTreeHelper(node.getLchild());
			System.out.println(node.getValue());
			printTreeHelper(node.getRchild());
			return;
		}
	}
	
	public void preOrderTraversal() // no recursion
	{
		Stack<BinaryNode> s = new Stack<BinaryNode>();
		s.push(root);
		BinaryNode top;
		while (!s.isEmpty())
		{
			top = s.pop();
			if (top != null)
			{
				System.out.println(top.getValue());
				s.push(top.getRchild());
				s.push(top.getLchild());
			}
		}
	}
	
	public BinaryNode lca(int val1, int val2)
	{
		return lcaHelper(val1, val2, root);
	}
	
	private static BinaryNode lcaHelper(int val1, int val2, BinaryNode node)
	{
		if (node == null)
		{
			return null;
		}
		else if (val1 < node.getValue() && val2 < node.getValue())
		{
			return lcaHelper(val1, val2, node.getLchild());
		}
		else if (val1 > node.getValue() && val2 > node.getValue())
		{
			return lcaHelper(val1, val2, node.getRchild());
		}
		else
		{
			return node;
		}
	}
	
	public int depth()
	{
		return depthHelper(root, 0);
	}
	
	private static int depthHelper(BinaryNode n, int d)
	{
		if (n.getLchild() != null && n.getRchild() != null)
		{
			return Math.max(depthHelper(n.getLchild(), d+1), depthHelper(n.getRchild(),d+1));
		}
		else if (n.getLchild() != null)
		{
			return depthHelper(n.getLchild(), d+1);
		}
		else if (n.getRchild() != null)
		{
			return depthHelper(n.getRchild(), d+1);
		}
		else 
		{
			return d;
		}
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(11);
		bst.add(4);
		bst.add(10);
		bst.add(7);
		bst.add(2);
		bst.add(20);
		bst.add(17);
		bst.add(15);
		bst.add(40);
		bst.add(18);
		bst.add(50);
		bst.add(15);
		bst.add(100);
		bst.add(101);
		System.out.println(bst.depth());
	}
	
}

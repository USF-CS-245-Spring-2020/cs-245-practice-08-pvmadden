//
// Tom Sawyer Software
// Copyright 2007 - 2020
// All rights reserved.
//
// www.tomsawyer.com
//


public class BST<T extends Comparable>
{

	BSTNode<T> root;


	/**
	 * Return true if item is found in the BST; false otherwise.
	 *
	 * @param item
	 * @return
	 */
	boolean find(T item)
	{
		return find(root, item);
	}

	protected boolean find(BSTNode node, T item)
	{
		if(node == null)
		{
			return false;
		}
		if(item == node.data)
		{
			return true;
		}
		else if(item.compareTo(node.data) < 0)
		{
			return find(node.left, item);
		}
		else
		{
			return find(node.right, item);
		}
	}


	/**
	 * Insert item into BST, keeping duplicates in their own nodes.
	 *a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 * @param item
	 */
	void insert(Comparable item)
	{
		root = insert(root, item);
	}

	protected BSTNode insert(BSTNode node, Comparable item)
	{
		if(node == null)
		{
			return new BSTNode<T>((T) item);
		}
		if(item.compareTo(node.data) < 0)
		{
			node.left = insert(node.left, item);
		}
		else
		{
			node.right = insert(node.right, item);
		}
		return node;
	}


	/**
	 * Using println, output each item in the BST, in order.
	 */
	void print()
	{
		inOrderTraversal(root);
	}

	protected void inOrderTraversal(BSTNode node)
	{
		if(node != null)
		{
			inOrderTraversal((node.left));
			System.out.println(node.data);
			inOrderTraversal(node.right);
		}
	}


	/**
	 * Delete first instance of item from the BST.
	 * @param item
	 */
	void delete(T item)
	{
		root = delete(root, item);
	}

	protected  BSTNode delete(BSTNode node, T item)
	{
		if(node == null)
		{
			return null;
		}
		if(node.data.compareTo(item) < 0)
		{
			node.right = delete(node.right, item);
		}
		else if(node.data.compareTo(item) > 0)
		{
			node.left = delete(node.left, item);
			return node;
		}
		else
		{
			if(node.left == null)
			{
				return node.right;
			}
			else if(node.right == null)
			{
				return node.left;
			}
			else
			{
				if(node.right.left == null)
				{
					node.data = node.right.data;
					node.right = node.right.right;
				}
				else
				{
					node.data = removeSmallest(node.left);//is this right?
				}
				return node;
			}
		}
		System.out.println("Somehow here");
		return null;
	}

	T removeSmallest(BSTNode node)
	{
		if(node.left.left == null)
		{
			T smallest = (T) node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		else
		{
			return removeSmallest(node.left);
		}
	}
}

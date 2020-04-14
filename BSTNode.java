//
// Tom Sawyer Software
// Copyright 2007 - 2020
// All rights reserved.
//
// www.tomsawyer.com
//


public class BSTNode<T extends Comparable>
{
	public BSTNode(T item)
	{
		data = item;
	}
	T data;
	BSTNode left;
	BSTNode right;
}

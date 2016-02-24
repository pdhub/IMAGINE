package com.hearth.chipmonk;

public class IsBinaryTreeBST {

	public boolean isBst(MyTree a, int small, int large){
		
		if(a==null)
			return true;
		
		if(a.value > small && a.value < large){
			
			boolean leftBst = isBst(a.left, small, a.value);
			boolean rightBst = isBst(a.right, a.value, large);
			
			return leftBst&&rightBst;
			
		}else
			return false;
	}
	
}
class MyTree{
	int value;
	MyTree left;
	MyTree right;
	
	MyTree(int value){
		this.value = value;
		left = right = null;
	}
}

package com.hearth.chipmonk;

import java.util.LinkedList;
import java.util.Queue;

public class PrintNodesAtDesiredLevelBst {

	public void printNodeS(MyTree tree, int desire){
		
		if(desire<0)
			return;
		Queue<MyTree> treeQueue = new LinkedList<MyTree>();
		Queue<Integer> levelQueue = new LinkedList<Integer>();
		
		treeQueue.add(tree);
		levelQueue.add(0);
		
		while(!treeQueue.isEmpty()){
			MyTree tempTree = treeQueue.poll();
			int currentLevel = levelQueue.poll();
			
			if(tempTree==null)
				return;
			else if(currentLevel==desire){
				System.out.println(tempTree.value);
			}else{
				treeQueue.add(tempTree.left);
				treeQueue.add(tempTree.right);
				
				levelQueue.add(currentLevel+1);
				levelQueue.add(currentLevel+1);
			}
			
		}
	}
}

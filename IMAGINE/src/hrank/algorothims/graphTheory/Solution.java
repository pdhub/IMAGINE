package hrank.algorothims.graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    
    public static class Node {
        int id;
        //Neighbor->distance
        HashMap<Node,Integer> Neighbor; 
        int distance;
        
        public Node(int id){
            this.id=id;
            this.Neighbor=new HashMap<Node,Integer>();
            this.distance=-1;
        }
        
        
    }
    
    //return the index with minimum distance in the arraylsit O(Q.size())
	public static int minIndex(ArrayList<Node> Q){
		int output=-1;
		int minDistance=65536000;
		for (int i=0;i<Q.size();i++){
			if (Q.get(i).distance<minDistance){
				output=i;
				minDistance=Q.get(i).distance;
			}
			
		}
		return output;
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner in=new Scanner(System.in);
        int T=in.nextInt();
        for (int t=0;t<T;t++){
        	
            int N=in.nextInt();int M=in.nextInt();
            Node[] A=new Node[N];
            for (int i=0;i<N;i++)
            {
            	A[i]=new Node(i);
            }
            //init edges
            for (int e=0;e<M;e++){
                int i=in.nextInt()-1;int j=in.nextInt()-1;
                int weight=in.nextInt();
                Node N1=A[i];Node N2=A[j];
                if (!N1.Neighbor.keySet().contains(N2)|| N1.Neighbor.get(N2)>weight) {N1.Neighbor.put(N2,weight);}
                if (!N2.Neighbor.keySet().contains(N1)|| N2.Neighbor.get(N1)>weight) {N2.Neighbor.put(N1,weight);}
            }
            //print 17(1-index)/16(0-index)'s 
            //System.out.println(A[6].toString());
            int start=in.nextInt()-1;
            
            ArrayList<Node> Q=new ArrayList<Node>();
            //init start Node
            Node startNode=A[start];
            startNode.distance=0;
            boolean[] B=new boolean[N];
            B[start]=true;
            
            //put start node to queue
            Q.add(startNode);
            //while queue not empty
            while (Q.size()>0){
            	int headIndex=minIndex(Q);
                //process new node(expand frontier)
                //change neighbor distance
                Node headNode= Q.get(headIndex);
                //if (headNode.id==16) System.out.println("exist");
                for (Node N0:headNode.Neighbor.keySet()){
                    //whether to add the node to the queue
                    if (!B[N0.id]){
                        //enqueue
                        Q.add(N0);
                        //bitmap modify
                        B[N0.id]=true;
                    }
                    //treat its distance
                    if (N0.distance==-1 || N0.distance> headNode.distance+headNode.Neighbor.get(N0)){
                        //if (N0.id==6) System.out.println("alert");//test
                    	N0.distance=headNode.distance+headNode.Neighbor.get(N0);
                    	//if (N0.id==6) System.out.println("new distance is "+N0.distance);//test
                    }
                    
                }
                Q.remove(headIndex);
            }
            
            for (int i=0;i<N;i++){
                if (i!=start) System.out.print(A[i].distance+" ");
            }
            System.out.println("");
            
            
        }
        
    }
}
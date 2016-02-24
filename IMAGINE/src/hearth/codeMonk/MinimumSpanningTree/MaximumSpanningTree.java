package hearth.codeMonk.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSpanningTree {

	public static int parent[];
	public static int count[];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        String[] line;
        Queue<MAXEDGE> pq;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
        	line = br.readLine().trim().split(" ");
        	int N = Integer.parseInt(line[0]);
        	parent = new int[N];
        	count = new int[N];
        	for (int j = 0; j < N; j++) {
        		parent[j] = j;
        		count[j] = 1;
        	}
        	int M = Integer.parseInt(line[1]);
        	
        	pq = new PriorityQueue<MAXEDGE>(M);
        	
        	//Add the edges to the Priority Queue
        	for (int j = 0; j < M; j++) {
        		line = br.readLine().trim().split(" ");
        		pq.add(new MAXEDGE(Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1, Integer.parseInt(line[2])));
        	}
        	
        	
        	//Now pop one by one and create the MAX Spanning TREE.
        	
        	maxiMumSpanningWeight(pq);
        	
        	
        }
	}
	public static void maxiMumSpanningWeight(Queue pq){
		int maxWeight = 0;
		
		while(!pq.isEmpty()){
			MAXEDGE edge = (MAXEDGE) pq.poll();
			if(union(edge.getV1(), edge.getV2())){
				maxWeight+=edge.getWeight();
			}
			
		}
		System.out.println(maxWeight);
	}
	
	public static int findParent(int v){
		if(parent[v]==v)
			return v;
		else
			return findParent(parent[v]);
	}
	
	public static boolean union(int v1, int v2){
		int p1 = findParent(v1);
		int p2 = findParent(v2);
		
		if(p1==p2)
			return false;
		if(count[p1]>=count[p2]){
			parent[p2]=p1;
			count[p1]+=count[p2];
		}
		else{
			parent[p1]=p2;
			count[p2]+=count[p1];
		}
		return true;
	}
	
	
}
class MAXEDGE implements Comparable<MAXEDGE>{
	private int v1,v2,weight;
	MAXEDGE(int v1,int v2,int weight){
		this.v1 = v1;
		this.v2= v2;
		this.weight=weight;
	}
	
	public int getV1() {
		return v1;
	}
	public void setV1(int v1) {
		this.v1 = v1;
	}
	public int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(MAXEDGE edge) {
		return edge.getWeight()-weight;
	}
	
	
	
}

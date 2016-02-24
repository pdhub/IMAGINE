
/*
 https://www.hackerearth.com/code-monk-minimum-spanning-tree/algorithm/3-types/
 * */

package hearth.codeMonk.MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;


public class _3Types {

	private static int[] maleParents;
	private static int[] femaleParents;
	private static int[] maleCounts;
	private static int[] femaleCounts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        maleParents = new int[N];
        maleCounts = new int[N];
        femaleParents = new int[N];
        femaleCounts = new int[N];
        
        for (int i = 0; i < N; i++) {
        	maleParents[i] = i;//Each node points to itself as parent
        	maleCounts[i] = 1;
        	femaleParents[i] = i;
        	femaleCounts[i] = 1;
        }
        
        int M = Integer.parseInt(line[1]);
        Queue<_3TYPE_EDGE> pq = new PriorityQueue<_3TYPE_EDGE>(M);
        
        for (int i = 0; i < M; i++) {
            line = br.readLine().trim().split(" ");
            pq.add(new _3TYPE_EDGE(Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1, Integer.parseInt(line[2])));
        }
        
        /**We are done here with our GRAPH creation. 
         * The actual logic starts here**/
        
        int destroyCount = 0;
        while(!pq.isEmpty()){
        	_3TYPE_EDGE e = pq.poll();
        	if(e.type==3){
        		if(!union(maleParents, maleCounts, e.v1, e.v2)){
        			destroyCount++;
        		}
        		//Also union the female branch.
        		union(femaleParents, femaleCounts, e.v1, e.v2);
        		
        	}
        	else if(e.type==1){
        		if(!union(maleParents, maleCounts, e.v1, e.v2)){
        			destroyCount++;
        		}
        	}else if(e.type==2){
        		if(!union(femaleParents, femaleCounts, e.v1, e.v2)){
        			destroyCount++;
        		}
        	}
        }
        
        System.out.println(destroyCount);
	}
	private static boolean union(int[] parents, int[] counts,
			int v1, int v2) {
		int parentOfV1 = findParent(v1, parents);
		int parentOfV2 = findParent(v2, parents);
		
		if(parentOfV1==parentOfV2)
			return false;
		if(counts[parentOfV1]>=counts[parentOfV2]){
			maleParents[parentOfV2]= parentOfV1;
			counts[parentOfV1]+=counts[parentOfV2];
		}else{
			maleParents[parentOfV1]= parentOfV2;
			counts[parentOfV2]+=counts[parentOfV1];
		}
		
		return false;
	}
	private static int findParent(int v, int[] parents) {
		if(parents[v]==v){
			return v;
		}else
			return findParent(parents[v], parents);
	}
	
	
}

class _3TYPE_EDGE implements Comparable<_3TYPE_EDGE>{
	public int type;
	public int v1;
	public int v2;
	
	_3TYPE_EDGE(int type, int v1, int v2){
		this.type = type;
		this.v1 = v1;
		this.v2 = v2;
	}
	
	@Override
	public int compareTo(_3TYPE_EDGE o) {
		return type-o.type;
	}
	
}

package hrank.algorothims.graphTheory;

public class Vertex implements Comparable<Vertex>{
	public int id;
	public String name;
	public Vertex(int id, String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Vertex v) {
		if(this.id == v.id)
			return 0;
		if(this.id > v.id)
			return 1;
		else
			return -1;
		
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object v) {
		// TODO Auto-generated method stub
		return this.id == ((Vertex)v).id;
	}
	
}
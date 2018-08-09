import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs{
	
	public static void bfs(basicGraph g, ArrayList<Node> nodes, int nodeNum){
//		boolean[] processed = new boolean[nodes.size()]; 
		Queue<Node> q = new LinkedList<Node>();
		ArrayList<Node> temp; //temporary pointer;
		
		q.add(nodes.get(nodeNum));
		nodes.get(nodeNum).setState(Node.State.Visited);
		
		while(!q.isEmpty() ){
			Node v = q.remove();
			process_vertex_early(v);
			temp = v.getChildren();
			for(int i=0; i< temp.size(); i++){
				Node y = temp.get(i);
				if(y.getState() == Node.State.Unvisited){
					process_edge(v,y);
					q.add(y);
					y.setState(Node.State.Visited);
				}
			}
			process_vertex_late(v);
			
		}
		
	}
	
	public static void process_vertex_early(Node v){System.out.print(" "+v.getName()); };
	public static void process_edge(Node start, Node end){};
	public static void process_vertex_late(Node v){};

}

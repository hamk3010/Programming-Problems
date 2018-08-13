import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public abstract class dfs {
	
	enum edgeClass{TREE, BACK, FORWARD, CROSS, UNCLASSIFIED};
	
	HashMap<Node, Integer> entry_time = new HashMap<>();
	HashMap<Node, Integer> exit_time = new HashMap<>();
	HashMap<Node, Node> parent = new HashMap<>();
	WrapInt t = new WrapInt();
	boolean finished = false;
	ArrayList<Node> children;
	basicGraph graph;
	Stack<Node> myStack= myStack = new Stack<Node>(); //for topological sort
	
	public dfs(basicGraph g){
		this.graph = g;
		this.t.value = 0;
		doDFS(g.getNodes().get(0));
	}
	
	public void doDFS(Node start){
		if(finished) 
			return;
		
		ArrayList<Node> neighbors;
		start.setState(Node.State.Visiting);
		entry_time.put(start, t.value);
		
		process_vertex_early(start);
		neighbors = start.getChildren();
		for(Node neighbor: neighbors){
			if(neighbor.getState() == Node.State.Unvisited){
				parent.put(neighbor, start);
				process_edge(start, neighbor);
				doDFS(neighbor);
			}
			else if(neighbor.getState() != Node.State.Unvisited){
				process_edge(start, neighbor);
			}
			if(finished)
				return;
		}
		process_vertex_late(start);
		t.value+=1;
		exit_time.put(start, t.value);
		start.setState(Node.State.Visited);
	}
	
	public abstract void process_vertex_early(Node start);
	public abstract void process_edge(Node start, Node end);
	public abstract void process_vertex_late(Node start);
	
	public edgeClass edge_classification(Node start, Node end){
		if(parent.get(end) == start) 
			return edgeClass.TREE;
		if(end.getState() ==  Node.State.Visiting)
			return edgeClass.BACK;
		if( (end.getState() == Node.State.Visited) && (entry_time.get(end) > entry_time.get(start) ) ){
			return edgeClass.FORWARD;
		}
		if( (end.getState() == Node.State.Visited) && (entry_time.get(end) < entry_time.get(start) ) ){
			return edgeClass.CROSS;
		}
		
		return edgeClass.UNCLASSIFIED;
	}

}
//wrapper class so we avoid using static variables to update time
class WrapInt{
	public int value;
}



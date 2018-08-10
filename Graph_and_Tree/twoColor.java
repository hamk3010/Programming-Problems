import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;



// This method colors a nodes into two different colors. It forms a bipartite graph if one can be formed otherwise
// it returns an unevenly colored nodes. 
public class twoColor {

	
	
	enum color{
		WHITE, BLACK, UNCOLORED;
		public String toString() {return name();}
	};
	
	private HashMap<Node, twoColor.color> myColor = new HashMap<>();
	private basicGraph myGraph;
	
	public twoColor(){};
	public twoColor(String[] nodes, String[][] edges){
		this.myGraph = new basicGraph(nodes,edges);
		for(Node node: myGraph.getNodes() ){
			myColor.put(node, twoColor.color.UNCOLORED);
		}
	}
	
	//Define bfs (which is exactly the same as in the bfs class but we do it only to REALLY
	// get the gist of how BFS actually works
	public void bfs(Node node){
		Queue<Node> q = new LinkedList<Node>(); ///WE GOTTA PROBLEM IN HERE!!
		ArrayList<Node> neighbors;
		ArrayList<Node> nodes = myGraph.getNodes();
		q.add(node);
		node.setState(Node.State.Visited);
		
		while(!q.isEmpty()){
			Node start = q.remove();
			process_vertex_early(start);
			neighbors = start.getChildren();
			for(Node neighbor: neighbors){
				if(neighbor.getState() == Node.State.Unvisited){
					process_edge(start, neighbor );
					q.add(neighbor);
					neighbor.setState(Node.State.Visited);
				}
			}
			process_vertex_late(start);
		}
	}
	
	public void paint(){
		ArrayList<Node> nodes = myGraph.getNodes();
		for(Node node:nodes){
			if(node.getState() == Node.State.Unvisited){
				myColor.put(node, color.WHITE);
				bfs(node);
			}
		}
		
	}
	
	public void process_vertex_early(Node v){};
	
	public void process_edge(Node startNode, Node endNode ){
		if(myColor.get(startNode) == myColor.get(endNode)){
			System.out.print("Not a bipartite Graph due to");
			System.out.println("Node "+ startNode.getName() + " and " + endNode.getName());
		}
		myColor.put(endNode, complement(myColor.get(startNode) ) );
	}
	
	public void process_vertex_late(Node v){
		System.out.println(v.getName() + "'s color is "+ myColor.get(v) );
	}
	
	public twoColor.color complement(twoColor.color givenColor){
		if(givenColor == color.WHITE) return(color.BLACK);
		if(givenColor == color.BLACK) return (color.WHITE);
		return (color.UNCOLORED);
	}
	
	
	public static void main(String[] args){
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = { {"d","a"}, {"b","f"}, {"d","b"},{"a","f"},{"c","d"} };
		twoColor two_color = new twoColor(projects, dependencies);
		two_color.paint();
		
	}
}

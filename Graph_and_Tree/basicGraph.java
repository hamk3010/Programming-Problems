import java.util.ArrayList;
import java.util.HashMap;


public class basicGraph {

	private ArrayList<Node> nodes = new ArrayList<Node>();
	private HashMap<String, Node> map = new HashMap<String, Node>();
	public int nEdges =0;
	
	public basicGraph(){
		
	}
	
	public basicGraph(String[] nodes, String[][] edges){
		for(String node: nodes){
			this.getOrCreateNode(node);
		}
		for(String[] edge: edges){
			String first = edge[0];
			String end = edge[1];
			this.addEdge(first, end);
		}
	}
	
	public Node getOrCreateNode(String name){
		if(!map.containsKey(name)){
			Node node = new Node(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}
	
	public void addEdge(String startName, String endName){
		Node start = getOrCreateNode(startName);
		Node end = getOrCreateNode(endName);
		start.addNeighbor(end);
		nEdges++;
	}
	
	public ArrayList<Node> getNodes(){return nodes;}

}

class Node{
	enum State{Unvisited, Visited, Visiting;}
	private ArrayList<Node> children = new ArrayList<Node>();
	private HashMap<String, Node> map = new HashMap<String, Node>();
	private String name;
	private Node.State state = State.Unvisited;

	
	public Node(String n){name = n;}
	
	public void addNeighbor(Node node){
		if(!map.containsKey(node.getName()) ){
			children.add(node);
		}
	}
	
	public String getName(){return name;}
	public ArrayList<Node> getChildren(){return children;}
	public Node.State getState(){return state;}
	
	public void setState(Node.State state){
		this.state = state;
	}
}
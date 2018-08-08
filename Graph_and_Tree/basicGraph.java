import java.util.ArrayList;
import java.util.HashMap;

public class basicGraph {

	private ArrayList<Node> nodes = new ArrayList<Node>();
	private HashMap<String, Node> map = new HashMap<String, Node>();
	public int nEdges =0;
	
	
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
	private ArrayList<Node> children = new ArrayList<Node>();
	private HashMap<String, Node> map = new HashMap<String, Node>();
	private String name;

	
	public Node(String n){name = n;}
	
	public void addNeighbor(Node node){
		if(!map.containsKey(node.getName()) ){
			children.add(node);
		}
	}
	
	public String getName(){return name;}
	public ArrayList<Node> getChildren(){return children;}
}
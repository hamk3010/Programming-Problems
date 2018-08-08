import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	
	//Project is the type of our node since we are actually building this class for a project ordering problem
	private ArrayList<Project> nodes = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	
	public Project getOrCreateNode(String name){
		if(!map.containsKey(name)){
			Project node = new Project(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}
	
	public void addEdge(String startName, String endName){
		Project start = getOrCreateNode(startName);
		Project end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	
	public ArrayList<Project> getNodes(){return nodes;}

}

class Project{
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	private int dependencies = 0;
	
	public Project(String n){name = n;}
	
	public void addNeighbor(Project node){
		if(!map.containsKey(node.getName()) ){
			children.add(node);
			node.incrementDependencies();
		}
	}
	
	public void incrementDependencies(){dependencies++;}
	public void decrementDependencies(){dependencies--;}
	
	public String getName(){return name;}
	public ArrayList<Project> getChildren(){return children;}
	public int getNumberDependencies(){return dependencies;}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


//The test was done on a directed graph and it finds new connected components in the graph.
public class connectedComponents {
	
	public static void connected_components(basicGraph g){
		int component_Number;
		
		component_Number = 0;
		ArrayList<Node> nodes = g.getNodes();
		
		for(int i = 0; i< nodes.size(); i++){
			if(nodes.get(i).getState() == Node.State.Unvisited ){
				component_Number++;
				System.out.print("Component"+ component_Number);
				bfs.bfs(g,nodes,i);
				System.out.println();
			}
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = { {"d","a"}, {"b","f"}, {"d","b"},{"a","f"},{"c","d"} };
		basicGraph myGraph = new basicGraph(projects, dependencies);
		connected_components(myGraph);
	}


}

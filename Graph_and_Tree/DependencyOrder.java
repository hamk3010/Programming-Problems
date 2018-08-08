import java.util.ArrayList;

//Along with the Graph class this will run in O(P+D) time and O(P) space.

//This problem was adopted from Cracking the Coding Interview book and I use their solution to
//better grasp of what the author meant. I also added another line of code and tested her solution.

//Note: backward order is the order in which the graphs should be built as shown in the main function

public class DependencyOrder {

	static Project[] findBuildOrder(String[] projects, String[][] dependencies){
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	static Graph buildGraph(String[] projects, String[][] dependencies){
		Graph graph = new Graph();
		for(String project: projects){
			graph.getOrCreateNode(project);
		}
		for(String[] dependency: dependencies){
			String first = dependency[0];
			String end = dependency[1];
			graph.addEdge(first, end);
		}
		return graph;
	}
		
	static int addNonDependent(Project[] order, ArrayList<Project> projects, int offset){
		for(Project project : projects){
			if(project.getNumberDependencies() == 0){
				order[offset]=project;
				project.decrementDependencies(); //This part is missing from the Coding the Interview book
				offset++;
			}
		}
		return offset;
	}
	
	//Return a list of the projects build in the correct order
	static Project[] orderProjects(ArrayList<Project> projects){
		Project[] order = new Project[projects.size()];
		int endOfList = addNonDependent(order, projects, 0);
		
		int toBeProcessed = 0;
		while(toBeProcessed < order.length){
			Project current = order[toBeProcessed];
			if(current == null){
				return null;
			}
			ArrayList<Project> children = current.getChildren();
			for(Project child: children){
				child.decrementDependencies();
			}
			endOfList = addNonDependent(order, projects, endOfList);
			toBeProcessed++;
		}
		return order;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] projects = {"a", "b", "c", "d", "e", "f"};
		String[][] dependencies = { {"d","a"}, {"b","f"}, {"d","b"},{"a","f"},{"c","d"} };
		Project[] buildOrder = findBuildOrder(projects, dependencies);
		for(int i= buildOrder.length-1; i>=0; i--){
			System.out.println(buildOrder[i].getName());
		}
		

	}
	
	
}

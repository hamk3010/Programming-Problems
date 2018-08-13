import java.util.Stack;

public class topologicalSort extends dfs{
	


	public topologicalSort(basicGraph g) {
		super(g);
	}
	
	@Override
	public void process_vertex_early(Node start) {}

	@Override
	public void process_edge(Node start, Node end) {
		edgeClass edge_class = edge_classification(start, end);
		if(edge_class == edgeClass.BACK)
			System.out.println("Warning: directed cycle found, not a DAG");
	}



	@Override
	public void process_vertex_late(Node start) {
		myStack.add(start);
	}
	
	public static void main(String[] args) {
		String[] nodes1 = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] edges1 = { {"a","b"}, {"b","c"}, {"c","d"}, {"a","e"}, {"e","f"}, {"f","g"} };
		basicGraph dag = new basicGraph(nodes1, edges1);
		topologicalSort topsort_DAG = new topologicalSort(dag);
		
		String[] nodes2 = {"a", "b", "c", "d", "e"};
		String[][] edges2 = { {"a","b"},{"b","d"},{"b","e"},{"e","a"},{"a","c"} };
		basicGraph cycle = new basicGraph(nodes2, edges2);
		topologicalSort topsort_cycle = new topologicalSort(cycle);
		
		System.out.println("Printing DAG:");
		while(!topsort_DAG.myStack.isEmpty()){
			System.out.println(topsort_DAG.myStack.pop().getName());
		}
		
		System.out.println("Printing DAG with the cycle");
		while(!topsort_cycle.myStack.isEmpty()){
			System.out.println(topsort_cycle.myStack.pop().getName());
		}
	

	}


}

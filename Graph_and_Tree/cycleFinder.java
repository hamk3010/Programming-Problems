
public class cycleFinder extends dfs{

	public cycleFinder(basicGraph g) {
		super(g);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process_vertex_early(Node start) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process_edge(Node start, Node end) {
		if(parent.get(end) != start){
			System.out.println("Cycle from "  + start.getName() + " to " + end.getName());
			finished = true;
		}
		
	}

	@Override
	public void process_vertex_late(Node start) {
	}
	
	public static void main(String[] args) {
		String[] nodes1 = {"a", "b", "c", "d", "e"};
		String[][] edges1 = { {"a","b"}, {"a","d"}, {"b","c"}, {"d","e"}, {"e","c"} };
		basicGraph withCycle = new basicGraph(nodes1, edges1);
		cycleFinder findCycle = new cycleFinder(withCycle);
		System.out.print(findCycle.finished);
		
		String[] nodes2 = {"a", "b", "c", "d", "e"};
		String[][] edges2 = { {"a", "b"}, {"b","c"}, {"c","d"}, {"d","e"} };
		basicGraph withoutCycle = new basicGraph(nodes2, edges2);
		cycleFinder findCycle2 = new cycleFinder(withoutCycle);
		System.out.println();
		System.out.print(findCycle2.finished);

	}
	

}

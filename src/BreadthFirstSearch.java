import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*************************************************************************
 *  Breadth First Search class.
 *
 *  @version 1.0 24/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BreadthFirstSearch
{
	private final int sourceVertex;
	private boolean[] visited;
	private int[] edgeTo;
	
	/**
     * Perform Breadth First Search on all vertices in a graph
     */
	public BreadthFirstSearch(UndirectedGraph graph, int sourceVertex) throws IllegalArgumentException
	{
		if((sourceVertex < 0) || (sourceVertex >= graph.getNumberOfVertices()))
		{
			throw new IllegalArgumentException("Source vertex must be in graph");
		}
		
		this.sourceVertex = sourceVertex;
		visited = new boolean[graph.getNumberOfVertices()];
		edgeTo = new int[graph.getNumberOfVertices()];
		breadthFirstSearch(graph, sourceVertex);
	}
	
	/**
     * Perform breadth first search on the graph for a particular vertex
     * 
     * @param graph: graph to perform breadth first search on
     * @param vertex: vertex to perform breadth first search on
     */
    private void breadthFirstSearch(UndirectedGraph graph, int vertex)
    {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	visited[vertex] = true;
    	queue.add(vertex);
    	while(!queue.isEmpty())
    	{
    		int currentVertex = queue.remove();
    		for(int adjacentVertex : graph.getAdjacencyList(currentVertex))
    		{
    			if(!visited[adjacentVertex])
    			{
    				visited[adjacentVertex] = true;
    				edgeTo[adjacentVertex] = currentVertex;
    				queue.add(adjacentVertex);
    			}
    		}
    	}
    }
    
    /**
     * Check if there is a path from the source vertex to a particular vertex
     * 
     * @param vertex: vertex to check if a path exists to from the source vertex
     * @return is there a path from the source vertex to the vertex?
     */
    public boolean hasPathTo(int vertex)
    {
    	return visited[vertex];
    }
    
    /**
     * Get the path (if it exists) from the source vertex to a particular vertex
     * 
     * @param vertex: vertex to find path to (if it exists) from source vertex
     * @return path (if it exists) from the source vertex to the vertex
     */
    public Iterable<Integer> pathTo(int vertex)
    {
    	Stack<Integer> path = null;
    	if(hasPathTo(vertex))
    	{
    		path = new Stack<Integer>();
    		for(int currentVertex = vertex; currentVertex != sourceVertex; currentVertex = edgeTo[currentVertex])
    		{
    			path.push(currentVertex);
    		}
    		path.push(sourceVertex);
    	}
    	return path;
    }
}
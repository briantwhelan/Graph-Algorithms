import java.util.Stack;
/*************************************************************************
 *  Depth First Search class.
 *
 *  @version 1.0 24/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DepthFirstSearch
{
	private final int sourceVertex;
	private boolean[] visited;
	private int[] edgeTo;
	
	/**
     * Perform Depth First Search on all vertices in a graph
     */
	public DepthFirstSearch(UndirectedGraph graph, int sourceVertex)
	{
		if((sourceVertex < 0) || (sourceVertex >= graph.getNumberOfVertices()))
		{
			throw new IllegalArgumentException("Source vertex must be in graph");
		}
		
		this.sourceVertex = sourceVertex;
		visited = new boolean[graph.getNumberOfVertices()];
		edgeTo = new int[graph.getNumberOfVertices()];
		depthFirstSearch(graph, sourceVertex);
	}
	
	/**
     * Perform depth first search on the graph for a particular vertex
     * 
     * @param graph: graph to perform depth first search on
     * @param vertex: vertex to perform depth first search on
     */
    private void depthFirstSearch(UndirectedGraph graph, int vertex)
    {
    	visited[vertex] = true;
    	for(int adjacentVertex : graph.getAdjacencyList(vertex))
    	{
    		if(!visited[adjacentVertex])
    		{
    			edgeTo[adjacentVertex] = vertex;
    			depthFirstSearch(graph, adjacentVertex);
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
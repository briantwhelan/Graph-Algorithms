import java.util.HashSet;
/*************************************************************************
 *  Undirected Graph class.
 *
 *  @version 1.0 24/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class UndirectedGraph 
{
	private final int numberOfVertices;
	private int numberOfEdges;
	private HashSet<Integer>[] adjacencyLists;
	
	/**
     * Create an empty undirected graph with a particular number of vertices
     * @param: number of vertices to be included in undirected graph
     */
	public UndirectedGraph(int numberOfVertices)throws IllegalArgumentException
	{
		if(numberOfVertices < 0)
		{
			throw new IllegalArgumentException("Number of vertices must be positive");
		}
		
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		this.adjacencyLists = (HashSet<Integer>[]) new HashSet[numberOfVertices];
		for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			adjacencyLists[vertex] = new HashSet<Integer>();
		}
	}
	
//	/**
//     * Create an undirected graph from an input stream
//	 */
//	public UndirectedGraph(In in)
//	{
//		this(in.readInt()); 
//		int E = in.readInt(); 
//		for(int i = 0; i < E; i++)
//		{ 
//			int v = in.readInt(); 
//			int w = in.readInt(); 
//			addEdge(v, w);
//		}
//	}
	
	/**
     * Add an edge to the undirected graph
     * 
     * @param vertex1: first vertex of edge to be added
     * @param vertex2: second vertex of edge to be added
     */
    public void addEdge(int vertex1, int vertex2)
    {
    	if((vertex1 >= 0) && (vertex1 < numberOfVertices)
    		&& (vertex2 >= 0) && (vertex2 < numberOfVertices)
    		&& (!adjacencyLists[vertex1].contains(vertex2)))
    	{
	    	adjacencyLists[vertex1].add(vertex2);
	    	adjacencyLists[vertex2].add(vertex1);
	    	numberOfEdges++;
    	}
    }
    
    /**
     * Get adjacency list for a particular vertex
     * 
     * @param vertex: vertex of which adjacency list is required
     * @return vertices adjacent to vertex
     */
    public Iterable<Integer> getAdjacencyList(int vertex)
    {
    	Iterable<Integer> adjacencyList = null;
    	if((vertex >= 0) && (vertex < numberOfVertices))
    	{
    		adjacencyList = adjacencyLists[vertex];
    	}
    	
    	return adjacencyList;
    }
    
    /**
     * Get degree of a particular vertex
     * 
     * @param vertex: vertex of which degree is required
     * @return degree of vertex
     */
    public int getDegree(int vertex)
    {
    	int degree = -1;
    	if((vertex >= 0) && (vertex < numberOfVertices))
    	{
    		degree = adjacencyLists[vertex].size();
    	}
    	
    	return degree;
    }
    
    /**
     * Get number of vertices in undirected graph
     * 
     * @return number of vertices in undirected graph
     */
    public int getNumberOfVertices()
    {
    	return numberOfVertices;
    }
    
    /**
     * Get number of edges in undirected graph
     * 
     * @return number of edges in undirected graph
     */
    public int getNumberOfEdges()
    {
    	return numberOfEdges;
    }
    
    /**
     * Get String representation of graph's vertices and edges
     * 
     * @return String containing information on graph's vertices and edges
     */
    @Override
    public String toString()
    {
	    String string =  getNumberOfVertices() + " vertices, " + getNumberOfEdges() + " edges\n";
	    for(int vertex = 0; vertex < numberOfVertices; vertex++)
	    {
		    string += vertex + ": ";
		    for(int adjacentVertex : getAdjacencyList(vertex))
		    {
		    	string += adjacentVertex + " ";
		    }
		    string += "\n";
	    }
	    
	    return string;
    }
}
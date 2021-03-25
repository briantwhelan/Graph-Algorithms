import java.util.HashSet;
/*************************************************************************
 *  Weighted Directed Graph class.
 *
 *  @version 1.0 25/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class WeightedDirectedGraph 
{
	private final int numberOfVertices;
	private int numberOfEdges;
	private HashSet<Edge>[] adjacencyLists;
	
	/**
     * Create an empty weighted directed graph with a particular number of vertices
     * @param numberOfVertices: number of vertices to be included in weighted directed graph
     */
	public WeightedDirectedGraph(int numberOfVertices) throws IllegalArgumentException
	{
		if(numberOfVertices < 0)
		{
			throw new IllegalArgumentException("Number of vertices must be positive");
		}
		
		this.numberOfVertices = numberOfVertices;
		this.numberOfEdges = 0;
		this.adjacencyLists = (HashSet<Edge>[]) new HashSet[numberOfVertices];
		for(int vertex = 0; vertex < numberOfVertices; vertex++)
		{
			adjacencyLists[vertex] = new HashSet<Edge>();
		}
	}
	
	/**
     * Add an edge to the weighted directed graph
     * 
     * @param edge: edge to be added to weighted directed graph
     */
    public void addEdge(Edge edge)
    {
    	int vertex1 = edge.getHeadVertex();
    	int vertex2 = edge.getOtherVertex(vertex1);
    	if((vertex1 >= 0) && (vertex1 < numberOfVertices)
    		&& (vertex2 >= 0) && (vertex2 < numberOfVertices)
    		&& (!adjacencyLists[vertex1].contains(edge)))
    	{
	    	adjacencyLists[vertex1].add(edge);
	    	numberOfEdges++;
    	}
    }
    
    /**
     * Get incident edges for a particular vertex
     * 
     * @param vertex: vertex of which incident edges are required
     * @return edges incident to vertex
     */
    public Iterable<Edge> getIncidentEdges(int vertex)
    {
    	Iterable<Edge> incidentEdges = null;
    	if((vertex >= 0) && (vertex < numberOfVertices))
    	{
    		incidentEdges = adjacencyLists[vertex];
    	}
    	
    	return incidentEdges;
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
     * Get number of vertices in weighted directed graph
     * 
     * @return number of vertices in weighted directed graph
     */
    public int getNumberOfVertices()
    {
    	return numberOfVertices;
    }
    
    /**
     * Get number of edges in weighted directed graph
     * 
     * @return number of edges in weighted directed graph
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
		    for(Edge incidentEdge : getIncidentEdges(vertex))
		    {
		    	string += incidentEdge + " ";
		    }
		    string += "\n";
	    }
	    
	    return string;
    }
}
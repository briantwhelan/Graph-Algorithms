import java.util.Stack;
/*************************************************************************
 *  Dijkstra class.
 *
 *  @version 1.0 29/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class Dijkstra 
{
	private Edge[] edgeTo;
	private double[] distanceTo;
	private MinPQ<Integer> minPQ;
	
	/**
     * Perform Depth First Search on all vertices in a graph
     */
	public Dijkstra(WeightedDirectedGraph graph, int sourceVertex) throws IllegalArgumentException
	{
		if((sourceVertex < 0) || (sourceVertex >= graph.getNumberOfVertices()))
		{
			throw new IllegalArgumentException("Source vertex must be in graph");
		}
		
		edgeTo = new Edge[graph.getNumberOfVertices()];
		distanceTo = new double[graph.getNumberOfVertices()];
		minPQ = new MinPQ<Integer>(graph.getNumberOfVertices());
		
		for(int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++)
		{
			distanceTo[vertex] = Double.POSITIVE_INFINITY;
		}
		distanceTo[sourceVertex] = 0.0;
		
		minPQ.insert(sourceVertex);
		while(!minPQ.isEmpty())
		{
			relax(graph, minPQ.deleteMin());
		}
	}
	
    /**
     * Relax
     * 
     * @param graph: graph to relax 
     * @param vertex:
     */
    private void relax(WeightedDirectedGraph graph, int vertex)
    {
    	for(Edge edge : graph.getIncidentEdges(vertex))
    	{
    		int w = edge.getHeadVertex();
    		if(distanceTo[w] > (distanceTo[vertex] + edge.getWeight()))
    		{
    			distanceTo[w] = distanceTo[vertex] + edge.getWeight();
    			edgeTo[w] = edge;
    			if(minPQ.contains(w))
    			{
    				minPQ.changeKey(w, distanceTo[w]);
    			}
    			else
    			{
    				minPQ.insert(w, distanceTo[w]);
    			}
    		}
    	}
    }
	
	/**
     * Get the distance to a particular vertex from the source vertex
     * 
     * @param vertex: vertex to find distance to from source vertex
     * @return distance from the source vertex to the vertex
     */
    public double distanceTo(int vertex)
    {
    	return distanceTo[vertex];
    }
	
	/**
     * Check if there is a path from the source vertex to a particular vertex
     * 
     * @param vertex: vertex to check if a path exists to from the source vertex
     * @return is there a path from the source vertex to the vertex?
     */
    public boolean hasPathTo(int vertex)
    {
    	return distanceTo[vertex] < Double.POSITIVE_INFINITY;
    }
    
    /**
     * Get the path (if it exists) from the source vertex to a particular vertex
     * 
     * @param vertex: vertex to find path to (if it exists) from source vertex
     * @return path (if it exists) from the source vertex to the vertex
     */
    public Iterable<Edge> pathTo(int vertex)
    {
    	Stack<Edge> path = null;
    	if(hasPathTo(vertex))
    	{
    		path = new Stack<Edge>();
    		for(Edge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.getTailVertex()])
			{
    			path.push(edge);
    		}
    	}
    	return path;
    }
}

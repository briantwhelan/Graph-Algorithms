import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
/*************************************************************************
 *  Weighted Directed Graph test class.
 *
 *  @version 1.0 25/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class WeightedDirectedGraphTest 
{
	/**
     * Test constructor for invalid inputs
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException()
    {
    	//Test trying to create invalid graph
    	new WeightedDirectedGraph(-1);
    }
    
    /**
     * Test constructor for valid inputs
     */
    @Test
    public void testConstructor()
    {  	
    	//Test trying to create valid graph
    	new WeightedDirectedGraph(10);
    }
    
	/**
     * Test addEdge()
     */
    @Test
    public void testAddEdge()
    {
    	WeightedDirectedGraph graph = new WeightedDirectedGraph(3);
    	
    	//Test adding invalid edges
    	Edge edge = new Edge(1, 5, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	edge = new Edge(4, 1, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	edge = new Edge(1, -2, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	edge = new Edge(-1, 1, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	
    	//Test adding a valid edge
    	edge = new Edge(1, 2, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing addEdge for a valid edge", 1, graph.getNumberOfEdges());
    	
    	//Test adding a duplicate edge
    	graph.addEdge(edge);
    	assertEquals("Testing addEdge for a duplicate edge", 1, graph.getNumberOfEdges());   	
    }
    
    /**
     * Test getIncidentEdges()
     */
    @Test
    public void testGetIncidentEdges()
    {
    	WeightedDirectedGraph graph = new WeightedDirectedGraph(3);
    	
    	//Test getting an invalid adjacency list for invalid vertices
    	assertEquals("Testing getIncidentEdges for an invalid vertex", null, graph.getIncidentEdges(4));
    	assertEquals("Testing getIncidentEdges for an invalid vertex", null, graph.getIncidentEdges(-1));
    	
    	//Test getting an empty adjacency list for a valid vertex
    	assertEquals("Testing getIncidentEdges for a valid vertex", new HashSet<Edge>(), graph.getIncidentEdges(0));
    	
    	//Test getting a non-empty adjacency list for a valid vertex
    	Edge edge = new Edge(1, 0, 1.0);
    	graph.addEdge(edge);
    	edge = new Edge(2, 0, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing getIncidentEdges for a valid vertex", new HashSet<Edge>(Arrays.asList(new Edge(2, 0, 1.0), new Edge(1, 0, 1.0))), graph.getIncidentEdges(0));    
    }
    
    /**
     * Test getDegree()
     */
    @Test
    public void testGetDegree()
    {
    	WeightedDirectedGraph graph = new WeightedDirectedGraph(3);
    	
    	//Test getting degree of invalid vertices
    	assertEquals("Testing getDegree for an invalid vertex", -1, graph.getDegree(4));
    	assertEquals("Testing getDegree for an invalid vertex", -1, graph.getDegree(-1));
    	
    	//Test getting degree of a valid vertex with degree 0
    	assertEquals("Testing getDegree for a valid vertex", 0, graph.getDegree(0));
    	
    	//Test getting degree of a valid vertex with degree 2
    	Edge edge = new Edge(1, 0, 1.0);
    	graph.addEdge(edge);
    	edge = new Edge(2, 0, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing getDegree for a valid vertex", 2, graph.getDegree(0));  
    }
    
    /**
     * Test getNumberOfVertices()
     */
    @Test
    public void testGetNumberOfVertices()
    {    	
    	//Test getting number of vertices in a graph which has 0 vertices
    	WeightedDirectedGraph graph = new WeightedDirectedGraph(0);
    	assertEquals("Testing getNumberOfVertices", 0, graph.getNumberOfVertices());
    	
    	//Test getting number of vertices in a graph which has 3 vertices
    	graph = new WeightedDirectedGraph(3);
    	assertEquals("Testing getNumberOfVertices", 3, graph.getNumberOfVertices());  
    }
    
    /**
     * Test getNumberOfEdges()
     */
    @Test
    public void testGetNumberOfEdges()
    {    	
    	WeightedDirectedGraph graph = new WeightedDirectedGraph(3);
    	
    	//Test getting number of edges in a graph which has 0 edges
    	assertEquals("Testing getNumberOfEdges", 0, graph.getNumberOfEdges());
    	
    	//Test getting number of vertices in a graph which has 2 edges
    	Edge edge = new Edge(0, 1, 1.0);
    	graph.addEdge(edge);
    	edge = new Edge(0, 2, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing getNumberOfEdges", 2, graph.getNumberOfEdges());  
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	//Test toString on empty graph
    	WeightedDirectedGraph graph = new WeightedDirectedGraph(0);
    	assertEquals("Testing toString on empty graph", "0 vertices, 0 edges\n", graph.toString());
    	
    	//Test getting number of vertices in a graph which has 2 edges
    	graph = new WeightedDirectedGraph(3);
    	Edge edge = new Edge(1, 0, 1.0);
    	graph.addEdge(edge);
    	edge = new Edge(2, 0, 1.0);
    	graph.addEdge(edge);
    	assertEquals("Testing toString on non-empty graph", "3 vertices, 2 edges\n0: 2-0, 1.0 1-0, 1.0 \n1: \n2: \n", graph.toString());  
    }
}

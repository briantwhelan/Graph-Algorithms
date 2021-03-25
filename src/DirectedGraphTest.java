import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
/*************************************************************************
 *  Directed Graph test class.
 *
 *  @version 1.0 25/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class DirectedGraphTest 
{
	/**
     * Test constructor for invalid inputs
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException()
    {
    	//Test trying to create invalid graph
    	new DirectedGraph(-1);
    }
    
    /**
     * Test constructor for valid inputs
     */
    @Test
    public void testConstructor()
    {  	
    	//Test trying to create valid graph
    	new DirectedGraph(10);
    }
    
	/**
     * Test addEdge()
     */
    @Test
    public void testAddEdge()
    {
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	//Test adding invalid edges
    	graph.addEdge(1, 5);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(4, 1);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(1, -2);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	graph.addEdge(-1, 1);
    	assertEquals("Testing addEdge for an invalid edge", 0, graph.getNumberOfEdges());
    	
    	//Test adding a valid edge
    	graph.addEdge(1, 2);
    	assertEquals("Testing addEdge for a valid edge", 1, graph.getNumberOfEdges());
    	
    	//Test adding a duplicate edge
    	graph.addEdge(1, 2);
    	assertEquals("Testing addEdge for a duplicate edge", 1, graph.getNumberOfEdges());   	
    }
    
    /**
     * Test getAdjacencyList()
     */
    @Test
    public void testGetAdjacencyList()
    {
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	//Test getting an invalid adjacency list for invalid vertices
    	assertEquals("Testing getAdjacencyList for an invalid vertex", null, graph.getAdjacencyList(4));
    	assertEquals("Testing getAdjacencyList for an invalid vertex", null, graph.getAdjacencyList(-1));
    	
    	//Test getting an empty adjacency list for a valid vertex
    	assertEquals("Testing getAdjacencyList for a valid vertex", new HashSet<Integer>(), graph.getAdjacencyList(0));
    	
    	//Test getting a non-empty adjacency list for a valid vertex
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing getAdjacencyList for a valid vertex", new HashSet<Integer>(Arrays.asList(1, 2)), graph.getAdjacencyList(0));    
    }
    
    /**
     * Test getDegree()
     */
    @Test
    public void testGetDegree()
    {
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	//Test getting degree of invalid vertices
    	assertEquals("Testing getDegree for an invalid vertex", -1, graph.getDegree(4));
    	assertEquals("Testing getDegree for an invalid vertex", -1, graph.getDegree(-1));
    	
    	//Test getting degree of a valid vertex with degree 0
    	assertEquals("Testing getDegree for an valid vertex", 0, graph.getDegree(0));
    	
    	//Test getting degree of a valid vertex with degree 2
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing getDegree for an valid vertex", 2, graph.getDegree(0));  
    }
    
    /**
     * Test getNumberOfVertices()
     */
    @Test
    public void testGetNumberOfVertices()
    {    	
    	//Test getting number of vertices in a graph which has 0 vertices
    	DirectedGraph graph = new DirectedGraph(0);
    	assertEquals("Testing getNumberOfVertices", 0, graph.getNumberOfVertices());
    	
    	//Test getting number of vertices in a graph which has 3 vertices
    	graph = new DirectedGraph(3);
    	assertEquals("Testing getNumberOfVertices", 3, graph.getNumberOfVertices());  
    }
    
    /**
     * Test getNumberOfEdges()
     */
    @Test
    public void testGetNumberOfEdges()
    {    	
    	DirectedGraph graph = new DirectedGraph(3);
    	
    	//Test getting number of edges in a graph which has 0 edges
    	assertEquals("Testing getNumberOfEdges", 0, graph.getNumberOfEdges());
    	
    	//Test getting number of vertices in a graph which has 2 edges
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing getNumberOfEdges", 2, graph.getNumberOfEdges());  
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	//Test toString on empty graph
    	DirectedGraph graph = new DirectedGraph(0);
    	assertEquals("Testing toString on empty graph", "0 vertices, 0 edges\n", graph.toString());
    	
    	//Test getting number of vertices in a graph which has 2 edges
    	graph = new DirectedGraph(3);
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	assertEquals("Testing toString on non-empty graph", "3 vertices, 2 edges\n0: 1 2 \n1: \n2: \n", graph.toString());  
    }
}

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;
/*************************************************************************
 *  Breadth First Search test class.
 *
 *  @version 1.0 24/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class BreadthFirstSearchTest 
{    
	/**
     * Test constructor for invalid inputs
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException()
    {
    	UndirectedGraph graph = new UndirectedGraph(3);
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	
    	//Test trying to perform invalid depth first search
    	new BreadthFirstSearch(graph, -1);
    }
    
    /**
     * Test constructor for valid inputs
     */
    @Test
    public void testConstructor()
    {  	
    	UndirectedGraph graph = new UndirectedGraph(3);
    	graph.addEdge(0, 1);
    	graph.addEdge(0, 2);
    	
    	//Test trying to perform valid depth first search
    	new BreadthFirstSearch(graph, 0);
    }
    
	/**
     * Test hasPathTo
     */
    @Test
    public void testHasPathTo()
    {
    	UndirectedGraph graph = new UndirectedGraph(3);
    	graph.addEdge(0, 1);
    	BreadthFirstSearch dfs = new BreadthFirstSearch(graph, 0);
    	
    	//Test for when path does not exist
    	assertEquals("Testing hasPathTo for a path that does not exist", false, dfs.hasPathTo(2));
    	
    	//Test for when path exists
    	assertEquals("Testing hasPathTo for a path that exists", true, dfs.hasPathTo(1));
    }
    
	/**
     * Test pathTo
     */
    @Test
    public void testPathTo()
    {
    	UndirectedGraph graph = new UndirectedGraph(4);
    	graph.addEdge(0, 1);
    	graph.addEdge(1, 2);
    	BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
    	
    	//Test for when path does not exist
    	assertEquals("Testing pathTo for a path that does not exist", null, bfs.pathTo(3));
    	
    	//Test for when path exists
    	Stack<Integer> expectedPath = new Stack<Integer>();
    	expectedPath.push(2);
    	expectedPath.push(1);
    	expectedPath.push(0);
    	assertEquals("Testing pathTo for a path that exists", expectedPath, bfs.pathTo(2));
    }
}
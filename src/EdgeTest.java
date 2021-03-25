import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;
/*************************************************************************
 *  Edge test class.
 *
 *  @version 1.0 25/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class EdgeTest 
{  
    /**
     * Test constructor
     */
    @Test
    public void testConstructor()
    {  	
    	new Edge(0, 1, 2.5);
    }
    
    /**
     * Test getHeadVertex()
     */
    @Test
    public void testGetHeadVertex()
    {    	
    	Edge edge = new Edge(0, 1, 2.5);
    	
    	//Test getting head vertex
    	assertEquals("Testing getHeadVertex", 0, edge.getHeadVertex());
    }
    
    /**
     * Test getOtherVertex()
     */
    @Test
    public void testGetOtherVertex()
    {    	
    	Edge edge = new Edge(0, 1, 2.5);
    	
    	//Test getting other vertex
    	assertEquals("Testing getOtherVertex", 1, edge.getOtherVertex(0));
    	assertEquals("Testing getOtherVertex", 0, edge.getOtherVertex(1));
    }
    
    /**
     * Test getWeight()
     */
    @Test
    public void testGetWeight()
    {    	
    	Edge edge = new Edge(0, 1, 2.5);
    	
    	//Test getting edge's weight
    	assertEquals("Testing getWeight", 2.5, edge.getWeight(), 0);
    }
    
    /**
     * Test compareTo()
     */
    @Test
    public void testCompareTo()
    {    	    	
    	//Test comparing two edges with equal weight
    	Edge edge = new Edge(0, 1, 2.5);
    	Edge otherEdge = new Edge(2, 3, 2.5);
    	assertEquals("Testing compareTo for two edges with equal weight", 0, edge.compareTo(otherEdge));
    	
    	//Test comparing two edges with unequal weight
    	otherEdge = new Edge(2, 3, 1.0);
    	assertEquals("Testing compareTo for two edges with unequal weight", 1, edge.compareTo(otherEdge));
    	
    	//Test comparing two edges with unequal weight
    	otherEdge = new Edge(2, 3, 4.0);
    	assertEquals("Testing compareTo for two edges with unequal weight", -1, edge.compareTo(otherEdge));
    }
    
    /**
     * Test equals()
     */
    @Test
    public void testEquals()
    {    	
    	Edge edge = new Edge(0, 1, 2.5);
    	
    	//Test equals on the same object
    	assertEquals("Testing equals for the same object", true, edge.equals(edge)); 
    	
    	//Test equals on a different object type
    	assertEquals("Testing equals for a different object", false, edge.equals(new String("test")));
    	
    	//Test equals on the same object type with different field values
    	Edge edge2 = new Edge(1, 3, 4.0);
    	assertEquals("Testing equals for a different object", false, edge.equals(edge2));
    }
    
    /**
     * Test hashCode()
     */
    @Test
    public void testHashCode()
    {    	
    	//Test hashCode on two edges with different field values
    	Edge edge1 = new Edge(0, 1, 2.5);
    	Edge edge2 = new Edge(0, 2, 4.0);
    	assertNotEquals("Testing hashCode for two edges with different field values", edge2.hashCode(), edge1.hashCode()); 
    	
    	//Test hashCode on two edges with equal field values
    	edge2 = new Edge(0, 1, 2.5);
    	assertEquals("Testing hashCode for two edges with equal field values", edge2.hashCode(), edge1.hashCode()); 
    }
    
    /**
     * Test toString()
     */
    @Test
    public void testToString()
    {    	
    	//Test toString on empty graph
    	Edge edge = new Edge(0, 1, 2.5);
    	assertEquals("Testing toString", "0-1, 2.5", edge.toString()); 
    }
}

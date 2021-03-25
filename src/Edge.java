import java.util.HashSet;
import java.util.Objects;
/*************************************************************************
 *  Edge class.
 *
 *  @version 1.0 25/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class Edge implements Comparable<Edge>
{
	private final int vertex1;
	private final int vertex2;
	private final double weight;
	
	/**
     * Create an edge with the specified properties
     * @param vertex1: head vertex of edge
     * @param vertex2: tail vertex of edge
     * @param weight: weight of edge
     */
	public Edge(int vertex1, int vertex2, double weight)
	{
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}
	
	/**
     * Get head vertex in edge
     * 
     * @return head vertex in edge
     */
	public int getHeadVertex()
	{
		return vertex1;
	}
	
	/**
     * Get other vertex in edge
     * 
     * @param vertex: the known vertex in edge
     * @return vertex in edge not specified in parameter
     */
	public int getOtherVertex(int vertex)
	{
		int otherVertex = -1;
		if(vertex == vertex1)
		{
			otherVertex = vertex2;
		}
		else if(vertex == vertex2)
		{
			otherVertex = vertex1;
		}
		
		return otherVertex;
	}
	
	/**
     * Get weight of edge
     * 
     * @return weight of edge
     */
	public double getWeight()
	{
		return weight;
	}
	
	/**
     * Compare two edges' weights
     * 
     * @param edge: edge to compare to
     * @return integer representing result of comparison
     */	
	@Override
	public int compareTo(Edge edge)
	{
		int comparison = 0;
		if(weight < edge.getWeight())
		{
			comparison = -1;
		}
		else if(weight > edge.getWeight())
		{
			comparison = 1;
		}
		
		return comparison;
	}
	
	/**
     * Compare two edges
     * 
     * @return boolean representing result of comparison
     */	
	@Override
	public boolean equals(Object object)
	{
		boolean isEquals;
		if(object == this)
		{
			isEquals = true;
		}
		else if(!(object instanceof Edge))
		{
			isEquals = false;
		}
		else
		{
			Edge edge = (Edge)object;
			isEquals = (edge.getHeadVertex() == vertex1)
						&& (edge.getOtherVertex(edge.getHeadVertex()) == vertex2)
						&&	(edge.getWeight() == weight);
		}
		return isEquals;
	}
	
	/**
     * Get hash code of edge
     * 
     * @return hash code corresponding to edge
     */	
	@Override
	public int hashCode()
	{
		int result = 17;
		result = 31 * result + vertex1;
		result = 31 * result + vertex2;
		result = 31 * result + (int)weight;
		return result;
		//return Objects.hash(vertex1, vertex2, weight);
	}
	
	/**
     * Get String representation of edge
     * 
     * @return String containing information on edge
     */	
	@Override
	public String toString()
	{
		return vertex1 + "-" + vertex2 + ", " + weight;
	}
}
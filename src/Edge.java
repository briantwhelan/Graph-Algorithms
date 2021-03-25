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
	private final int tailVertex;
	private final int headVertex;
	private final double weight;
	
	/**
     * Create an edge with the specified properties
     * @param vertex1: tail vertex of edge
     * @param vertex2: head vertex of edge
     * @param weight: weight of edge
     */
	public Edge(int tailVertex, int headVertex, double weight)
	{
		this.tailVertex = tailVertex;
		this.headVertex = headVertex;
		this.weight = weight;
	}
	
	/**
     * Get tail vertex in edge
     * 
     * @return tail vertex in edge
     */
	public int getTailVertex()
	{
		return tailVertex;
	}
	
	/**
     * Get head vertex in edge
     * 
     * @return head vertex in edge
     */
	public int getHeadVertex()
	{
		return headVertex;
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
		if(vertex == tailVertex)
		{
			otherVertex = headVertex;
		}
		else if(vertex == headVertex)
		{
			otherVertex = tailVertex;
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
			isEquals = (edge.getTailVertex() == tailVertex)
						&& (edge.getHeadVertex() == headVertex)
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
		result = 31 * result + tailVertex;
		result = 31 * result + headVertex; 
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
		return tailVertex + "-" + headVertex + ", " + weight;
	}
}
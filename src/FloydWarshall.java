/*************************************************************************
 *  Floyd Warshall class.
 *
 *  @version 1.0 29/3/21
 *
 *  @author Brian Whelan
 *
 *************************************************************************/
public class FloydWarshall 
{
	private Edge[][] adjacencyMatrix;
	private double[][] distanceTo;
	
	public FloydWarshall(WeightedDirectedGraph graph)
	{
		distanceTo = new double[graph.getNumberOfVertices()][graph.getNumberOfVertices()];
		adjacencyMatrix = new Edge[graph.getNumberOfVertices()][graph.getNumberOfVertices()];
		
		//Initialise all distances to infinity
		for(int vertex1 = 0; vertex1 < graph.getNumberOfVertices(); vertex1++)
		{
			for(int vertex2 = 0; vertex2 < graph.getNumberOfVertices(); vertex2++)
			{
				if(vertex1 == vertex2)
				{
					distanceTo[vertex1][vertex2] = 0.0;
				}
				else
				{
					distanceTo[vertex1][vertex2] = Double.POSITIVE_INFINITY;
				}
			}
		}
		
		//Initialise known distances and edges
		for(int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++)
		{
			for(Edge edge : graph.getIncidentEdges(vertex))
			{
				distanceTo[edge.getTailVertex()][edge.getHeadVertex()] = edge.getWeight();
				adjacencyMatrix[edge.getTailVertex()][edge.getHeadVertex()] = edge;
			}
		}
		        
	    for(int i = 0; i < graph.getNumberOfVertices(); i++) 
	    {
	      for(int j = 0; j < graph.getNumberOfVertices(); j++) 
	      {
	        for(int k = 0; k < graph.getNumberOfVertices(); k++) 
	        {
	          if(distanceTo[j][k] > (distanceTo[j][i] + distanceTo[i][k]))
	          {
	        	  distanceTo[j][k] = distanceTo[j][i] + distanceTo[i][k];
	        	  adjacencyMatrix[j][k] = adjacencyMatrix[i][k];
	          }
	        }
	      }
	    }
	}
}

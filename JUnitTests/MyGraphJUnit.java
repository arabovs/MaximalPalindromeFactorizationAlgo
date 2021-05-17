package JUnitTests;
import static org.junit.Assert.*;
import org.junit.Test;
import wrapper_classes.MyGraph;

public class MyGraphJUnit extends MyGraph{

	protected int n;
	
	public MyGraphJUnit(int v) { super(v); }
	public void setUp(){ n = 12; }
	public void testMyGraph(){
			
	MyGraph graph = new MyGraph(n);
		graph.addEdge(1, 2);
		graph.addEdge(2, 3);
		graph.addEdge(4, 5);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(9, 10);
	}
}

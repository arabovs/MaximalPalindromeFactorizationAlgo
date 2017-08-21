package wrapper_classes;

import java.util.*;
/**
 * 
 * @author Simeon Arabov
 * MyGraph implements a simple graph with create Vertex , add Edge and compute BFS functions
 *
 */
public class MyGraph
{
 private static int V;   
 private LinkedList<Integer> adj[]; 
 static WrapperSet[] path;


//create graph with vertices equal to V
 public MyGraph(int v)
 {
     V = v;
     adj = new LinkedList[v];
     for (int i=0; i<v; ++i)
         adj[i] = new LinkedList<Integer>();
     path = new WrapperSet[v];
     for(int i =0;i<v;i++){
    	 path[i] = new WrapperSet();
     }
 }

//add edge
 public void addEdge(int v,int w)
 {
     adj[v].add(w);
 }

 // prints BFS traversal from a given source s
 public HashSet<Integer> BFS(int s)
 {

     boolean visited[] = new boolean[V];
     LinkedList<Integer> queue = new LinkedList<Integer>();
     HashSet<Integer> hash = new HashSet<Integer>();
     
     visited[s]=true;
     queue.add(s);

     while (queue.size() != 0)
     {

         s = queue.poll();
       //  System.out.print(s+" ");
         hash.add(s);
         

         Iterator<Integer> i = adj[s].listIterator();
         while (i.hasNext())
         {
             int n = i.next();
             if (!visited[n])
             {
            	 
                 visited[n] = true;
                 queue.add(n);
             }
         }
     }
     return hash;
     
     
    
 }

//test functions
 public static void main(String args[])
 {
	 MyGraph g = new MyGraph(4);

     g.addEdge(0, 1);
     g.addEdge(0, 2);
     g.addEdge(1, 2);
     g.addEdge(2, 0);
     g.addEdge(2, 3);
     g.addEdge(3, 3);

     System.out.println("Following is Breadth First Traversal "+
                        "(starting from vertex 2)");

     g.BFS(2);

     
   
     }
 

 

 
}
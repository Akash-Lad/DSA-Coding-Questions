import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    static void TopologicalSort(ArrayList<ArrayList<Integer>>adj, int v){

        int indegree[] = new int[v];

        for(int i=0; i<v; i++)
            for(int u:adj.get(i))
                indegree[u]++;

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<v; i++)
            if(indegree[i]==0)
                q.add(i);
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");

            for(int x:adj.get(u)){
                if(--indegree[x]==0)
                    q.add(x);
            }
        }

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){

        adj.get(u).add(v);
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int src = 0;
        int v = 5;
        boolean visited[] = new boolean[v];

        for(int i=0; i<v;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0, 2);
        addEdge(adj,0, 3);
        addEdge(adj,1, 3);
        addEdge(adj,1, 4);
        addEdge(adj,2, 3);

        TopologicalSort(adj,v);

    }
}

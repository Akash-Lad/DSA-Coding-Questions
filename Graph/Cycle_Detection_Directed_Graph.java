import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static boolean DFS_Recursive(ArrayList<ArrayList<Integer>>adj, int s, boolean visited[], boolean rec_stack[]){

        visited[s] = true;
        rec_stack[s] = true;

        for(int v:adj.get(s)){

            if((visited[v]==false) && DFS_Recursive(adj,v,visited,rec_stack))
                    return true;
            else if(rec_stack[v]==true)
                return true;
        }
        rec_stack[s] = false;
        return false;
    }

    static boolean DFS(ArrayList<ArrayList<Integer>>adj, int v){

        boolean visted[] = new boolean[v];
        boolean rec_stack[] = new boolean[v];

        for(int i=0;i<v;i++)
            if(visted[i]==false)
                if(DFS_Recursive(adj,i,visted,rec_stack))
                    return true;

        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){

        adj.get(u).add(v);
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int src = 0;
        int v = 6;
        boolean visited[] = new boolean[v];

        for(int i=0; i<v;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        //addEdge(adj,5,3);

        if(DFS(adj,v))
            System.out.println("Cycle Found");
        else
            System.out.println("Cycle Not Found");

    }
}

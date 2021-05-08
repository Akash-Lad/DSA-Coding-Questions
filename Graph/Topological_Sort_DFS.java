import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    static void DFS(ArrayList<ArrayList<Integer>>adj, Stack<Integer>stack, boolean visited[],int src){

        visited[src] = true;

        for(int i:adj.get(src))
            if(visited[i]==false)
                DFS(adj,stack,visited,i);

        stack.push(src);
    }

    static void TopologicalSort(ArrayList<ArrayList<Integer>>adj, Stack<Integer>stack, int v){

        boolean visited [] = new boolean[v];

        for(int i=0; i<v; i++){
            if(visited[i]==false)
                DFS(adj,stack,visited,i);
        }

        while(!stack.isEmpty()){
            int u = stack.pop();
            System.out.println(u);
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

        addEdge(adj,0,1);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,3,4);

        Stack<Integer> stack = new Stack<>();
        TopologicalSort(adj,stack,v);

    }
}

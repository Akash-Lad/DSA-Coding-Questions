package com.company;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    static boolean DFS_Recursive(ArrayList<ArrayList<Integer>>adj, int s, boolean visited[], int parent){

        visited[s] = true;

        for(int v:adj.get(s)){

            if(visited[v]==false){
                if(DFS_Recursive(adj,v,visited,s)==true)
                    return true;
            }
            else if(v!=parent)
                return true;

        }

        return false;
    }

    static boolean DFS(ArrayList<ArrayList<Integer>>adj, int v){

        boolean visted[] = new boolean[v];

        for(int i=0;i<v;i++){

            if(visted[i]==false)
                if(DFS_Recursive(adj,i,visted,-1))
                    return true;
        }
        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){

        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        int src = 0;
        int v = 6;
        boolean visited[] = new boolean[v];

        for(int i=0; i<v;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        addEdge(adj,2,4);
        addEdge(adj,4,5);

        if(DFS(adj,v))
            System.out.println("Cycle Found");
        else
            System.out.println("Cycle Not Found");

    }
}

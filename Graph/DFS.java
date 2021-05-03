package com.company;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{

    public static void dispx(ArrayList<ArrayList<Integer>>adj){

        for(int i=0; i<adj.size(); i++){
            for(int j=0; j<adj.get(i).size(); j++){
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer>>adj, int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void DFS(ArrayList<ArrayList<Integer>>adj, boolean []visited, int v, int s){
        visited[s] = true;
        System.out.print(s+" ");
        for(int x:adj.get(s))
            if(visited[x]==false)
                DFS(adj,visited,v,x);


    }
    public static void main(String[] args) {

        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,3);
        addEdge(adj,1,4);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        boolean visited [] = new boolean[v];
        DFS(adj,visited,5,0);
        //dispx(adj);
    }
}

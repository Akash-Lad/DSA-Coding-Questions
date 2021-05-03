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

    public static void Shortest_Path_unweighted_graph(ArrayList<ArrayList<Integer>>adj, boolean visited[], int v, int s){
        int dist[] = new int[v];
        for(int i=0;i<v;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        while(q.isEmpty()==false){
            int u = q.poll();
            for(int x:adj.get(u)){
                if(visited[x]==false){
                    dist[x] = dist[u] + 1;
                    visited[x] = true;
                    q.add(x);
                }
            }
        }
        for(int i:dist)
            System.out.print(i+" ");
    }

    public static void main(String[] args) {

        int v = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<Integer>());
        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,1,3);
        addEdge(adj,2,3);
        boolean visited [] = new boolean[v];
        Shortest_Path_unweighted_graph(adj,visited,4,0);
        //dispx(adj);
    }
}

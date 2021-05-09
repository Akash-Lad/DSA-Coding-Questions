import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static int min(int x, int y, int z){

        if(x < y)
            return (x<z)?x:z;
        else
            return (y<z)?y:z;
    }

    public static int minCost(int graph[][], int m, int n){

        if(n<0 || m<0)
            return Integer.MAX_VALUE;
        else if(m==0 && n==0)
            return graph[m][n];
        else
            return graph[m][n] + min(minCost(graph,m-1,n-1),
                                    minCost(graph,m,n-1),
                                    minCost(graph,m-1,n));


    }

    public static void main(String[] args)
    {
        int cost[][] = { {1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3} };

        System.out.println(minCost(cost,2,2));

    }
}

static void BFS(ArrayList<ArrayList<Integer>> adj,int s,boolean visited[]){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;

        while(!queue.isEmpty()){

            int u = queue.poll();
            System.out.print(u+" ");

            for(int item:adj.get(u)){

                if(visited[item]==false){

                    visited[item] = true;
                    queue.add(item);
                }

            }
        }
    }

    static void BfsDisconnected(ArrayList<ArrayList<Integer>> adj,int v){

        boolean []visited = new boolean[v];
        int count = 0;
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                BFS(adj,i,visited);
                count++;
        }
    }
        System.out.println(count);

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v){

        adj.get(u).add(v);
        adj.get(v).add(u);

    }

    public static void main(String[] args){

        int vetex = 9;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(5);

        for(int i=0;i<vetex;i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,3,4);
        addEdge(adj,5,6);
        addEdge(adj,5,7);
        addEdge(adj,7,8);
        int s = 0;
        boolean [] visited = new boolean[vetex];

        BfsDisconnected(adj,vetex);

    }
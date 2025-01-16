import java.util.*;

class Pair {
    int dist;
    int node;

    public Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

class Primealgo {
    public static int Primesalgo(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dist - y.dist);
        int vis[] = new int[V];
        pq.add(new Pair(0, 0));
        int sum = 0;

        while (pq.size() > 0) {
            int wt = pq.peek().dist;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) {
                continue;
            }

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjnode = adj.get(node).get(i).get(0);
                int edw = adj.get(node).get(i).get(1);
                if (vis[adjnode] == 0) {
                    pq.add(new Pair(edw, adjnode));
                }
            }
        }

        return sum;
    }

    public static void main(String args[]) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> edge1 = new ArrayList<>();
            edge1.add(v);
            edge1.add(w);
            adj.get(u).add(edge1);

            ArrayList<Integer> edge2 = new ArrayList<>();
            edge2.add(u);
            edge2.add(w);
            adj.get(v).add(edge2);
        }

        int sum = Primesalgo(V, adj);
        System.out.println("Minimum spanning tree is: " + sum);
    }
}

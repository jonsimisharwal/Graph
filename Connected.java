// Problem Statement: You are given a graph with n vertices and m edges.
// You can remove one edge from anywhere and add that edge between any two vertices
// in one operation. Find the minimum number of operations that will be required to make 
//the graph connected. If it is not possible to make the graph connected, return -1.
import java.util.*;
class Connected {
    public static void main (String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};

        Solution obj = new Solution();
        int ans = obj.makeConnected(V, edge);
        System.out.println("The number of operations needed: " + ans);

    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtras=0;
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if (ds.FindUPar(u) == ds.FindUPar(v)) {
                cntExtras++;
            } else {
                ds.unionBySize(u, v);
            }
        }
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) cntC++;
        }
        int ans = cntC - 1;
        if (cntExtras >= ans) {return ans;  }
        return -1;
    }
}
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
       for(int i=0;i<=n;i++){
        rank.add(0);
        parent.add(i);
        size.add(1);
       }
    }
    public int FindUPar(int node){
        if(node== parent.get(node)){
            return node;
        }
        int ulp=FindUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=FindUPar(u);
        int ulp_v=FindUPar(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }else{
            parent.set(ulp_v,ulp_u);
            int ranku=rank.get(ulp_u);
            rank.set(ulp_u,ranku+1);
        }
    }
     public void unionBySize(int u,int v){
        int ulp_u=FindUPar(u);
        int ulp_v=FindUPar(v);
        if(ulp_u == ulp_v){
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));

        }else{
            parent.set(ulp_v,ulp_u);
           size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        
        }
    }
}
//Problem Statement: Given a Directed Acyclic Graph (DAG) with V vertices and E edges,
// Find any Topological Sorting of that Graph.

import java.util.*;
class Toposort{
    public static void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,st,adj);
            }
        }
        st.push(node);
    }
    public static int[] Toposorting(int V,ArrayList<ArrayList<Integer>> adj){
        int vis[]=new int[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,st,adj);
            }
        }
        int i=0;
        int ans[]=new int[V];
        while(!st.isEmpty()){
         ans[i]=st.peek();
         st.pop();
         i++;
        }
        return ans;
    }
    public static void main(String args[]){
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<5;i++){
        adj.add(new ArrayList<>());
    }
    adj.get(0).add(1);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
    int ans[]=Toposorting(5, adj);
    for(int node:ans){
        System.out.print(node + " ");
    }
    System.out.println();
    }
}
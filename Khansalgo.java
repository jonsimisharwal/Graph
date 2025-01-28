import java.util.*;
class Khansalgo{
    public static int[] Toposort(int V,ArrayList<ArrayList<Integer>> adj){
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int node:adj.get(i)){
                indegree[node]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
         for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
         }
         int topo[]=new int[V];
         int i=0;
         while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[i++]=node;
            for(int it:adj.get(node)){
               indegree[it]--;
               if(indegree[it]==0){
                q.add(it);
               }
            }
         }
         return topo;
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<6;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);
        
        int ans[]=Toposort(6, adj);
        for(int node:ans){
            System.out.print(node +" ");
        }
        System.out.println();
    }
}
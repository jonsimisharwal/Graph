
import java.util.*;
class Topological{
    //linear ordering of vertices such that if there is an edge between u and v then u appears before v in that ordering
    // topological sorting by DFS
    public static void dfs(int node,int vis[],Stack<Integer> st,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,st,adj);
            }
            st.push(node);
        }
       
    }
    public static void Toposort(int V,ArrayList<ArrayList<Integer>> adj){
          int vis[]=new int[V];
          Stack<Integer> st=new Stack<>();
          for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,st,adj);
            }
          }
          int ans[]=new int[V];
          int i=0;
          while(!st.isEmpty()){
           ans[i++]=st.peek();
           st.pop();
          }
          for(int j=0;j<ans.length;j++){
            System.out.print(ans[j] +" ");
          }
          System.out.println();
    }  
   //   kahn's algorithm-topological sorting by BFS
   public static int[] KToposort(int V ,ArrayList<ArrayList<Integer>> adj){
    int indegree[]=new int[V];
    for(int i=0;i<V;i++){
        for(int it:adj.get(i)){
             indegree[it]++;
        }
    }
    Queue<Integer> q=new LinkedList<>();
    for(int i=0;i<V;i++){
        if(indegree[i]==0){
            q.add(i);
        }
    }
    int temp[]=new int[V];
    int i=0;
    while(!q.isEmpty()){
        int node=q.peek();
        q.remove();
        temp[i++]=node;
        for(int it:adj.get(node)){
            indegree[it]--;
            if(indegree[it]==0){
                q.add(it);
            }}}
    return temp;
   }
    public static void main(String args[]){
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       for(int i=0;i<6;i++){
         adj.add(new ArrayList<>());
       }
       adj.get(5).add(0);
       adj.get(0).add(4);
       adj.get(4).add(1);
       adj.get(1).add(3);
       adj.get(3).add(2);
       adj.get(2).add(5);
       
      Toposort(6,adj);
       int[] ans=KToposort(6,adj);
       if (ans.length > 0) {
       for(int i=0;i<6;i++){
       System.out.print(ans[i]);
       }
       System.out.println();
    }
    }
}
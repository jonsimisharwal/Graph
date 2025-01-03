
import java.util.*;
class Node{
    int val1;
    int val2;
    public Node(int val1,int val2){
        this.val1=val1;
        this.val2=val2;
    }

}
 class CycleDetection{
    //by using Dfs
    public static boolean DFS(int node,int par,int[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                
                if(DFS(it,node, vis, adj)){
                    return true;
                }
                
            }
            else if( it!=par ){
                return true;
            }
        }
        return false;
    }
    //using dfs
    public static boolean CycledetectDFS(int V,ArrayList<ArrayList<Integer>> adj){
      int vis[]=new int[V];
     
    for(int i=0;i<V;i++){
        if(vis[i]==0){
            if(DFS(i,-1,vis,adj)==true){
                return true;
            }
        }
    }
    return false;
    }
    public static boolean BFS(int node,boolean[] vis,int[] parent ,ArrayList<ArrayList<Integer>> adj){
       
        Queue<Node> q=new LinkedList<>();
    q.add(new Node(node,-1));
    vis[node]=true;
    while(!q.isEmpty()){
        int nodes=q.peek().val1;
        int par=q.peek().val2;
        q.remove();
        for(Integer it:adj.get(nodes)){
            if(vis[it]==false){
                q.add(new Node(it,nodes));
                vis[it]=true;
                }else if(par!=it){
                    return true;
                }
                    
                }
            }
        
            return false;
    }
       
    
    public static boolean CycleDetectionBfs(int V,ArrayList<ArrayList<Integer>> adj){
        boolean vis[]=new boolean[V];
        Arrays.fill(vis,false);
        int parent[]=new int[V];
        Arrays.fill(parent,-1);
        for(int i=0;i<V;i++){
            if(vis[i]==false){
               if( BFS(i,vis,parent,adj)==true){
                return true;

               }
            }
        }
        return false;

    }
    public static void main(String args[]){
     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
     for(int i=0;i<6;i++){
       adj.add(new ArrayList<>());
     }
     adj.get(1).add(2);
     adj.get(2).add(1);
     adj.get(1).add(3);
     adj.get(3).add(1);
     adj.get(2).add(4);
     adj.get(4).add(2);
     adj.get(4).add(5);
     adj.get(5).add(4);
 //   boolean ans=CycledetectDFS(5,adj);
 //   System.out.println("cycle detection in this:"+ ans);
   boolean value=CycleDetectionBfs(6,adj);
   System.out.println("cycle detection in this:"+ value);
    }
 }
import java.util.*;
class BipartiteGraph{
    public static boolean isBipartite(int[][] graph) {
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        
        for(int i=0;i<graph.length;i++){
            
                if(color[i]==-1){
                   if( dfs(i,0,color,graph)==false){
                         return false;
                   }
                    
                }
            
        }
        return true;
    }
    public static boolean dfs(int node,int col,int color[],int[][] graph){
        color[node]=col;
        for(int next:graph[node]){
            if(color[next]==-1){
            if(dfs(next,1-col,color,graph)==false){
                  return false;
            }
            }else if(color[next]==col){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
   int graph[][]={{1,2,3},{0,2},{0,1,3},{0,2}};
   boolean ans=isBipartite(graph);
   System.out.println("Is Graph Bipartite? "+ans);
    }
}
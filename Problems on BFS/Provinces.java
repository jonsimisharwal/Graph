import java.util.*;
class Provinces
{
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adjl,int vis[]){
        vis[node]=1;
        for(Integer it:adjl.get(node)){
            if(vis[it]==0){
                dfs(it,adjl,vis);

            }
        }
    }

    public static int Proviences(int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<ArrayList<Integer>> adjl=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjl.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adjl.get(i).add(j);
                    adjl.get(j).add(i);
                }
            }
            
        }
        int vis[]=new int[V];
        int count=0;
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                count++;
                dfs(i,adjl,vis);
            }
        }
        return count;
    }
    public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
        int ans=Proviences(3, adj);
        System.out.println("number of provinces:"+ ans);
    }
}
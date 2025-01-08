import java.util.*;
import java.util.PriorityQueue;
class Pair{
    int first; 
    int second; 
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Dijkastrasalgo{
    public static int[] Dijkastrasalgo(int v,int s,ArrayList<ArrayList<ArrayList<Integer>>> adj){
   PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
    int dist[]=new int[v];
    pq.add(new Pair(0,s));
    for(int i=0;i<v;i++){
          dist[i]=(int)1e9;
    }
    dist[s]=0;
    while(!pq.isEmpty()){
        int dis=pq.peek().first;
        int node=pq.peek().second;
        pq.remove();
        for(int i = 0;i<adj.get(node).size();i++) {
            int edges = adj.get(node).get(i).get(1); 
            int adjnode = adj.get(node).get(i).get(0); 
            
          
            if(dis+edges<dist[adjnode]){
                dist[adjnode]=dis+edges;
                pq.add(new Pair(dist[adjnode],adjnode));
               
            }
        }
    }

   return dist;
        
    }
    public static void main(String args[]){
        int v = 3,s=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};
        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }  
          };
          ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }  
          };
          ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }  
          };
          ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
              {
                  add(inter1); 
                  add(inter2); 
                  add(inter3); 
              }
          };
        int ans[]=Dijkastrasalgo(v, s, adj);
        for(int it:ans){
            System.out.print(it +" ");
        }
        System.out.println();
    }
}
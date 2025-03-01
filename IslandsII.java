import java.util.*;
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp=findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u ==ulp_v){
            return ;
        }
        if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        } else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }else{
            parent.set(ulp_v,ulp_u);
            int ranku=rank.get(ulp_u);
            rank.set(ulp_u,ranku+1);
        }
    }
    public void unionBySize(int u,int v){
        int ulp_u=findUPar(u);
        int ulp_v=findUPar(v);
        if(ulp_u ==ulp_v){
            return ;
        }
        if(size.get(ulp_v)<size.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        } else {
            parent.set(ulp_u,ulp_v);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        
        }
    }
}

class IslandsII{
    public static boolean isValid(int adjr,int adjc,int n,int m){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<m;
    }
    public static List<Integer> NumberofIslandsII(int n,int m,int operators[][]){
      DisjointSet ds=new DisjointSet(n*m);
      int vis[][]=new int[n][m];
      int count=0;
      List<Integer> ans=new ArrayList<>();
      int len=operators.length;
      for(int i=0;i<len;i++){
        int row=operators[i][0];
        int col=operators[i][1];
        if(vis[row][col]==1){
            ans.add(count);
            continue;
        }
        vis[row][col]=1;
        count++;
        int dr[] = { -1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        for (int ind = 0; ind < 4; ind++) {
            int adjr = row + dr[ind];
            int adjc = col + dc[ind];
            if (isValid(adjr, adjc, n, m)) {
                if (vis[adjr][adjc] == 1) {
                    int nodeNo = row * m + col;
                    int adjNodeNo = adjr * m + adjc;
                    if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                        count--;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        ans.add(count);
      }
   return ans;
    }
    public static void main(String args[]){
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

      
        List<Integer> ans = NumberofIslandsII(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}
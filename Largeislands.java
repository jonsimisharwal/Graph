import java.util.*;


class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}


class Largeislands{
    public static boolean isValid(int newr,int newc,int n){
        return newr>=0 && newr<n && newc>=0 && newc<n ;
    }
    public static int MaxIslands(int grid[][]){
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    continue;
                }
                int dr[]={-1,0,+1,0};
                int dc[]={0,-1,0,+1};
                for(int i=0;i<4;i++){
                    int newr=row+dr[i];
                    int newc=col+dc[i];
                    if(isValid(newr,newc,n) && grid[row][col]==1){
                        int nodeno= row*n +col;
                        int adjnodeno=newr*n + newc;
                        ds.unionBySize(nodeno, adjnodeno);

                    }
                }
            }
        }
        int mx=0;
        for (int row = 0; row < n; row++) {
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    continue;
                }
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> component = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            component.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
            
            int sizeTotal = 0;
            for (Integer parents : component) {
                sizeTotal += ds.size.get(parents);
            }
        
            mx = Math.max(mx, sizeTotal + 1);
        }
    }
    for (int cellNo = 0; cellNo < n * n; cellNo++) {
        mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
    }
        return mx;
    
}
    public static void main(String args[]){
        int[][] grid = {
            {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
            {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

     
        int ans = MaxIslands(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }
}
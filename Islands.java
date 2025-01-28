//Problem Statement: Given a grid of size NxM (N is the number of rows and M is the number
//of columns in the grid) consisting of '0's (Water) and ‘1's(Land). 
//Find the number of islands.
import java.util.*;
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Islands{
    public static void bfs(int ro,int co,int vis[][],int grid[][]){
        vis[ro][co]=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(ro,co));
        int n=grid.length;
        int m=grid[0].length;
        while(!q.isEmpty()){
          int row=q.peek().first;
          int col=q.peek().second;
          q.remove();
          for(int delrow = -1; delrow<=1;delrow++) {
            for(int delcol = -1; delcol <= 1; delcol++) {
                int nrow = row + delrow; 
                int ncol = col + delcol; 
        // check if neighbour row and column is valid, and is an unvisited land
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; 
                    q.add(new Pair(nrow, ncol)); 
                }
            }
        
          }
        }
    }
    public static int numIslands(int grid[][]){
   int n=grid.length;
   int m=grid[0].length;
   int vis[][]=new int[n][m];
   int cnt=0;
   for(int row=0;row<n;row++){
    for(int col=0;col<m;col++){
        if(vis[row][col]==0 && grid[row][col]==1){
            cnt++;
            bfs(row,col,vis,grid);
        }
    }
   }
   return cnt;
    }
    public static void main(String args[]){
       int grid[][]={{0,1,1,0},{0,1,1,0},{0,0,1,0},{0,0,0,0},{1,1,0,1}};
       int ans=numIslands(grid);
       System.out.println("number of Islands:"+ ans);
    }
}
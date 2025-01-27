// Problem Statement: Given a binary grid of N*M. Find the distance of the nearest 1 
// in the grid for each cell.
import java.util.*;
class Node{
    int first;
    int second;
    int third;
    public Node(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

class Zeroonematrix{
    public static int[][] Nearestdistance(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Node> q=new LinkedList<>();

        int vis[][]=new int[n][m];

        int dist[][]=new int[n][m];
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;

                }else{
                    vis[i][j]=0;
                }
            }
         }
         int dx[]={-1,0,+1,0};
         int dy[]={0,-1,+1,0};
         
            
         
         while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dist[row][col]=steps;
            for(int i=0;i<4;i++){
                int nrow=row+dx[i];
                int ncol=col+dy[i];
                if(nrow>=0 &&nrow<n && ncol>=0 && ncol<n && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow,ncol,steps+1));
                }
            }
            
         }
         return dist;
        }
    public static void main(String args[]){
     int grid[][]={{1,0,1},{1,1,0},{1,0,0}};
    

     int ans[][]=Nearestdistance(grid);
     for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            System.out.print(ans[i][j]+" ");
        }
        System.out.println();
     }

    }
}
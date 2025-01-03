import java.util.*;
class Node{
    int first;
    int second;
    public Node(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Enclaves{
    public static int NumofEnclaves(int grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Node> q=new LinkedList<>();
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||i==n-1||j==0||j==m-1){
                    if(grid[i][j]==1){
                        q.add(new Node(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int dx[]={-1,0,+1,0};
        int dy[]={0,-1,0,+1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
                q.remove();
                for(int i=0;i<4;i++){
                    int nrow=row+dx[i];
                    int ncol=col+dy[i];
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                        vis[i][j]=1;
                    }
                }

        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String args[]){
    int grid[][]={{0,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,0,0}};
    int ans=NumofEnclaves(grid);
    System.out.println("ans is:"+ ans);
    }
}
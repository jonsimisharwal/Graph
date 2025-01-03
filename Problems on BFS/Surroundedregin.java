

class Surroundedregin{
    public static void dfs(int nrow,int ncol,int[][] vis,char grid[][],int[] dx,int[] dy){
           vis[nrow][ncol]=1;
           int n=grid.length;
           int m=grid[0].length;
           for(int i=0;i<4;i++){
            int row=nrow+dx[i];
            int col=ncol+dy[i];
            if(row>=0 && row<n && col>=0 &&col<m && vis[row][col]==0 && grid[row][col]=='O'){
                dfs(row,col,vis,grid,dx,dy);
            }
           }
    }
        public static char[][] Fill(char grid[][]){
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];

        int dx[]={-1,0,+1,0};
        int dy[]={0,-1,0,+1};
        for(int i=0;i<n;i++){
           
            if(grid[i][0]=='O'&& vis[i][0]==0){
                dfs(i,0,vis,grid,dx,dy);
               }
               if(grid[i][m-1]=='O'&& vis[i][m-1]==0){
                dfs(i,m-1,vis,grid,dx,dy);
               }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]=='O'&& vis[0][j]==0){
                dfs(0,j,vis,grid,dx,dy);
               }
               if(grid[n-1][j]=='O'&& vis[n-1][j]==0){
                dfs(n-1,j,vis,grid,dx,dy);
               }
        }
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(vis[i][j]==0 && grid[i][j]=='O'){
                grid[i][j]='X';
            }
        }
      }
      return grid;

    }
    public static void main(String args[]){
        
      char grid[][]={{'X', 'X', 'X', 'X'}, 
      {'X', 'O', 'X', 'X'}, 
      {'X', 'O', 'O', 'X'}, 
      {'X', 'O', 'X', 'X'}, 
      {'X', 'X', 'O', 'O'}};
     
      char ans[][]=Fill(grid);
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            System.out.print(ans[i][j]+" ");
        }
        System.out.println();
      }
    }
}
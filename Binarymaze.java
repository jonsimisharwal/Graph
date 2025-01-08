import java.util.*;
class tuple{
    int first;
    int second;
    int third;
    public tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Binarymaze{
    public static int Binarymaze(int src[],int dest[],int grid[][]){
        if(src[0] == dest[0] && src[1] == dest[1]){
             return 0; 
           }
        Queue<tuple> q=new LinkedList<>();
     
      
        int n=grid.length;
        int m=grid[0].length;
        int dist[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};
        dist[src[0]][src[1]] = 0; 
        q.add(new tuple(0,src[0],src[1]));
        while(!q.isEmpty()){
            int dis=q.peek().first;
            int r=q.peek().second;
            int c=q.peek().third;
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow<n && nrow>=0 && ncol>=0 && ncol<n && dis+1<dist[nrow][ncol] && grid[nrow][ncol]==1){
                    if (dis + 1 < dist[nrow][ncol]) {
                        dist[nrow][ncol] = dis + 1;
                
                if(nrow == dest[0] && 
                       ncol == dest[1]){ 
                        return dis + 1;
                     }
                q.add(new tuple(1+dis, nrow, ncol)); 
            }
        }
        }
        }
    
  return -1;
    }
public static void main(String args[]){
    int[] source={0,1};
        int[] destination={2,2};
        
        int[][] grid={{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};
        int ans=Binarymaze( source, destination, grid);
        System.out.println(ans);
}
}
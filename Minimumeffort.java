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

class Minimumeffort {
    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        pq.add(new tuple(0,0,0));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        int dr[]={-1,0,+1,0};
        int dc[]={0,+1,0,-1};
        while(!pq.isEmpty()){
            int diff=pq.peek().first;
            int r=pq.peek().second;
            int c=pq.peek().third;
            pq.remove();
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(r==n-1&& c==m-1){
                    return diff;
                }
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int neweffort=Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]),diff);
                    if(neweffort<dist[nrow][ncol]){
                        dist[nrow][ncol]=neweffort;
                           pq.add(new tuple(neweffort,nrow,ncol));
                    }
                   
                }
            }


        }
        return 0;
    }
    public static void main(String args[]){
        int heights[][]={{1,2,2},{3,8,2},{5,3,5}};
        int ans=minimumEffortPath(heights);
        System.out.println("minimum effort path is:"+ ans);
    }
}
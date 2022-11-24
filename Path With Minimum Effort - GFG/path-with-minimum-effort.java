//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Triplet
{
    int first,second,third;
    Triplet(int f,int sec,int thi)
    {
        first=f;
        second=sec;
        third=thi;
    }
}
class Solution {
    
    int MinimumEffort(int heights[][]) {
        int n=heights.length;
        int m=heights[0].length;
        int dis[][]=new int[n][m];
        PriorityQueue<Triplet>pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Triplet(0,0,0));
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dis[i][j]=(int)(1e9);
            }
        }
        dis[0][0]=0;
        int dx[]={-1,0,0,1};
        int dy[]={0,-1,1,0};
        while(!pq.isEmpty())
        {
           Triplet t=pq.poll();
           int diff=t.first;
           int tx=t.second;
           int ty=t.third;
           if(tx==n-1&&ty==m-1)
           return diff;
           for(int i=0;i<4;i++)
           {
               int x=tx+dx[i];
               int y=ty+dy[i];
               if(x>=0&&x<n&&y>=0&&y<m)
               {
                 int newEffort=Math.max(Math.abs(heights[x][y]-heights[tx][ty]),diff);
                 if(newEffort<dis[x][y])
                 {
                     dis[x][y]=newEffort;
                     pq.add(new Triplet(newEffort,x,y));
                 }
               }
           }
        }
        return -1;
    }
}
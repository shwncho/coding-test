import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j]=value;
            }
        }
        //가로,세로,모양의 3차원
        long[][][] dp = new long[N][N][3];

        dp[0][1][0]=1;
        for(int i=0; i<N; i++){
            for(int j=2; j<N; j++){
                //가로이동
                if(map[i][j]!=1){
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                }
                //세로이동
                if(i-1 >= 0 && map[i][j]!=1){
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                }
                //대각선이동
                if(i-1 >= 0 && map[i][j]!=1 && map[i-1][j]!=1 && map[i][j-1]!=1){
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }

        System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000;

        int[][] dp = new int[n+1][10];

        for(int i=1; i<10; i++){
            dp[1][i]=1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                if(j==0)    dp[i][j]=dp[i-1][1]%MOD;
                else if(j==9)    dp[i][j]=dp[i-1][8]%MOD;
                else{
                    dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%MOD;
                }
            }
        }

        long answer=0;
        for(int j=0; j<10; j++){
            answer+=dp[n][j];
        }

        System.out.println(answer%MOD);
    }
}

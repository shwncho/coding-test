import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] route = new int[M];
        long[] sum = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)  route[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<M-1; i++){
            if(route[i] < route[i+1]){
                sum[route[i]]++;
                sum[route[i+1]]--;
            }
            else{
                sum[route[i+1]]++;
                sum[route[i]]--;
            }
        }

        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + sum[i];
        }

        long answer = 0;

        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(sum[i]!=0){
                answer+=Math.min(a*sum[i],b*sum[i]+c);
            }
        }

        System.out.println(answer);
    }
}
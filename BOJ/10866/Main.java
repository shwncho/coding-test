import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb  =new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if(command.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());

                dq.addLast(num);
            }
            else if(command.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());

                dq.addFirst(num);
            }
            else if(command.equals("front")){
                if(!dq.isEmpty()){
                    sb.append(dq.getFirst()).append("\n");
                }
                else    sb.append(-1).append("\n");
            }
            else if(command.equals("back")){
                if(!dq.isEmpty()){
                    sb.append(dq.getLast()).append("\n");
                }
                else sb.append(-1).append("\n");
            }
            else if(command.equals("pop_front")){
                if(!dq.isEmpty()){
                    sb.append(dq.pollFirst()).append("\n");
                }
                else sb.append(-1).append("\n");
            }
            else if(command.equals("pop_back")){
                if(!dq.isEmpty()){
                    sb.append(dq.pollLast()).append("\n");
                }
                else sb.append(-1).append("\n");
            }
            else if(command.equals("size")){
                sb.append(dq.size()).append("\n");
            }
            else if(command.equals("empty")){
                if(dq.isEmpty())    sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}

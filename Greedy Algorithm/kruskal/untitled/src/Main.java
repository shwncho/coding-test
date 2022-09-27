import javax.swing.text.html.CSS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int v1;
    public int v2;
    public int cost;
    Edge(int v1, int v2, int cost){
        this.v1=v1;
        this.v2=v2;
        this.cost=cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost-o.cost;
    }
}
public class Main {
    static int[] unf;
    public static int Find(int v){
        if(v==unf[v])   return  v;
        else return unf[v]=Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb)  unf[fa]=fb;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n+1];
        ArrayList<Edge> list = new ArrayList<>();
        for(int i=1; i<=n; i++) unf[i]=i;
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a,b,c));
        }

        int answer=0;

        Collections.sort(list);
        for(Edge o : list){
            int fv1 = Find(o.v1);
            int fv2 = Find(o.v2);
            if(fv1!=fv2){
                answer+=o.cost;
                Union(o.v1, o.v2);
            }
        }

        System.out.println(answer);
    }
}

package 알고리즘강의.그래프;

import java.util.*;

class Main {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public int bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        ch[v]=1;
        dis[v]=0;
        int L = 1;
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0; i<len; i++){
                int cur = queue.poll();
                for(int nv: graph.get(cur)){
                    if(ch[nv]==0){
                        ch[nv]=1;
                        dis[nv]=L;
                        queue.offer(nv);
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        Main T=new Main();
        Scanner kb=new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        T.bfs(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }
}
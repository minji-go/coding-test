package 알고리즘강의.그래프;

import java.util.*;



class 그래프최단거리 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public int bfs(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int level = 1;
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i=0; i<size; i++){
                Node node = Q.poll();
                for(Node child : node.list){
                    if(child.data==n) return level;
                    else Q.offer(child);
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args){
        그래프최단거리 T=new 그래프최단거리();
        Scanner kb=new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }

        Node[] nodes = new Node[n+1];
        for(int i=1; i<=n; i++){
            if(nodes[i] == null) nodes[i]= new Node(i);
            for(int v : graph.get(i)){
                if(ch[v]!=1) {
                    nodes[v] = new Node(v);
                    nodes[i].list.add(nodes[v]);
                    ch[v]=1;
                }
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(i+" : "+T.bfs(nodes[i]));
        }

    }
    static class Node {
        int data;
        List<Node> list;

        public Node(int val){
            data=val;
            list=new ArrayList<>();
        }
    }
}
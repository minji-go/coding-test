package 문제모음.백준.재귀;

import java.util.*;

public class _11724_연걸요소의개수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[] nodes = new Node[n+1];
        for(int i=1; i<=n; i++){
            nodes[i]=new Node(i);
        }

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            nodes[a].addNeighbors(nodes[b]);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            set.add(nodes[i].getNumber());
        }
        System.out.println(set.size());
    }

    public static class Node {
        private int number;
        private List<Node> neighbors=new ArrayList<>();

        public Node(int number){
            this.number = number;
        }

        public int getNumber(){
            return number;
        }

        public void setNumber(int number){
            this.number = number;
            for(Node neighbor : neighbors) {
                if(this.number>neighbor.getNumber()) setNumber(neighbor.getNumber());
                if(this.number<neighbor.getNumber()) neighbor.setNumber(this.number);
            }
        }

        public List<Node> getNeighbors(){
            return neighbors;
        }

        public void addNeighbors(Node neighbor){
            neighbors.add(neighbor);
            neighbor.getNeighbors().add(this);

            if(this.number>neighbor.getNumber()) setNumber(neighbor.getNumber());
            if(this.number<neighbor.getNumber()) neighbor.setNumber(this.number);
        }

    }
}
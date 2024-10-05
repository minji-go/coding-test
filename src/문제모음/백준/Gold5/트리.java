package 문제모음.백준.Gold5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리 {

    public static class Main {

        private int leafCnt; //CHECK*** 매개변수로 설정하면 안됨!!

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt(); //N: 노드의 개수(<=50)
            int[] nodes = new int[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = sc.nextInt(); //0번 노드부터 N-1번까지의 부모노드 (부모가 없다면 -1)
            }
            int delNode = sc.nextInt(); //지울 노드의 번호

            Main T = new Main();
            System.out.println(T.solution(n, nodes, delNode));

        }

        private int solution(int n, int[] nodes, int delNum) {

            Node[] nodeArr = new Node[n];
            Node rootNode = null;

            for (int i = 0; i < n; i++) {

                if(nodeArr[i] == null){
                    nodeArr[i] = new Node(i);
                }
                int parentNum = nodes[i];

                if (parentNum == -1){
                    rootNode = nodeArr[i];
                    continue;
                }

                if (nodeArr[parentNum] == null) {
                    nodeArr[parentNum] = new Node(parentNum);
                }
                nodeArr[parentNum].addChildNode(nodeArr[i]);
            }

            searchChildNode(rootNode, delNum);

            return leafCnt;
        }

        private boolean searchChildNode(Node node, int delNum) { //CHECK*** 삭제하고난 후에 leaf node가 된다는 사실을 고려해야함!
            if (node.getNum() == delNum) {
                return true;
            }

            if (node.getChildNodes().isEmpty()) {
                leafCnt++;
                return false;
            }

            for (Node n : node.getChildNodes()) {
                if (searchChildNode(n, delNum) && node.getChildNodes().size() == 1) {
                     leafCnt++;
                }
            }
            return false;
        }

        public class Node {
            private Integer num;
            private List<Node> childNodes;

            public Node(Integer num) {
                this.num = num;
                this.childNodes = new ArrayList<>();
            }

            public void addChildNode(Node node) {
                childNodes.add(node);
            }

            public Integer getNum() {
                return num;
            }
            public List<Node> getChildNodes() {
                return childNodes;
            }

        }


    }
}

/*
-> 1 / -1 / 0 : 0
     0*


-> 5 / -1 0 0 1 1 / 2 : 2
      0
    1   2*
   3  4

-> 5 / -1 0 0 1 1 / 1 : 1
     0
    1*  2
   3 4

-> 5 / -1 0 0 1 1 / 0 : 0
    0*
   1  2
  3 4

-> 9 / -1 0 0 2 2 4 4 6 6 / 4 : 2
      0
    1   2
       3  4*
         5 6
           78

*/
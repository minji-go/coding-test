package 문제모음.백준.재귀;

import java.util.*;

public class _2606_바이러스 {
    public static Set<Computer> set = new HashSet<>();

    public void dfs(Computer computer){
        if(set.contains(computer)) return;
        set.add(computer);
        for(Computer next : computer.getLink()) {
            dfs(next);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int computerNum = sc.nextInt();
        int linkNum = sc.nextInt();
        Computer[] computers = new Computer[computerNum+1];
        for(int i=1; i<=computerNum; i++){
            computers[i] = new Computer(i);
        }
        for(int i=0; i<linkNum; i++){
            int one = sc.nextInt();
            int two = sc.nextInt();
            computers[one].linkTo(computers[two]);
        }

        _2606_바이러스 T = new _2606_바이러스();
        T.dfs(computers[1]);
        System.out.println(set.size()-1);
    }

    public static class Computer {
        private int num;
        private List<Computer> link = new ArrayList<>();

        public Computer(int num){
            num=num;
        }

        public int  getNum(){
            return num;
        }

        public List<Computer> getLink(){
            return link;
        }

        public void linkTo(Computer computer){
            link.add(computer);
            computer.getLink().add(this);
        }
    }
}
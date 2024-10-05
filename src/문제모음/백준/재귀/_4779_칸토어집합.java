package 문제모음.백준.재귀;

import java.util.*;

public class _4779_칸토어집합 {
    static String[] answer = new String[13];
    public String dfs(int n){
        if(answer[n]!=null) return answer[n];
        else return answer[n]=dfs(n-1)+dfs(n-1).replace("-", " ")+dfs(n-1);
    }

    public static void main(String[] args){
        _4779_칸토어집합 T = new _4779_칸토어집합();
        answer[0] = "-";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(T.dfs(n));
        }
    }
}

  
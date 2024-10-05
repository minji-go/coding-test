package 알고리즘정답노트.브루트포스;//문제: https://www.acmicpc.net/problem/1476
//설명: E S M (1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)을 우리가 알고 있는 연도로 몇년인지 구하는 문제
//개념: 수학, 브루트포스, 정수론

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1476_브루트포스_정수론 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = e;
        while(!(s % 28 == x % 28 && m % 19 == x % 19)){
            x+= 15;
        }

        System.out.println(x);
    }
}

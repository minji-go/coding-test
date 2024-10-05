
// 문제 링크 : https://www.acmicpc.net/problem/17427
// 문제 설명 : N보다 작거나 같은 모든 자연수 각각 약수의 총합을 더한 값을 구하는 문제
// 핵심 개념 :

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }

    public static long solution(int N) throws Exception {
        long gx = 0;
        for (int i = 1; i <= N; i++) {
           gx+= i*(N/i);
        }
        return gx;
    }

}

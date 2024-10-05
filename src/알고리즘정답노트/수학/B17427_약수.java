package 알고리즘정답노트.수학;

// 문제 링크 : https://www.acmicpc.net/problem/17427
// 문제 설명 : N보다 작거나 같은 모든 자연수 각각 약수의 총합을 더한 값을 구하는 문제
// 핵심 개념 : 수학, 정수론
// https://brightmango.tistory.com/345
// https://brightmango.tistory.com/entry/%EB%B0%B1%EC%A4%80-17427-%EC%95%BD%EC%88%98%EC%9D%98-%ED%95%A92-Java


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B17427_약수 {

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

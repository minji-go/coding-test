package 알고리즘오답노트.다이나믹프로그래밍;

// 문제 링크 : https://www.acmicpc.net/problem/11727
// 문제 설명 : 2*n 직사각형을 1*2, 2*1, 2*2 타일로 채우는 방법의 수를 구하여 10,007로 나눈 나머지를 문제
// 핵심 개념 : 다이나믹 프로그래밍
// 오답 원인: 나머지 계산을 나중에 적용해서 int 범위를 초과함

import java.io.*;

public class B11727_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1000];
        dp[0]=1;
        dp[1]=3;
        for(int i=2; i<n; i++){
            dp[i]=(dp[i-1]+dp[i-2]*2)%10007; // 나머지 연산의 분배법칙
        }
        System.out.println(dp[n-1]);
    }
}
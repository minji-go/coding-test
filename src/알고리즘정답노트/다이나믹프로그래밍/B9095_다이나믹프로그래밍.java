package 알고리즘정답노트.다이나믹프로그래밍;

// 문제 링크 : https://www.acmicpc.net/problem/9095
// 문제 설명 : 정수 n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 문제
// 핵심 개념 : 다이나믹 프로그래밍

import java.io.*;

public class B9095_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4; i<11;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}

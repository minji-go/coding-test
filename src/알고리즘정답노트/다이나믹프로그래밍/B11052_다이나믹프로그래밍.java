package 알고리즘정답노트.다이나믹프로그래밍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문제 링크 : https://www.acmicpc.net/problem/11052
// 문제 설명 : 카드 1개부터 카드 n개가 포함된 된 카드팩이 있을 때, n개의 카드를 구매하기 위해 지불할 최대 금액을 구하는 문제
// 핵심 개념 : 다이나믹 프로그래밍

public class B11052_다이나믹프로그래밍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n+1];
		int[] dp = new int[n+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++){
			p[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=1; i<=n; i++){
			for(int j=1; j<=i; j++){
				dp[i]=Math.max(dp[i], dp[i-j]+p[j]);
			}
		}
		System.out.println(dp[n]);
	}
}
package 알고리즘오답노트.다이나믹프로그래밍;

import java.io.*;

// 문제 링크 : https://www.acmicpc.net/problem/15990
// 문제 설명 : n을 같은 수를 두 번 이상 연속해서 사용하지 않고 1,2,3의 합으로 나타내는 방법의 수를 구하여, 1,000,000,009로 나눈 나머지를 구하는 문제
// 핵심 개념 : 다이나믹 프로그래밍
// 오답 원인 : 테스트 케이스가 많은데, 그때마다 dp를 다시 구해서 시간초과됨

public class B15990_다이나믹프로그래밍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int[] tn = new int[t];
		int max = 0;
		for(int i=0; i<t; i++){
			tn[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, tn[i]);
		}

		long[][] dp = new long[Math.max(max+1,4)][4];
		dp[1] = new long[]{1, 1, 0, 0};
		dp[2] = new long[]{1, 0, 1, 0};
		dp[3] = new long[]{3, 1, 1, 1};
		for(int i=4; i<=max; i++){
			dp[i][1]=(dp[i-1][0]-dp[i-1][1])%1_000_000_009;
			dp[i][2]=(dp[i-2][0]-dp[i-2][2])%1_000_000_009;
			dp[i][3]=(dp[i-3][0]-dp[i-3][3])%1_000_000_009;
			dp[i][0]=(dp[i][1]+dp[i][2]+dp[i][3]);
		}

		for (int i = 0; i < t; i++) {
			System.out.println(dp[i][0] % 1_000_000_009);
		}
	}

}
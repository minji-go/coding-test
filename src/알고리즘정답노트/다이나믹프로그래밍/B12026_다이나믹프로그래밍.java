package 알고리즘정답노트.다이나믹프로그래밍;//문제: https://www.acmicpc.net/problem/12026
//설명: B,O,J 블록으로 순서대로 이동할 때 N번째 블록까지 가는데 필요한 에너지의 최솟값을 구하는 문제
//개념: 다이나믹 프로그래밍


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B12026_다이나믹프로그래밍 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for (int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(((s.charAt(i)=='B' && s.charAt(j) == 'J')
                        ||(s.charAt(i)=='O' && s.charAt(j) == 'B')
                        ||(s.charAt(i)=='J' && s.charAt(j) == 'O'))
                    && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
                }
            }
        }

        System.out.println(dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1]);
    }
}

package 알고리즘정답노트.다이나믹프로그래밍;

// 문제 링크 : https://www.acmicpc.net/problem/2193
// 문제 설명 : N자리 이친수(1로 시작하고, 11을 부분 문자열로 갖지 않는 수)의 개수를 구하는 문제
// 핵심 개념 : 다이나믹 프로그래밍

import java.io.*;

public class B2193_다이나믹프로그래밍 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] answer = new long[n + 1];
        answer[0] = 0;
        answer[1] = 1;
        for(int i=2; i<=n; i++){
            answer[i] = answer[i - 2] + answer[i - 1];
        }
        bw.write(String.valueOf(answer[n]));
        bw.close();
    }
}


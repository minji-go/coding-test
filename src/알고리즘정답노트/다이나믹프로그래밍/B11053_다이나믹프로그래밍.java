package 알고리즘정답노트.다이나믹프로그래밍;

// 문제 링크 : https://www.acmicpc.net/problem/11053
// 문제 설명 : 주어진 수열의 가장 긴 증가하는 부분 수열의 길이를 구하는 문제
// 핵심 개념 : 다이나믹 프로그래밍

import java.util.*;
import java.io.*;

public class B11053_다이나믹프로그래밍 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bw.write(String.valueOf(solution(n, arr)));
        bw.close();
    }

    public static int solution(int n, int[] arr) {
        int[] cnt = new int[n];
        cnt[n-1] = 1;
        int answer = 1;
        for(int i=n-2; i>=0; i--){
            int max = 0;
            for(int j=i+1; j<n; j++){
                if(arr[i]<arr[j]) max = Math.max(max, cnt[j]);
            }
            cnt[i] = max+1;
            answer = Math.max(answer, cnt[i]);
        }
        return answer;
    }
}

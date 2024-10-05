package 알고리즘정답노트.수학;
// 문제 링크: https://www.acmicpc.net/problem/1978
// 문제 설명: 주어진 수 N개 중에서 소수의 개수를 구하는 문제
// 핵심 개념: 수학, 정수론, 소수 판정 (1.N까지 나눗셈, 2.N의 제곱근까지 나눗셈, 3.에라토스테네스의 체)

import java.io.*;
import java.util.*;

public class B1978_소수판정 {
    private static boolean[] multiple;

    public static void main(String[] args) throws Exception {
        fillMultiple(1000);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(!multiple[x]) answer++;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    private static void fillMultiple(int m) {
        multiple = new boolean[m+1];
        multiple[0] = multiple[1] = true;
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if(!multiple[i]) {
                for(int j=i*i; j<=m; j+=i){
                    multiple[j] = true;
                }
            }
        }
    }
}

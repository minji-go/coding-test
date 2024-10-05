package 알고리즘오답노트.수학;
// 문제 링크 : https://www.acmicpc.net/problem/1929
// 문제 설명 : N 이상 M 이하의 소수를 모두 구하는 문제
// 핵심 개념 : 수학, 정수론, 소수 판정, 에라토스테네스의 체
// 오답 이유 : 에라토스테네스의 체 개념 이해 제대로 못함
/*
    에라토스테네스의 체
    - 특정 정수 이하의 모든 소수를 찾기 위해서 소수인 반대인 합성수를 제거하는 접근
    - i(=j*j)의 소수는 2부터 j까지의 배수를 모두 제거하면 구할 수 있음
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1929_수학_에라토스테네스의체 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] multiple = solution(n);
        for (int i = m; i <= n; i++) {
            if (!multiple[i]) bw.write(i+"\n");
        }
        bw.close();
    }

    public static boolean[] solution(int n) throws Exception {
        boolean[] multiple = new boolean[n + 1];
        multiple[0] = multiple[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!multiple[i]) {
                for (int j = i * i; j <= n; j += i) {
                    multiple[j] = true;
                }
            }
        }
        return multiple;
    }
}

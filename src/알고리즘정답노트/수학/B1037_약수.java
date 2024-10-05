package 알고리즘정답노트.수학;

// 문제 링크 : https://www.acmicpc.net/problem/1037
// 문제 설명 : N의 약수의 개수와 약수가 주어질 때, N을 구하는 문제
// 핵심 개념 : 수학 정수론
/*
    short= 부호있는 16비트 정수
    int  = 부호있는 32비트 정수
    long = 부호있는 64비트 정수
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1037_약수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] num = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<cnt; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(cnt, num));
    }

    public static int solution(int cnt, int[] num) throws Exception {
        Arrays.sort(num);
        return num[0] * num[cnt - 1];
    }
}

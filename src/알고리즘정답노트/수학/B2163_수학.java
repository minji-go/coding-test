package 알고리즘정답노트.수학;

//문제: https://www.acmicpc.net/problem/2163
//설명: N*M 크기의 초콜릿을 1*1 크기의 초콜릿으로 쪼개기 위한 최소 횟수를 구하는 문제
//개념: 수학, 사칙연산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2163_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println((n-1) + n*(m-1));
    }
}
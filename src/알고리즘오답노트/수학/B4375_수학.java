package 알고리즘오답노트.수학;

// 문제 링크 : https://www.acmicpc.net/problem/4375
// 문제 설명 : 각 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 자리수를 구하는 문제
// 핵심 개념 : 수학, 브루트포스, 정수론
// 오답 이유 : 1) 문제 이해를 못함. 2) 1로만 이루이진 수를 만들다보니 overflow 발생

import java.io.*;

public class B4375_수학 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            System.out.println(solution(n));
        }
    }

    public static int solution(int n) throws Exception {
        int num = 0;
        for (int i=1;; i++) {
            num = (num*10+1)%n;
            if (num == 0) return i;
        }
    }
}

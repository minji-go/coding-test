package 알고리즘정답노트.수학;

// 문제 링크 : https://www.acmicpc.net/problem/10430
// 문제 설명 : 나머지의 분배법칙 증명
// 핵심 개념 : 수학, 구현, 사칙연산

/*  (A + B) % N = ((A % N) + (B % N)) % N  증명

    A = q1 X N + r1
    B = q2 X N + r2

    (A + B) % N
    = (q1 X N + r1 + q2 X N + r2) % N
    = ((q1+q2) X N + r1 + r2) % N
    = (r1 + r2) % N
*/

import java.util.*;
import java.io.*;

public class B10430_분배법칙 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int x : solution(A, B, C)) {
            System.out.println(x);
        }
    }

    public static int[] solution(int A, int B, int C) throws Exception {
        int[] answer = new int[4];
        answer[0] = (A+B)%C;
        answer[1] = ((A%C)+(B%C))%C;
        answer[2] = (A*B)%C;
        answer[3] = ((A%C)*(B%C))%C;
        return answer;
    }
}

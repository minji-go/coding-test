package 알고리즘강의.배열;

import java.util.*;

public class 멘토링 {
    public static void main(String[] args) {
/*
    1. A학생이 B학생의 멘토라면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
    2. M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지
*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        멘토링 T = new 멘토링();
        System.out.println(T.answer(n, m, arr));
    }

    public int answer(int n, int m, int[][] arr) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt = 0;
                for (int k = 0; k < m; k++) {
                    int pi=0, pj=0;
                    for (int s = 0; s < n; s++) {
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    if (pi < pj) cnt++;
                }
                if (cnt == m) answer++;
            }
        }

        return answer;
    }
}

package 알고리즘강의.배열;

import java.util.Arrays;
import java.util.Scanner;

public class 등수구하기 {
    public static void main(String[] args) {
/*
    1. N명의 국어점수를 입력된 순서대로 등수로 출력
    2. 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        등수구하기 T = new 등수구하기();
        for (int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private int[] answer(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if(arr[i] < arr[j]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }

    private int[] solution(int n, int[] score) {

        int[] scoreCopy = new int[n];
        for (int i = 0; i < n; i++) {
            scoreCopy[i] = score[i];
        }
        Arrays.sort(scoreCopy);

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                if (score[i] == scoreCopy[j]) {
                    answer[i] = n-j;
                    break;
                }
            }
        }

        return answer;
    }
}

package 알고리즘강의;

import java.util.HashMap;
import java.util.Scanner;

public class 매출액의종류 {
    public static void main(String[] args) {
/*
    1. N일간의 매출기록, 연속구간의 길이 K
    2. 매출액의 종류를 출력
    7 4
    20 12 20 10/ 23 17 10
*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        매출액의종류 T = new 매출액의종류();
        int[] answer = T.solution(n, k, arr);
        for (int x : answer) {
            System.out.print(x + " ");
        }

    }

    private int[] solution(int n, int k, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int[] answer = new int[n-k+1];
        answer[0] = map.size();

        for (int i = k; i < n; i++) {
            if (map.getOrDefault(arr[i-k], 0) > 1) {
                map.put(arr[i-k], map.get(arr[i-k]) - 1);
            } else if (map.getOrDefault(arr[i-k], 0) == 1) {
                map.remove(arr[i-k]);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            answer[i-k+1] = map.size();
        }
        return answer;
    }


}

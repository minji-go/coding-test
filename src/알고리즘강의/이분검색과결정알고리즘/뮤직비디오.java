package 알고리즘강의.이분검색과결정알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 뮤직비디오 {

    public static void main(String[] args) {
/*
    1. N : 곡의 개수, M : DVD의 개수
    2. 순서대로 녹화
    3. 최소 용량 크기
*/
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        뮤직비디오 T = new 뮤직비디오();
        System.out.println(T.solution(n, m, arr));
    }

    public int answer(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    private int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) {
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }

    private int solution(int n, int m, int[] arr) {
        int totalMin = Arrays.stream(arr).sum();
        int dvdMin = (int) Math.ceil(totalMin / m);
        while (!isAnswer(m, arr, dvdMin)) {
            dvdMin++;
        }
        return dvdMin;

    }

    private boolean isAnswer(int dvdNum, int[] songMin, int answer) {
        int tmp = 0;
        int num = 0;
        for (int m : songMin) {
            tmp += m;
            if (tmp > answer) {
                num++;
                tmp = m;
            }
        }

        if(num >= dvdNum) return false;
        else return true;
    }
}

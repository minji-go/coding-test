package 알고리즘강의.그리디알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 결혼식 {
    public static void main(String[] args) {
/*
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] duration = new String[num];
        for (int i = 0; i < num; i++) {
            duration[i] = sc.nextLine();
        }

        결혼식 T = new 결혼식();
        System.out.println(T.solution(num, duration));
*/

        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        List<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sT = kb.nextInt();
            int eT = kb.nextInt();
            list.add(new Time(sT, 's'));
            list.add(new Time(eT, 'e'));
        }
        
        결혼식 T = new 결혼식();
        System.out.println(T.answer(list));

    }

    private int answer(List<Time> list) {
        int answer = Integer.MIN_VALUE;
        Collections.sort(list);
        int cnt = 0;
        for (Time ob : list) {
            if(ob.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }


    private int solution(int num, String[] duration) {
        int[] time = new int[73];

        for (String d : duration) {
            int start = Integer.parseInt(d.split(" ")[0]);
            int end = Integer.parseInt(d.split(" ")[1]);
            time[start]++;
            time[end]--;
        }

        int maxTime = time[0];
        for (int i=1; i<time.length; i++) {
            time[i] = time[i-1] + time[i];
            if (time[i] > maxTime) {
                maxTime = time[i];
            }
        }

        return maxTime;
    }

    static class Time implements Comparable<Time>{
        public int time;
        public char state;

        Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time ob) {
            if(this.time == ob.time) return this.state - ob.state;
            else return this.time - ob.time;
        }
    }
}

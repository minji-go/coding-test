package 알고리즘강의.그리디알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 씨름선수 {
    public static void main(String[] args) {
/*
    능력치가 둘다 높은 지원자가 있으면 탈락, 그렇지 않으면 선발
*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Body> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Body(h, w));
        }

        씨름선수 T = new 씨름선수();
        System.out.println(T.solution(list, n));
    }

    public int answer(List<Body> list, int n) {
        int cnt = 0;
        Collections.sort(list);
        int max = Integer.MIN_VALUE;
        for (Body ob : list) {
            if (ob.weight > max) {
                max = ob.weight;
                cnt++;
            }
        }
        return cnt;
    }

    private int solution(List<Body> list, int n) {

        list.sort((o1, o2) -> (int) (o1.height-o2.height));

        int num = 1;
        while (true) {
            int i = list.size() - num;
            if(i <= 0) break;
            long weight = list.get(i).weight;
            for (int j = list.size()-num-1; j>=0; j--) {
                if (weight > list.get(j).weight) {
                    list.remove(j);
                }
            }
            num++;
        }

        return list.size();

    }

    static class Body implements Comparable<Body> {
        public int height, weight;

        public Body(int h, int w) {
            this.height = h;
            this.weight = w;
        }

        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }

}


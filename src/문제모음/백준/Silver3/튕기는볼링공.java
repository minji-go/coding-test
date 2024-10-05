package 문제모음.백준.Silver3;

import java.util.Scanner;

public class 튕기는볼링공 {
public static class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double[][] arrs = new double[(int)n][2];
        for (int i = 0; i < n; i++) {
            arrs[i][0] = sc.nextDouble();
            arrs[i][1] = sc.nextDouble();
        }

        Main T = new Main();
        String[] answer = T.solution(n, arrs);
        for (String s : answer) {
            System.out.println(s);
        }
    }

    private String[] solution(double n, double[][] arrs) {
        String[] answer = new String[(int) n];
        double width = 105;
        double ballRadius = 10;
        double pinRadius = 6;

        for(int i=0; i<n; i++){
            double[] arr = arrs[(int)i];
            double t = arr[0] * 100;
            double x = arr[1];
            double distance = 0;

            while (distance + ballRadius + pinRadius <= t) {
                distance += 2* (width/2-10)/Math.tan(Math.toRadians(x));
            }

            if ((distance + ballRadius + pinRadius > t)) {
                answer[i] = "yes";
            } else {
                answer[i] = "no";
            }
        }

        return answer;
    }

}
}

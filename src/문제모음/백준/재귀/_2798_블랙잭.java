package 문제모음.백준.재귀;

import java.util.Arrays;
import java.util.Scanner;

public class _2798_블랙잭 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] card = new int[n];
        for(int i=0; i<n; i++){
            card[i] = sc.nextInt();
        }
        Arrays.sort(card);

        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++){
                for(int k=j+1; k<n; k++){
                    int sum = card[i]+card[j]+card[k];
                    if(sum>m) break;
                    max = Math.max(max, sum);
                }
            }
        }
        System.out.println(max);
    }
}

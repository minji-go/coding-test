package 문제모음.백준.재귀;

import java.util.*;

public class _18312_시각 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String k = sc.next();

        int total = (n+1)*60*60;

        int hour=0, time=0;
        for(int i=0; i<n+1; i++){
            if(!String.format("%02d", i).contains(k)) hour++;
        }
        for(int i=0; i<60; i++){
            if(!String.format("%02d", i).contains(k)) time++;
        }

        System.out.println(total-hour*time*time);
    }
}
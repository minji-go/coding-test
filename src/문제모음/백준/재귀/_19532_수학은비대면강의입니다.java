package 문제모음.백준.재귀;

import java.util.*;

public class _19532_수학은비대면강의입니다 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int x=0, y=0;
        if(a==0) y=c/b;
        if(b==0) x=c/a;
        if(d==0) y=f/e;
        if(e==0) x=f/d;

        if(x==0 && y==0){
            x=(e*c-b*f)/(e*a-b*d);
            y=(c-a*x)/b;
        } else if(x==0 && a!=0){
            x=c-b*y/a;
        } else if(x==0 && d!=0){
            x=f-e*y/d;
        } else if(y==0 && b!=0){
            y=c-a*x/b;
        } else if(y==0 && e!=0){
            y=f-d*x/e;
        }

        System.out.println(x+" "+y);
    }
}
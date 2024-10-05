package 문제모음.백준.재귀;

import java.util.*;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n%5==0) System.out.print(n/5);
        else {
            int count = n/5;
            while(count>1){
                int sugar=n-count*5;
                if(sugar%3==0) {
                    count+=sugar/3;
                    System.out.print(count);
                    break;
                }
                count--;
            }
            if(count==0) System.out.print(-1);
        }
    }
}
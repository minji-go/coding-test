package 문제모음.백준.재귀;

import java.util.*;

public class _25501_재귀의귀재 {
    public void recursion(char[] s, int l, int r){
        if(l >= r) System.out.println("1 " + (l+1));
        else if(s[l] != s[r]) System.out.println("0 " + (l+1));
        else recursion(s, l+1, r-1);
    }

    public static void main(String[] args) {
        _25501_재귀의귀재 T = new _25501_재귀의귀재();
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        for(int i=0; i<t; i++){
            String s = sc.next();
            T.recursion(s.toCharArray(), 0, s.length()-1);
        }
    }
}
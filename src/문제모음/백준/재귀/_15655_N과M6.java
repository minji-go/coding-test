package 문제모음.백준.재귀;

import java.util.*;

public class _15655_N과M6 {
    public static int n, m;
    public static int[] nums;
    public static Set<Integer> set = new TreeSet<>();

    public void dfs(int idx){
        if(set.size()==m){
            for(int x : set){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }
        if(idx==n) return;

        set.add(nums[idx]);
        dfs(idx+1);
        set.remove(nums[idx]);
        dfs(idx+1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        _15655_N과M6 T = new _15655_N과M6();
        T.dfs(0);
    }
}
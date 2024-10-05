package 문제모음.백준.재귀;

import java.util.*;

public class _13023_ABCDE {
    static int n, m;
    static Map<Integer, List<Integer>> friends;
    static Set<Integer> set = new HashSet<>();

    public boolean dfs(int i, int count){
        if(count == 5 && set.size() == 5) return true;
        else if(count == 5) return false;

        List<Integer> friendOfI = friends.get(i);
        if(friendOfI == null) return false;

        for(Integer friend : friendOfI){
            if(set.contains(friend)) continue;
            set.add(friend);
            if(dfs(friend, count+1)) return true;
            set.remove(friend);
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        friends = new HashMap<>();
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            List<Integer> friendOfA = friends.getOrDefault(a, new ArrayList<>());
            List<Integer> friendOfB = friends.getOrDefault(b, new ArrayList<>());
            friendOfA.add(b);
            friendOfB.add(a);
            friends.put(a, friendOfA);
            friends.put(b, friendOfB);
        }

        _13023_ABCDE T = new _13023_ABCDE();
        int answer = 0;
        for(int i=0; i<n; i++){
            set.add(i);
            if(T.dfs(i, 1)){
                answer = 1;
                break;
            }
            set.remove(i);
        }
        System.out.println(answer);

    }
}
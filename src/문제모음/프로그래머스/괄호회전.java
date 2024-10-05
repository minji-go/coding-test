package 문제모음.프로그래머스;

import java.util.*;

class 괄호회전 {


    private static Queue<Character> queue;
    private static Stack<Character> stack;

    public static int solution(String s) {

        int answer = 0;

        queue = new LinkedList<Character>();
        stack = new Stack<Character>();

        //1. 괄호를 하나씩 큐에 삽입
        for(int i=0; i<s.length(); i++){
            queue.offer(s.charAt(i));
        }

        //2. 큐 회전 * s.length()-1 회
        for(int i=0; i<s.length(); i++){

            if(check()) answer++;

            queue.offer(queue.poll());
        }

        return answer;
    }

    public static boolean check(){

        boolean stop = false;

        int j=0;

        for(; j<queue.size(); j++){

            char paren = queue.poll();

            if(paren == '[' || paren == '(' || paren == '{') {
                stack.push(paren);

            } else if (stack.isEmpty()) {
                stop = true;

            } else {
                char paren2 = stack.pop();

                if(!(paren2 == '[' && paren == ']')
                        && !(paren2 == '(' && paren == ')')
                        && !(paren2 == '{' && paren == '}')){
                    stop = true;
                }
            }

            queue.offer(paren);

            if(stop) break;
        }

        for(j= j+1; j<queue.size(); j++){
            queue.offer(queue.poll());
        }

        if(!stack.isEmpty() || stop == true) return false;

        return true;
    }
}
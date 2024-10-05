package 알고리즘정답노트.시뮬레이션;
//문제: https://school.programmers.co.kr/learn/courses/30/lessons/67257
//설명: 숫자들과 3가지 연산문자로 이뤄진 연산 수식이 주어질 때, 연산자의 우선순위를 새로 지정해서 절대값이 가장 큰 결과를 구하는 문제
//개념: 구현

import java.util.Stack;

class P67257_구현_DFS {
    public long solution(String expression) {

        String[][] ops = {
                {"*","+","-"},
                {"*","-","+"},
                {"+","*","-"},
                {"+","-","*"},
                {"-","*","+"},
                {"-","+","*"}};

        long answer = 0;
        for(int i=0; i<6; i++){
            Stack<String> stack1 = getStack(expression);
            Stack<String> stack2 = new Stack<>();
            for(int j=0; j<3; j++) {
                while(!stack1.isEmpty()){
                    stack2.add(stack1.pop());
                }
                while (!stack2.isEmpty()) {
                    String s = stack2.pop();
                    if (s.equals(ops[i][j])) {
                        long left = Long.parseLong(stack1.pop());
                        long right = Long.parseLong(stack2.pop());
                        switch (s) {
                            case "*":
                                s = String.valueOf(left * right);
                                break;
                            case "+":
                                s = String.valueOf(left + right);
                                break;
                            case "-":
                                s = String.valueOf(left - right);
                                break;
                        }
                    }
                    stack1.add(s);
                }
            }
            answer=Math.max(Math.abs(Long.parseLong(stack1.pop())), answer);
        }
        return answer;
    }

    private static Stack<String> getStack(String expression) {
        Stack<String> stack = new Stack<>();
        for(int lt = 0, rt = 0; rt< expression.length(); rt++){
            char c = expression.charAt(rt);
            if(c=='-' || c=='+' || c=='*'){
                stack.add(expression.substring(lt, rt));
                stack.add(expression.substring(rt, rt+1));
                lt=rt+1;
            } else if(rt== expression.length()-1){
                stack.add(expression.substring(lt, rt+1));
            }
        }
        return stack;
    }
}
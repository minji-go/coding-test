package 문제모음.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    public static int solution(int[] queue1, int[] queue2) {

        Queue<Integer> queue1Copy = new LinkedList<>();
        Queue<Integer> queue2Copy = new LinkedList<>();

        //1. queue1, queue2를 큐에 옮겨 담으면서, 두 큐의 총합/2 값을 구한다.
        long queue1Sum = 0;
        long queue2Sum = 0;

        for (int num : queue1) {
            queue1Sum += num;
            queue1Copy.offer(num);
        }
        for (int num : queue2) {
            queue2Sum += num;
            queue2Copy.offer(num);
        }

        final long halfSum = (queue1Sum + queue2Sum) / 2;


        //2. queue1의 합을 구하여 halfSum보다 크면 poll, 작으면 queue2에서 poll
        //3. queue1의 합이 halfSum이 될때까지 반복하되, queue1과 queue2가 모두 한번씩 비면 중단하고 -1을 반환한다.
        int result = 0;
        int resultLimit = (queue1.length + queue2.length) * 2;

        while (result < resultLimit) {

            if (queue1Sum > halfSum) {
                int num = queue1Copy.poll();
                queue1Sum = queue1Sum - num;
                queue2Copy.offer(num);
            } else if (queue1Sum < halfSum) {
                int num = queue2Copy.poll();
                queue1Sum = queue1Sum + num;
                queue1Copy.offer(num);
            } else {
                break;
            }

            result++;
        }

        if (result == resultLimit) result = -1;

        return result;
    }

    public static void main(String[] args) {
        int[] queue1 = {1,1,1,1,1,1,1,1,1,10};
        int[] queue2 = {1,1,1,1,1,1,1,1,1,1};

        System.out.println(solution(queue1, queue2));
    }
}

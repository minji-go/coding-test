package 알고리즘강의.동적계획법;

public class 계단오르기 {

    public static void main(String[] args) {
/*
        1. 한계단 또는 두 계단씩 올라간다.
        2. N계단일 때 올라갈 수 있는 방법의 수
*/

/*
        B9663_백트래킹 T = new B9663_백트래킹();
      	Scanner sc = new Scanner(System.in);
        int floor = sc.nextInt();
        dy = new int[n+1];
   		System.out.println(T.solution(floor));
*/
        계단오르기 T = new 계단오르기();

        int floor = 7;
        dy = new int[floor + 1];
        System.out.println(T.solution(floor)==21);
        floor = 3;
        dy = new int[floor + 1];
        System.out.println(T.solution(floor)==3);
        floor = 33;
        dy = new int[floor + 1];
        System.out.println(T.solution(floor)==5702887);

    }

    static int[] dy;
    private int answer(int n) {

        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }

    private int solution(int floor) {

/*
        1 : 1C0
        2 : 2C0 + 1C1
        3 : 3C0 + 2C1
        4 : 4C0 + 3C1 + 2C2
        5 : 5C0 + 4C1 + 3C2
        6 : 6C0 + 5C1 + 4C2 + 3C3
        7 : 7C0 + 6C1 + 5C2 + 4C3
        8 : 8C0 + 7C1 + 6C2 + 5C3 + 4C4
        33 : 33C0 + 32C1 + ... 18C15 + 17C16
*/
        int answer = 1;
        int left = floor;
        int right = 0;
        for (int i = 0; i < floor / 2; i++) {
            left--;
            right++;

            long parent = 1;
            long child = 1;
            for (int j = 0; j < right; j++) {
                parent *= left - j;
                child *= right - j;
            }
            answer += (parent/child);
        }

        return answer;
    }
}

package 문제모음.프로그래머스;

/* POINT >> 자료형 long */
public class 멀쩡한사각형 {

    public static long solution(int w, int h) {
        // 가장 작은 사각형의 w + h - 1) * n

        long shortLength;
        long longLength;
        long answer = ((long)w * h) - (w + h - 1);

        if (w > h) {
            longLength = w;
            shortLength = h;
        } else {
            longLength = h;
            shortLength = w;
        }

        for (long i = shortLength; i > 1; i--) {
            if (shortLength % i == 0 && longLength % i == 0) {
                answer = ((long)w * h) - (shortLength/i + longLength/i - 1) * i;
                break;
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        solution(100000000, 999999999);
    }
}

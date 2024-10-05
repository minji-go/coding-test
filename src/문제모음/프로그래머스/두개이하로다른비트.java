package 문제모음.프로그래머스;

public class 두개이하로다른비트 {

    public static long[] solution(long[] numbers) {

        long[] answer = new long[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            long number = numbers[i];
            String bit = Long.toBinaryString(number);   //changeToBit(number);
            String bitCopy = Long.toBinaryString(number);

            for (int j = bitCopy.length() - 1; j >= 0; j--) {
                if (bitCopy.charAt(j) == '0' && j == bitCopy.length()-1) {
                    bitCopy = bitCopy.substring(0, j) + "1";
                    break;
                } else if (bitCopy.charAt(j) == '0') {
                    bitCopy = bitCopy.substring(0, j) + "10" + bitCopy.substring(j + 2);
                    break;
                }
                if (j == 0) {
                    bitCopy = "10" + bitCopy.substring(1);
                }
            }

            answer[i] = Long.parseLong(bitCopy, 2);
        }

        return answer;
    }
}
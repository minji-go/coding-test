package 알고리즘강의.문자열;

public class 유효한팰린드롬 {

    public static void main(String[] args) {
/*
        1. 문자열이 팰린드롬이면 "YES", 아니면 "NO"
        2. 알파벳 대소문자 구분안함, 알파벳 이외 문자는 무시
*/

/*
        펠린드롬 palindrome = new 펠린드롬();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(palindrome.solution(str));
*/
        String input1 = "found7, time: study; Yduts; emit, 7Dnuof";
        System.out.println(solution(input1).equals("YES"));
        String input2 = "sOil, Xlios;";
        System.out.println(solution(input2).equals("YES"));
        String input3 = "killing machine esenihcam gnillik";
        System.out.println(solution(input3).equals("NO"));
    }

    private static String answer(String s) {
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";
        return answer;
    }

    private static String solution(String input) {

        //1. 문자열을 영어만남기고, 영어대문자로 변환
        String inputUpperCase = input.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<inputUpperCase.length(); i++) {
            char character = inputUpperCase.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                sb.append(inputUpperCase.substring(i, i + 1));
            }
        }

        //2. 맨앞과 맨끝부터 짝지어 비교
        String inputAlphabet = sb.toString();
        int length = inputAlphabet.length();
        for (int i = 0; i < length / 2; i++) {
            if (!inputAlphabet.substring(i, i + 1).equals(inputAlphabet.substring(length - 1 - i, length - i))) {
                return "NO";
            }
        }

        return "YES";
    }


}

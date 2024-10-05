package 알고리즘강의.문자열;

public class 암호 {

    public static void main(String[] args) {
/*
        1. 숫자 입력
        2. 문자를 7개씩 쪼개어 변환 (# = 1, * = 0)
        3. 십진수로 변환 후 아스키 코드로 변환
*/

/*
        B9663_백트래킹 T = new B9663_백트래킹();
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(T.solution(num, str));
*/

        암호 T = new 암호();
        System.out.println(T.solution(4, "#****###**#####**#####**##**").equals("COOL"));
        System.out.println(T.solution(2, "#**##**#***#*#").equals("LE"));
    }

    public String answer(int n, String s) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            int num = Integer.parseInt(tmp, 2);
            answer += (char)num;
            s = s.substring(7);
        }
        return answer;
    }

    public String solution(int num, String str) {

        str = str.replace("#", "1").replace("*", "0");
        String answer = "";
        for (int i = 1; i <=num*7; i=i+7) {
            char c = (char) Integer.parseInt(str.substring(i-1, i+6), 2);
            answer += c;
        }

        return answer;
    }
}
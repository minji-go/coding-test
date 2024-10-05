package 문제모음.프로그래머스;

import java.util.HashMap;

public class 다단계칫솔판매 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {


        HashMap<String, Person> company = new HashMap<>();

        //1. enroll 객체 생성
        for (String name : enroll) {
            company.put(name, new Person(name));
        }

        //2. enroll과 referral 관계정의하기
        for (int i=0; i<referral.length; i++) {

            if (!referral[i].equals("-")) continue;

            Person enrollPerson =  company.get(enroll[i]);
            Person referralPerson = company.get(referral[i]);

            enrollPerson.setReferral(referralPerson);
        }


        //3. seller과 amount 탐색하며 계산하기
        for (int i = 0; i <seller.length; i++) {

            Person sellerPerson = company.get(seller[i]);
            int money = amount[i] * 100;

            sellerPerson.setTotalMoney(money);
        }


        //4. enroll 순서대로 totalMoney 꺼내서 result 만들기
        int[] answer = new int[enroll.length];

        for (int i=0; i<enroll.length; i++) {
            answer[i] = company.get(enroll[i]).getTotalMoney();
        }

        return answer;
    }

    static class Person {

        private String name;
        private Person referral;
        private int totalMoney;

        Person(String name) {
            this.name = name;
        }

        private void setReferral(Person referral) {
            this.referral = referral;
        }

        private void setTotalMoney(int money){

            if(referral != null)
                referral.setTotalMoney((int) (0.1 * money));

            this.totalMoney += Math.ceil(0.9 * money);
        }

        private int getTotalMoney(){
            return totalMoney;
        }

    }

    public static void main(String[] args) {

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        int[] result = solution(enroll, referral, seller, amount);

        for(int money : result) System.out.println(money);
    }
}


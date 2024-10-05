package 문제모음.프로그래머스;

import java.util.HashMap;

public class 스킬트리 {

    public static int solution(String skill, String[] skill_trees) {

        HashMap<Character, Boolean> map = new HashMap<>();

        //skill : CBD
        //skillIndex = 1;

        //1. 선행조건이 있는 skill을 map에 저장
        for (int i=0; i<skill.length(); i++) {
            map.put(skill.charAt(i), true);
        }


        //2. skillIndex는 선행조건이 있는 skill 중 어떤 걸 배울 차례인지를 나타낸다.
        //3. skillTree에서 선행조건이 있는 skill이 나오면, skillIndex와 비교하여 배울 수 있다면 skillIndes++;
        int answer = 0;
        int skillIndex = 0;

        for (String skillTree : skill_trees) {

            for (int i = 0; i < skillTree.length(); i++) {

                char thisSkill = skillTree.charAt(i);

                if(map.get(thisSkill) != null) {
                    if(thisSkill != skill.charAt(skillIndex)) break;
                    skillIndex++;
                }

                if(i == skillTree.length()-1) answer++;
            }

            skillIndex = 0;
        }

        return answer;
    }

    public static void main(String[] args) {

        String skill = "CBD";
        String[] skiil_tree = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(solution(skill, skiil_tree));

    }
}


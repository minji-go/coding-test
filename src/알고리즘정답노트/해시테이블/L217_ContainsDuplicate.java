package 알고리즘정답노트.해시테이블;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 문제 링크: https://leetcode.com/problems/contains-duplicate/
 * 문제 설명: 배열에 중복된 값이 있으면 true, 모두 다르면 false 반환
 * 핵심 개념: Set은 중복을 허용하지 않음, set.add()가 false면 중복 존재
 * 시간 복잡도: O(n) – 배열 한 번 순회
 * 공간 복잡도: O(n) – Set에 최대 n개 저장
 */
class L217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return !Arrays.stream(nums).allMatch(set::add);
    }
}

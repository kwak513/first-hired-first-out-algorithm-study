import java.util.*;

/*
    ex) [3번, 1번, 2번, 3번] => 3번: 2개, 1번: 1개, 2번: 1개
        - 2개 골라라: 종류 2개
        ------------------------ 포켓몬 종류 ? 고를 개수
        - 3개 골라라: 종류 3개
        - 4개 골라라: 종류 3개
        - 5개 골라라: 종류 3개

*/
class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int num: nums){
            hashSet.add(num);
        }
        
        // 고를 포켓몬 개수
        int numToPick = nums.length / 2;
        
        if(numToPick >= hashSet.size()){
            return hashSet.size();
        }
        
        return numToPick;
        
    }
}

/*
    - HashSet<Integer>(): 문법 실수, () 제외
    - HashMap을 사용할 필요가 없었음. (중요한 건 '어떤' 종류인지가 아니라, 종류의 '개수'이기 때문)
*/
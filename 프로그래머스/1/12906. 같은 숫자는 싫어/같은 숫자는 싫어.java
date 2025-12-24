import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // 정답 담을 리스트 생성
        ArrayList<Integer> answerList = new ArrayList<>();
        
        // 정답을 새 리스트에 담기
        for(int i = 0; i < arr.length; i++){
            
            // 첫번째 요소는 무조건 담기
            if(i == 0){
                answerList.add(arr[i]);
            }
            
            // 두번째 요소부터는 직전 요소와 같지 않을때만 담기
            else if(i > 0 && arr[i - 1] != arr[i]){
                answerList.add(arr[i]);
            }
        }
        
        // ArrayList를 int[] 배열로 만드는 과정
        int answerLength = answerList.size();
        int[] answer = new int[answerLength];
        
        for(int j = 0; j < answerLength; j++){
            answer[j] = answerList.get(j);
        }
        
        return answer;
    }
}

/*
1. 길이
- length: 배열 (int[], String[], ...)
- size(): 컬렉션 (ArrayList, HashMap, HashSet, ...)
- length(): 문자열 String

2. int[] vs ArrayList<Integer>
- int[]는 고정 길이
- 생성 방법: int[] array = new int[길이] / int[] array = {1, 2, 3}
*/
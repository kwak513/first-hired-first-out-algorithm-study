import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int answerSize = answers.length;
        
        ArrayList<Integer> supoja1 = new ArrayList<>();
        ArrayList<Integer> supoja2 = new ArrayList<>();
        ArrayList<Integer> supoja3 = new ArrayList<>();
        
        // 수포자 1, 2, 3번의 정답 배열 만들기
        for(int i = 0; i < answerSize; i++){
            int[] supoja1Hubo = {1, 2, 3, 4, 5};
            int[] supoja2Hubo = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] supoja3Hubo = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            
            supoja1.add(supoja1Hubo[i % 5]);
            supoja2.add(supoja2Hubo[i % 8]);
            supoja3.add(supoja3Hubo[i % 10]);
        }
        
        // 수포자 1, 2, 3번의 정답 개수 저장
        int supoja1RightNum = 0;
        int supoja2RightNum = 0;
        int supoja3RightNum = 0;
        
        // 몇 개가 정답인지 확인
        for(int j = 0; j < answerSize; j++){
            if(answers[j] == supoja1.get(j)){
                supoja1RightNum++;
            }
            if(answers[j] == supoja2.get(j)){
                supoja2RightNum++;
            }
            if(answers[j] == supoja3.get(j)){
                supoja3RightNum++;
            }
        }
        
        // 가장 많이 맞은 사람의 정답 개수
        int maxRightNum = Math.max(Math.max(supoja1RightNum, supoja2RightNum), supoja3RightNum);
        
        ArrayList<Integer> bestSupoja = new ArrayList<>();
        
        // 최다 득점자를 ArrayList에 저장
        if(maxRightNum == supoja1RightNum){
            bestSupoja.add(1);
        }
        if(maxRightNum == supoja2RightNum){
            bestSupoja.add(2);
        }
        if(maxRightNum == supoja3RightNum){
            bestSupoja.add(3);
        }
        
        // 최다 득점자 ArrayList -> int[] 배열로 변환
        int bestSupojaNum = bestSupoja.size();
        int[] answer = new int[bestSupojaNum];
        
        for(int p = 0; p < bestSupojaNum; p++){
            answer[p] = bestSupoja.get(p);
        }
        
        return answer;
        
    }
}

/*
1. Math.max: 인자 2개만 가능
*/
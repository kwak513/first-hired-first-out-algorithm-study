import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] timeArray = new int[speeds.length];
        
        // 100% 되는데 걸리는 시간 계산
        for(int i = 0; i < progresses.length; i++){
            // i번째의 progresses, speeds 추출
            int currentProgress = progresses[i];
            int currentSpeed = speeds[i];
            
            int time = (100 - currentProgress) / currentSpeed;
            int timeNamuji = (100 - currentProgress) % currentSpeed;
            
            if(timeNamuji == 0){
                time = time;
            }
            else{
                time = time + 1;
            }
            
            timeArray[i] = time;    //  [2일, 1일, 3일]
        }
        
        //  [2일, 1일, 3일] -> [2일, 2일, 3일]
        for(int j = 0; j < timeArray.length - 1; j++){
            int currentTime = timeArray[j];
            int nextTime = timeArray[j + 1];
            
            if(currentTime > nextTime){
                timeArray[j + 1] = currentTime;
            }
        }
        
        //  [2일, 2일, 3일] -> {2일: 2, 3일: 1}
                
        Map<Integer, Integer> answerMap = new LinkedHashMap<>();
        
        for(int p = 0; p < timeArray.length; p++){
            int num = answerMap.getOrDefault(timeArray[p], 0);
            answerMap.put(timeArray[p], num + 1);
        }
        
        // value만 추출: [2, 1]
        ArrayList<Integer> answerList =  new ArrayList<>(answerMap.values());
        
        // ArrayList -> int[]
        int[] answer = new int[answerList.size()];
        
        for(int q = 0; q < answerList.size(); q++){
            answer[q] = answerList.get(q);
        }
        
        return answer;
        
       
        
    
        
        
    }
}


/*
[문제 풀이]
ex) progress: 30, speed: 40 -> (100 - 30) / 40 = 1 -> 나머지가 있으면 + 1 -> 총 2일 
    progress: 95, speed: 10 -> (100 - 95) / 10 = 0 -> 나머지가 있으면 + 1 -> 총 1일
    
    - [2일, 1일, 3일] -> 순회하면서 이전꺼보다 작으면 이전꺼로 바꿈 -> [2일, 2일, 3일] 
    - 같은 날짜인 것의 개수를 배열로 return.

[]
*/
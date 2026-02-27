import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int currentProgress = progresses[i];
            int currentSpeed = speeds[i];
            
            int requiredDay = 
                (100 - currentProgress) % currentSpeed != 0 ?
                ((100 - currentProgress) / currentSpeed) + 1 :
                ((100 - currentProgress) / currentSpeed);
            
            list.add(requiredDay);
            
        }
        
        // ex) list: [7일, 3일, 9일]
        
        List<Integer> answerList = new ArrayList<>();
        
        int maxDay = list.get(0);
        int count = 1;
        
        for(int j = 1; j < list.size(); j++){
            
            int currentDay = list.get(j);
            
            if(currentDay <= maxDay){
                count++;
            }
            else{
                answerList.add(count);
                maxDay = currentDay;
                count = 1;
            }
        
        }
        
        answerList.add(count);
        
        int[] answer = new int[answerList.size()];
        
        for(int p = 0; p < answerList.size(); p++){
            answer[p] = answerList.get(p);
        }
        
        return answer;
        
    }
}
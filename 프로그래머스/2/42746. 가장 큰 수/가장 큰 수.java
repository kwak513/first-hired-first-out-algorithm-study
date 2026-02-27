import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        boolean allZero = true;
        for(int num: numbers){
            if(num != 0){
                allZero = false;
            }
        }
        
        if(allZero){
            return "0";
        }
        
        
        List<String> numbersToString = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++){
            String currentNumToString = ((Integer) numbers[i]).toString();
            
            numbersToString.add(currentNumToString);
        }
        
        Collections.sort(numbersToString, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder answer = new StringBuilder();
        
        for(String str: numbersToString){
            answer.append(str);
            
        }
        
        
        return answer.toString();
    }
}
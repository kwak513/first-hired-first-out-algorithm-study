class Solution {
    boolean solution(String s) {
        int openNum = 0;
        
        // s 순회하면서 체크
        for(int i =0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            
            if(currentChar == '('){
                openNum++;
            }
            else if(currentChar == ')'){
                // 조건 1 체크
                if(openNum == 0){
                    return false;
                }
                
                openNum--;
                
            }
        }
        
        // 조건 2 체크
        if(openNum == 0){
            return true;
        }
        else{
            return false;
        }
        
    }
}

/*
[언제 false?]
- 조건 1. )가 들어오는 순간, 매칭되는 (가 없으면 바로 false
- 조건 2. ()()( 처럼 괄호가 닫히지 않으면 false

[헷갈린 문법]
1. String.charAt(i): 반환은 char
2. char는 == 비교

*/
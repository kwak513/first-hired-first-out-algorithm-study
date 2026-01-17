import java.util.*;
class Solution {
    
            
        char[] digits;
        boolean[] visited;
        Set<Integer> set = new HashSet<>();
    
    
    public int solution(String numbers) {
        digits = numbers.toCharArray();
        visited = new boolean[digits.length];
        
        dfs("");
        return set.size();
  
        }
        
        void dfs(String current){
            if(!current.equals("")){
                
                int number = Integer.parseInt(current);
                if(isPrime(number)){
                    set.add(number);
                }
            }
            
            for(int j = 0; j < digits.length; j++){
                
                if(!visited[j]){
                    visited[j] = true;
                    dfs(current + digits[j]);
                    visited[j] = false;
                }
            }
            
        }
    
        boolean isPrime(int num){
            if(num < 2){
                return false;
            }
            
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    return false;
                }
            }
            
            return true;
        }
    
}


/*
1. 가능한 모든 조합 만들기: DFS (깊이 우선 탐색)
2. 소수인지 판단: 
    - 2부터 √n 중에 약수 있으면, n은 소수가 아님

[문법]
- .toCharArray(): String → char[] 전용
- Integer.parseInt: String → int
-  Math.sqrt(num): √num
    - sqrt: SQuare RooT

*/

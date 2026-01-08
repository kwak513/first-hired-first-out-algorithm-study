import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int count = 0;
        // 오름차순을 위한 PriorityQueue
        Queue<Integer> scovilleQueue = new PriorityQueue<>();
        
        // int[] -> PriorityQueue
        for(int i: scoville){
            scovilleQueue.add(i);
        }
               
        int firstSmallK;
        int secSmallK;
        
        while(scovilleQueue.peek() < K){
            
            // 2개보다 적게 남아있으면, 섞는게 불가능!
            if(scovilleQueue.size() < 2){
                return -1;
            }
            
            count++;
            firstSmallK = scovilleQueue.poll();
            secSmallK = scovilleQueue.poll();
            
            int newK = firstSmallK + (secSmallK * 2);
            scovilleQueue.add(newK);
            
        }
        
         if(scovilleQueue.peek() >= K){
            return count;
        }
        else{
            return -1;
        }
    }
}


/*
1. PriorityQueue
- scoville 길이가 길기 때문에, Arrays.sort()는 효율성 bad
- 자동으로 오름차순으로 출력하는 PriorityQueue 사용
- cf) 내림차순 Queue<Integer> scovilleQueue = new PriorityQueue<>(Collections.reverseOrder());

*/

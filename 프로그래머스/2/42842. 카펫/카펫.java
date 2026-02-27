class Solution {
    public int[] solution(int brown, int yellow) {
        
        
        for(int yellowHeight = 1; yellowHeight <= Math.sqrt(yellow); yellowHeight++){
            
            if(yellow % yellowHeight == 0){
                int yellowWidth = yellow / yellowHeight;
                
                if((yellowWidth + 2) * (yellowHeight + 2) == brown + yellow){
                    return new int[]{yellowWidth + 2, yellowHeight + 2};
                }
            }
            
            
            
        }
        
        return new int[]{-1, -1};
        
        
        
        
    }
}
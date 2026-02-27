class Solution {
    public int solution(int[][] sizes) {
        
        // 긴 변 저장용
        int[] longerLength = new int[sizes.length];
        // 짧은 변 저장용
        int[] shorterLength = new int[sizes.length];
        
        
        for(int i = 0; i < sizes.length; i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            
            
            longerLength[i] = Math.max(width, height);
            shorterLength[i] = Math.min(width, height);
            
        }
        
        int maxOfLongerLength = longerLength[0];
        
        for(int longL: longerLength){
            maxOfLongerLength = Math.max(longL, maxOfLongerLength);
        }
        
        int maxOfShorterLength = shorterLength[0];
        
        for(int shortL: shorterLength){
            maxOfShorterLength = Math.max(shortL, maxOfShorterLength);
        }
        
        return maxOfLongerLength * maxOfShorterLength;
        
    }
}
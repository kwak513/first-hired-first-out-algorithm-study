class Solution {
    public int solution(int n, int k) {
        
        String nToK = Integer.toString(n, k);
        
        String[] nToKSplit = nToK.split("0");
        int count = 0;
        
        for(String num: nToKSplit){
            
            if(num.equals("") || num.equals("1")){
                continue;
            }
            
            // Integer parsedNumToInt = Integer.parseInt(num);
            long parsedNumToInt = Long.parseLong(num);
            
            boolean isPrime = true;
            
            for(int i = 2; i <= Math.sqrt(parsedNumToInt); i++){
                if(parsedNumToInt % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) count++;
        }
        
        return count;
    }
}
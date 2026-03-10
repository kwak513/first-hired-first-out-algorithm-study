import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        int basicTime = fees[0];
        int basicTimeFee = fees[1];
        
        int extraTimeUnit = fees[2];
        int extraTimeUnitFee = fees[3];
        
        
        Map<String, Integer> inTimeMap = new TreeMap<>();
        Map<String, Integer> totalTimeMap = new TreeMap<>();
        
        for(int i = 0; i < records.length; i++){
            
            String currentRecord = records[i];
            
            String[] currentRecordSplit = currentRecord.split(" ");
            
            String time = currentRecordSplit[0];
            
            Integer hour = Integer.parseInt(time.split(":")[0]);
            Integer min = Integer.parseInt(time.split(":")[1]);
            
            Integer timeToMin = hour * 60 + min;
            
            
            String carNumber = currentRecordSplit[1];
            String inOrOut = currentRecordSplit[2];
            
            if(inOrOut.equals("IN")){
                inTimeMap.put(carNumber, timeToMin);
            }
            else if(inOrOut.equals("OUT")){
                
                Integer inTimeMin = inTimeMap.get(carNumber);
                
                Integer currentTotalTime = totalTimeMap.getOrDefault(carNumber, 0);
                
                totalTimeMap.put(carNumber, currentTotalTime + (timeToMin - inTimeMin));
                inTimeMap.remove(carNumber);
            }
            
            
        }
        
        for(String noOutCarNum: inTimeMap.keySet()){
            Integer endOfDayTimeMin = 23 * 60 + 59;
            
            Integer currentTotalTime2 = totalTimeMap.getOrDefault(noOutCarNum, 0);
                
            totalTimeMap.put(noOutCarNum, currentTotalTime2 + (endOfDayTimeMin - inTimeMap.get(noOutCarNum)));
        }
        
        
        List<Integer> answerList = new ArrayList<>();
        
        // 요금 계산
        for(String carNum: totalTimeMap.keySet()){
            Integer totalTime = totalTimeMap.get(carNum);
            
            if(totalTime <= basicTime){
                // 5000원 basicTimeFee
                
                answerList.add(basicTimeFee);
            }
            else{
                Integer timeRequireExtraFee = (totalTime - basicTime);
                
                Integer extraPrice = timeRequireExtraFee % extraTimeUnit == 0 ? (timeRequireExtraFee / extraTimeUnit) * extraTimeUnitFee : ((timeRequireExtraFee / extraTimeUnit) + 1) * extraTimeUnitFee;
                
                // basicTimeFee + extraPrice
                answerList.add(basicTimeFee + extraPrice);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int p = 0; p < answerList.size(); p++){
            answer[p] = answerList.get(p);
        }
        return answer;
    }
}
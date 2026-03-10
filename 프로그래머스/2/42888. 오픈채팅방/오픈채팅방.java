import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++){
            
            String currentRecord = record[i];
                        
            String userStatus = currentRecord.split(" ")[0];    // Enter, Leave, Change
            
            if(userStatus.equals("Enter") || userStatus.equals("Change")){
                String userId = currentRecord.split(" ")[1];    // "uid1234"
                String userName = currentRecord.split(" ")[2];    // "Muzi"
                
                map.put(userId, userName);
            }
            // Leave
            else{
                continue;
            }
            
        }
        
        List<String> answerList = new ArrayList<>();
        
        for(int p = 0; p < record.length; p++){
            String currentRecord = record[p];
            
            String userStatus = currentRecord.split(" ")[0];    // Enter, Leave, Change
            String userId = currentRecord.split(" ")[1];    // "uid1234"
                     
            String finalUserName = map.get(userId);
            
            if(userStatus.equals("Enter")){
                String enterMessage = finalUserName + "님이 들어왔습니다.";
                answerList.add(enterMessage);
            }
            else if(userStatus.equals("Leave")){
                String enterMessage = finalUserName + "님이 나갔습니다.";
                answerList.add(enterMessage);
            }
            
        }
        
        String[] answer = new String[answerList.size()];
        
        for(int q = 0; q < answerList.size(); q++){
            answer[q] = answerList.get(q);
        }
        
        return answer;
    }
}
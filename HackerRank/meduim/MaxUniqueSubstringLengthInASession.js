// Max Unique Substring Length in a Session

function maxDistinctSubstringLengthInSessions(sessionString) { 
    
    if(!sessionString || sessionString === "*") return 0;
    
    let maxLen = 0;
    
    const sessions = sessionString.split("*");
    
    for(let session of sessions){
        
        let left = 0;
        const set = new Set();
        
        for(let right = 0; right < session.length; right++){
            const currentChar = session[right];
            
            // duplicate O
            while(set.has(currentChar)){
                
                set.delete(session[left]);
                left++;
            }
            
            // duplicate X
            set.add(currentChar);
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
    }
    return maxLen;
    
}

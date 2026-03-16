function solution(citations) {
    
    let maxCitation = citations[0];
    
    for(const citation of citations){
        
        maxCitation = Math.max(maxCitation, citation);
        
    }
    
    for(let i = maxCitation; i >= 0; i--){
        let count = 0;
        
        for(const cit of citations){
            if(i <= cit){
                count++;
            }
        }
        
        if(i <= count){
            return i;
        }
    }
    
    return -1;
}

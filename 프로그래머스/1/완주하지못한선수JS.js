function solution(participant, completion) {
    
    const map = new Map();
    
    for(const part of participant){
        
        // const currentVal = map.getOrDefault(part, 0);
        const currentVal = map.get(part) || 0;
        
        map.set(part, currentVal + 1);
        
    }
    
    for(const complete of completion){
        map.set(complete, map.get(complete) - 1);
    }
    
    for(const item of map.keys()){
        if(map.get(item) === 1){
            return item;
        }
    }
    
    return "-1";
    
}

function solution(progresses, speeds) {
    
    const list = [];
    
    for(let i = 0; i < progresses.length; i++){
        let currentProgress = progresses[i];
        let currentSpeed = speeds[i];
        
        let requiredDay = Math.ceil((100 - currentProgress) / currentSpeed);
            
            
            // (100 - currentProgress) % currentSpeed != 0 ?
            //     ((100 - currentProgress) / currentSpeed) + 1 :
            //     ((100 - currentProgress) / currentSpeed);
        
        list.push(requiredDay);
        
    }
    
    const answerList = [];
    
    let maxDay = list[0];
    let count = 1;
    
    
    for(let j = 1; j < list.length; j++){
        let currentDay = list[j];
        
        if(currentDay <= maxDay){
            count++;
        }
        else{
            answerList.push(count);
            maxDay = currentDay;
            count = 1;
        }
    }
    
    answerList.push(count);
    
    return answerList;
    
    
}

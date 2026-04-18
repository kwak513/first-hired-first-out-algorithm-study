var mergeAlternately = function(word1, word2) {
    
    let output = "";
    
    const minLength = Math.min(word1.length, word2.length);

    for(let i = 0; i < minLength; i++){
        output += word1[i] + word2[i];
    }

    output += word1.slice(minLength) +  word2.slice(minLength);

    return output;

    /*
    const word1Length = word1.length;
    const word2Length = word2.length;

    let output = "";

    if(word1Length <= word2Length){
        for(let i = 0; i < word1Length; i++){
            output += word1[i]
            output += word2[i]
        }
        for(let j = word1Length; j < word2Length; j++){
            output += word2[j];
        }
    }
    // else if(word1Length > word2Length)
    else{
        for(let i = 0; i < word2Length; i++){
            output += word1[i]
            output += word2[i]
        }
        for(let j = word2Length; j < word1Length; j++){
            output += word1[j];
        }
    }

    return output;
    
    */
    
};

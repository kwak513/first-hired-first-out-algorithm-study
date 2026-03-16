function solution(n, lost, reserve) {
    
    const lostSet = new Set();
    const reserveSet = new Set();

    for(let i of lost){
        lostSet.add(i);
    }
    for(let j of reserve){
        reserveSet.add(j);
    }
    // 1. 중복 제거
    const tempSet = new Set(reserveSet);
    
    // Set<Integer> tempSet = new HashSet<>(reserveSet);
    
    for(const p of tempSet){
        if(lostSet.has(p)){
            lostSet.delete(p);
            reserveSet.delete(p);
        }
    }

    // 2. List로 만들어서 정렬
    // List<Integer> lostList = new ArrayList<>(lostSet);
    const reserveList = [...reserveSet];
    
    // List<Integer> reserveList = new ArrayList<>(reserveSet);

    // Collections.sort(lostList);
    // Collections.sort(reserveList);
    
    reserveList.sort((a, b) => a - b);

    // 3. 

    for(const q of reserveList){
        if(lostSet.has(q - 1)){
            lostSet.delete(q - 1);
            reserveSet.delete(q);
        }
        else if(lostSet.has(q + 1)){
            lostSet.delete(q + 1);
            reserveSet.delete(q);
        }
    }

    return n - lostSet.size;
}

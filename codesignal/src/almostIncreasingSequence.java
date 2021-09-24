boolean almostIncreasingSequence(int[] sequence) {
    
    
    int found = 0;
    for (int i = 0; i < sequence.length - 1; i++) {
        if (sequence[i+1] <= sequence[i]) {
            found++;
            if (
               (i + 2 < sequence.length && sequence[i + 2] <= sequence[i])
               &&
               (i >= 1 && sequence[i + 1] <= sequence[i-1])
            ) return false;
        }
    }
    return found <= 1;
}
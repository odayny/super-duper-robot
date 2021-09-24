boolean isLucky(int n) {
    int nCopy = n;
    int halfSum = 0; 
    int sum = 0; 
    int digitCount = 0;
    int halfIter = 0; 
    while (n != 0) { 
        int lastDigit = n % 10;
        sum += lastDigit;
        digitCount++;
        n /= 10;
        if ((digitCount / 2) > halfIter) {
            int nCopyLastDigit = nCopy % 10;
            halfSum += nCopyLastDigit;
            halfIter++;
            nCopy /= 10;
        }
    }
    return (sum - halfSum) == halfSum;
}

class Solution {
    public int minimumSwap(String s1, String s2) {
        int xyCount = 0;
        int yxCount = 0;
        //iter trough string
        for (int i = 0; i < s1.length(); i++) {
            // same pair - skip
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            //xy pair
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xyCount++;
            }
            //xy pair
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yxCount++;
            }
        }
        
        if ((xyCount % 2) != (yxCount % 2)) {
            return -1;
        }
        
        if ((xyCount % 2) == 0) {
            return (xyCount + yxCount) / 2;
        }
            
        if ((xyCount % 2)  == 1) {
            return ((xyCount + yxCount) / 2) +1;
        }
        return -666;
    }
}


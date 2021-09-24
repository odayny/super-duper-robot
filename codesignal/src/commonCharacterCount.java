int commonCharacterCount(String s1, String s2) {
    Map<Integer, Integer> s1Map = new HashMap<>(s1.length());
    for (int i = 0; i < s1.length(); i++) {
        if (s1Map.containsKey((int) s1.charAt(i))) {
            s1Map.put((int) s1.charAt(i), s1Map.get((int) s1.charAt(i)) + 1);
        } else {
            s1Map.put((int) s1.charAt(i), 1);
        }
    }
    int commonCharsCount = 0;
    for (int i = 0; i < s2.length(); i++) {
        if (s1Map.containsKey((int) s2.charAt(i))) {
            commonCharsCount++;
            int symbolCount = s1Map.get((int) s2.charAt(i));
            if (symbolCount > 1) {
                s1Map.put((int) s2.charAt(i), symbolCount - 1);
            } else {
                s1Map.remove((int) s2.charAt(i));
            }
        }
    }
    return commonCharsCount;
}


/*
   a  b  c  d
0  0. 0. 0. 0
1  1. 0. 0. 0 s 1
2  2. 0. 0. 0 s 2
3. 2. 1. 0. 0 s 3
4. 2. 1. 1. 0 s 4
5. 2. 1. 2. 0 s 5
6. 1. 1. 2. 0 s 4
7. 1. 1. 2.-1 s 3
8. 1. 1. 1.-1 s 2
9. 0. 1. 1.-1 s 1
0.-1. 1. 1.-1 s 0
-  4. 1. 3. 1

*/
String[] allLongestStrings(String[] inputArray) {
    int longestStringLength = 0;
    List<String> longestStrings = new ArrayList<>(inputArray.length);
    for (String string : inputArray) {
        if (longestStringLength == string.length()) {
            longestStrings.add(string);
        } else if (longestStringLength < string.length()) {
            longestStrings = new ArrayList<>(inputArray.length);
            longestStrings.add(string);
            longestStringLength = string.length();
        }
    }
    return longestStrings.toArray(new String[longestStrings.size()]);
}

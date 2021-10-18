/*
You are given an array of desired filenames in the order of their creation. Since two files cannot have equal names, the one which comes later will have an addition to its name in a form of (k), where k is the smallest positive integer such that the obtained name is not used yet.

Return an array of names that will be given to the files.

Example

For names = ["doc", "doc", "image", "doc(1)", "doc"], the output should be
fileNaming(names) = ["doc", "doc(1)", "image", "doc(1)(1)", "doc(2)"].

Input/Output

[execution time limit] 3 seconds (java)

[input] array.string names

Guaranteed constraints:
5 ≤ names.length ≤ 1000,
1 ≤ names[i].length ≤ 15.

[output] array.string
*/
String[] fileNaming(String[] names) {
    Map<String, Integer> namesMap = new HashMap<>();
    for (int i = 0; i < names.length; i++) {
        String name = names[i];
        if (!namesMap.containsKey(name)) {
            namesMap.put(name, 1);
        } else {
            int count = namesMap.get(name);
            while(namesMap.containsKey(name + "(" + count + ")")){
                count++;
            }
            names[i] = name + "(" + count + ")";
            namesMap.put(name, ++count);
            namesMap.put(names[i], 1);
        }
    }
    return names;
}

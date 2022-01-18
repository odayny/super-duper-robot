class Solution_BadPerformance {
  //it works but performance is awful
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> coursesMap = new HashMap<Integer, Set<Integer>>();

        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> dependencies;
            if (coursesMap.containsKey(prerequisites[i][0])) {
                dependencies = coursesMap.get(prerequisites[i][0]);
            } else {
                dependencies = new HashSet<Integer>();
            }
            dependencies.add(prerequisites[i][1]);
            coursesMap.put(prerequisites[i][0], dependencies);
            
            
        }
        
         for (int i = 0; i < numCourses; i++) {
             Set<Integer> passed = new HashSet<Integer>();
             passed.add(i);
             if (isCycle(coursesMap, coursesMap.get(i), passed)) {
                 return false;
             }    
             //another dirty hack here
             coursesMap.remove(i);
         }
         return true;
        
    }
    
    private boolean isCycle(Map<Integer, Set<Integer>> coursesMap, Set<Integer> position, Set<Integer> passed) {
        if (position == null) {
            return false;
        } else {
            for (Integer i : position) {
                if (passed.contains(i)) {
                    return true;
                }
                //dirty hack here
                Set<Integer> newPassed = new HashSet<Integer>();
                newPassed.addAll(passed);
                newPassed.add(i);
                if (isCycle(coursesMap, coursesMap.get(i), newPassed)) {
                    return true;
                }
            }
            return false;
        }
    }
}

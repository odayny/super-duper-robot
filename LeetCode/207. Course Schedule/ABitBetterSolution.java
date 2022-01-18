class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // idea here is to find a cycle in graph
        // let's use Khan's algorithm for that
        // https://www.youtube.com/watch?v=cIBFEhD77b4
        
        // store all relations somewhere
        // (v2)let's save some memory for memes (45.3 MB and 12 ms)
        //-boolean[][] relations = new boolean[numCourses][numCourses];
        int[] dependenciesCount = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            //-int dependant = prerequisite[0];
            int dependency = prerequisite[1];
            //-relations[dependant][dependency] = true;
            dependenciesCount[dependency]++;
        }
        
        // now let's find a cycle
        // passed nodes count
        int passed = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        // first of all put in queue all nodes with no dependencies
        for(int i = 0;  i < numCourses;  i++) {
            if (dependenciesCount[i] == 0) {
                queue.offer(i);
            }
        }
        
        // lets process all elements from queue:
        //  - decrease dependenciesCount for it's dependants
        //   - if any of them got to 0: put 'em in queue
        //  - remove item from queue
        //  - increase passed count
        while (queue.peek() != null) {
            int dependency = queue.poll();
            //-boolean[] dependants = relations[dependency];
            //-for (int i = 0; i < numCourses; i++){
            //-    if (dependants[i]) {
            //-        if (dependenciesCount[i] > 0) {
            //-            dependenciesCount[i]--;
            //-            if (dependenciesCount[i] == 0) {
            //-                queue.offer(i);
            //-            }
            //-        } 
            //-    }
            //-}
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == dependency) {
                    int dependant = prerequisite[1];
                    if (dependenciesCount[dependant] > 0) {
                        dependenciesCount[dependant]--;
                        if (dependenciesCount[dependant] == 0) {
                            queue.offer(dependant);
                        }
                    } 
                }
            }
            passed++;
        }
        System.out.println(passed);
        // if passed count differs from numCourses than there is something wrong with the graph
        return passed == numCourses;
    }
}

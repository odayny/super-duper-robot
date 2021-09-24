class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Solution.Point> heap = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            heap.add(new Point(points[i]));
        }
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll().array();
        }
        return result;
    }
    
    
    class Point implements Comparable<Solution.Point> {
        int x;
        int y;
        int distance() {
            return x * x + y * y;
        }
        public int compareTo(Point ext) {
            return this.distance() - ext.distance();
        }
        Point(int[] cords) {
            x = cords[0];
            y = cords[1];
        }
        int[] array() {
            return new int[]{x, y};
        }
    }
}

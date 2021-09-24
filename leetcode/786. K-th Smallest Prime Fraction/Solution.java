class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                double adiv = ((double) a[0]) / ((double) a[1]);
                double bdiv = ((double) b[0]) / ((double) b[1]);
                return adiv < bdiv ? -1 : 1;
            }
        });
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                pq.add(new int[] {arr[i], arr[j]});
            }
        }
        
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        
        return pq.peek();
    }
}

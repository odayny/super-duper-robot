int[] sortByHeight(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
        if (a[i]<0) {
            continue;
        }
        int minPos = i;
        for (int j = i + 1; j < n; j++) {
            if (a[j]<0) {
                continue;
            }
            if (a[j] < a[minPos]) {
                minPos = j;
            }
        }
        if (a[minPos] < a[i]) {
            int tmp = a[minPos];
            a[minPos] = a[i];
            a[i] = tmp;
        }
    }
    // boolean sorted = false;
    // while (!sorted) {
    //     sorted = true;
    //     for (int i = 0; i < n - 1; i++) {
    //         if (a[i]<0) {
    //             continue;
    //         }
    //         int j = i+1;
    //         while (j < n && a[j] < 0) j++;
    //         if (a[i] > a[j] && a[j] >= 0) {
    //             sorted = false;
    //             int temp = a[i];
    //             a[i] = a[j];
    //             a[j] = temp;
    //         }
    //     }
    // }
    return a;
}

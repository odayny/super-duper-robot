int shapeArea(int n) {
    int area = 0;
    for (int i = n; i > 0; i--) area += i;
    area += (area - n) * 2 + area - 2*n +1;
    return area;
    // int centerLineArea = n + (n-1);
    // int sideArea = 0;
    // int i = centerLineArea - 2;
    // while (i > 0) {
    //     sideArea += i;
    //     i -= 2;
    // }
    // return centerLineArea + sideArea*2;
}
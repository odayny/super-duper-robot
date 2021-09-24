https://leetcode.com/problems/k-th-smallest-prime-fraction/

not the best solution, but it works.

some notes (to verify and improve):

```
[1, 2, 3, 5, 7]
m 0     1     2     3
0 1/7 < 1/5 < 1/3 < 1/2
1 2/7 < 2/5 < 2/3
2 3/5 < 3/7
3 5/7


add m[0,0]
check pq.size vs k
add m[0,1], m[1,0]
check pq.size vs k
add m[0,2], m[1,1], m[2,0]
...
if k < pq.size
peek kth
```

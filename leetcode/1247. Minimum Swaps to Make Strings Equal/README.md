this can be calculated:

there are 3 possible pairs between ``s1[i]`` and ``s2[i]``.
 - same symbols: ignore
 - 2 types of different symbols: count both separately

then both counts must be odd or even at the same time (that means we have enough symbols to swap).

if even: one swap between random 2 equal pairs will solve exactly 2 differences
if odd: same as even **but** in the end we will get 2 different pairs. to resolve them we need 1 extra op (see "xy", "yx" example)

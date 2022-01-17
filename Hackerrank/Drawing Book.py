" https://www.hackerrank.com/challenges/drawing-book/problem "

"""
find count of flips (starting from 0)
find flip with requested page (starting from zero again)
return what is smaller: flip with requested page (going from 1st page) or total - flip with requested page (going from back)
"""

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'pageCount' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER p
#

def pageCount(n, p):
    # Write your code here
    flips = n//2
    wantedFlip = p//2
    return min(wantedFlip, flips - wantedFlip)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    p = int(input().strip())

    result = pageCount(n, p)

    fptr.write(str(result) + '\n')

    fptr.close()

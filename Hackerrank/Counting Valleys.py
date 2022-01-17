"https://www.hackerrank.com/challenges/counting-valleys/problem"

#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countingValleys' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER steps
#  2. STRING path
#

def countingValleys(steps, path):
    # Write your code here
    h = 0
    valleys = 0
    for i in range(steps) :
        if path[i] == 'U' :
            h += 1
        if path[i] == 'D' :
            h -= 1
            if h == -1 :
                valleys += 1
    return valleys

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    steps = int(input().strip())

    path = input()

    result = countingValleys(steps, path)

    fptr.write(str(result) + '\n')

    fptr.close()

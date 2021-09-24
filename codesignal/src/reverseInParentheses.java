String reverseInParentheses(String inputString) {
    return doReverse(inputString, false);
}

String doReverse(String inputString, boolean activator) {
    for (int i = 0; i < inputString.length() -1; i++) {
        if (inputString.charAt(i) == '(') {
            int innerBlocks = 0;
            int blockEnd = i+1;
            for (int j = i + 1; j < inputString.length(); j++) {
                if (inputString.charAt(j) == '(') {
                    innerBlocks++;
                } else if (inputString.charAt(j) == ')') {
                    if (innerBlocks == 0) {
                        blockEnd = j;
                    } else {
                        innerBlocks--;
                    }
                }
            }
            String revStr = doReverse(inputString.substring(i+1, blockEnd), true);
            inputString = inputString.substring(0, i) + revStr + inputString.substring(blockEnd+1);
            i--;
        }
    }
    if (activator) {
        String result = "";
        for (int i = inputString.length() -1; i >= 0; i--) {
            result += inputString.charAt(i);
        }
        return result;
    }
    return inputString;
}
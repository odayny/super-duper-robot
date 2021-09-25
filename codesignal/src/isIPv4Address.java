/*
An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

Given a string, find out if it satisfies the IPv4 address naming rules.

Example

For inputString = "172.16.254.1", the output should be
isIPv4Address(inputString) = true;

For inputString = "172.316.254.1", the output should be
isIPv4Address(inputString) = false.

316 is not in range [0, 255].

For inputString = ".254.255.0", the output should be
isIPv4Address(inputString) = false.

There is no first number.

Input/Output

[execution time limit] 3 seconds (java)

[input] string inputString

A string consisting of digits, full stops and lowercase English letters.

Guaranteed constraints:
1 ≤ inputString.length ≤ 30.

[output] boolean

true if inputString satisfies the IPv4 address naming rules, false otherwise.
*/
boolean isIPv4Address(String inputString) {
    // wanna write something stupidly overcompicated and shitty ad the same time, lol
    int groupCount = 0;
    int digitCount = 0;
    for (int i = 0; i < inputString.length(); i++) {
        char current = inputString.charAt(i);
        if (current >= '0' && current <= '9') {
            digitCount++;
        }
        if (digitCount > 3) return false;
        if (current == '.') {
            groupCount++;
            if (digitCount == 3) {
                if (inputString.charAt(i - 3) > '2') return false;
                if (inputString.charAt(i - 3) == '2' && inputString.charAt(i-2) > '5') return false;
                if (inputString.charAt(i - 3) == '2' && inputString.charAt(i-2) == '5' && inputString.charAt(i-1) > '5') return false; 
            }
            if (digitCount < 1 || digitCount > 3) return false;
            if (digitCount > 1 && inputString.charAt(i-digitCount) == '0') return false;
            digitCount = 0;
        }
        if (groupCount > 3) return false;
        if ((current < '0' || current > '9') && current != '.') return false;
    }
    if (groupCount != 3) return false;
    //yes it's copypaste
    if (digitCount == 3) {
        if (inputString.charAt(inputString.length()-3) > '2') return false;
        if (inputString.charAt(inputString.length()-3) == '2' && inputString.charAt(inputString.length()-2) > '5') return false;
        if (inputString.charAt(inputString.length()-3) == '2' && inputString.charAt(inputString.length()-2) == '5' && inputString.charAt(inputString.length()-1) > '5') return false;
    }
    if (groupCount < 3) return false;
    if (digitCount < 1 || digitCount > 3) return false;
    if (digitCount > 1 && inputString.charAt(inputString.length()-digitCount) == '0') return false;
    return true;
}

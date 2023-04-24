public class URLify {
    public static void main(String[] args) {
//        System.out.println(urlify("Mr John Smith"));
        String input = "Mr John Smith    ";
        char[] chars = input.toCharArray();
        int trueLength = findIndexOfLastNonSpaceCharacter(chars) + 1; // Length without ' ' at the end
        replaceSpaces(chars, trueLength);
        System.out.println(chars);
    }

    // Mr John Smith -> Mr%20John%20Smith
    public static String urlify(String input) {
        if (input.isEmpty()) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }

    // Mr John Smith   -> Mr%20John%20Smith
    public static void replaceSpaces(char[] input, int trueLength) {
       int spaceCount = 0, finalLength = 0;
       for (int i = 0; i < trueLength; i++) {
           if (input[i] == ' ') {
               spaceCount++;
           }
       }
       finalLength = trueLength + spaceCount * 2;
       if (trueLength < input.length) {
           input[trueLength] = '\0';
       }
       for (int i = trueLength - 1; i >= 0; i--) {
           if (input[i] == ' ') {
               input[finalLength - 1] = '0';
               input[finalLength - 2] = '2';
               input[finalLength - 3] = '%';
               finalLength -= 3;
           } else {
               input[finalLength - 1] = input[i];
               finalLength--;
           }
       }
    }

    public static int findIndexOfLastNonSpaceCharacter(char[] chars) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
}

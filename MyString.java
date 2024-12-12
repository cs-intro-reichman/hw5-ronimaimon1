/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h')); // Should return 1
        System.out.println(countChar(hello, 'l')); // Should return 2
        System.out.println(countChar(hello, 'z')); // Should return 0
        System.out.println(spacedString(hello)); // Should return "h e l l o"
        
        // Additional tests
        System.out.println(subsetOf("sap", "space")); // true
        System.out.println(subsetOf("spa", "space")); // true
        System.out.println(subsetOf("pass", "space")); // false
        System.out.println(subsetOf("c", "space")); // true
        
        System.out.println(randomStringOfLetters(5)); // Example: a random string like "abcde"
        
        System.out.println(insertRandomly('x', "cat")); // Should return a string with 'x' inserted at a random position
        
        System.out.println(remove("meet", "committee")); // Expected: "comit"
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        // Convert string and char to lowercase
        str = str.toLowerCase();
        ch = Character.toLowerCase(ch);
        
        // Count occurrences
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
         // Loop through each character in str1
    for (int i = 0; i < str1.length(); i++) {
        char currentChar = str1.charAt(i);
        boolean found = false;

        // Search for the current character in str2
        for (int j = 0; j < str2.length(); j++) {
            if (str2.charAt(j) == currentChar) {
                // Mark the character as "used" by changing it to a placeholder (e.g., '\0')
                str2 = str2.substring(0, j) + str2.substring(j + 1);
                found = true;
                break;
            }
        }

        // If a character in str1 couldn't find a match in str2, return false
        if (!found) {
            return false;
        }
    }

    // All characters matched successfully
    return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i);
            if (i < str.length() - 1) {
                result += " ";
            }
        }
        return result;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            char randomCh = (char) ('a' + Math.random() * 26);
            str += randomCh;
        }
        return str;
    
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String result = "";
        
        // Loop through each character in str1
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);

            // If the current character is NOT in str2, append it
            if (!isInStr2(currentChar, str2)) {
                result += currentChar; // Concatenate characters manually
            }
        }

        return result;
    }

    public static boolean isInStr2(char ch, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}

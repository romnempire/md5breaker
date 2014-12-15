public class Crack {
    private static char START = 'a';
    private static char STOP = 'z';
    private static int NUM_CHARS = 5;


    public static void main(String[] args) {
        // create and initialize the password string
        char[] candidate = new char[NUM_CHARS];
        for (int i = 0; i < candidate.length; i++) {
            candidate[i] = START;
        }

        // create loop variables for an arbitrary number of characters in the password string
        char[] loopVars = new char[candidate.length];
        for (int i = 0; i < loopVars.length; i++) {
            loopVars[i] = START;
        }

        // for each character in the password
        for (int i = 0; i < candidate.length; i++) {
            //
        }

    }

    public static String HashString(char[] password) {
        return "string";
    }
}
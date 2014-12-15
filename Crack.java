public class Crack {
    private static Char START = 'a';
    private static Char STOP = 'z';
    private int NUM_CHARS = 5;


    public static void main(String[] args) {
        // create and initialize the password string
        Char[] candidate = new Char[NUM_CHARS];
        for (int i = 0; i < candidate.length; i++) {
            candidate[i] = START;
        }

        // create loop variables for an arbitrary number of characters in the password string
        Char[] loopVars = new Char[candidate.length];
        for (int i = 0; i < loopVars.length; i++) {
            loopVars[i] = START;
        }

        // for each character in the password
        for (int i = 0; i < candidate.length; i++) {

        }

    }

    public static String HashString(String[]) {
        return "string";
    }
}
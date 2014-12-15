public class Crack {
    private static char START = 'a';
    private static char STOP = 'z';
    private static int NUM_CHARS = 5;


    public static void main(String[] args) {
        byte[] hash = {0x9, 0x8, 0xa, 0x2, 0x9, 0x6, 0x6, 0xd, 0x4, 0xd, 0x8, 0x7, 0xb, 0x3, 0xb, 0x6, 0x2, 0xb, 0x2,
                0xb, 0x9, 0x2, 0x4, 0x1, 0xe, 0x3, 0xd, 0x5, 0x1, 0x7, 0xf, 0xf};

        if (args.length == 1) {
            hash = toByteArray(args[0]);
        }
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
        do {
            candidate[1] = START;
            do {
                candidate[2] = START;
                do {
                    candidate[3] = START;
                    do {
                        candidate[4] = START;
                        do {
                            candidate[5] = START;
                            if (matches(toHashString(candidate), hash)) ;
                            candidate[5]++;
                        } while (candidate[5] != START);
                        candidate[4]++;
                    } while (candidate[4] != START);
                    candidate[3]++;
                } while (candidate[3] != START);
                candidate[2]++;
            } while (candidate[2] != START);
            candidate[1]++;
        } while (candidate[1] != START);

    }

    private static boolean matches(byte[] bytes, byte[] hash) {
        return false;
    }

    private static byte[] toByteArray(String s) {
        return new byte[0];
    }

    public static byte[] toHashString(char[] password) {
        return null;
    }
}
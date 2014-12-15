public class Crack {
    private static char START = 'a';
    private static char STOP = 'z';
    private static int NUM_CHARS = 5;
    char a = 277;

    public static void main(String[] args) {
        byte[] hash;

        if (args.length == 1) {
            hash = toByteArray(args[0]);
        } else {
            hash = toByteArray("98a2966d4d87b3b62b2b9241e3d517ff");
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
        // this should probably be refactored into something recursive
        outerLoop:
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
                            if (matches(toHashString(candidate), hash)) {
                                System.out.printf("%s\n", candidate);
                                break outerLoop;
                            }
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
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != hash[i]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] toByteArray(String s) {
        return javax.xml.bind.DatatypeConverter.parseHexBinary(s);
    }

    public static byte[] toHashString(char[] c) {
        return null;
    }
}
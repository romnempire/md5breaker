import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Crack {
    private static char START = 'a';
    private static char STOP = 'z';
    private static int NUM_CHARS = 5;
    char a = 277;

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] hash;

        if (args.length == 1) {
            hash = toByteArray(args[0]);
        } else {
            hash = toByteArray("98a2966d4d87b3b62b2b9241e3d517ff");
        }
        // create and initialize the password string
        char[] iteration_vars = new char[NUM_CHARS];
        for (int i = 0; i < iteration_vars.length; i++) {
            iteration_vars[i] = START;
        }

        // create loop variables for an arbitrary number of characters in the password string
        char[] loopVars = new char[iteration_vars.length];
        for (int i = 0; i < loopVars.length; i++) {
            loopVars[i] = START;
        }

        // for each character in the password
        // this should probably be refactored into something recursive

        iteration_vars[0] = START;
        outerLoop:
        do {
            iteration_vars[1] = START;
            do {
                iteration_vars[2] = START;
                do {
                    iteration_vars[3] = START;
                    do {
                        iteration_vars[4] = START;
                        do {
                            String candidate = "" + iteration_vars[0] + iteration_vars[1] + iteration_vars[2] + iteration_vars[3] + iteration_vars[4];
                            if (matches(toHashString(candidate), hash)) {
                                System.out.printf("%s\n", iteration_vars);
                                break outerLoop;
                            }
                            iteration_vars[4]++;
                        } while (iteration_vars[4] != START);
                        iteration_vars[3]++;
                    } while (iteration_vars[3] != START);
                    iteration_vars[2]++;
                } while (iteration_vars[2] != START);
                iteration_vars[1]++;
            } while (iteration_vars[1] != START);
            iteration_vars[0]++;
        } while (iteration_vars[0] != START);
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

    public static byte[] toHashString(String s) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] message = s.getBytes("ASCII");
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(message);
    }
}
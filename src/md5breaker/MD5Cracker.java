package md5breaker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5Cracker {
	int maxLength;
	String hexmd5hash;
    public static void main (String[] args) {

    	MD5Cracker c = new MD5Cracker();
    	System.out.println(c.find("98a2966d4d87b3b62b2b9241e3d517ff"));
    }
    
    public MD5Cracker() {
    	//this is 5 because it attempts to implement You Brute from
    	//http://thehackerolympics.com/#rules/
    	maxLength = 5;
    }
    
    public MD5Cracker(int _maxLength) {
    	maxLength = _maxLength;
    }

    public byte[] hashString(String s) {
        byte[] bs = s.getBytes();
        byte[] digest = new byte[bs.length];
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(bs);
            digest = md.digest();

        } catch (NoSuchAlgorithmException e) {

        }

        return digest;
    }
    
    public String byteArrayToString(byte[] b) {
    	return DatatypeConverter.printHexBinary(b).toLowerCase();
    }
    
    public String find(String _hexmd5hash) {
    	hexmd5hash = _hexmd5hash;
    	
    	for(int i = 1; i <= maxLength; i++) {
    		String s = testStringsOfLength(i, new char[0]);
    		if (!s.equals("")) {
    			return s;
    		}
    	}
    	
    	return "halp";
    }
    
    private String testStringsOfLength(int len, char[] chars) {
		if(len == 0) {
    		String s = String.valueOf(chars);
    		String out = byteArrayToString(hashString(s));
    		if (out.equals(hexmd5hash)) {
    			return s;
    		} else {
    			return "";
    		}
		} else {
			String s = "";
			for (char c = 'a'; Character.isLetter(c); c = (char)(Character.valueOf(c).charValue()+1)) {
				char[] c2 = new char[chars.length+1];
				System.arraycopy(chars, 0, c2, 0, chars.length);
				c2[c2.length-1] = c;
				String s2 = testStringsOfLength(len-1, c2);
				if (!s2.equals("")) {
					s = s2;
					break;
				}
			}
			return s;
		}
    } 
}

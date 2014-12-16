package md5breaker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5Cracker {
	int length;
    public static void main (String[] args) {

    	MD5Cracker c = new MD5Cracker();
    	System.out.println(c.find("98a2966d4d87b3b62b2b9241e3d517ff"));
    }
    
    public MD5Cracker() {
    	//this is 5 because it attempts to implement You Brute from
    	//http://thehackerolympics.com/#rules/
    	length = 5;
    }
    
    public MD5Cracker(int _maxLength) {
    	length = _maxLength;
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
    
    public String find(String hexmd5hash) {
    	
    	for (char c0 = 'a'; c0 != 'z'; c0 = (char)(Character.valueOf(c0).charValue()+1)) {
        	for (char c1 = 'a'; c1 != 'z'; c1 = (char)(Character.valueOf(c1).charValue()+1)) {
            	for (char c2 = 'a'; c2 != 'z'; c2 = (char)(Character.valueOf(c2).charValue()+1)) {
                	for (char c3 = 'a'; c3 != 'z'; c3 = (char)(Character.valueOf(c3).charValue()+1)) {
                    	for (char c4 = 'a'; c4 != 'z'; c4 = (char)(Character.valueOf(c4).charValue()+1)) {
                    		char[] chars = {c0,c1,c2,c3,c4};
                    		String s = String.valueOf(chars);
                    		String out = byteArrayToString(hashString(s));
                    		if (out.equals(hexmd5hash)) {
                    			return s;
                    		}
                    	}
                	}
            	}
        	}
    	}
	
    	return "throw an error, batman smells";
    }
    
}

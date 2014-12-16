package testmd5breaker;

import static org.junit.Assert.*;
import md5breaker.MD5Cracker;

import org.junit.Test;

public class TestCrack {
	
	@Test
	public void testHashString() {
		MD5Cracker c = new MD5Cracker();
		String input = "hello";
		//using "hello"
		String hash = "5d41402abc4b2a76b9719d911017c592";
		String actual = c.byteArrayToString(c.hashString(input));
		assertEquals(hash, actual);
	}
	
	@Test
	public void testFind() {
		MD5Cracker c = new MD5Cracker();
		String input = "5d41402abc4b2a76b9719d911017c592";
		String value = "hello";
		String out = c.find(input);
		assertEquals(out, value);
		
	}
}

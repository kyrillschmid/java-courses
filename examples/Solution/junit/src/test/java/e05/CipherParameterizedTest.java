package e05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CipherParameterizedTest {
	
/*
	@Test
	public void TestEncode() {
		String input = "This is a test string";
		String expected = "Wklv#lv#d#whvw#vwulqj";
		String actual = Cipher.encode(input);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@MethodSource("inputProviderEncoder")
	public void testEncodeMultipleInputs(String input, String expected) {
		String actual = Cipher.encode(input);
		assertEquals(expected, actual);	
	}
	
	static List<String[]> inputProviderEncoder() {
		return Arrays.asList(new String[][] {
			{"", ""},
			{"a", "d"},
			{"hello world", "khoor#zruog"},
		});
	}
	
	@Test 
	public void TestDecode() {
		String input = "Sdudphwhul}hg#whvwv#duh#frro";
		String expected = "Parameterized tests are cool";
		String actual = Cipher.decode(input);
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@MethodSource("inputProviderDecoder")
	public void testDecodeMultipleInputs(String input, String expected) {
		String actual = Cipher.decode(input);
		assertEquals(expected, actual);	
	}
	
	static List<String[]> inputProviderDecoder() {
		return Arrays.asList(new String[][] {
			{"", ""},
			{"d", "a"},
			{"khoor#zruog", "hello world"},
		});
	}
*/

}

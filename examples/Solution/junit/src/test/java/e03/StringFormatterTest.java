package e03;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;

public class StringFormatterTest {
	
/*    @Test
    public void testCapitalize() {
        assertEquals("HELLO WORLD", StringFormatter.capitalize("hello world"));
        assertNull(StringFormatter.capitalize(null));
        assertEquals("", StringFormatter.capitalize(""));
    }
    
    @Test
    public void testIsEmpty() {
    	assertTrue(StringFormatter.isEmpty(""), () -> "Empty string should be empty");
    	assertFalse(StringFormatter.isEmpty("abc"), () -> "abc is not an empty string");
    }

    @Test
    public void testTruncate() {
    	assertAll(
    			"Truncate failed", 
    			() -> assertEquals("abc", StringFormatter.truncate("abc", 3)),
    			() -> assertEquals("ab", StringFormatter.truncate("abc", 2)),
    			() -> assertEquals("a", StringFormatter.truncate("abc", 1)),
    			() -> assertNull(StringFormatter.truncate(null, 5)),
    			() -> assertEquals("", StringFormatter.truncate("", 3)),
    			() -> assertEquals("abc", StringFormatter.truncate("abc", 4)),
    			() -> assertThrows(IllegalArgumentException.class, () -> StringFormatter.truncate("abc", -1))
    			);
    }

    @Test
    public void testTimeout() {
        assertTimeoutPreemptively(Duration.ofMillis(500), () -> {
            String input = "abcdefghijklmnopqrstuvwxyz";
            StringFormatter.truncate(input, input.length() - 1);
        });
    }
    
    @Test
    public void testReverse() {
    	assertEquals("cba", StringFormatter.reverse("abc"));
    	assertNull(StringFormatter.reverse(null));
    	assertEquals("", StringFormatter.reverse(""));
    }*/
}


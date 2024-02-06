package e05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserParameterizedTestJson {
	
/*    @ParameterizedTest
    @MethodSource("userProvider")
    public void testToString(User user, String expectedOutput) {
        String actualOutput = user.toString();
        assertEquals(expectedOutput, actualOutput);
    }
    
    static List<Object[]> userProvider() throws IOException {
        InputStream inputStream = UserParameterizedTestJson.class.getResourceAsStream("/users.json");
        ObjectMapper mapper = new ObjectMapper();
        List<User> users = mapper.readValue(inputStream, new TypeReference<List<User>>() {});
        inputStream.close();

        
        Object[][] data = new Object[users.size()][2];
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            String expectedOutput = user.toString();
            data[i][0] = user;
            data[i][1] = expectedOutput;
        }
        return Arrays.asList(data);
    }*/

}

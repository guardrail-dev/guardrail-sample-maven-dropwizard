
package helloworld;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.CompletionStage;
import com.example.clients.petstore.user.GetUserByNameResponse;

public class HelloTest {
    @Test
    public void happyPath() {
        CompletionStage<GetUserByNameResponse> result = new Hello().execute();
        System.out.println(result);
    }
}

package helloworld;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import com.example.clients.petstore.definitions.User;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CompletionStage;
import com.example.clients.petstore.user.GetUserByNameResponse;

public class HelloTest {
    @Test
    public void happyPath() {
        CompletionStage<GetUserByNameResponse> result = new Hello().execute();
        result.thenApply( response -> {
            assertThat(result).isCompleted();
            response.fold(this::handleOk, this::handleBadRequest, this::handleNotFound);
            return result;
        });
    }
    
    private Object handleOk(User user) {
        assertThat(user.getEmail()).isNotEmpty();
        return user;
    }

    private Object handleBadRequest() {
     fail("bad request");
     return null;
    }

    private Object handleNotFound() {
        fail("not found");
        return null;
    }
}

package helloworld;

import com.example.clients.petstore.user.GetUserByNameResponse;
import com.example.clients.petstore.user.UserClient;
import java.util.concurrent.CompletionStage;

public class Hello {
  public CompletionStage<GetUserByNameResponse> execute() {
      UserClient client = new UserClient.Builder().build();
      return client.getUserByName("billg").call();
  }
}

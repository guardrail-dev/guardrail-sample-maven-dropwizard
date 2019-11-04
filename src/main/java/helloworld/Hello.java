
package helloworld;

import com.example.clients.petstore.user.GetUserByNameResponse;
import com.example.clients.petstore.user.UserClient;
import java.util.concurrent.CompletionStage;

public class Hello {
  public static void main(String[] args) {
      UserClient client = new UserClient.Builder().build();
      CompletionStage<GetUserByNameResponse> result = client.getUserByName("billg").call();
      System.out.println(result);
  }
}

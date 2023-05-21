package tasks.nivel_2;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userList = new ArrayList<>();
   public void saveUser(User user) {
       userList.add(user);
   }

    public List<User> getUserList() {
        return userList;
    }
}

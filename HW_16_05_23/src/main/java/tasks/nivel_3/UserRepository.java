package tasks.nivel_3;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> userslist = new ArrayList<>();
    public User getUserById(String userId) {
    for(User user: userslist){
        if(user.getId().equals(userId)){
            return user;
        }
    }
        return null;
    }
}

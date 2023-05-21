package tasks.nivel_4;

public class User {
    private String testUser;
    private  String email;


    public User(String testUser, String email) {
        this.testUser = testUser;
        this.email = email;
    }

    public String getTestUser() {
        return testUser;
    }

    public String getEmail() {
        return email;
    }
}

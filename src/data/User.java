package data;

public class User {
    
    private long id;
    private String username;
    private String password_hash;

    
    public User(long id, String username, String password_hash) {
        this.id = id;
        this.username = username;
        this.password_hash = password_hash;
    }


    public long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword_hash() {
        return password_hash;
    }


    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password_hash=" + password_hash + "]";
    }


    


}

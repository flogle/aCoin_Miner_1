package data;

public class ACoinUserData {
    
    private long id;
    private long user_id;
    private double acoins;
    private boolean locked;
    private boolean admin;

    
    public ACoinUserData(long id, long user_id, double acoins, boolean locked, boolean admin) {
        this.id = id;
        this.user_id = user_id;
        this.acoins = acoins;
        this.locked = locked;
        this.admin = admin;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public long getUser_id() {
        return user_id;
    }


    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }


    public double getAcoins() {
        return acoins;
    }


    public void setAcoins(double acoins) {
        this.acoins = acoins;
    }


    public boolean isLocked() {
        return locked;
    }


    public void setLocked(boolean locked) {
        this.locked = locked;
    }


    public boolean isAdmin() {
        return admin;
    }


    public void setAdmin(boolean admin) {
        this.admin = admin;
    }


    @Override
    public String toString() {
        return "ACoinUserData [id=" + id + ", user_id=" + user_id + ", acoins=" + acoins + ", locked=" + locked
                + ", admin=" + admin + "]";
    }


    


}

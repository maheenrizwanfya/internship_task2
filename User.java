public class User {
    String name;
    Profile userProfile;

    public User(String name, double initialCash){
        this.name = name;
        this.userProfile = new Profile(initialCash);
    }

    public Profile getProfile(){
        return userProfile;
    }
}

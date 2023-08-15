package tech.codingclub.helix.entity;

public class signupResponse {
    public String message;



    public signupResponse(String message,Boolean user_created) {
        this.message = message;
        this.user_created = user_created;
    }

    public Boolean user_created;

}

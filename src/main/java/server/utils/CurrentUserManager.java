package server.services;

public class CurrentUserManager {
    private String userName;

    /**
     * Instantiates a new User manager.
     *
     * @param userName the user name
     */
    public CurrentUserManager(String userName) {
        this.userName = userName;
    }

    /**
     * Instantiates a new User manager.
     */
    public CurrentUserManager() {
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     * @return the user name
     */
    public CurrentUserManager setUserName(String userName) {
        this.userName = userName;
        return this;
    }


}

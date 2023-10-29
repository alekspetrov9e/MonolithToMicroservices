package de.tum.in.ase.eist;

import java.util.List;

public class UserService {
    private List<User> users;

    private AuthenticationService authenticationService;
    private DiscussionService discussionService;

    public UserService(List<User> users) {
        this.users = users;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void setDiscussionService(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    public void registerUser(String username, String password) {
        // TODO Part 1: Implement User Service
        throw new UnsupportedOperationException("Not Implemented");
    }

    public void deleteUser(String username, Long token) {
        // TODO Part 1: Implement User Service
        throw new UnsupportedOperationException("Not Implemented");
    }

    public User getUser(String username) {
        var optionalUser = users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
        if (optionalUser.isEmpty()) {
            return null;
        }
        return optionalUser.get();
    }
}

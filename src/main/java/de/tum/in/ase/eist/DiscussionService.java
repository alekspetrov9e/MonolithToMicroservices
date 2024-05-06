package de.tum.in.ase.eist;

import java.util.List;
import java.util.Map;

public class DiscussionService {
    private List<Discussion> discussions;

    private AuthenticationService authenticationService;

    public DiscussionService(List<Discussion> discussions) {
        this.discussions = discussions;
    }

    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public void createDiscussion(String username, Long token, String topic) {
        // TODO Part 3: Implement Discussion Service
        if (!authenticationService.isAuthenticated(username, token)) {
            return;
        }
        Discussion discussion = new Discussion(topic);
        discussions.add(discussion);
    }

    public void addComment(String username, Long token, String topic, String comment) {
        // TODO Part 3: Implement Discussion Service
        if (!authenticationService.isAuthenticated(username, token)) {
            return;
        }
        var optionalDiscussion = discussions.stream().filter(discussion ->
                discussion.getTopic().equals(topic)).findFirst();
        if (optionalDiscussion.isEmpty()) {
            return;
        }
        Discussion discussion = optionalDiscussion.get();
        discussion.addComment(username, comment);
    }

    public List<Map.Entry<String, String>> getComments(String topic) {
        // TODO Part 3: Implement Discussion Service
        var optionalDiscussion = discussions.stream().filter(discussion ->
                discussion.getTopic().equals(topic)).findFirst();
        if (optionalDiscussion.isEmpty()) {
            return null;
        }
        Discussion discussion = optionalDiscussion.get();
        return discussion.getComments();
    }

    public List<String> getCommentsByUser(String topic, String username) {
        // TODO Part 3: Implement Discussion Service
        var optionalDiscussion = discussions.stream().filter(discussion ->
                discussion.getTopic().equals(topic)).findFirst();
        if (optionalDiscussion.isEmpty()) {
            return null;
        }
        Discussion discussion = optionalDiscussion.get();
        return discussion.getCommentsByUser(username);
    }

    public void deleteUserComments(String username) {
        for (Discussion discussion : discussions) {
            discussion.deleteCommentsByUser(username);
        }
    }
}

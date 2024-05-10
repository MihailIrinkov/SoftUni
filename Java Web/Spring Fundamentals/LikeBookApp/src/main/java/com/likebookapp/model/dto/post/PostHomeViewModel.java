package com.likebookapp.model.dto.post;

import com.likebookapp.model.entity.Post;

import java.util.ArrayList;
import java.util.List;

public class PostHomeViewModel {

    private List<Post> myPosts;
    private List<Post> allOtherPosts;

    public PostHomeViewModel() {
        this.myPosts = new ArrayList<>();
        this.allOtherPosts = new ArrayList<>();
    }

    public List<Post> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<Post> myPosts) {
        this.myPosts = myPosts;
    }

    public List<Post> getAllOtherPosts() {
        return allOtherPosts;
    }

    public void setAllOtherPosts(List<Post> allOtherPosts) {
        this.allOtherPosts = allOtherPosts;
    }

    public int getAllOtherPostsSize() {
        return allOtherPosts.size();
    }

}

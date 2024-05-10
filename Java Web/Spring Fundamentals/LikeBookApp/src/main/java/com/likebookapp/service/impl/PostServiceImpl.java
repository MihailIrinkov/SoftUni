package com.likebookapp.service.impl;

import com.likebookapp.enums.MoodNameEnum;
import com.likebookapp.model.dto.post.PostBindingModel;
import com.likebookapp.model.dto.post.PostHomeViewModel;
import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final LoggedUser loggedUser;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, MoodRepository moodRepository, LoggedUser loggedUser) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public PostHomeViewModel getAll() {
        List<Post> posts = this.postRepository.findAll();

        PostHomeViewModel postHomeViewModel = new PostHomeViewModel();

        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getUser().getUsername()
                    .equals(loggedUser.getUsername())) {
                postHomeViewModel.getMyPosts().add(posts.get(i));
            } else {
                postHomeViewModel.getAllOtherPosts().add(posts.get(i));
            }
        }

        return postHomeViewModel;
    }

    @Override
    public boolean addPost(PostBindingModel postBindingModel) {
        if (!loggedUser.isLogged()) {
            return false;
        }

        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();
        Mood mood = this.moodRepository.findByMoodName(postBindingModel.getMood());
        if (user.getUsername() != null) {
            Post post = new Post();
            post.setContent(postBindingModel.getContent());
            post.setMood(mood);
            post.setUser(user);

            this.postRepository.save(post);
            return true;
        }

        return false;
    }

    @Override
    public void like(Long id) {
        Post post = postRepository.findById(id).get();
        User user = userRepository.findByUsername(loggedUser.getUsername()).get();

        if (post.getUser() != null && user.getId() != null) {
            List<User> likesList = post.getUserLikes();
            boolean userLikePost = false;

            for (int i = 0; i < likesList.size(); i++) {
                if (likesList.get(i).getId() == user.getId()) {
                    userLikePost = true;
                }
            }

            if (!userLikePost) {
                post.getUserLikes().add(user);
                postRepository.save(post);
            }
        }
    }

    @Override
    public void remove(Long id) {
        Optional<Post> postToDelete = this.postRepository.findById(id);

        if (postToDelete.isPresent()) {
            Post post = postToDelete.get();
            this.postRepository.delete(post);
        }
    }
}

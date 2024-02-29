package com.likebookapp.service;

import com.likebookapp.model.dto.post.PostBindingModel;
import com.likebookapp.model.dto.post.PostHomeViewModel;

import java.util.List;

public interface PostService {

    PostHomeViewModel getAll();
    boolean addPost(PostBindingModel postBindingModel);

    void like(Long id);

    void remove(Long id);
}

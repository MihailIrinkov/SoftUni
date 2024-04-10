package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostDTO;
import softuni.exam.instagraphlite.models.dto.PostRootDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidationUtilsImpl;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final String POST_FILE_PATH = "src/main/resources/files/posts.xml";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public PostServiceImpl(PostRepository postRepository,
                           UserRepository userRepository,
                           PictureRepository pictureRepository,
                           XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<PostDTO> posts = xmlParser.fromFile(Path.of(POST_FILE_PATH).toFile(), PostRootDTO.class).getPosts();

        for (PostDTO p : posts) {
            Optional<User> userExists = this.userRepository.findByUsername(p.getUser().getUsername());
            Optional<Picture> pictureExists = this.pictureRepository.findByPath(p.getPicture().getPath());
            if (userExists.isEmpty() || pictureExists.isEmpty() || !validationUtils.isValid(p)) {
                sb.append("Invalid Post");
                sb.append(System.lineSeparator());

                continue;
            }

            Post postToSave = modelMapper.map(p, Post.class);
            postToSave.setUser(this.userRepository.findByUsername(p.getUser().getUsername()).get());
            postToSave.setPicture(this.pictureRepository.findByPath(p.getPicture().getPath()).get());
            this.postRepository.save(postToSave);
            sb.append(String.format("Successfully imported Post, made by %s%n",
                    postToSave.getUser().getUsername()));
        }

        return sb.toString().trim();
    }
}

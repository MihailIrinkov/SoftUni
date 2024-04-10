package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.UserDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static String USER_FILE_PATH = "src/main/resources/files/users.json";
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public UserServiceImpl(UserRepository userRepository,
                           PostRepository postRepository,
                           PictureRepository pictureRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<UserDTO> users = Arrays.stream(gson.fromJson(readFromFileContent(), UserDTO[].class))
                .toList();

        for (UserDTO u : users) {
            Optional<Picture> picture = this.pictureRepository
                    .findByPath(u.getProfilePicture());
            if (picture.isEmpty() || !validationUtils.isValid(u)) {
                sb.append("Invalid User");
                sb.append(System.lineSeparator());

                continue;
            }

            User userToSave = modelMapper.map(u, User.class);
            userToSave.setProfilePicture(picture.get());
            this.userRepository.save(userToSave);

            sb.append(String.format("Successfully imported User: %s%n",
                    userToSave.getUsername()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {
        StringBuilder sb = new StringBuilder();

        List<Long> postsByCount = this.postRepository.findByPostCount();

        for (Long l : postsByCount) {
            List<Post> allByUserIdOrderByPictureSize =
                    this.postRepository.findAllByUserIdOrderByPicture_Size(l);
            sb.append(String.format("User: %s%n", this.userRepository.findById(l).get().getUsername()));
            sb.append(String.format("Post count: %d%n", allByUserIdOrderByPictureSize.size()));
            for (Post p : allByUserIdOrderByPictureSize) {
                sb.append(String.format("==Post Details:\n" +
                                "----Caption: %s\n" +
                                "----Picture Size: %.2f\n",
                        p.getCaption(),
                        p.getPicture().getSize()));
            }

        }

        return sb.toString().trim();
    }
}

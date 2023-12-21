package bg.softuni.mvcdemo.services;

import bg.softuni.mvcdemo.dto.UserRegisterDto;
import bg.softuni.mvcdemo.entity.User;
import bg.softuni.mvcdemo.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(UserRegisterDto userRegisterDto) {
        // Create user entity
        ModelMapper mapper = new ModelMapper();
        User user  = mapper.map(userRegisterDto, User.class);
        // Ensure email is free
        boolean emailInUse =
                this.userRepository.existsByEmail(userRegisterDto.getEmail());

        if (emailInUse) {
            return false;
        }

        // Save user entity
        this.userRepository.save(user);
        return true;

    }
}

package org.softuni.mobilele.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.mobilele.enums.UserRoleEnum;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.model.entity.UserRoleEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MobileleUserDetailsServiceTest {

    private MobileleUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new MobileleUserDetailsService(
                mockUserRepository
        );
    }

    @Test
    void testMock() {

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Anna");

        when(mockUserRepository.findAllByEmail("admin@example.com"))
                .thenReturn(Optional.of(userEntity));

        Optional<UserEntity> userOpt =
                mockUserRepository.findAllByEmail("admin@example.com");

        UserEntity user = userOpt.get();

        Assertions.assertEquals("Anna", user.getFirstName());
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("pesho@example.com")
        );
    }

    @Test
    void testUserFoundException() {
        // Arrange
        UserEntity testUserEntity = createTestUser();
        when(mockUserRepository.findAllByEmail(testUserEntity.getEmail()))
                .thenReturn(Optional.of(testUserEntity));

        // Act
        UserDetails userDetails = serviceToTest.loadUserByUsername(testUserEntity.getEmail());

        // Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(
                testUserEntity.getEmail(),
                userDetails.getUsername(),
                "Username is not mapped to email"
        );

        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(2, userDetails.getAuthorities().size());
        Assertions.assertTrue(
                containsAuthority(userDetails, "ROLE_" + UserRoleEnum.ADMIN),
                "The user is not admin");
        Assertions.assertTrue(
                containsAuthority(userDetails, "ROLE_" + UserRoleEnum.USER),
                "The user is not user");

    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails
                .getAuthorities()
                .stream()
                .filter(a -> expectedAuthority.equals(a.getAuthority()))
                .findAny().isPresent();
    }

    private static UserEntity createTestUser() {

        UserRoleEntity userRoleEntity1 = new UserRoleEntity();
        userRoleEntity1.setRole(UserRoleEnum.ADMIN);

        UserRoleEntity userRoleEntity2 = new UserRoleEntity();
        userRoleEntity2.setRole(UserRoleEnum.USER);

        List<UserRoleEntity> userRole = new ArrayList<>();
        userRole.add(userRoleEntity1);
        userRole.add(userRoleEntity2);


        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("firstname");
        userEntity.setLastName("lastname");
        userEntity.setEmail("pesho@example.com");
        userEntity.setPassword("topsecret");
        userEntity.setActive(false);
        userEntity.setUserRole(userRole);

        return userEntity;
    }
}

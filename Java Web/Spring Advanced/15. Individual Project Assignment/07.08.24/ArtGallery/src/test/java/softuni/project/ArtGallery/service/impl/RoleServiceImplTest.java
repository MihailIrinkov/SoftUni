package softuni.project.ArtGallery.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import softuni.project.ArtGallery.model.entity.Role;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.RoleRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    private RoleServiceImpl serviceToTest;

    @Mock
    private RoleRepository mockRoleRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new RoleServiceImpl(
                mockRoleRepository);
    }

    @Test
    void getRoleByName() {
        Role role = createTestRole();

        mockRoleRepository.save(role);

        when(mockRoleRepository.findByName(UserRoles.ADMIN))
                .thenReturn(role);

        Role roleByName = serviceToTest.getRoleByName(role.getName().toString());

        Assertions.assertEquals(UserRoles.ADMIN, roleByName.getName());
    }

    private static Role createTestRole() {
        Role role = new Role(UserRoles.ADMIN);

        return role;
    }
}
package softuni.project.ArtGallery.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.project.ArtGallery.model.entity.Category;
import softuni.project.ArtGallery.model.entity.Role;
import softuni.project.ArtGallery.model.enums.CategoryNames;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.CategoryRepository;
import softuni.project.ArtGallery.repository.RoleRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryRoleSeeder implements CommandLineRunner {

    // Java data initialisation
    private CategoryRepository categoryRepository;

    private RoleRepository roleRepository;

    public CategoryRoleSeeder(CategoryRepository categoryRepository,
                              RoleRepository roleRepository) {
        this.categoryRepository = categoryRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryNames.values())
                    .map(categoryNames -> new Category(categoryNames))
                    .collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
        }

        if (this.roleRepository.count() == 0) {
            List<Role> roles = Arrays.stream(UserRoles.values())
                    .map(userRoles -> new Role(userRoles))
                    .collect(Collectors.toList());

            this.roleRepository.saveAll(roles);
        }

    }

}

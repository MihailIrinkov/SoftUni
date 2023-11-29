package softuni.bg.exerciseJSONprocessing.services.seed;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.exerciseJSONprocessing.domain.entities.Category;
import softuni.bg.exerciseJSONprocessing.domain.entities.Product;
import softuni.bg.exerciseJSONprocessing.domain.entities.User;
import softuni.bg.exerciseJSONprocessing.domain.models.category.CategoryImportModel;
import softuni.bg.exerciseJSONprocessing.domain.models.category.wrappers.CategoryImportWrapperModel;
import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductImportModel;
import softuni.bg.exerciseJSONprocessing.domain.models.product.wrappers.ProductWrapperImportModel;
import softuni.bg.exerciseJSONprocessing.domain.models.user.UserImportModel;
import softuni.bg.exerciseJSONprocessing.domain.models.user.wrappers.UserWrapperImportModel;
import softuni.bg.exerciseJSONprocessing.repositories.CategoryRepository;
import softuni.bg.exerciseJSONprocessing.repositories.ProductRepository;
import softuni.bg.exerciseJSONprocessing.repositories.UserRepository;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.IntStream;

import static softuni.bg.exerciseJSONprocessing.constants.Pats.*;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.GSON;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.MODEL_MAPPER;

@Service
public class SeedServiceImpl implements SeedService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SeedServiceImpl(UserRepository userRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void seedUser(String type) throws IOException, JAXBException {
        if (this.userRepository.count() > 0) return;


        final List<User> usersToSave = type.equals("JSON") ?
                getAllUsersFromJson() : getAllUsersFromXml();

        this.userRepository.saveAll(usersToSave);

    }

    @Override
    public void seedCategories(String type) throws IOException, JAXBException {
        if (this.categoryRepository.count() > 0) return;

        final List<Category> categoriesToSave = type.equals("JSON") ?
                getAllCategoriesFromJson() :
                getAllCategoriesFromXml();

        this.categoryRepository.saveAll(categoriesToSave);

    }

    @Override
    public void seedProducts(String type) throws IOException, JAXBException {
        if (this.productRepository.count() > 0) return;

        final List<Product> productsBeforeMap = type.equals("JSON") ?
                getAllProductsFromJson() :
                getAllProductsFromXml();

        final List<Product> productsToSave = productsBeforeMap
                .stream()
                .map(this::setRandomCategories)
                .map(this::setRandomBuyer)
                .map(this::setRandomSeller).toList();

        this.productRepository.saveAll(productsToSave);
    }

    private Product setRandomSeller(Product product) {

        User seller = this.userRepository.getRandomEntity()
                .orElseThrow(NoSuchElementException::new);
        product.setSeller(seller);

        while (product.getBuyer() != null && product.getBuyer().getId().equals(seller.getId())) {
            seller = this.userRepository.getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);
            product.setSeller(seller);
        }

        return product;
    }

    private Product setRandomBuyer(Product product) {
        if (product.getPrice().compareTo(BigDecimal.valueOf(750L)) > 0) {
            final User buyer = this.userRepository.getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);
            product.setBuyer(buyer);
        }

        return product;
    }

    private Product setRandomCategories(Product product) {

        final Random random = new Random();

        final int countOfCategories = random.nextInt((int) this.categoryRepository.count());

        Set<Category> categories = new HashSet<>();

        IntStream.range(0, countOfCategories)
                .forEach(value -> {
                    categories.add(this.categoryRepository.getRandomEntity()
                            .orElseThrow(NoSuchElementException::new));
                });
        product.setCategories(categories);

        return product;
    }

    private List<Category> getAllCategoriesFromJson() throws IOException {

        final FileReader fileReader =
                new FileReader(CATEGORIES_JSON_PATH.toFile());

//        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//        final ModelMapper modelMapper = new ModelMapper();

        final List<Category> categories = Arrays.stream(GSON.fromJson(fileReader, CategoryImportModel[].class))
                .map(CategoryImportModel
                        -> MODEL_MAPPER.map(CategoryImportModel, Category.class))
                .toList();

        fileReader.close();

        return categories;
    }

    private List<Category> getAllCategoriesFromXml() throws IOException, JAXBException {

        final FileReader fileReader =
                new FileReader(CATEGORIES_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(CategoryImportWrapperModel.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final CategoryImportWrapperModel categoryImportWrapperModel =
                (CategoryImportWrapperModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return categoryImportWrapperModel.getCategories()
                .stream()
                .map(categoryImportModel ->
                        MODEL_MAPPER.map(categoryImportModel, Category.class))
                .toList();
    }

    private List<User> getAllUsersFromJson() throws IOException {
        FileReader fileReader = new FileReader(USER_JSON_PATH.toFile());

        fileReader.close();

        final List<User> users = Arrays.stream(GSON.fromJson(fileReader, UserImportModel[].class))
                .map(userImportModel -> MODEL_MAPPER.map(userImportModel, User.class))
                .toList();

        return users;
    }

    private List<User> getAllUsersFromXml() throws IOException, JAXBException {
        final FileReader fileReader = new FileReader(USER_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(UserWrapperImportModel.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final UserWrapperImportModel wrapperImportModel =
                (UserWrapperImportModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return wrapperImportModel.getUsers()
                .stream()
                .map(model -> MODEL_MAPPER.map(model, User.class))
                .toList();

    }

    private List<Product> getAllProductsFromJson() throws IOException {

        FileReader fileReader = new FileReader(PRODUCTS_JSON_PATH.toFile());

        final List<Product> products = Arrays.stream(GSON.fromJson(fileReader, ProductImportModel[].class))
                .map(productImportModel -> MODEL_MAPPER.map(productImportModel, Product.class))
                .toList();

        fileReader.close();

        return products;
    }

    private List<Product> getAllProductsFromXml() throws IOException, JAXBException {
        final FileReader fileReader = new FileReader(PRODUCTS_XML_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(ProductWrapperImportModel.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final ProductWrapperImportModel wrapperImportModel =
                (ProductWrapperImportModel) unmarshaller.unmarshal(fileReader);

        fileReader.close();

        return wrapperImportModel.getProducts().stream()
                .map(productImportModel -> MODEL_MAPPER.map(productImportModel, Product.class))
                .toList();

    }

}

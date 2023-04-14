package petStore;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PetStoreTests {

    @Test(expected = UnsupportedOperationException.class)
    public void testGetAnimals() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        List<Animal> animals = petStore.getAnimals();
        animals.remove(1);
    }

    @Test
    public void testCreatePetStore() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        Assert.assertEquals(2, petStore.getCount());
    }

    @Test
    public void testGetCollection() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(animal1);
        animalList.add(animal2);

        Collection<Animal> animalCollection = Collections
                .unmodifiableCollection(animalList);

        //Assert.assertArrayEquals(animalList, petStore.getAnimals());
    }

    @Test
    public void testGetCount() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        Assert.assertEquals(2, petStore.getCount());
    }

    @Test
    public void testFindAnimalsWithMaxKg() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);
        Animal animal3 = new Animal("choko", 30, 30.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);

        List<Animal> animalListMaxKg = new ArrayList<>();
        animalListMaxKg.add(animal2);
        animalListMaxKg.add(animal3);

        List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(18);

        Assert.assertEquals(2, animals.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimalWhenNameNull() {
        PetStore petStore = new PetStore();
        petStore.addAnimal(null);
    }

    @Test
    public void testGetTheMostExpensiveAnimal() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);
        Animal animal3 = new Animal("choko", 30, 30.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        Assert.assertEquals(animal3, petStore.getTheMostExpensiveAnimal());
    }

    @Test
    public void testFindAllAnimalBySpecie() {
        PetStore petStore = new PetStore();
        Animal animal1 = new Animal("koko", 20, 15.5);
        Animal animal2 = new Animal("boko", 30, 20.5);
        Animal animal3 = new Animal("choko", 30, 30.5);

        petStore.addAnimal(animal1);
        petStore.addAnimal(animal2);
        petStore.addAnimal(animal3);

        List<Animal> animals = new ArrayList<>();
        animals.add(animal2);

        Assert.assertEquals(animals, petStore
                .findAllAnimalBySpecie("boko"));
    }

}


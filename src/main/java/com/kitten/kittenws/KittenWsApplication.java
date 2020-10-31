package com.kitten.kittenws;

import com.kitten.kittenws.entity.*;
import com.kitten.kittenws.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@AllArgsConstructor
public class KittenWsApplication {

    public static void main(String[] args) {
        SpringApplication.run(KittenWsApplication.class, args);
    }

    @Bean
//    @Profile("dev")
    CommandLineRunner createInitialUsers(BreedRepository breedRepository, CategoryRepository categoryRepository,
                                         CharacteristicsRepository characteristicsRepository, PeriodRepository periodRepository,
                                         ProducerRepository producerRepository, ProductRepository productRepository,
                                         ResponsibilityRepository responsibilityRepository, ContactRepository contactRepository,
                                         AboutRepository aboutRepository, ServiceRepository serviceRepository) {

        return args -> {

            Category cat = new Category("Cat");
            Category food = new Category("Food");

            Arrays.asList(cat, food).forEach(categoryRepository::save);

            Breed british = new Breed("British shorthair", "Gray miracle with round face");
            Breed scottish = new Breed("Scottish fold", "Gray miracle with folded ear");
            Breed siam = new Breed("Siam", "White miracle with black mouth");
            Breed van = new Breed("Van", "Whit miracle with colored eye");
            Breed norwegian = new Breed("Norwegian", "Colorful miracle with cool face");

            Arrays.asList(british, scottish, siam, van, norwegian).forEach(breedRepository::save);

            Characteristics sincere = new Characteristics("Sincere");
            Characteristics calm = new Characteristics("Calm");
            Characteristics playful = new Characteristics("Playful");
            Characteristics sleepy = new Characteristics("Sleepy");
            Characteristics wild = new Characteristics("Wild");

            Arrays.asList(calm, sincere, playful, sleepy, wild).forEach(characteristicsRepository::save);

            Period onceDay = new Period("Once a day");
            Period twiceDay = new Period("Twice a day");
            Period thriceDay = new Period("Thrice a day");
            Period onceWeek = new Period("Once a week");
            Period twiceWeek = new Period("Twice a week");
            Period thriceWeek = new Period("Thrice a week");
            Period onceMonth = new Period("Once a month");
            Period twiceMonth = new Period("Twice a month");
            Period thriceMonth = new Period("Thrice a month");

            Arrays.asList(onceDay, twiceDay, thriceDay, onceWeek, twiceWeek, thriceWeek, onceMonth, twiceMonth, thriceMonth).forEach(periodRepository::save);

            Producer royalCanin = new Producer("Royal Canin");
            Producer pedigree = new Producer("Pedigree");
            Producer whiskas = new Producer("Whiskas");

            Arrays.asList(royalCanin, pedigree, whiskas).forEach(producerRepository::save);

            Product babyCat = new Product("Babycat", 1);
            Product kitten = new Product("Kitten", 5);
            Product adult = new Product("Adult", 3);
            Product young = new Product("Young", 2);
            Product soupWhiskas = new Product("Soup", 11);
            Product canWhiskas = new Product("Can", 9);

            Arrays.asList(babyCat, kitten, adult, young, soupWhiskas, canWhiskas).forEach(productRepository::save);

            Responsibility feed = new Responsibility("Feed");
            Responsibility wash = new Responsibility("Wash");
            Responsibility medicine = new Responsibility("Medicine");
            Responsibility control = new Responsibility("Control");
            Responsibility walk = new Responsibility("Walk");

            Arrays.asList(feed, wash, medicine, control, walk).forEach(responsibilityRepository::save);

            babyCat.setProducer(royalCanin);
            babyCat.setCategory(food);

            kitten.setProducer(royalCanin);
            kitten.setCategory(food);

            adult.setProducer(pedigree);
            adult.setCategory(food);

            young.setProducer(pedigree);
            young.setCategory(food);

            soupWhiskas.setProducer(whiskas);
            soupWhiskas.setCategory(food);

            canWhiskas.setProducer(whiskas);
            canWhiskas.setCategory(food);

            Arrays.asList(babyCat, kitten, adult, young, soupWhiskas, canWhiskas).forEach(productRepository::save);

            Set<Characteristics> britishChar = new HashSet();
            britishChar.add(calm);
            britishChar.add(sincere);
            britishChar.add(playful);

            Set<Characteristics> scottishChar = new HashSet();
            scottishChar.add(wild);
            scottishChar.add(calm);
            scottishChar.add(playful);

            Set<Characteristics> vanChar = new HashSet();
            vanChar.add(playful);
            vanChar.add(sleepy);
            vanChar.add(sincere);

            Set<Responsibility> britishResp = new HashSet<>();
            britishResp.add(medicine);
            britishResp.add(feed);

            Set<Responsibility> vanResp = new HashSet<>();
            britishResp.add(wash);
            britishResp.add(control);

            Set<Responsibility> ordinaryResp = new HashSet<>();
            britishResp.add(walk);
            britishResp.add(feed);

            Set<Product> vanProducts = new HashSet<>();
            vanProducts.add(babyCat);
            vanProducts.add(canWhiskas);

            Set<Product> britishProducts = new HashSet<>();
            britishProducts.add(soupWhiskas);
            britishProducts.add(kitten);
            britishProducts.add(adult);
            britishProducts.add(babyCat);
            britishProducts.add(canWhiskas);
            britishProducts.add(young);

            Set<Product> norwegianProducts = new HashSet<>();
            norwegianProducts.add(adult);
            norwegianProducts.add(young);

            british.setCategory(cat);
            british.setCharacteristics(britishChar);
            british.setProducts(britishProducts);
            british.setResponsibilities(britishResp);
            british.setImage("cat.jpg");

            scottish.setCategory(cat);
            scottish.setCharacteristics(scottishChar);
            scottish.setProducts(norwegianProducts);
            scottish.setResponsibilities(ordinaryResp);
            scottish.setImage("cat.jpg");

            siam.setCategory(cat);
            siam.setCharacteristics(vanChar);
            siam.setProducts(vanProducts);
            siam.setResponsibilities(vanResp);
            siam.setImage("cat.jpg");


            van.setCategory(cat);
            van.setCharacteristics(vanChar);
            van.setProducts(vanProducts);
            van.setResponsibilities(vanResp);
            van.setImage("cat.jpg");

            norwegian.setCategory(cat);
            norwegian.setCharacteristics(britishChar);
            norwegian.setProducts(norwegianProducts);
            norwegian.setResponsibilities(ordinaryResp);
            norwegian.setImage("cat.jpg");

            Arrays.asList(british, scottish, siam, van, norwegian).forEach(breedRepository::save);

            Contact contact = new Contact(
                    "Baku",
                    "(+99470) 559-56-56",
                    "From 9.00 a.m. to 19.00 p.m",
                    "https://instagram.com",
                    "https://facebook.com",
                    "https://twitter.com");
            contactRepository.save(contact);

            About about = new About("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
            aboutRepository.save(about);

            List<Service> services = Arrays.asList(
                    new Service("Providing regular info about your sweet friend", "services/service.jpg"),
                    new Service("Providing regular info about your sweet friend", "services/service.jpg"),
                    new Service("Providing regular info about your sweet friend", "services/service.jpg")
            );
            serviceRepository.saveAll(services);
        };
    }

}

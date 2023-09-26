package com.inho.tacocloud;

import com.inho.tacocloud.tacos.Ingredient;
import com.inho.tacocloud.tacos.data.IngredientRepository;
import com.inho.tacocloud.tacos. Ingredient.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repository) {
        return (args) -> {
//            repository.save (new Ingredient ("FLTO", "Flour Tortilla", Type.WRAP));
//            repository.save (new Ingredient ("COTO", "Corn Tortilla", Type.WRAP));
//            repository.save(new Ingredient ("GRBF", "Ground Beef", Type.PROTEIN));
//            repository.save (new Ingredient ("CARN", "Carnitas", Type.PROTEIN));
//            repository.save (new Ingredient ("TTO", "Diced Tomatoes", Type. VEGGIES));
//            repository.save(new Ingredient ("LET", "Lettuce", Type. VEGGIES));
//            repository.save (new Ingredient ("CHED", "Cheddar", Type.CHEESE));
//            repository.save (new Ingredient ("JACK", "Monterrey Jack", Type.CHEESE));
//            repository.save(new Ingredient ("SLSA", "Salsa", Type.SAUCE));
//            repository.save(new Ingredient("SCR", "Sour Cream", Type.SAUCE));
        };
    }
}

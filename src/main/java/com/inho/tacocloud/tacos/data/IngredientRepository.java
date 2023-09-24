package com.inho.tacocloud.tacos.data;

import com.inho.tacocloud.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

package com.inho.tacocloud.tacos.web;

import com.inho.tacocloud.tacos.Ingredient;
import com.inho.tacocloud.tacos.data.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);

        return optionalIngredient.orElse(null);
    }
}

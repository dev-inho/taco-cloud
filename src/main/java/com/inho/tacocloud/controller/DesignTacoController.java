package com.inho.tacocloud.controller;

import com.inho.tacocloud.tacos.Ingredient;
import com.inho.tacocloud.tacos.Order;
import com.inho.tacocloud.tacos.Taco;
import com.inho.tacocloud.tacos.data.IngredientRepository;
import com.inho.tacocloud.tacos.data.TacoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/design")
public class DesignTacoController {

    private final IngredientRepository jdbcIngredientRepository;

    private final TacoRepository tacoRepository;

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredientList = new ArrayList<>();

        jdbcIngredientRepository.findAll()
                .forEach(ingredientList::add);

        Ingredient.Type[] types = Ingredient.Type.values();

        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredientList, type));
        }

        model.addAttribute("taco", new Taco());

        return "design";
    }


    private List<Ingredient> filterByType(List<Ingredient> ingredientList, Ingredient.Type type) {
        return ingredientList
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processDesign(Taco design, Errors errors, @ModelAttribute Order order) {
        if(errors.hasErrors()) return "design";

        Taco savedTaco = tacoRepository.save(design);

        order.addDesign(savedTaco);

        return "redirect:/orders/current";
    }
}

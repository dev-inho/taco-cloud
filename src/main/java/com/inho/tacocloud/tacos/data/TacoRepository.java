package com.inho.tacocloud.tacos.data;

import com.inho.tacocloud.tacos.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}

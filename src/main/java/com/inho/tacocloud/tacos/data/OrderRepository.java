package com.inho.tacocloud.tacos.data;

import com.inho.tacocloud.tacos.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}

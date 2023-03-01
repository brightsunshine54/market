package com.filantrop.SpringDataJDBC.dao.repository;

import com.filantrop.SpringDataJDBC.dao.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, String> {
}

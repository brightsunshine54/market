package com.filantrop.SpringDataJDBC;

import com.filantrop.SpringDataJDBC.dao.model.Cart;
import com.filantrop.SpringDataJDBC.dao.repository.CartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@SpringBootApplication
public class SpringDataJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CartRepository cartRepository) {
        return args -> {
            Cart cart = new Cart();
            cart.setCategory("SLOW_MOTION");
            cartRepository.save(cart);
/*
			AggregateReference<Author,Integer> author = AggregateReference.to(authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());

			Post post = new Post( "Dan's First Post", "This is Dan's First Post",author);
			post.addComment(new Comment( "Dan", "This is a comment"));
			post.addComment(new Comment( "John", "This is another comment"));
			postRepository.save(post);
*/

        };
    }

    @Bean
    BeforeConvertCallback<Cart> beforeSaveCallback() {
        return (cart) -> {
            if (cart.getCartId() == null) {
                cart.setCartId(UUID.randomUUID().toString());
            }
            return cart;
        };
    }

}

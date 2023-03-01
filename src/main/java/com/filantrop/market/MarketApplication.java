package com.filantrop.market;

import com.filantrop.market.dao.model.Cart;
import com.filantrop.market.dao.model.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;

import java.util.UUID;

@SpringBootApplication
public class MarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketApplication.class, args);
    }
/*
    @Bean
    CommandLineRunner run(CartRepository cartRepository) {
        return args -> {
            Cart cart = new Cart();
            cart.setCategory("SLOW_MOTION");
            cartRepository.save(cart);

			AggregateReference<Author,Integer> author = AggregateReference.to(authorRepository.save(new Author(null, "Dan", "Vega", "danvega@gmail.com", "dvega")).id());

			Post post = new Post( "Dan's First Post", "This is Dan's First Post",author);
			post.addComment(new Comment( "Dan", "This is a comment"));
			post.addComment(new Comment( "John", "This is another comment"));
			postRepository.save(post);


        };
    }
 */

    @Bean
    BeforeConvertCallback<Cart> beforeSaveCartCallback() {
        return (cart) -> {
            if (cart.getCartId() == null) {
                cart.setCartId(UUID.randomUUID().toString());
            }
            return cart;
        };
    }

    @Bean
    BeforeConvertCallback<Item> beforeSaveItemCallback() {
        return (item) -> {
            if (item.getItemId() == null) {
                item.setItemId(UUID.randomUUID().toString());
            }
            return item;
        };
    }

    //https://github.com/petrelevich/jvm-digging/tree/master/springDataJdbc
    //https://github.com/danvega/blog-jdbc


}

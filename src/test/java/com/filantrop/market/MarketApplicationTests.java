package com.filantrop.market;

import com.filantrop.market.dao.model.Cart;
import com.filantrop.market.dao.model.Item;
import com.filantrop.market.dao.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class MarketApplicationTests {

    @Autowired
    CartRepository cartRepository;

    @Test
    void getCartById() {
        Cart before = new Cart("CATEGORY");
        cartRepository.save(before);
        assertThat(before.getCartId()).isNotNull();

        Cart reloaded = cartRepository.findById(before.getCartId()).get();
        assertThat(reloaded.getCategory()).isEqualTo("CATEGORY");
        assertThat(reloaded.getCreateDateTime()).isNotNull();
    }

    @Test
    void updateDateTimeSaveTest() {
        Cart before = new Cart("CATEGORY");
        cartRepository.save(before);

        Cart updated = cartRepository.findById(before.getCartId()).get();
        updated.setUpdateDateTime(Instant.now());

        cartRepository.save(updated);

        Cart reloaded = cartRepository.findById(before.getCartId()).get();
        assertThat(reloaded.getUpdateDateTime()).isNotNull();
        log.info("Loaded cart: {}", reloaded);
    }

    @Test
    void saveCartWithItemsTest() {
        Cart cart = new Cart("SOME_CATEGORY");

        Item item_1 = new Item();
        item_1.setItemId(UUID.randomUUID().toString());
        item_1.setName("Item-1");
        item_1.setSpecification("specification_1");
        cart.getItems().add(item_1);

        Item item_2 = new Item();
        item_2.setItemId(UUID.randomUUID().toString());
        item_2.setName("Item-2");
        item_2.setSpecification("specification_2");
        cart.getItems().add(item_2);

        cartRepository.save(cart);

        Cart loadedCart = cartRepository.findById(cart.getCartId()).get();
        log.info("Loaded cart: {}", loadedCart);
    }

}

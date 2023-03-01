package com.filantrop.SpringDataJDBC;

import com.filantrop.SpringDataJDBC.dao.model.Cart;
import com.filantrop.SpringDataJDBC.dao.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class SpringDataJdbcApplicationTests {

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

}

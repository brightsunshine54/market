package com.filantrop.SpringDataJDBC;

import com.filantrop.SpringDataJDBC.dao.model.Cart;
import com.filantrop.SpringDataJDBC.dao.repository.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataJdbcApplicationTests {

    @Autowired
    CartRepository cartRepository;

    @Test
    void idByCallBack() {

        Cart before = new Cart("CATEGORY");

        cartRepository.save(before);

        assertThat(before.getCartId()).isNotNull();

        Cart reloaded = cartRepository.findById(before.getCartId()).get();
        assertThat(reloaded.getCategory()).isEqualTo("CATEGORY");
    }

}

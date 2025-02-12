package kitchenpos.menus.tobe.domain.model;

import kitchenpos.global.domain.vo.Price;
import kitchenpos.menus.helper.MenuFixtureFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuProductsTest {

    @DisplayName("메뉴상품들의 값은 메뉴 상품의 값의 합이다.")
    @Test
    void getTotalPrice() {
        MenuProducts products = new MenuProducts(Arrays.asList(MenuFixtureFactory.미트파이_메뉴_상품_1500원_1개, MenuFixtureFactory.레몬에이드_메뉴_상품_1000원_1개));
        assertThat(products.getTotalPrice()).isEqualTo(new Price(BigDecimal.valueOf(2500L)));
    }

    @DisplayName("메뉴 (Menu)는 하나 이상의 메뉴 상품 (Menu Product)을 가져야 한다.")
    @Test
    void create() {
        assertThatThrownBy(() -> new MenuProducts(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

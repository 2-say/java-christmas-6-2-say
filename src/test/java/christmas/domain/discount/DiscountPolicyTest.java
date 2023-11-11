package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DiscountPolicyTest {


    @DisplayName("주말 할인 테스트")
    @Test
    void weekendDiscountPolicyTest() {
        // given
        List<Menu> bilgeCase1 = List.of(Menu.CHOCOCAKE);
        Bilge bilge = new Bilge(bilgeCase1);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        // when
        int discount = discountPolicy.discount(bilge, Menu.CHOCOCAKE.getPrice());

        // then
        Assertions.assertThat(discount).isEqualTo(12977);
    }
}

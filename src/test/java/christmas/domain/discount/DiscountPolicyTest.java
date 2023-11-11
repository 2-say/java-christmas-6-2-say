package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DiscountPolicyTest {

    @DisplayName("평일 할인 테스트")
    @Test
    void weekdayDiscountPolicyTest() {
        // given
        List<Menu> bilgeCase1 = List.of(Menu.CHOCOCAKE);
        LocalDate today = LocalDate.of(2023,12,1);
        Bilge bilge = new Bilge(today,bilgeCase1);
        DiscountPolicy discountPolicy = new WeekdayDiscountPolicy();

        // when
        int discount = discountPolicy.discount(bilge, Menu.CHOCOCAKE.getPrice());

        // then
        Assertions.assertThat(discount).isEqualTo(12977);
    }


    @DisplayName("주말 할인 테스트")
    @Test
    void weekendDiscountPolicyTest() {
        // given
        List<Menu> bilgeCase1 = List.of(Menu.BARBECUERIB);
        LocalDate today = LocalDate.of(2023,12,1);
        Bilge bilge = new Bilge(today,bilgeCase1);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        // when
        int discount = discountPolicy.discount(bilge, Menu.BARBECUERIB.getPrice());

        // then
        Assertions.assertThat(discount).isEqualTo(51977);
    }


}

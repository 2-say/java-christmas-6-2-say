package christmas.domain.discount;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import christmas.service.DiscountService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class DiscountPolicyTest {

    @DisplayName("평일 할인 테스트")
    @Test
    void weekdayDiscountPolicyTest() {
        // given
        Map<Menu,Integer> bilgeCase1 = Map.of(Menu.CHOCOCAKE,2);
        LocalDate today = LocalDate.of(2023,12,1);
        Bilge bilge = new Bilge(today,bilgeCase1);
        DiscountPolicy discountPolicy = new WeekdayDiscountPolicy();
        // when
        int discount = discountPolicy.discount(bilge);

        // then
        Assertions.assertThat(discount).isEqualTo(4046);
    }


    @DisplayName("주말 할인 테스트")
    @Test
    void weekendDiscountPolicyTest() {
        // given
        Map<Menu,Integer> bilgeCase1 = Map.of(Menu.TIBONESTEAK,2);
        LocalDate today = LocalDate.of(2023,12,3);
        Bilge bilge = new Bilge(today,bilgeCase1);
        DiscountPolicy discountPolicy = new WeekendDiscountPolicy();

        // when
        int discount = discountPolicy.discount(bilge);

        // then
        Assertions.assertThat(discount).isEqualTo(4046);
    }





}

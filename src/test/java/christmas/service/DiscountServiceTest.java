package christmas.service;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

public class DiscountServiceTest {


    @Test
    void 주말_할인_테스트 () {
        // given

        Map<Menu,Integer> bilgeCase1 = Map.of(Menu.TIBONESTEAK,2);
        LocalDate today = LocalDate.of(2023,12,3);
        Bilge bilge = new Bilge(today,bilgeCase1);
        DiscountService discountService = new DiscountService(bilge);

        // when
        int totalDiscount = discountService.applyDiscount();

        // then
        Assertions.assertThat(totalDiscount).isEqualTo(2200);
    }
}

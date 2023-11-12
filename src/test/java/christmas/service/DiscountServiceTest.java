package christmas.service;

import christmas.domain.Bilge;
import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;

public class DiscountServiceTest {
    @Test
    void 평일_스타데이_크리스마스누적_할인_테스트() {
        // given
        Map<Menu, Integer> bilgeCase1 = Map.of(Menu.CHOCOCAKE, 2);
        LocalDate today = LocalDate.of(2023, 12, 3);
        Bilge bilge = new Bilge(today, bilgeCase1);
        DiscountService discountService = new DiscountService(bilge);

        // when
        int totalDiscount = discountService.applyDiscount();

        // then
        Assertions.assertThat(totalDiscount).isEqualTo(4046+1000+1200);
    }

    @Test
    void 주말_크리스마스누적_할인_테스트() {
        // given
        Map<Menu, Integer> bilgeCase1 = Map.of(Menu.BARBECUERIB, 2);
        LocalDate today = LocalDate.of(2023, 12, 15);
        Bilge bilge = new Bilge(today, bilgeCase1);
        DiscountService discountService = new DiscountService(bilge);

        // when
        int totalDiscount = discountService.applyDiscount();

        // then
        Assertions.assertThat(totalDiscount).isEqualTo(4046+2400);
    }


}

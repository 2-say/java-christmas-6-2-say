package christmas.utils;

import christmas.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {



    @DisplayName("메뉴수량 입력 값 Map으로 분리")
    @Test
    void processEntryTest(){
        // given
        String entry = "타파스-2,제로콜라-3";

        // when
        Map<Menu, Integer> result = Utils.processEntry(entry);

        // then
        assertEquals(2, result.size());
        assertEquals(2, result.get(Menu.TAPAS));
        assertEquals(3, result.get(Menu.ZEROCOLA));
    }
}

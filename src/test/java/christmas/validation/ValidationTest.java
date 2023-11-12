package christmas.validation;

import christmas.domain.Menu;
import christmas.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {

    @Test
    void validateDayInRange_테스트() {
        // given
        int case1 = 1;
        int case2 = 32;
        int case3 = 0;

        // when
        Throwable result1 = catchThrowable(() -> {
            Validation.validateDayInRange(case1);
        });
        Throwable result2 = catchThrowable(() -> {
            Validation.validateDayInRange(case2);
        });
        Throwable result3 = catchThrowable(() -> {
            Validation.validateDayInRange(case3);
        });

        // then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("String to int 검증 테스트")
    @Test
    void validateStringToInteger_Test() {
        // given
        String input = "1a";
        // when
        Throwable result = catchThrowable(() -> {
            Validation.validateStringToInteger(input);
        });
        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 중복 이름 입력 검증 테스트")
    @Test
    void checkDuplicateMenuNameTest() {
        String entry = "타파스-2,제로콜라-3,타파스-2";

        // when
        Throwable result = catchThrowable(() -> {
            Utils.processEntry(entry);
        });

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("없는 메뉴 이름 입력 검증 테스트")
    @Test
    void notFoundMenuNameTest() {
        String entry = "타바스-2,제로콜라-3";

        // when
        Throwable result = catchThrowable(() -> {
            Utils.processEntry(entry);
        });

        // then
        assertThat(result).isInstanceOf(IllegalArgumentException.class);
    }


}

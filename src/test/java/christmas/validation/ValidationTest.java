package christmas.validation;

import christmas.utils.Utils;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

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




}

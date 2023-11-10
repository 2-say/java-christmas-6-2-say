package christmas.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class ValidationTest {

    @Test
    void validateDayInRange_테스트() {
        // given
        List<Integer> case1 = List.of(1,2,3);
        List<Integer> case2 = List.of(0);
        List<Integer> case3 = List.of(31,32);

        // when
        Throwable result1 =  catchThrowable(() ->{
            Validation.validateDayInRange(case1.get(0),case1.get(1),case1.get(2));
        });
        Throwable result2 =  catchThrowable(() ->{
            Validation.validateDayInRange(case2.get(0));
        });
        Throwable result3 =  catchThrowable(() ->{
            Validation.validateDayInRange(case3.get(0),case3.get(1));
        });

        // then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

}

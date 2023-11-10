package christmas.view;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @Test
    void infoMessage_테스트(){
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // when
        OutputView.InfoMessage();
        String capturedOutput = outContent.toString().trim();
        // then
        assertEquals("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.", capturedOutput);
    }
}

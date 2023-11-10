package christmas.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    @BeforeEach
    void testSetup() {
    }

    @Test
    void infoMessage_테스트() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // when
        OutputView.infoMessage();
        String capturedOutput = outContent.toString().trim();
        // then
        assertEquals("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.", capturedOutput);
    }

    @Test
    void infoEventMessage_테스트() {
        // given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        // when
        OutputView.infoEventMessage();
        String capturedOutput = outContent.toString().trim();
        // then
        assertEquals("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", capturedOutput);
    }

}

package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    void callbackV1() {

        TimeLogTemplate template1 = new TimeLogTemplate();
        template1.execute(() -> log.info("BL 1 Start..."));

        TimeLogTemplate template2 = new TimeLogTemplate();
        template2.execute(() -> log.info("BL 2 Start..."));
    }
}

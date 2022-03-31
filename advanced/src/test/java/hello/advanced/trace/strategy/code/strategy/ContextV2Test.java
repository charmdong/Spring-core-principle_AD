package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ContextV2Test {

    @Test
    void strategyV1() {

        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("BL 1 start..."));
    }
}
package hello.aop.internalcall;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CallServiceV1Test {

    @Autowired
    CallServiceV1 callServiceV1;

    @Test
    void external () {
        callServiceV1.external();
    }

    @Test
    void internal () {
        callServiceV1.internal();
    }
}
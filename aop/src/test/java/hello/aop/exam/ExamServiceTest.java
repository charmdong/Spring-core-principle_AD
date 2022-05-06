package hello.aop.exam;

import hello.aop.exam.aop.RetryAspect;
import hello.aop.exam.aop.TraceAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import({TraceAspect.class, RetryAspect.class})
class ExamServiceTest {

    @Autowired
    ExamService examService;

    @Test
    void test() {
        for (int index = 0; index < 5; index++) {
            log.info("client request index={}", index);
            examService.request("data" + index);
        }
    }
}
package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class DecoratorPatternClientTest {

    @Test
    void noDecorator() {
        DecoratorPatternClient client = new DecoratorPatternClient(new RealComponent());

        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);

        client.execute();
    }

    @Test
    void decorator2() {
        DecoratorPatternClient client = new DecoratorPatternClient(new TimeDecorator(new MessageDecorator(new RealComponent())));

        client.execute();
    }
}
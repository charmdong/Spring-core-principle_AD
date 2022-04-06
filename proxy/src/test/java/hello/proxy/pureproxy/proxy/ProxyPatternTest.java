package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject subject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(subject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {

        ProxyPatternClient client = new ProxyPatternClient(new CacheProxy(new RealSubject()));

        client.execute();
        client.execute();
        client.execute();
    }
}

package hello.advanced.trace;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TraceId {

    private String id;
    private int level;

    @PostConstruct
    public void init() {
        this.id = createId();
        this.level = 0;
    }

    private String createId () {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId () {
        return id;
    }

    public void levelUp() {
        this.level++;
    }

    public void levelDown() {
        this.level--;
    }

    public int getLevel () {
        return level;
    }
}

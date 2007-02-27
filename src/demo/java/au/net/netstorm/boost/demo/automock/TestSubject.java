package au.net.netstorm.boost.demo.automock;

import java.io.DataInput;
import java.util.Map;

public interface TestSubject {
    void executeGet(Map map);

    void executePut(Map map, DataInput[] dataInputs);
}

package au.net.netstorm.boost.nursery.typetokens;

import java.util.List;

public class DefaultSampleFactoryClient implements SampleFactoryClient {
    SampleFactoryMethod factory;
    TypeR<List<String>> type;

    public List<String> useFactory() {
        List<String> list = factory.nu(type);
        list.add("I work");
        return list;
    }
}

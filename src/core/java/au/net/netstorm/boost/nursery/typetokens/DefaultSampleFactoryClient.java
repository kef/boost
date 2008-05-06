package au.net.netstorm.boost.nursery.typetokens;


public class DefaultSampleFactoryClient implements SampleFactoryClient {
    SampleFactoryMethod factory;
    TypeR<SampleGeneric<String>> type;

    public SampleGeneric<String> useFactory() {
        return factory.nu(type);
    }
}

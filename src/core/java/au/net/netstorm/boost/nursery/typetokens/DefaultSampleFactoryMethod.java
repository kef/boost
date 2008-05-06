package au.net.netstorm.boost.nursery.typetokens;


public final class DefaultSampleFactoryMethod implements SampleFactoryMethod {
    public <T> T nu(TypeR<T> type) {
        return type.nu();
    }
}

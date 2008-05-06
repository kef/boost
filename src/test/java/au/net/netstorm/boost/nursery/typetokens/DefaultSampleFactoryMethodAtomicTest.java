package au.net.netstorm.boost.nursery.typetokens;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultSampleFactoryMethodAtomicTest extends LifecycleTestCase implements InjectableTest, LazyFields {
    SampleFactoryMethod subject;
    TypeR<Object> typeMock;

    public void testNu() {
        expect.oneCall(typeMock, new Object(), "nu");
        subject.nu(typeMock);
    }
}

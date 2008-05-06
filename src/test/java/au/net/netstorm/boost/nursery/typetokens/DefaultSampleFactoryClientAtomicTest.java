package au.net.netstorm.boost.nursery.typetokens;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultSampleFactoryClientAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private SampleFactoryClient subject;
    SampleFactoryMethod factoryMock;
    TypeR<SampleGeneric<String>> typeMock;
    SampleGeneric<String> sampleMock;

    public void setUpFixtures() {
        subject = new DefaultSampleFactoryClient();
    }

    public void testUseFactory() {
        expect.oneCall(factoryMock, sampleMock, "nu", typeMock);
        SampleGeneric<String> result = subject.useFactory();
        assertSame(sampleMock, result);
    }

}

package au.net.netstorm.boost.nursery.typetokens;

import java.util.List;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public class DefaultSampleFactoryClientAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private SampleFactoryClient subject;
    SampleFactoryMethod factoryMock;
    TypeR<List<String>> typeMock;
    List<String> listMock;

    public void setUpFixtures() {
        subject = new DefaultSampleFactoryClient();
    }

    public void testUseFactory() {
        expect.oneCall(factoryMock, listMock, "nu", typeMock);
        expect.oneCall(listMock, true, "add", "I work");
        List<String> result = subject.useFactory();
        assertSame(listMock, result);
    }

}

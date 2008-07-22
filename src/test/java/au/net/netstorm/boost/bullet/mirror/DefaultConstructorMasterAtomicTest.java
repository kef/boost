package au.net.netstorm.boost.bullet.mirror;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;

public final class DefaultConstructorMasterAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableTest, LazyFields {
    private Implementation impl = new DefaultImplementation(String.class);
    FieldTestUtil fielder;
    EdgeClass classer;
    ConstructorMaster subject;
    ReflectMaster reflectorMock;

    public void setUpFixtures() {
        fielder.setInstance(subject, "reflector", reflectorMock);
    }

    public void testGetGenericParameterTypes() {
        Constructor<String> constructor = classer.getConstructor(String.class, char[].class);
        Type[] expected = constructor.getGenericParameterTypes();
        expect.oneCall(reflectorMock, constructor, "getConstructor", impl);
        Type[] actual = subject.getGenericParameterTypes(impl);
        assertEquals(expected, actual);
    }
}

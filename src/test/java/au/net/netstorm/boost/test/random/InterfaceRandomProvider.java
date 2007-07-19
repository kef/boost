package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.reflect.DefaultInstantiatorWithProvider;
import au.net.netstorm.boost.reflect.InstantiatorWithProvider;
import au.net.netstorm.boost.test.automock.AutoMocker;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX 2076 Drive this out
public final class InterfaceRandomProvider implements SpecificProvider {
    private static final Interface DATA = new DefaultInterface(Data.class);
    private final InstantiatorWithProvider instantiator = new DefaultInstantiatorWithProvider();
    private final au.net.netstorm.boost.util.impl.ImplMaster implMaster = new DefaultImplMaster();
    private final TypeMaster typeMaster = new DefaultTypeMaster();
    private final DataProviders dataProviders;
    private final Provider randomProvider;
    private final AutoMocker mocker;

    public InterfaceRandomProvider(Provider randomProvider, DataProviders dataProviders, AutoMocker mocker) {
        this.randomProvider = randomProvider;
        this.dataProviders = dataProviders;
        this.mocker = mocker;
    }

    public boolean canProvide(Class type) {
        return type.isInterface();
    }

    public Object provide(Class type) {
        Interface iface = popIfNotInterface(type);
        if (isProvided(type)) return providedImpl(type);
        if (isDataWithImpl(iface)) return defaultImpl(iface);
        return mock(type);
    }

    private Interface popIfNotInterface(Class type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        return new DefaultInterface(type);
    }

    private boolean isProvided(Class type) {
        return dataProviders.canProvide(type);
    }

    private Object providedImpl(Class type) {
        return dataProviders.provide(type);
    }

    private boolean isDataWithImpl(Interface iFace) {
        if (!typeMaster.extendz(iFace, DATA)) return false;
        return implMaster.hasDefaultImpl(iFace);
    }

    private Object defaultImpl(Interface type) {
        Implementation impl = implMaster.defaultImpl(type);
        Class implClass = impl.getImpl();
        return instantiator.createInstance(implClass, randomProvider);
    }

    private Object mock(Class type) {
        return mocker.mock(type);
    }
}

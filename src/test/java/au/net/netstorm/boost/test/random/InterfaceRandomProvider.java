package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.reflect.DefaultInstantiatorWithProvider;
import au.net.netstorm.boost.reflect.InstantiatorWithProvider;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class InterfaceRandomProvider implements SpecificProvider {
    private static final Interface DATA = new DefaultInterface(Data.class);
    private final InstantiatorWithProvider instantiator = new DefaultInstantiatorWithProvider();
    private final au.net.netstorm.boost.util.impl.ImplMaster implMaster = new DefaultImplMaster();
    private final TypeMaster typeMaster = new DefaultTypeMaster();
    private final DataProviders dataProviders;
    private final Provider randomProvider;
    private final MockSupport mocks;

    public InterfaceRandomProvider(Provider randomProvider, DataProviders dataProviders, MockSupport mocks) {
        this.randomProvider = randomProvider;
        this.dataProviders = dataProviders;
        this.mocks = mocks;
    }

    public boolean canProvide(Class type) {
        return type.isInterface();
    }

    public Object provide(Class type) {
        Interface iface = popIfNotInterface(type);
        if (isProvided(type)) return providedImpl(type);
        if (isData(iface)) return defaultImpl(iface);
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

    private boolean isData(Interface iFace) {
        return typeMaster.extendz(iFace, DATA);
    }

    private Object defaultImpl(Interface type) {
        if (!implMaster.hasDefaultImpl(type)) throw new ImplementationNotFoundException(type);
        Implementation impl = implMaster.defaultImpl(type);
        Class implClass = impl.getImpl();
        return instantiator.createInstance(implClass, randomProvider);
    }

    private Object mock(Class type) {
        return mocks.mock(type);
    }
}

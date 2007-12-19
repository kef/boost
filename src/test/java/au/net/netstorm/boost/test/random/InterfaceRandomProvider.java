package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.reflect.DefaultInstantiatorWithProvider;
import au.net.netstorm.boost.reflect.InstantiatorWithProvider;
import au.net.netstorm.boost.test.automock.MockSupport;
import au.net.netstorm.boost.test.specific.DataProviders;
import au.net.netstorm.boost.test.specific.EnumProvider;
import au.net.netstorm.boost.util.impl.DefaultImplMapper;
import au.net.netstorm.boost.util.impl.DefaultImplMaster;
import au.net.netstorm.boost.util.impl.ImplMapper;
import au.net.netstorm.boost.util.impl.ImplMaster;
import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class InterfaceRandomProvider implements SpecificProvider {
    private static final Interface DATA = new DefaultInterface(Data.class);
    private final InstantiatorWithProvider instantiator = new DefaultInstantiatorWithProvider();
    // FIX 1914 Tidy this long winded mapper thread to get to impl master.
    private ImplMapper mapper = new DefaultImplMapper("Default");
    private ImplMapper[] mappers = {mapper};
    private final ImplMaster implMaster = new DefaultImplMaster(mappers);
    private final TypeMaster typeMaster = new DefaultTypeMaster();
    private final EnumProvider enumProviders;
    private final DataProviders dataProviders;
    private final Provider randomProvider;
    private final MockSupport mocks;

    public InterfaceRandomProvider(Provider randomProvider, DataProviders dataProviders, EnumProvider enumProviders, MockSupport mocks) {
        this.randomProvider = randomProvider;
        this.dataProviders = dataProviders;
        this.enumProviders = enumProviders;
        this.mocks = mocks;
    }

    public boolean canProvide(Class<?> type) {
        if (type.isInterface()) return true;
        if (type.isEnum()) return true;
        return false;
    }

    public <T> T provide(Class<T> type) {
        if (isProvided(type)) return providedImpl(type);
        Interface iface = popIfNotInterface(type);
        if (isData(iface)) {
            Object impl = defaultImpl(iface);
            return type.cast(impl);
        }
        return mock(type);
    }

    private Interface popIfNotInterface(Class type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        return new DefaultInterface(type);
    }

    private boolean isProvided(Class type) {
        if (dataProviders.canProvide(type)) return true;
        if (enumProviders.canProvide(type)) return true;
        return false;
    }

    private <T> T providedImpl(Class<T> type) {
        if (dataProviders.canProvide(type)) return dataProviders.provide(type);
        if (enumProviders.canProvide(type)) return enumProviders.provide(type);
        throw new IllegalArgumentException("" + type);
    }

    private boolean isData(Interface iFace) {
        return typeMaster.extendz(iFace, DATA);
    }

    private Object defaultImpl(Interface type) {
        if (!implMaster.hasImpl(type)) throw new ImplementationNotFoundException(type);
        Implementation impl = implMaster.impl(type);
        Class implClass = impl.getImpl();
        return instantiator.createInstance(implClass, randomProvider);
    }

    private <T> T mock(Class<T> type) {
        Object mock = mocks.mock(type);
        return type.cast(mock);
    }
}

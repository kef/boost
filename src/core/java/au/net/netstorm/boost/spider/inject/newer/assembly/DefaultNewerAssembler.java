package au.net.netstorm.boost.spider.inject.newer.assembly;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.spider.inject.newer.field.ClassToNuAssembler;
import au.net.netstorm.boost.spider.inject.newer.field.DefaultClassToNuAssembler;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerAssembler implements NewerAssembler {
    private final ClassToNuAssembler classToNuAssembler = new DefaultClassToNuAssembler();
    private final NewerProxySupplierAssembler newerSupplierAssembler = new DefaultNewerProxySupplierAssembler();
    private final ProviderEngine provider;

    public DefaultNewerAssembler(ProviderEngine provider) {
        this.provider = provider;
    }

    public Newer assemble(Interface type) {
        Class newerClass = type.getType();
        Implementation classToNu = classToNuAssembler.assemble(newerClass);
        NewerProxySupplier newerProxySupplier = newerSupplierAssembler.assemble(provider);
        return (Newer) newerProxySupplier.nu(type, classToNu);
    }
}

package au.net.netstorm.boost.spider.inject.newer.assembly;

import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.spider.inject.newer.field.ClassToNuAssembler;
import au.net.netstorm.boost.spider.inject.newer.field.DefaultClassToNuAssembler;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerAssembler implements NewerAssembler {
    private final ClassToNuAssembler classToNuAssembler = new DefaultClassToNuAssembler();
    private NewerProxySupplierAssembler newerSupplierAssembler = new DefaultNewerProxySupplierAssembler();

    public Object assemble(Interface type) {
        Class newerClass = type.getType();
        Implementation classToNu = classToNuAssembler.assemble(newerClass);
        NewerProxySupplier newerProxySupplier = newerSupplierAssembler.assemble();
        return newerProxySupplier.nu(type, classToNu);
    }
}

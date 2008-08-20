package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.Field;
import au.net.netstorm.boost.gunge.proxy.DefaultLayerFactory;
import au.net.netstorm.boost.gunge.proxy.LayerFactory;
import au.net.netstorm.boost.gunge.type.DefaultTypeMaster;
import au.net.netstorm.boost.gunge.type.TypeMaster;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.sledge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.instantiate.DefaultNuImpl;
import au.net.netstorm.boost.spider.instantiate.NuImpl;

public final class DefaultProxfierWirer implements ProxifierWirer {
    private final LayerFactory layers = new DefaultLayerFactory();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final EdgeField fielder = new DefaultEdgeField();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final NuImpl nuImpl;

    public DefaultProxfierWirer(ProviderEngine engine) {
        this.nuImpl = new DefaultNuImpl(engine);
    }

    public Proxifier get() {
        Proxifier proxifier = new DefaultProxifier();
        wire(proxifier);
        return proxifier;
    }

    private void wire(Proxifier proxifier) {
        setField(proxifier, "proxies", layers);
        setField(proxifier, "typer", typer);
        setField(proxifier, "nuImpl", nuImpl);
    }

    private void setField(Proxifier proxifier, String name, Object ref) {
        Field field = classer.getDeclaredField(DefaultProxifier.class, name);
        field.setAccessible(true);
        fielder.set(field, proxifier, ref);
    }
}

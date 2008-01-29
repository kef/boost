package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.instantiate.DefaultNu;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.TypeMaster;

import java.lang.reflect.Field;

public final class DefaultProxfierWirer implements ProxifierWirer {
    private final ProxyFactory proxies = new DefaultProxyFactory();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final EdgeField fielder = new DefaultEdgeField();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Nu nu;

    public DefaultProxfierWirer(ProviderEngine engine) {
        this.nu = new DefaultNu(engine);
    }

    public Proxifier get() {
        Proxifier proxifier = new DefaultProxifier();
        wire(proxifier);
        return proxifier;
    }

    private void wire(Proxifier proxifier) {
        setField(proxifier, "proxies", proxies);
        setField(proxifier, "typer", typer);
        setField(proxifier, "nu", nu);
    }

    private void setField(Proxifier proxifier, String name, Object ref) {
        Field field = classer.getDeclaredField(DefaultProxifier.class, name);
        field.setAccessible(true);
        fielder.set(field, proxifier, ref);
    }
}

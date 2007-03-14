package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.demo.pebble.newer.DefaultPebbleProviderAssembler;
import au.net.netstorm.boost.demo.pebble.newer.PebbleProviderAssembler;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.test.automock.BoooostCase;

public final class FieldResolverDemoTest extends BoooostCase {
    private final ExplicitResolver resolver = new DefaultExplicitResolver();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Field field = classer.getDeclaredField(JuicyPebble.class, "someOneIKnow");
    private final LazyBastard lazareetus = new Larry();
    private final PebbleProviderAssembler assembler = new DefaultPebbleProviderAssembler();
    private final PebbleProvider provider = assembler.assemble();
    private FieldResolver subject;

    protected void setUp() throws Exception {
        resolver.add(LazyBastard.class, Larry.class);
        subject = new DefaultFieldResolver(resolver, provider);
    }

    public void testResolve() {
        // FIX BREADCRUMB 1715 Complete me.
        Object resolved = subject.resolve(field);
        assertEquals(lazareetus, resolved);
    }
}

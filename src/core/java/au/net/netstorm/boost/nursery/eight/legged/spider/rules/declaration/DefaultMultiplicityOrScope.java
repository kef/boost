package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

public final class DefaultMultiplicityOrScope implements MultiplicityOrScope {
    private final RuleBuilder builder;

    public DefaultMultiplicityOrScope(RuleBuilder builder) {
        this.builder = builder;
    }

    public void asSingle() {
        builder.setIsSingleton();
    }

    public Multiplicity in(Class<?> host) {
        return in(host, ANY_NAME);
    }

    public Multiplicity in(Class<?> host, String name) {
        builder.setScope(host, name);
        return this;
    }

    public Multiplicity in(String name) {
        return in(ANY_HOST, name);
    }
}

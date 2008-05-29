package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

public interface Scope {
    Multiplicity in(Class<?> host);

    Multiplicity in(Class<?> host, String name);

    Multiplicity in(String name);
}
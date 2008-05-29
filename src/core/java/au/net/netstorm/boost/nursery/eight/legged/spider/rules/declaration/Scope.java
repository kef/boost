package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

public interface Scope {
    Class<?> ANY_HOST = Any.class;

    String ANY_NAME = new String(new char[0]);

    Multiplicity in(Class<?> host);

    Multiplicity in(Class<?> host, String name);

    Multiplicity in(String name);
}
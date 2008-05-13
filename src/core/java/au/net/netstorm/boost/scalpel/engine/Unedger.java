package au.net.netstorm.boost.scalpel.engine;

interface Unedger {
    Object[] unedge(Object[] edged);

    Class<?>[] unedge(Class<?>[] edged);
}

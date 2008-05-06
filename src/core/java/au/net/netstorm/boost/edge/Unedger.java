package au.net.netstorm.boost.edge;

interface Unedger {
    Object[] unedge(Object[] edged);

    Class<?>[] unedge(Class<?>[] edged);
}

package au.net.netstorm.boost.edge.guts;

interface Unedger {
    Object[] unedge(Object[] edged);

    Class<?>[] unedge(Class<?>[] edged);
}

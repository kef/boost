package au.net.netstorm.boost.scalpel.guts;

interface Unedger {
    Object[] unedge(Object[] edged);

    Class<?>[] unedge(Class<?>[] edged);
}

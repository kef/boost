package au.net.netstorm.boost.nursery.autoedge;

interface Unedger {
    Object[] unedge(Object[] edged);

    Class<?>[] unedge(Class<?>[] edged);
}

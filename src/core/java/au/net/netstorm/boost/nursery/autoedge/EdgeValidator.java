package au.net.netstorm.boost.nursery.autoedge;

interface EdgeValidator {
    <E extends Edge<?>> void validate(Class<E> edge);
}

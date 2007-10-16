package au.net.netstorm.boost.test.marker;

public class DefaultMarker implements Marker {
    public boolean is(Object ref, Class marker) {
        Class cls = ref.getClass();
        return marker.isAssignableFrom(cls);
    }
}

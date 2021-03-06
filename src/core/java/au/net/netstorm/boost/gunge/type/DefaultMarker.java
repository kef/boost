package au.net.netstorm.boost.gunge.type;

public class DefaultMarker implements Marker {
    public boolean is(Object ref, Class marker) {
        Class cls = ref.getClass();
        return marker.isAssignableFrom(cls);
    }
}

package au.net.netstorm.boost.test.timing;

// FIX 2000 Use or Lose.
public class DefaultTimingSupport implements TimingSupport {
    public void time(Class cls, String method, long start, long end) {
        // FIX 2000 Complete me.
        // FIX 2000 Delete the buffer stuff below...
        StringBuffer buffer = new StringBuffer();
        buffer.append(" cls: " + cls);
        buffer.append(" method: " + method);
        buffer.append(" start: " + start);
        buffer.append(" end: " + end);
        buffer.append(" duration: " + (end - start));
    }
}

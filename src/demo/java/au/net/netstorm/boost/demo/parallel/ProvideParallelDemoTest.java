package au.net.netstorm.boost.demo.parallel;

public class ProvideParallelDemoTest extends ParallelTest {
    Integer threads = 10;

    public void testProvider() {
        Blobs blobs = resolve();
        checkProvide(blobs);
    }

    private Blobs resolve() {
        LavaLamp lamp = (LavaLamp) provider.provide(DefaultLavaLamp.class);
        return lamp.getBlobs();
    }

    public void testProvideCount() {
        int actual = DefaultLavaLamp.counter;
        assertEquals(threads, actual);
    }

    private void checkProvide(Blobs blobs) {
        boolean actual = blobs != null;
        assertEquals(true, actual);
    }
}

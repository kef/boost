package au.net.netstorm.boost.demo.parallel;

public class DefaultLavaLamp implements LavaLamp {
    public static final Object LOCK = new Object();
    public static int counter = 0;
    Blobs blobs;

    public Blobs getBlobs() {
        synchronized (LOCK) {
            counter++;
        }
        return blobs;
    }
}

package au.net.netstorm.boost.util.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.Assert;

// FIXME: SC506 Make instance instead of static.
// FIXME: SC506 ? Surely there is a full serialise production class.
public class SerializationTestUtil extends Assert {
    public static void checkSerializable(Object instance) {
        try {
            doCheckSerializable(instance);
        } catch (Exception e) {
            throw new RuntimeException("Object instance could not be serialized. " + instance.getClass(), e);
        }
    }

    private static void doCheckSerializable(Object instance) throws Exception {
        byte[] serialized = serialize(instance);
        Object rehydrated = deserialize(serialized);
        assertEquals(instance, rehydrated);
    }

    private static Object deserialize(byte[] buf) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }

    private static byte[] serialize(Object instance) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance);
        return baos.toByteArray();
    }
}

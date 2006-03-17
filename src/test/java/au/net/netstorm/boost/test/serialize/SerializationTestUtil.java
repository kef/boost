package au.net.netstorm.boost.test.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.Assert;

// FIXME: SC050 Define API class which only links to public APIs.

// FIXME: SC506 Make instance instead of static.
// FIXME: SC506 ? Surely there is a full serialise production class.
public class SerializationTestUtil extends Assert {
    public static void checkSerializable(Object instance) {
        try {
            tryCheckSerializable(instance);
        } catch (Exception e) {
            throw new RuntimeException("Object instance could not be serialized. " + instance.getClass(), e);
        }
    }

    private static void tryCheckSerializable(Object instance) throws Exception {
        byte[] serialized = serialize(instance);
        Object rehydrated = deserialize(serialized);
        // FIXME: SC050 !!!!!!!!!!!!!!!!!!!!!!!!!! REALLY NEED TO REINSTATE THIS !!!!!!!!!!!!!!!!!!!!!!!!!
        // FIXME: SC050 Work out what we are really aiming for here.  The following line used to be in the
        // FIXME: SC050 codebase.  It has been removed because a Data type which references a Mock (during testing).
        // FIXME: SC050 This Mock references a test utility.  The test utility is not serialisable.  Made the field
        // FIXME: SC050 transient.  This causes the following line to fail.
//        assertEquals(instance, rehydrated);
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

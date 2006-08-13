package au.net.netstorm.boost.test.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.Assert;

public class DefaultSerializationTestChecker implements SerializationTestChecker {
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
        Assert.assertEquals(instance, rehydrated);
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

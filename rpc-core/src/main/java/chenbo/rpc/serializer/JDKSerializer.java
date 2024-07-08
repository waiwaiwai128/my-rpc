package chenbo.rpc.serializer;

import java.io.*;

/**
 * 使用JDK的序列化器
 */

public class JDKSerializer implements CommonSerializer{
    @Override
    public byte[] serialize(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object to be serialized is null");
        }
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(obj);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error occurred during serialization", e);
        }
    }

    @Override
    public Object deserialize(byte[] bytes, Class<?> clazz) {
        if (bytes == null || bytes.length == 0) {
            throw new IllegalArgumentException("Byte array to be deserialized is null or empty");
        }
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error occurred during deserialization", e);
        }
    }

    @Override
    public int getCode() {
        return 0;
    }
}

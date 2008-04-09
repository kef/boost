package au.net.netstorm.boost.gunge.equals;

class ByteArrayTestObject {
    private byte[] buffer;

    public ByteArrayTestObject(byte[] buffer) {
        this.buffer = buffer;
    }

    public String toString() {
        return "For Checkstyle ArrayTestObject[aBuffer=" + new String(buffer) + "]";
    }
}

package au.net.netstorm.boost.type.util.bytes;

public final class DefaultBytesSplitter implements BytesSplitter {
    public byte[] split(byte[] input, int start, byte delimiter) {
        int delimiterPosition = findDelimiterPosition(input, start, delimiter);
        return getBytes(input, start, delimiterPosition);
    }

    private int findDelimiterPosition(byte[] input, int start, byte delimiter) {
        int index = start;
        while (index < input.length && input[index] != delimiter) {
            index++;
        }
        return index;
    }

    private byte[] getBytes(byte[] input, int start, int delimiterPosition) {
        int resultLength = delimiterPosition - start;
        byte[] result = new byte[resultLength];
        System.arraycopy(input, start, result, 0, resultLength);
        return result;
    }
}

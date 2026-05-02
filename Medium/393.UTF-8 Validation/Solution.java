class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int byte0 = data[i] & 0xFF;
            int numBytes;

            if ((byte0 & 0x80) == 0) {
                numBytes = 1;
            } else if ((byte0 & 0xE0) == 0xC0) {
                numBytes = 2;
            } else if ((byte0 & 0xF0) == 0xE0) {
                numBytes = 3;
            } else if ((byte0 & 0xF8) == 0xF0) {
                numBytes = 4;
            } else {
                return false;
            }

            for (int j = 1; j < numBytes; j++) {
                if (i + j >= data.length) return false;
                if ((data[i + j] & 0xC0) != 0x80) return false;
            }

            i += numBytes;
        }
        return true;
    }
}
package no158ReadNCharactersGivenRead4II;

class Reader4 {
	int read4 (char[] buffer) {
		return 0;
	} // fake
}

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    private int pointer = 0, counter = 0;
    private char[] buffer = new char[4];
    
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pointer == 0) {
                counter = read4(buffer);
            }
            if (counter == 0) break;
            while (index < n && pointer < counter) {
                buf[index++] = buffer[pointer++];
            }
            if (pointer == counter) pointer = 0;
        }
        return index;
    }
}
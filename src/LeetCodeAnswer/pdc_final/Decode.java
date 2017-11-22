package LeetCodeAnswer.pdc_final;
import java.math.BigInteger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;

public class Decode {
	private static String decode(String key, String message) {
		if (message == null || message.length() == 0) return "";
		String xString = "12389084059184098308123098579283204880956800909293831223134798257496372124879237412193918239183928140";
		char[] xChar = xString.toCharArray();
		char[] yChar = key.toCharArray();
		char[] messageChar = message.toCharArray();

		int xLength = xChar.length;
		int yLength = yChar.length;
		if (xLength < yLength) return "INVALID";
		int triangleLength = (int) Math.sqrt((2 * messageChar.length - 1));
		if ((1 + triangleLength) * triangleLength / 2 != messageChar.length) return "INVALID";
		int[] z = new int[yLength];
		
		// digit add 
		for (int j = 0; j < yLength; j++) {
			if (yChar[j] < '0' || yChar[j] > '9') return "INVALID";
			z[j] = (Character.getNumericValue(xChar[j]) + Character
					.getNumericValue(yChar[j])) % 10;
		}
		for (int i = 1; i < xLength - yLength + 1; i++) {
			for (int j = 0; j < yLength; j++) {
				z[j] = (Character.getNumericValue(xChar[i + j]) + z[j]) % 10;
			}
		}
		BigInteger k = BigInteger.valueOf(0);
		for (int i = 0; i < yLength; i++) {
			k = k.multiply(BigInteger.valueOf(10))
					.add(BigInteger.valueOf(z[i]));
		}

		int k_final = 1 + k.mod(BigInteger.valueOf(25)).intValue();

		// reverse shift to produce I
		for (int i = 0; i < messageChar.length; i++) {
			if (messageChar[i] < 'A' || messageChar[i] > 'Z') return "INVALID";
			char c = (char) (messageChar[i] - k_final);
			messageChar[i] = (char) (c < 'A' ? c + 26 : c);
		}
		
		return revSpiralize(new String(messageChar));
	}

	public static String revSpiralize(String message) {
        int size = ((int)Math.sqrt(8*message.length()+1)-1)/2;
        StringBuilder[] sbs = new StringBuilder[size];
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        int counter = 0;
        int step = size;
        for(int i = 0; i < message.length();){
            for(int j = 0; j < step; j++) {
                sbs[2*counter+j].insert(counter, message.charAt(i+j));
            }
            i += step--;
            if(i == message.length()){
                break;
            }
            for(int j = 0; j < step; j++) {
                sbs[size-1-counter].insert(counter+j+1, message.charAt(i+j));
            }
            i += step--;
            if(i == message.length()){
                break;
            }
            for(int j = 0; j < step; j++) {
                StringBuilder sb = sbs[size-2-counter-j];
                sb.insert(sb.length()-counter, message.charAt(i+j));
            }
            i += step--;
            if(i == message.length()){
                break;
            }
            counter++;
        }
        StringBuilder result = new StringBuilder();
        for(int i = size-1; i >= 0; i--){
            for(int j = i; j < size; j++){
                result.append(sbs[j].charAt(i));
            }
        }
        return result.toString();
    }
	
	public static void main(String[] args) throws IOException {
//		System.out.println(decode("1239793247987948712739187492308012309184023849817397189273981723912221", "QTGXGTHWEQENWQVKPIRFO"));
		String csvFile = "/Users/Fernando/Desktop/test/p3_q1_p2.tsv";
		FileWriter writer = new FileWriter(csvFile);
		Instant start = Instant.now();
		Random random = new Random();
		int[] messageLength = {10,15,21,28,36};
		for (int i = 0; i < 50000000; i++) {
			String message = RandomStringUtils.randomAlphabetic(messageLength[random.nextInt(5)]).toUpperCase();
			String key = RandomStringUtils.randomNumeric(70 + random.nextInt(20));
			CSVUtils.writeLine(writer, Arrays.asList(key, message, decode(key, message)));
		}
		int[] invalid = {2,9,22,27,35,30,44};
		// invalid message length
		for (int i = 0; i < 1000000; i++) {
			String message = RandomStringUtils.randomAlphabetic(invalid[random.nextInt(7)]).toUpperCase();
			String key = RandomStringUtils.randomNumeric(70 + random.nextInt(20));
			CSVUtils.writeLine(writer, Arrays.asList(key, message, decode(key, message)));
		}
		// invalid key length
		for (int i = 0; i < 1000000; i++) {
			String message = RandomStringUtils.randomAlphabetic(messageLength[random.nextInt(5)]).toUpperCase();
			String key = RandomStringUtils.randomNumeric(105 + random.nextInt(10));
			CSVUtils.writeLine(writer, Arrays.asList(key, message, decode(key, message)));
		}
		// invalid message content
		for (int i = 0; i < 1000000; i++) {
			String message = RandomStringUtils.randomAlphanumeric(messageLength[random.nextInt(5)]);
			String key = RandomStringUtils.randomNumeric(70 + random.nextInt(20));
			CSVUtils.writeLine(writer, Arrays.asList(key, message, decode(key, message)));
		}
		// invalid key content
		for (int i = 0; i < 1000000; i++) {
			String message = RandomStringUtils.randomAlphabetic(messageLength[random.nextInt(5)]).toUpperCase();
			String key = RandomStringUtils.randomAlphanumeric(70 + random.nextInt(20));
			CSVUtils.writeLine(writer, Arrays.asList(key, message, decode(key, message)));
		}
		
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken for the entire process: "+ timeElapsed.toMillis() +" milliseconds");
		writer.flush();
		writer.close();
	}
}

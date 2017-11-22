package LeetCodeAnswer.pgoa;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class LogParser {

    /**
     * Tests the method parseFile with an example test-case.
     * This method is completely for your own testing and is NOT
     * called/used while grading your answer.
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
        	filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
    	 *  Don't modify this function
    	 */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }
    
    private static Date stringToDate(String dateString) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy-hh:mm:ss");
    	Date date = new Date();
    	try {
    		date = dateFormat.parse(dateString);
    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
    	return date;
    }
    
    static String parseLines(String[] lines) {
    	HashMap<String, Integer> status = new HashMap<String, Integer>();
    	status.put("START", 0);
    	status.put("CONNECTED", 1);
    	status.put("DISCONNECTED", -1);
    	status.put("SHUTDOWN", -1);
    	List<Date> dates = new ArrayList<Date>();
    	List<String> events = new ArrayList<String>();
    	for (int i = 0; i < lines.length; i++) {
    		String[] strs = lines[i].split(" :: ");
    		if (strs.length < 2) continue;
    		if (!status.containsKey(strs[1])) continue;
    		dates.add(stringToDate(strs[0].substring(1, strs[0].length() - 1)));
    		events.add(strs[1]);
    	}
    	if (dates.size() == 0) return "Invalid input!";
    	long totalTime = dates.get(dates.size() - 1).getTime() - dates.get(0).getTime();
    	long connectedTime = 0, lastTime = 0;
    	for (int i = 0; i < dates.size(); i++) {
    		long currentTime = dates.get(i).getTime();
    		String currentEvent = events.get(i);
    		if (status.get(currentEvent) > 0) {
    			lastTime = currentTime;
    		} else if (lastTime > 0) {
    			connectedTime += currentTime - lastTime;
    			lastTime = -1;
    		}
    	}
    	
    	double ratio = (double) connectedTime / totalTime * 100;
    	String res = String.format("%d%s", (int) ratio, "%");
        return res;
    }
}

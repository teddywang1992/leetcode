package pgoa;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.HashMap;

public class PathFinder {

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
        
        List<String> answer = parseFile(filename);
        System.out.println(answer);
    }
    
    static List<String> parseFile(String filename)
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

        return parseLines(allLines);    	
    }
    
    static List<String> parseLines(List<String> lines) {

        List<String> res = new ArrayList<String>();
        HashSet<String> visited = new HashSet<String>();
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        if (lines == null || lines.size() == 0) return res;
        String[] input = lines.get(0).split(" ");
        if (input.length < 2) return res;
        String start = input[0], end = input[1];
        for (int i = 1; i < lines.size(); i++) {
        	String line = lines.get(i);
        	String[] nodes = line.trim().split(":");
        	List<String> list = new ArrayList<String>();
        	if (nodes.length >= 2) {
        		list = Arrays.asList(nodes[1].trim().split(" "));
        	}
        	graph.put(nodes[0].trim(), list);
        }
        traverse(start, end, "", visited, res, graph);
    	return res;
    }
    
    private static void traverse(String start, String end, String path, HashSet<String> visited, List<String> res, HashMap<String, List<String>> graph) {
    	String current = path;
    	current += start;
    	visited.add(start);
    	if (start.equals(end)){
    		res.add(current);
    	} else {
    		List<String> list = graph.get(start);
    		if (list != null) {
    			for (String str : list) {
    				if (!visited.contains(str)) {
    					traverse(str, end, current, visited, res, graph);
    				}
    			}
    		}
    	}
    	visited.remove(start);
    }
}

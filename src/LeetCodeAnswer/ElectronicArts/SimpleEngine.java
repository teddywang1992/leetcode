package LeetCodeAnswer.ElectronicArts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SimpleEngine {

	private static Scanner input;

	public static void main(String[] args) {
		SimpleEngine simpleEngine = new SimpleEngine();
		input = new Scanner(System.in);
		while (input.hasNextLine()) {
			simpleEngine.process(input.nextLine());
		}
		// simpleEngine
		// .process("'text:(file=testcase3_input.csv,schema=<date:string,game:string,platform:string,active_users_count:int,new_users_count:int,retained_users_count:int,churned_users_count:int>)?_dimensions=game&_metrics=sum(active_users_count),sum(new_users_count)&platform=ps4,xbox_one&_sort=game&_format=json'");
	}

	private void process(String line) {
		String input = line.split("\\?")[0], query = line.split("\\?")[1];
		query = query.substring(0, query.length() - 1);
		input = input.split("\\(")[1].split("\\)")[0];
		String file = input.split(",")[0].split("file=")[1];
		String[] schema = input.split("schema=<")[1].split(">")[0].split(",");
		int dimensionIndex = 0, metricIndex = 0;
		HashMap<String, Integer> dimensionMap = new HashMap<>(), metricMap = new HashMap<>();
		for (String str : schema) {
			String[] strs = str.split(":");
			if (strs[1].equals("string")) {
				dimensionMap.put(strs[0], dimensionIndex++);
			} else {
				metricMap.put(strs[0], metricIndex++);
			}
		}

		List<List<String>> dimensions = new ArrayList<>();
		List<List<Integer>> metrics = new ArrayList<>();
		BufferedReader br = null;
		String l = "";
		try {
			InputStream in = SimpleEngine.class.getResourceAsStream(file);
			br = new BufferedReader(new InputStreamReader(in));
			while ((l = br.readLine()) != null) {
				String[] inputs = l.split(",");
				List<Integer> metric = new ArrayList<>();
				List<String> dimension = new ArrayList<>();
				for (String str : inputs) {
//					if ((str.replace(",", ""))) {
//						metric.add(Integer.parseInt(str));
//					} else {
//						dimension.add(str);
//					}
				}
				dimensions.add(dimension);
				metrics.add(metric);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println(dimensions.size());
		System.out.println(query);
		String[] queries = query.split("&");
		String[] queryDimensions;
		String[] queryMetrics;
		String[] sorts;
		String format;
		HashMap<String, Set<String>> otherQueries = new HashMap<>();
		for (String q : queries) {
			String[] strs = q.split("=");
			if (strs[0].equals("_dimensions")) {
				queryDimensions = strs[1].split(",");
			} else if (strs[0].equals("_metrics")) {
				queryMetrics = strs[1].split(",");
			} else if (strs[0].equals("_sort")) {
				sorts = strs[1].split(",");
			} else if (strs[0].equals("_format")) {
				format = strs[1];
			} else {
				otherQueries.put(strs[0],
						new HashSet<String>(Arrays.asList(strs[1].split(","))));
			}
		}
		List<Result> res = new ArrayList<>();
		for (int i = 0; i < dimensions.size(); i++) {
			for (String key : otherQueries.keySet()) {
				String str = dimensions.get(i).get(dimensionMap.get(key));
				if (!otherQueries.get(key).contains(str)) continue;
			}
			Result result = new Result();
			// unfinished
		}
	}

	class Result {
		List<String> resDimensions = new ArrayList<>();
		List<Integer> resMetrics = new ArrayList<>();

		public Result() {

		}
	}
}

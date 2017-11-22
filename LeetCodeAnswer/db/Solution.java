package db;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
//dfs+hash
class Solution {
	public static void main(String[] args) {}
	static List<List<String>> findDuplicates(String path) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (path != null && path.length() > 0) {
			List<List<String>> files = findFileOfSameSize(path);
			for (List<String> filegroup : files) {
				HashMap<String, List<String>> h = new HashMap<String, List<String>>();
				HashSet<String> s = new HashSet<String>();
				for (String f : filegroup) {
					String hash = checksum(f);
					if (!h.containsKey(hash)) {
						h.put(hash, new ArrayList<String>());
					}
					h.get(hash).add(f);
					if (h.get(hash).size() > 1) {
						s.add(hash);
					}
				}
				for (String hash : s) {
					res.add(h.get(hash));
				}
			}
		}
		return res;
	}

	static List<List<String>> findFileOfSameSize(String path) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (path != null && path.length() > 0) {
			Stack<String> s = new Stack<String>();
			s.push(path);
			HashMap<Integer, List<String>> h = new HashMap<Integer, List<String>>();
			HashSet<Integer> set = new HashSet<Integer>();
			while (!s.empty()) {
				String cur = s.pop();
				if (!isDir(cur)) {
					int size = getFileSize(cur);
					if (!h.containsKey(size)) {
						h.put(size, new ArrayList<String>());
					}
					h.get(size).add(cur);
					if (h.get(size).size() > 1) {
						set.add(size);
					}
				} else {
					List<String> children = listDir(cur);
					for (String child : children) {
						s.push(child);
					}
				}
			}
			for (Integer size : set) {
				res.add(h.get(size));
			}
		}
		return res;
	}

	// /foo/bar.txt -> 'hello'
	// /baz.txt -> 'bye'
	// /bat.txt -> 'hello'
	// /three.four -> 'hello'
	// '/' -> [['/foo/bar.txt', '/baz.txt', '/three.four']]
	public static String checksum(String path) {
		return "";
	}

	public static boolean isDir(String path) {
		return false;
	}

	public static int getFileSize(String filePath) {
		return 0;
	}

	public static List<String> listDir(String path) {
		return null;
	}
}
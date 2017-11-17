package FacebookInterview;

import java.util.*;

public class AccountMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> emailToNeighbors = new HashMap<>();
        Set<String> emails = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                emails.add(email);
                emailToNeighbors.putIfAbsent(email, new HashSet<>());
                if (i == 1) continue;

                emailToNeighbors.get(account.get(i - 1)).add(email);
                emailToNeighbors.get(email).add(account.get(i - 1)); //init the graph
            }
        }

        for (String email : emails) {
            if (!visited.contains(email)) {
                visited.add(email);
                List<String> buffer = new ArrayList<>();
                buffer.add(email);
                helper(email, buffer, visited, emailToNeighbors);
                Collections.sort(buffer);
                buffer.add(0, emailToName.get(email));
                result.add(buffer);
            }
        }

        return result;
    }

    private void helper(String email, List<String> buffer, Set<String> visited, Map<String, Set<String>> map) {
        for (String neighbor : map.get(email)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                buffer.add(neighbor);
                helper(neighbor, buffer, visited, map);
            }
        }
    }}

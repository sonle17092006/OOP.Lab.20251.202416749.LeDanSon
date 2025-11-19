
import java.util.*;

public class TokenFrequency {
    public static void main(String[] args) {

        // 1. Read all command-line parameters as a single string
        String input = String.join(" ", args).trim();

        if (input.isEmpty()) {
            System.out.println("{}");
            return;
        }

        // 2. Split into tokens using whitespace
        String[] tokens = input.split("\\s+");

        // 3. Count frequency using a map
        Map<String, Integer> freq = new HashMap<>();
        for (String t : tokens) {
            freq.put(t, freq.getOrDefault(t, 0) + 1);
        }

        // 4. Sort tokens alphabetically
        List<String> sortedKeys = new ArrayList<>(freq.keySet());
        Collections.sort(sortedKeys);

        // 5. Format output: {token1 = x, token2 = y, ...}
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < sortedKeys.size(); i++) {
            String key = sortedKeys.get(i);
            sb.append(key).append(" = ").append(freq.get(key));
            if (i < sortedKeys.size() - 1) sb.append(", ");
        }

        sb.append("}");
        System.out.println(sb.toString());
    }
}

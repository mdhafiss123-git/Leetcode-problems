import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        int[] rowMap = new int[26];
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        for (int r = 0; r < 3; r++) {
            for (char c : rows[r].toCharArray()) {
                rowMap[c - 'a'] = r;
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int targetRow = rowMap[lower.charAt(0) - 'a'];
            boolean isValid = true;

            for (int i = 1; i < lower.length(); i++) {
                if (rowMap[lower.charAt(i) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
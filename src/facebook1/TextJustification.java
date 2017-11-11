package facebook1;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;
        while(i < n){
            int j = i, len = -1;
            while(j < n && len + words[j].length() + 1 <= maxWidth){
                len += words[j++].length() + 1;
            }
            int numOfWords = j - i, numOfGaps = numOfWords - 1;
            int basicGaps = 1;
            int remainGaps = 0;
            if(j != n && numOfWords > 1){
                basicGaps = 1 + (maxWidth - len) / numOfGaps;
                remainGaps = (maxWidth - len) % numOfGaps;
            }
            StringBuilder sb = new StringBuilder(words[i]);
            for(int k = i + 1; k < j; k++){
                for(int g = 0; g < basicGaps; g++){
                    sb.append(" ");
                }
                if(remainGaps-- > 0){
                    sb.append(" ");
                }
                sb.append(words[k]);
            }
            int leftAlignGaps = maxWidth - sb.length();
            while(leftAlignGaps-- > 0){
                sb.append(" ");
            }
            res.add(sb.toString());
            i = j;
        }
        return res;
    }
}

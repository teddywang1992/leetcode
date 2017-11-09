package facebook2;

public class CheckSmile {
//    input could include ":(" frown or ":)" smileys
//    check if the input is parentheses balance
    class CheckBalanced {
        public boolean check(String message) {
            int closeParentheses = 0;
            int openParentheses = 0;
            int smileys = 0;
            int frowns = 0;
            boolean isPotentialEmotion = false;
            for (char letter : message.toCharArray()) {
                if (letter == '(') {
                    if (isPotentialEmotion) {
                        frowns++;
                    }
                    openParentheses++;
                }
                else if (letter == ')') {
                    if (isPotentialEmotion) {
                        smileys++;
                    }
                    closeParentheses++;
                }
                if (closeParentheses > openParentheses) {
                    if (closeParentheses - smileys > openParentheses) {
                        return false;
                    }
                    closeParentheses = openParentheses;
                    smileys = smileys - (closeParentheses - openParentheses);
                }
                if (letter == ':') {
                    isPotentialEmotion = true;
                }
                else {
                    isPotentialEmotion = false;
                }
            }
            if (openParentheses - frowns > closeParentheses) {
                return false;
            }
            return true;
        }
    }
}

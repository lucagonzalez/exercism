import java.util.Arrays;
import java.util.stream.Collectors;

class SqueakyClean {
    static String clean(String identifier) {
        var stringBuilder = new StringBuilder();
        var capitaliseNext = false;
        for (int i = 0; i < identifier.length(); i++) {
            var currChar = identifier.charAt(i);


            if (Character.isWhitespace(currChar)) {
                stringBuilder.append("_");
            } else if (Character.isDigit(currChar)) {
                var currentDigit = Character.digit(currChar, 10);
                switch (currentDigit) {
                    //4,3,0,1,7
                    case 0:
                        stringBuilder.append("o");
                        break;
                    case 1:
                        stringBuilder.append("l");
                        break;
                    case 3:
                        stringBuilder.append("e");
                        break;
                    case 4:
                        stringBuilder.append("a");
                        break;
                    case 7:
                        stringBuilder.append("t");
                        break;
                }
            } else if (!Character.isAlphabetic(currChar)) {
                if (Character.toString(currChar).equals("-")) {
                    capitaliseNext = true;
                }
            } else {
                if (capitaliseNext) {
                    capitaliseNext = false;
                    stringBuilder.append(Character.toUpperCase(currChar));
                } else {
                    stringBuilder.append(currChar);

                }
            }
        }

        return stringBuilder.toString();
    }

    static void test() {
        String[] wordArr = {"abc", "def", "ghijk"};

        Arrays.stream(wordArr).collect(Collectors.counting());
    }
}
package au.net.netstorm.boost.util.tostring;

// FIX  97432 Move over to boost.
public final class DefaultFrogger implements Frogger {
    private static final String DELIMETER = "_";
    private static final String SPACE = " ";

    public String froggify(String str) {
        String result = "";
        String[] tokens = str.split(DELIMETER);
        for (String token : tokens) {
            result += froggifyWord(token) + SPACE;
        }
        return result.trim();
    }

    private String froggifyWord(String word) {
        if (isEmpty(word)) return word;
        return initCap(word);
    }

    private boolean isEmpty(String word) {
        return "".equals(word);
    }

    private String initCap(String word) {
        String firstLetter = getFirstLetter(word);
        String restOfWord = getAllButFirstLetter(word);
        String lowered = restOfWord.toLowerCase();
        return firstLetter + lowered;
    }

    private String getFirstLetter(String word) {
        return word.substring(0, 1);
    }

    private String getAllButFirstLetter(String word) {
        int length = word.length();
        return word.substring(1, length);
    }
}

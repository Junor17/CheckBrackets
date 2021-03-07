public class Main {

    static int startSquareCount = 0, endSquareCount = 0,
            startRoundCount = 0, endRoundCount = 0,
            startFigureCount = 0, endFigureCount = 0;

    public static void main(String[] args) {

        String trueStr = "(s[om]e)";
        System.out.println(checkBrackets(trueStr)); //true

        String falseStr1 = ")k{o}r(";
        System.out.println(checkBrackets(falseStr1)); //false

        String falseStr2 = "{my(personal)";
        System.out.println(checkBrackets(falseStr2)); //false
    }

    static boolean checkBrackets(String str) {

        for (int i = 0; i < str.length(); i++) {
            addBracketCount(str.charAt(i));
            if (!checkSequence()) return false;
        }
        return checkCount();
    }

    private static void addBracketCount(char symbol) {
        if (symbol == '[') startSquareCount++;
        if (symbol == ']') endSquareCount++;
        if (symbol == '(') startRoundCount++;
        if (symbol == ')') endRoundCount++;
        if (symbol == '{') startFigureCount++;
        if (symbol == '}') endFigureCount++;
    }

    private static boolean checkSequence() {
        return startFigureCount >= endFigureCount && startRoundCount >= endRoundCount && startSquareCount >= endSquareCount;
    }

    private static boolean checkCount() {
        return startFigureCount == endFigureCount && startRoundCount == endRoundCount && startSquareCount == endSquareCount;
    }
}
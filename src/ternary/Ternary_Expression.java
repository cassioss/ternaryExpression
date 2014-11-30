package ternary;

/**
 * Created by Cassio dos Santos Sousa on Nov/29/2014.
 */

public class Ternary_Expression {

    /**
     * A method that verifies if a String is a valid ternary expression
     *
     * @param expression - a String containing a candidate for ternary expression
     * @return true if the String is a valid ternary expression
     */

    public static boolean verifyExpression(String expression) {

        /* Rejects null or empty expressions */

        if (isEmptyOrNull(expression))
            return false;

        /* Rejects expressions without question marks (?) or colons (:) */

        if (!expression.contains(":") || !expression.contains("?"))
            return false;

        /* Rejects expressions that have different amounts for colons and question marks
        * or that have colons before the question marks */

        if (!equalQuestionBeforeColon(expression))
            return false;

        /* Parse the expression at question marks or colons */

        String[] parse_question_colon = expression.split("[\\:\\?]");

        /* Rejects if the parsing has empty characters */

        if (emptyElementsIn(parse_question_colon))
            return false;

        /* If the expression goes through the entire method, the String is valid */

        return true;
    }

    private static boolean equalQuestionBeforeColon(String expression) {
        int counter = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?')
                counter++;
            else {
                if (expression.charAt(i) == ':')
                    counter--;
            }
            if (counter < 0)
                return false;
        }
        if (counter == 0)
            return true;
        return false;
    }

    /**
     * @param parsed - a String array that came after parsing a String
     * @return true if one of the elements is null or empty
     */

    private static boolean emptyElementsIn(String[] parsed) {
        for (int i = 0; i < parsed.length; i++) {
            if (isEmptyOrNull(parsed[i]))
                return true;
        }
        return false;

    }

    /**
     * @param ref - a String being verified
     * @return true if the String is null or empty
     */

    private static boolean isEmptyOrNull(String ref) {
        if (ref == null)
            return true;
        if (ref == "" || ref.length() == 0)
            return true;
        return false;
    }

    /**
     * @param expression - a String containing a valid ternary expression
     * @return exp - an Expression containing the tree for this string
     */

    public static Expression_Tree parseExpression(String expression) {
        Node root = new Node();

        Expression_Tree exp = new Expression_Tree(root);
        return exp;
    }

    public static void main(String[] args) {
        String s = "a?c:d";
        String[] s1 = s.split("\\?");
        for (int i = 0; i > s1.length; i++) {
            System.out.println(s1[i]);
        }
    }

}

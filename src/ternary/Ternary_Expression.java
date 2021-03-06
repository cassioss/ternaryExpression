package ternary;

import java.util.HashSet;

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

        String[] parse_question_colon = parseByColonQuestion(expression);

        /* Rejects if the parsing has empty characters */

        if (emptyElementsIn(parse_question_colon))
            return false;

        /* There is a chance that an expression with colons in the end may pass the last method */

        if (endsWithColonOrQuestion(expression))
            return false;

        /* Rejects expressions with duplicates */

        if (duplicatesIn(parse_question_colon))
            return false;

        /* If the expression goes through the entire method, the String is valid */

        return true;
    }

    /**
     * A method that parses a String by colons or question marks
     *
     * @param expression - an expression to be parsed
     * @return a String array containing the parsed expression
     */

    private static String[] parseByColonQuestion(String expression) {
        return expression.split("\\?|\\:");
    }

    /**
     * Looks if there are any duplicates on a String array
     *
     * @param parse_question_colon - a string array
     * @return true if duplicates are found
     */

    private static boolean duplicatesIn(String[] parse_question_colon) {

        HashSet<String> lump = new HashSet<String>();
        for (String s : parse_question_colon) {
            if (lump.contains(s)) return true;
            lump.add(s);
        }
        return false;

    }

    /**
     * See if the last element in a string is a colon or a question mark
     *
     * @param expression - an expression to be verified
     * @return true if the last character is a colon or a question mark
     */

    private static boolean endsWithColonOrQuestion(String expression) {
        char last_char = expression.charAt(expression.length() - 1);
        if (last_char == ':' || last_char == '?')
            return true;
        return false;
    }

    /**
     * Sees if a String has equal number of colons and question marks, having question marks always before the colons
     *
     * @param expression - a String to be verified in terms of having colons and question marks
     * @return true if the number of colons is equal to the number of question marks
     */

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
     * Sees if any elements in a String array are empty or null
     *
     * @param parsed - a String array parsed after a String of a ternary expression
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
     * Sees if a String is empty or null
     *
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

}

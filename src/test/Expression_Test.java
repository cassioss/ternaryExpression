package test;

import org.junit.Test;

import static org.junit.Assert.*;
import static ternary.Ternary_Expression.*;

public class Expression_Test {

    @Test
    public void testNull() {
        assertFalse(verifyExpression(null));
    }

    @Test
    public void testEmpty() {
        String this_is_empty = "";
        assertFalse(verifyExpression(this_is_empty));
    }

    @Test
    public void testEqualAmounts_Question_Colon() {
        String wrong1 = "2?4?e:b";
        String wrong2 = "a?c:v:b";
        String right1 = "a?b:c";
        String right2 = "a?b?c:d:e";
        assertFalse(verifyExpression(wrong1));
        assertFalse(verifyExpression(wrong2));
        assertTrue(verifyExpression(right1));
        assertTrue(verifyExpression(right2));
    }

    @Test
    public void testColonBeforeQuestion() {
        String wrong1 = "2:4?e";
        String wrong2 = "a:c?v?b:c";
        String right1 = "a?b:c";
        String right2 = "a?b?c:d:e";
        assertFalse(verifyExpression(wrong1));
        assertFalse(verifyExpression(wrong2));
        assertTrue(verifyExpression(right1));
        assertTrue(verifyExpression(right2));
    }

    @Test
    public void testEmptyParsing_QuestionOrColon() {
        String wrong1 = "2?c:";
        String wrong2 = "2?:c";
        String wrong3 = "2?4?:d:e";
        String wrong4 = "2??d:e:c";
        assertFalse(verifyExpression(wrong1));
        assertFalse(verifyExpression(wrong2));
        assertFalse(verifyExpression(wrong3));
        assertFalse(verifyExpression(wrong4));
    }
}
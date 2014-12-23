ternaryExpression
=================

Ternary Expression verifier in Java. Includes JUnit 4 tests.

Tests
-----

- See if the expression itself is empty or null;
- See if the colons come before the question marks;
- See if the colon count is different than the question mark count;
- See if there are empty elements on the parsed String;
- Block "a?b?c:d:" - that might have passed on the last test;
- Test for duplicates.

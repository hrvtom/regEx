package regex;

import java.io.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {

	public static Console console;

	public static void main(String[] args) {

//		[]
		console = System.console();
		if (console == null) {
			System.err.println("No console.");
//			System.exit(1);
		}
		// Basics
		System.out.println("\nSimple character class [bcr] - b,c or r");
		Pattern pattern = Pattern.compile("[bcr]at");
		String input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		Matcher matcher = pattern.matcher(input);
		checkMatcher(matcher);

		System.out.println("Negation [^bcr] - any character except b,c or r");
		pattern = Pattern.compile("[^bcr]at");
		input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		System.out.println("Range [a-d] - any character a through d");
		pattern = Pattern.compile("[a-d]at");
		input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("Range [^a-d] - any character not a through d");
		pattern = Pattern.compile("[^a-d]at");
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("Range [a-dl-n] - any character a through d or l thorough n");
		pattern = Pattern.compile("[a-dl-n]at");
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		System.out.println("Union [a-d[l-n]] - any character a through d or l thorough n");
		pattern = Pattern.compile("[a-d[l-n]]at");
		input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		System.out.println("Intersection [a-n&&[c-s]] - any character in a through n and in c thorough s");
		pattern = Pattern.compile("[a-n&&[c-s]]at");
		input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		System.out.println("Subtraction [a-s&&[^c-n]] - any character in a through s and not in c thorough n");
		pattern = Pattern.compile("[a-s&&[^c-n]]at");
		input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		// Predefined character classes
		// . - any character
		// \d - a digit [0-9]
		// \D - non-digit c
		// \s - whitespace character [ \t\n\x0B\f\r]
		// \S - non-whitespace character [^\s]
		// \w - word character [a-zA-Z_0-9]
		// \W - non-word character [^\w]
		System.out.println("\nPredefined character classes");
		System.out.println("[\\dcr] - any number,c or r");
		pattern = Pattern.compile("[\\dcr]at");
		input = "batmate4atgratcat";
		System.out.println("Input: " + input);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		// Quantifiers
		// Greedy Reluctant Possessive
		// one or not at all X? X?? X?+
		// zero or more times X* X*? X*+
		// one or more times X+ X+? X++
		// exactly n times X{n} X{n}? X{n}+
		// at least n times X{n,} X{n,}? X{n,}+
		// at least n but no X{n,m} X{n,m}? X{n,m}+
		// more than m times

		// Zero-Length Matches are matches where start index and stop index are the same. A zero length match can occur
		// in several cases, in empty string, at he begging of the input string, after the last character of the input
		// string, or in between any two characters of an input string.

		System.out.println("\nQuantifiers");
		input = "a";
		System.out.println("Input: " + input);
		System.out.println("a?");
		pattern = Pattern.compile("a?");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a*");
		pattern = Pattern.compile("a*");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a+");
		pattern = Pattern.compile("a+");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		input = "aaa";
		System.out.println("\nInput: " + input);
		System.out.println("a?");
		pattern = Pattern.compile("a?");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a*");
		pattern = Pattern.compile("a*");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a+");
		pattern = Pattern.compile("a+");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		input = "ababaab";
		System.out.println("\nInput: " + input);
		System.out.println("a?");
		pattern = Pattern.compile("a?");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a*");
		pattern = Pattern.compile("a*");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a+");
		pattern = Pattern.compile("a+");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		// Even though the letter "b" appears in cells 1, 3, and 6, the output reports a zero-length match at those
		// locations. The regular expression a? is not specifically looking for the letter "b"; it's merely looking for
		// the presence (or lack thereof) of the letter "a". If the quantifier allows for a match of "a" zero times,
		// anything in the input string that's not an "a" will show up as a zero-length match.

		input = "aaaaaaa";
		System.out.println("\nInput: " + input);
		System.out.println("a{3}");
		pattern = Pattern.compile("a{3}");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a{3,}");
		pattern = Pattern.compile("a{3,}");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("a{3,6}");
		pattern = Pattern.compile("a{3,6}");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		input = "abccabaaaccbbbc";
		System.out.println("\nInput: " + input);
		System.out.println("[abc]{3}");
		pattern = Pattern.compile("[abc]{3}");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println("abc{3}");
		pattern = Pattern.compile("abc{3}");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		// Quantifier {3} applies to letter c only

		System.out.println("\nGreedy, Reluctant, Possessive");
		// Greedy quantifiers are considered "greedy" because they force the matcher to read in, or eat, the entire
		// input string prior to attempting the first match. If the first match attempt (the entire input string) fails,
		// the matcher backs off the input string by one character and tries again, repeating the process until a match
		// is found or there are no more characters left to back off from. Depending on the quantifier used in the
		// expression, the last thing it will try matching against is 1 or 0 characters.

		// The reluctant quantifiers, however, take the opposite approach: They start at the beginning of the input
		// string, then reluctantly eat one character at a time looking for a match. The last thing they try is the
		// entire input string.

		// Finally, the possessive quantifiers always eat the entire input string, trying once (and only once) for a
		// match. Unlike the greedy quantifiers, possessive quantifiers never back off, even if doing so would allow the
		// overall match to succeed.
		input = "xfooxxxxfoo";
		System.out.println("Input: " + input);
		System.out.println(".*foo");
		pattern = Pattern.compile(".*foo");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println(".*?foo");
		pattern = Pattern.compile(".*?foo");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		System.out.println(".*+foo");
		pattern = Pattern.compile(".*+foo");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		// The first example uses the greedy quantifier .* to find "anything", zero or more times, followed by the
		// letters "f" "o" "o". Because the quantifier is greedy, the .* portion of the expression first eats the entire
		// input string. At this point, the overall expression cannot succeed, because the last three letters ("f" "o"
		// "o") have already been consumed. So the matcher slowly backs off one letter at a time until the rightmost
		// occurrence of "foo" has been regurgitated, at which point the match succeeds and the search ends.

		// The second example, however, is reluctant, so it starts by first consuming "nothing". Because "foo" doesn't
		// appear at the beginning of the string, it's forced to swallow the first letter (an "x"), which triggers the
		// first match at 0 and 4. Our test harness continues the process until the input string is exhausted. It finds
		// another match at 4 and 13.

		// The third example fails to find a match because the quantifier is possessive. In this case, the entire input
		// string is consumed by .*+, leaving nothing left over to satisfy the "foo" at the end of the expression. Use a
		// possessive quantifier for situations where you want to seize all of something without ever backing off; it
		// will outperform the equivalent greedy quantifier in cases where the match is not immediately found.

		System.out.println("\nCapturing Groups");
		// Groups beginning with (? are pure, non-capturing groups that do not capture text and do not count towards the
		// group total.
		System.out.println("Backreference");
		// A backreference is specified in the regular expression as a backslash (\) followed by a digit indicating the
		// number of the group to be recalled. For example, the expression (\d\d) defines one capturing group matching
		// two digits in a row, which can be recalled later in the expression via the backreference \1

		// To match any 2 digits, followed by the exact same two digits, you would use (\d\d)\1 as the regular
		// expression:
		input = "1212";
		System.out.println("Input: " + input);
		System.out.println("(\\d\\d)\\1");
		pattern = Pattern.compile("(\\d\\d)\\1");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "1213";
		System.out.println("Input: " + input);
		System.out.println("(\\d\\d)\\1");
		pattern = Pattern.compile("(\\d\\d)\\1");
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		System.out.println("\nBoundary Matchers");
//		^  - the beginnig of a line
//		$  - the end of the line
//		\b - a word boundary
//		\B - a non-word boundary
//		\A - The beginning of the input
//		\G - the end of the previous match
//		\Z - the end of the input but for the final terminator, if any
//		\z - the end of the inpur
		input = "dog";
		String pat = "^dog$";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		pat = "^dog";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "     dog";
		pat = "^dog$";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		pat = "\\s*dog$";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		pat = "dog$";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "dogblahblah";
		pat = "^dog\\w*";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "dogblahblah";
		pat = "^dog";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		input = "The dog plays";
		pat = "\\bdog\\b";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "The doggie plays";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "dog";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);

		input = "The dog plays";
		pat = "\\bdog\\B";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		pattern = Pattern.compile(pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "The doggie plays";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "doggie";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
		input = "somedoggie";
		System.out.println("Input: " + input);
		System.out.println("Pattern: " + pat);
		matcher = pattern.matcher(input);
		checkMatcher(matcher);
//		pat = "[\b\B]dog[\b\B]"; /does not work

		// remove white spaces between a word character and .or,
		String EXAMPLE = "   .Some    .example   Test    .string";
		String strPattern = "(\\w)(\\s+)([.,])";// find word character followed by one or more spaces and end with . or
												// ,
		System.out.println("\nInput: " + EXAMPLE);
		System.out.println("Pattern: " + strPattern);
		System.out.println(EXAMPLE.replaceAll(strPattern, "$1$3"));
		strPattern = "(\\w*)(\\s+)([.,])";// find word character followed by one or more spaces and end with . or
		System.out.println("Input: " + EXAMPLE);
		System.out.println("Pattern: " + strPattern);
		System.out.println(EXAMPLE.replaceAll(strPattern, "$1$3"));

		// Extract text between the two title elements
		EXAMPLE = "<titlebla>nesto novo<title>";
		strPattern = "(?i)(<title.*?>)(.+?)<title.*?>"; // Reluctant
		System.out.println("\nInput: " + EXAMPLE);
		System.out.println("Pattern: " + strPattern);
		// (?i) case insensitive
		// (?x) Permits whitespace and comments in the pattern. In this mode, whitespace is ignored, and embedded
		// comments starting with # are ignored until the end of a line.
		// (?m) Enables multiline mode. In multiline mode the expressions ^ and $ match just after or just before,
		// respectively, a line terminator or the end of the input sequence. By default these expressions only match at
		// the beginning and the end of the entire input sequence.
		System.out.println(EXAMPLE.replaceAll(strPattern, "$2"));

		EXAMPLE = "test";
		System.out.println("\nInput: " + EXAMPLE);
		System.out.println(EXAMPLE.split("\\.").length);
		System.out.println(Arrays.toString(EXAMPLE.split("\\.")));

		// true if string contains a arbitrary number of characters except b
		EXAMPLE = "test_test";
		System.out.println("\nInput: " + EXAMPLE);
		System.out.println(EXAMPLE.matches("([\\w&&[^b]])*")); // each character is group on its own
		System.out.println(EXAMPLE.matches("([\\w&&[^b]]*)")); // this is one group
		System.out.println(EXAMPLE.matches("[\\w&&[^b]]*")); // no group at all

		// true if the string contains a number less than 300
		EXAMPLE = "t399";
		System.out.println("\nInput: " + EXAMPLE);
		System.out.println(EXAMPLE.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*"));
		EXAMPLE = "t299";
		System.out.println("Input: " + EXAMPLE);
		System.out.println(EXAMPLE.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*"));
		EXAMPLE = "199a";
		System.out.println("Input: " + EXAMPLE);
		System.out.println(EXAMPLE.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*"));

		// match each word
		EXAMPLE = "This is my small example string. Match every word in a string";
		System.out.println("\nInput: " + EXAMPLE);
		strPattern = "\\w+";
		System.out.println("Pattern: " + strPattern);
		pattern = Pattern.compile(strPattern);
		matcher = pattern.matcher(EXAMPLE);
		checkMatcher(matcher);

		// replace spaces with tab
		Pattern replace = Pattern.compile("\\s+");
		Matcher matcher2 = replace.matcher(EXAMPLE);
		System.out.println(matcher2.replaceAll("\t"));

		EXAMPLE = "aaaaaa.";
		System.out.println("\nInput: " + EXAMPLE);
//		pattern = Pattern.compile("[a{3}]"); //neradi
		pattern = Pattern.compile("a{3}");
		matcher = pattern.matcher(EXAMPLE);
		checkMatcher(matcher);

		EXAMPLE = "300.200";
		System.out.println("\nInput: " + EXAMPLE);
		strPattern = "(\\d+).?(\\d+)?";
		System.out.println("Pattern: " + strPattern);
		pattern = Pattern.compile(strPattern);
		matcher = pattern.matcher(EXAMPLE);
		matcher.find();
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));
		matcher = pattern.matcher("300.");
		matcher.find();
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));
		matcher = pattern.matcher("3123");
		matcher.find();
		System.out.println(matcher.group(1));
		System.out.println(matcher.group(2));

		// Group naming
		String gr1 = "gr1", gr2 = "gr2", gr3 = "gr3";
		String textToSearch = "prvi red\n nesto samo nesto Fan Speed 3 jos nesto sitno\n i za kraj";
		pattern = Pattern.compile("Fan Speed (?<" + gr3 + ">\\d)");
		matcher = pattern.matcher(textToSearch);
		checkMatcher(matcher);

	}

	private static void checkMatcher(Matcher matcher) {
		boolean found = false;
		while (matcher.find()) {
//			console.format("\"%s\" starting at index %d and ending at index %d.%n", matcher.group(), matcher.start(),
//					matcher.end());
			System.out.println(String.format("\"%s\" starting at index %d and ending at index %d.", matcher.group(),
					matcher.start(), matcher.end()));
			found = true;
		}
		if (!found) {
//			console.format("No match found.%n");
			System.out.println("No match found.");

		}
	}

}

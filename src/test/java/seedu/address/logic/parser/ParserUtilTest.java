package seedu.address.logic.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_RECORD;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.address.logic.parser.exceptions.ParseException;
<<<<<<< HEAD
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
import seedu.address.model.record.Date;
=======
import seedu.address.model.record.Date;
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import seedu.address.model.tag.Tag;
import seedu.address.testutil.Assert;

public class ParserUtilTest {
<<<<<<< HEAD
    private static final String INVALID_NAME = "R@chel";
=======
    private static final String INVALID_NAME = "P@yment from R@chel";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    private static final String INVALID_DATE = "+651234";
    private static final String INVALID_EXPENSE = " ";
    private static final String INVALID_INCOME = "example.com";
    private static final String INVALID_TAG = "#friend";

<<<<<<< HEAD
    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_DATE = "12-07-2007";
    private static final String VALID_EXPENSE = "15.70";
    private static final String VALID_INCOME = "16.70";
=======
    private static final String VALID_NAME = "Payment from Rachel";
    private static final String VALID_DATE = "12-07-2007";
    private static final String VALID_EXPENSE = "-15.70";
    private static final String VALID_INCOME = "+16.70";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String WHITESPACE = " \t\r\n";

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void parseIndex_invalidInput_throwsParseException() throws Exception {
        thrown.expect(ParseException.class);
        ParserUtil.parseIndex("10 a");
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() throws Exception {
        thrown.expect(ParseException.class);
        thrown.expectMessage(MESSAGE_INVALID_INDEX);
        ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_RECORD, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_RECORD, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(nameWithWhitespace));
    }

    @Test
    public void parseDate_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> ParserUtil.parseDate((String) null));
<<<<<<< HEAD
    }

    @Test
    public void parseDate_invalidValue_throwsParseException() {
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseDate(INVALID_DATE));
    }

    @Test
    public void parseDate_validValueWithoutWhitespace_returnsDate() throws Exception {
        Date expectedDate = new Date(VALID_DATE);
        assertEquals(expectedDate, ParserUtil.parseDate(VALID_DATE));
    }

    @Test
    public void parseDate_validValueWithWhitespace_returnsTrimmedDate() throws Exception {
        String dateWithWhitespace = WHITESPACE + VALID_DATE + WHITESPACE;
        Date expectedDate = new Date(VALID_DATE);
        assertEquals(expectedDate, ParserUtil.parseDate(dateWithWhitespace));
    }

    @Test
    public void parseAddress_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> ParserUtil.parseExpense((String) null));
    }

    @Test
    public void parseExpense_invalidValue_throwsParseException() {
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseExpense(INVALID_EXPENSE));
    }

    @Test
    public void parseExpense_validValueWithoutWhitespace_returnsExpense() throws Exception {
        Expense expectedExpense = new Expense(VALID_EXPENSE);
        assertEquals(expectedExpense, ParserUtil.parseExpense(VALID_EXPENSE));
    }

    @Test
    public void parseExpense_validValueWithWhitespace_returnsTrimmedExpense() throws Exception {
        String expenseWithWhitespace = WHITESPACE + VALID_EXPENSE + WHITESPACE;
        Expense expectedExpense = new Expense(VALID_EXPENSE);
        assertEquals(expectedExpense, ParserUtil.parseExpense(expenseWithWhitespace));
    }

    @Test
    public void parseIncome_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> ParserUtil.parseIncome((String) null));
=======
    }

    @Test
    public void parseDate_invalidValue_throwsParseException() {
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseDate(INVALID_DATE));
    }

    @Test
    public void parseDate_validValueWithoutWhitespace_returnsDate() throws Exception {
        Date expectedDate = new Date(VALID_DATE);
        assertEquals(expectedDate, ParserUtil.parseDate(VALID_DATE));
    }

    @Test
    public void parseDate_validValueWithWhitespace_returnsTrimmedDate() throws Exception {
        String dateWithWhitespace = WHITESPACE + VALID_DATE + WHITESPACE;
        Date expectedDate = new Date(VALID_DATE);
        assertEquals(expectedDate, ParserUtil.parseDate(dateWithWhitespace));
    }

    @Test
    public void parseMoneyFlow_null_throwsNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> ParserUtil.parseMoneyFlow((String) null));
    }

    @Test
    public void parseMoneyFlow_invalidValue_throwsParseException() {
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseMoneyFlow(INVALID_EXPENSE));
    }

    @Test
    public void parseExpense_validValueWithoutWhitespace_returnsExpense() throws Exception {
        Expense expectedExpense = new Expense(VALID_EXPENSE);
        assertEquals(expectedExpense, ParserUtil.parseMoneyFlow(VALID_EXPENSE));
    }

    @Test
    public void parseExpense_validValueWithWhitespace_returnsTrimmedExpense() throws Exception {
        String expenseWithWhitespace = WHITESPACE + VALID_EXPENSE + WHITESPACE;
        Expense expectedExpense = new Expense(VALID_EXPENSE);
        assertEquals(expectedExpense, ParserUtil.parseMoneyFlow(expenseWithWhitespace));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void parseIncome_invalidValue_throwsParseException() {
<<<<<<< HEAD
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseIncome(INVALID_INCOME));
=======
        Assert.assertThrows(ParseException.class, () -> ParserUtil.parseMoneyFlow(INVALID_INCOME));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void parseIncome_validValueWithoutWhitespace_returnsIncome() throws Exception {
        Income expectedIncome = new Income(VALID_INCOME);
<<<<<<< HEAD
        assertEquals(expectedIncome, ParserUtil.parseIncome(VALID_INCOME));
=======
        assertEquals(expectedIncome, ParserUtil.parseMoneyFlow(VALID_INCOME));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void parseIncome_validValueWithWhitespace_returnsTrimmedIncome() throws Exception {
        String incomeWithWhitespace = WHITESPACE + VALID_INCOME + WHITESPACE;
        Income expectedIncome = new Income(VALID_INCOME);
<<<<<<< HEAD
        assertEquals(expectedIncome, ParserUtil.parseIncome(incomeWithWhitespace));
=======
        assertEquals(expectedIncome, ParserUtil.parseMoneyFlow(incomeWithWhitespace));
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
    }

    @Test
    public void parseTag_null_throwsNullPointerException() throws Exception {
        thrown.expect(NullPointerException.class);
        ParserUtil.parseTag(null);
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() throws Exception {
        thrown.expect(ParseException.class);
        ParserUtil.parseTag(INVALID_TAG);
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() throws Exception {
        thrown.expect(NullPointerException.class);
        ParserUtil.parseTags(null);
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() throws Exception {
        thrown.expect(ParseException.class);
        ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }
}

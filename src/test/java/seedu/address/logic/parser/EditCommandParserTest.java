package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
<<<<<<< HEAD
import static seedu.address.logic.commands.CommandTestUtil.EXPENSE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.EXPENSE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INCOME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.INCOME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_EXPENSE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_INCOME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_DESC;
=======
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_DATE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_MONEYFLOW_DESC;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import static seedu.address.logic.commands.CommandTestUtil.INVALID_TAG_DESC;
import static seedu.address.logic.commands.CommandTestUtil.MONEYFLOW_EXPENSE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.MONEYFLOW_INCOME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
<<<<<<< HEAD
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DATE_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EXPENSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INCOME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INCOME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
=======
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.TAG_DESC_HUSBAND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MONEYFLOW_EXPENSE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MONEYFLOW_INCOME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_RECORD;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_RECORD;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_RECORD;

import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditRecordDescriptor;
<<<<<<< HEAD
import seedu.address.model.record.Expense;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
import seedu.address.model.record.Date;
=======
import seedu.address.model.record.Date;
import seedu.address.model.record.Income;
import seedu.address.model.record.Name;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import seedu.address.model.tag.Tag;
import seedu.address.testutil.EditRecordDescriptorBuilder;

public class EditCommandParserTest {

    private static final String TAG_EMPTY = " " + PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();

    @Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_NAME_AMY, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 f/ string", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + INVALID_NAME_DESC, Name.MESSAGE_NAME_CONSTRAINTS); // invalid name
<<<<<<< HEAD
        assertParseFailure(parser, "1" + INVALID_DATE_DESC, Date.MESSAGE_DATE_CONSTRAINTS); // invalid phone
        assertParseFailure(parser, "1" + INVALID_INCOME_DESC, Income.MESSAGE_INCOME_CONSTRAINTS); // invalid income
        assertParseFailure(parser, "1" + INVALID_EXPENSE_DESC, Expense.MESSAGE_EXPENSE_CONSTRAINTS); // invalid address
        assertParseFailure(parser, "1" + INVALID_TAG_DESC, Tag.MESSAGE_TAG_CONSTRAINTS); // invalid tag

        // invalid phone followed by valid income
        assertParseFailure(parser, "1" + INVALID_DATE_DESC + INCOME_DESC_AMY, Date.MESSAGE_DATE_CONSTRAINTS);
=======
        assertParseFailure(parser, "1" + INVALID_DATE_DESC, Date.MESSAGE_DATE_CONSTRAINTS); // invalid date
        assertParseFailure(parser, "1"
                + INVALID_MONEYFLOW_DESC, Income.MESSAGE_MONEY_FLOW_CONSTRAINTS); // invalid moneyflow
        assertParseFailure(parser, "1" + INVALID_TAG_DESC, Tag.MESSAGE_TAG_CONSTRAINTS); // invalid tag

        // invalid date followed by valid income
        assertParseFailure(parser, "1" + INVALID_DATE_DESC + MONEYFLOW_INCOME_DESC_AMY,
                Date.MESSAGE_DATE_CONSTRAINTS);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

        // valid date followed by invalid date. The test case for invalid date followed by valid date
        // is tested at {@code parse_invalidValueFollowedByValidValue_success()}
        assertParseFailure(parser, "1" + DATE_DESC_BOB + INVALID_DATE_DESC, Date.MESSAGE_DATE_CONSTRAINTS);

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Record} being edited,
        // parsing it together with a valid tag results in error
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_DESC_HUSBAND + TAG_EMPTY,
                Tag.MESSAGE_TAG_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_EMPTY + TAG_DESC_HUSBAND,
                Tag.MESSAGE_TAG_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_EMPTY + TAG_DESC_FRIEND + TAG_DESC_HUSBAND,
                Tag.MESSAGE_TAG_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
<<<<<<< HEAD
        assertParseFailure(parser, "1" + INVALID_NAME_DESC + INVALID_INCOME_DESC + VALID_EXPENSE_AMY + VALID_DATE_AMY,
=======
        assertParseFailure(parser, "1" + INVALID_NAME_DESC + INVALID_MONEYFLOW_DESC + VALID_DATE_AMY,
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
                Name.MESSAGE_NAME_CONSTRAINTS);
    }

    @Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = INDEX_SECOND_RECORD;
        String userInput = targetIndex.getOneBased() + DATE_DESC_BOB + TAG_DESC_HUSBAND
<<<<<<< HEAD
                + INCOME_DESC_AMY + EXPENSE_DESC_AMY + NAME_DESC_AMY + TAG_DESC_FRIEND;

        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withName(VALID_NAME_AMY)
                .withDate(VALID_DATE_BOB).withIncome(VALID_INCOME_AMY).withExpense(VALID_EXPENSE_AMY)
=======
                + MONEYFLOW_INCOME_DESC_AMY + NAME_DESC_AMY + TAG_DESC_FRIEND;

        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withName(VALID_NAME_AMY)
                .withDate(VALID_DATE_BOB).withMoneyFlow(VALID_MONEYFLOW_INCOME_AMY)
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_someFieldsSpecified_success() {
        Index targetIndex = INDEX_FIRST_RECORD;
<<<<<<< HEAD
        String userInput = targetIndex.getOneBased() + DATE_DESC_BOB + INCOME_DESC_AMY;

        EditCommand.EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB)
                .withIncome(VALID_INCOME_AMY).build();
=======
        String userInput = targetIndex.getOneBased() + DATE_DESC_BOB + MONEYFLOW_INCOME_DESC_AMY;

        EditCommand.EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB)
                .withMoneyFlow(VALID_MONEYFLOW_INCOME_AMY).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_oneFieldSpecified_success() {
        // name
        Index targetIndex = INDEX_THIRD_RECORD;
        String userInput = targetIndex.getOneBased() + NAME_DESC_AMY;
        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withName(VALID_NAME_AMY).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

<<<<<<< HEAD
        // phone
=======
        // date
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        userInput = targetIndex.getOneBased() + DATE_DESC_AMY;
        descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_AMY).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // income
<<<<<<< HEAD
        userInput = targetIndex.getOneBased() + INCOME_DESC_AMY;
        descriptor = new EditRecordDescriptorBuilder().withIncome(VALID_INCOME_AMY).build();
=======
        userInput = targetIndex.getOneBased() + MONEYFLOW_INCOME_DESC_AMY;
        descriptor = new EditRecordDescriptorBuilder().withMoneyFlow(VALID_MONEYFLOW_INCOME_AMY).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // expense
<<<<<<< HEAD
        userInput = targetIndex.getOneBased() + EXPENSE_DESC_AMY;
        descriptor = new EditRecordDescriptorBuilder().withExpense(VALID_EXPENSE_AMY).build();
=======
        userInput = targetIndex.getOneBased() + MONEYFLOW_EXPENSE_DESC_BOB;
        descriptor = new EditRecordDescriptorBuilder().withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // tags
        userInput = targetIndex.getOneBased() + TAG_DESC_FRIEND;
        descriptor = new EditRecordDescriptorBuilder().withTags(VALID_TAG_FRIEND).build();
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_multipleRepeatedFields_acceptsLast() {
        Index targetIndex = INDEX_FIRST_RECORD;
<<<<<<< HEAD
        String userInput = targetIndex.getOneBased() + DATE_DESC_AMY + EXPENSE_DESC_AMY + INCOME_DESC_AMY
                + TAG_DESC_FRIEND + DATE_DESC_AMY + EXPENSE_DESC_AMY + INCOME_DESC_AMY + TAG_DESC_FRIEND
                + DATE_DESC_BOB + EXPENSE_DESC_BOB + INCOME_DESC_BOB + TAG_DESC_HUSBAND;

        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB)
                .withIncome(VALID_INCOME_BOB).withExpense(VALID_EXPENSE_BOB).withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
=======
        String userInput = targetIndex.getOneBased() + DATE_DESC_AMY + MONEYFLOW_INCOME_DESC_AMY
                + TAG_DESC_FRIEND + DATE_DESC_AMY + MONEYFLOW_INCOME_DESC_AMY + TAG_DESC_FRIEND
                + DATE_DESC_BOB + MONEYFLOW_EXPENSE_DESC_BOB + TAG_DESC_HUSBAND;

        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB)
                .withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB)
                .withTags(VALID_TAG_FRIEND, VALID_TAG_HUSBAND)
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
                .build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_invalidValueFollowedByValidValue_success() {
        // no other valid values specified
        Index targetIndex = INDEX_FIRST_RECORD;
        String userInput = targetIndex.getOneBased() + INVALID_DATE_DESC + DATE_DESC_BOB;
        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB).build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // other valid values specified
<<<<<<< HEAD
        userInput = targetIndex.getOneBased() + INCOME_DESC_BOB + INVALID_DATE_DESC + EXPENSE_DESC_BOB
                + DATE_DESC_BOB;
        descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB).withIncome(VALID_INCOME_BOB)
                .withExpense(VALID_EXPENSE_BOB).build();
=======
        userInput = targetIndex.getOneBased() + MONEYFLOW_EXPENSE_DESC_BOB + INVALID_DATE_DESC
                + DATE_DESC_BOB;
        descriptor = new EditRecordDescriptorBuilder().withDate(VALID_DATE_BOB)
                .withMoneyFlow(VALID_MONEYFLOW_EXPENSE_BOB).build();
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        expectedCommand = new EditCommand(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_resetTags_success() {
        Index targetIndex = INDEX_THIRD_RECORD;
        String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        EditRecordDescriptor descriptor = new EditRecordDescriptorBuilder().withTags().build();
        EditCommand expectedCommand = new EditCommand(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }
}

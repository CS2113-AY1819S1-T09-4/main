package systemtests;

import static org.junit.Assert.assertFalse;
import static seedu.address.commons.core.Messages.MESSAGE_RECORDS_LISTED_OVERVIEW;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
<<<<<<< HEAD
import static seedu.address.testutil.TypicalRecords.BENSON;
import static seedu.address.testutil.TypicalRecords.CARL;
import static seedu.address.testutil.TypicalRecords.DANIEL;
import static seedu.address.testutil.TypicalRecords.KEYWORD_MATCHING_MEIER;
=======
import static seedu.address.testutil.TypicalRecords.CAIFAN;
import static seedu.address.testutil.TypicalRecords.KEYWORD_MATCHING_BURSARY;
import static seedu.address.testutil.TypicalRecords.RANDOM;
import static seedu.address.testutil.TypicalRecords.WORK;
import static seedu.address.testutil.TypicalRecords.ZT;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.RedoCommand;
import seedu.address.logic.commands.UndoCommand;
import seedu.address.model.Model;
import seedu.address.model.tag.Tag;

public class FindCommandSystemTest extends ExpenseBookSystemTest {

    @Test
    public void find() {
        /* Case: find multiple records in address book, command with leading spaces and trailing spaces
         * -> 2 records found
         */
        String command = "   " + FindCommand.COMMAND_WORD + " " + KEYWORD_MATCHING_BURSARY + "   ";
        Model expectedModel = getModel();
        ModelHelper.setFilteredList(expectedModel, WORK, RANDOM); // this names contain "Income"
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: repeat previous find command where record list is displaying the records we are finding
         * -> 2 records found
         */
        command = FindCommand.COMMAND_WORD + " " + KEYWORD_MATCHING_BURSARY;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find record where record list is not displaying the record we are finding -> 1 record found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " Carl";
        ModelHelper.setFilteredList(expectedModel, CARL);
=======
        command = FindCommand.COMMAND_WORD + " caifan";
        ModelHelper.setFilteredList(expectedModel, CAIFAN);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find multiple records in address book, 2 keywords -> 2 records found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " Benson Daniel";
        ModelHelper.setFilteredList(expectedModel, BENSON, DANIEL);
=======
        command = FindCommand.COMMAND_WORD + " ZT caifan";
        ModelHelper.setFilteredList(expectedModel, CAIFAN, ZT);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find multiple records in address book, 2 keywords in reversed order -> 2 records found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " Daniel Benson";
=======
        command = FindCommand.COMMAND_WORD + " caifan ZT";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find multiple records in address book, 2 keywords with 1 repeat -> 2 records found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " Daniel Benson Daniel";
=======
        command = FindCommand.COMMAND_WORD + " work ZT work";
        ModelHelper.setFilteredList(expectedModel, ZT, WORK);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find multiple records in address book, 2 matching keywords and 1 non-matching keyword
         * -> 2 records found
         */
        command = FindCommand.COMMAND_WORD + " work ZT NonMatchingKeyWord";
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: undo previous find command -> rejected */
        command = UndoCommand.COMMAND_WORD;
        String expectedResultMessage = UndoCommand.MESSAGE_FAILURE;
        assertCommandFailure(command, expectedResultMessage);

        /* Case: redo previous find command -> rejected */
        command = RedoCommand.COMMAND_WORD;
        expectedResultMessage = RedoCommand.MESSAGE_FAILURE;
        assertCommandFailure(command, expectedResultMessage);

        /* Case: find same records in address book after deleting 1 of them -> 1 record found */
        executeCommand(DeleteCommand.COMMAND_WORD + " 1");
<<<<<<< HEAD
        assertFalse(getModel().getAddressBook().getRecordList().contains(BENSON));
        command = FindCommand.COMMAND_WORD + " " + KEYWORD_MATCHING_MEIER;
=======
        assertFalse(getModel().getAddressBook().getRecordList().contains(WORK));
        command = FindCommand.COMMAND_WORD + " " + KEYWORD_MATCHING_BURSARY;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        expectedModel = getModel();
        ModelHelper.setFilteredList(expectedModel, RANDOM);
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find record in address book, keyword is same as name but of different case -> 1 record found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " MeIeR";
=======
        command = FindCommand.COMMAND_WORD + " rAndOm";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find record in address book, keyword is substring of name -> 0 records found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " Mei";
=======
        command = FindCommand.COMMAND_WORD + " ran";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        ModelHelper.setFilteredList(expectedModel);
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find record in address book, name is substring of keyword -> 0 records found */
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " Meiers";
=======
        command = FindCommand.COMMAND_WORD + " inc";
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        ModelHelper.setFilteredList(expectedModel);
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find record not in address book -> 0 records found */
        command = FindCommand.COMMAND_WORD + " Mark";
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

<<<<<<< HEAD
        /* Case: find day parameter of record in address book -> 0 records found */
        command = FindCommand.COMMAND_WORD + " " + DANIEL.getDate().value;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find address of record in address book -> 0 records found */
        command = FindCommand.COMMAND_WORD + " " + DANIEL.getExpense().value;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find email of record in address book -> 0 records found */
        command = FindCommand.COMMAND_WORD + " " + DANIEL.getIncome().value;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find tags of record in address book -> 0 records found */
        List<Tag> tags = new ArrayList<>(DANIEL.getTags());
=======
        /* Case: find date of record in address book -> 0 records found */
        command = FindCommand.COMMAND_WORD + " " + ZT.getDate().value;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find money flow of record in address book -> 0 records found */
        command = FindCommand.COMMAND_WORD + " " + ZT.getMoneyFlow().value;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find tags of record in address book -> 0 records found */
        List<Tag> tags = new ArrayList<>(ZT.getTags());
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        command = FindCommand.COMMAND_WORD + " " + tags.get(0).tagName;
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: find while a record is selected -> selected card deselected */
        showAllRecords();
        selectRecord(Index.fromOneBased(1));
<<<<<<< HEAD
        assertFalse(getRecordListPanel().getHandleToSelectedCard().getName().equals(DANIEL.getName().fullName));
        command = FindCommand.COMMAND_WORD + " Daniel";
        ModelHelper.setFilteredList(expectedModel, DANIEL);
=======
        assertFalse(getRecordListPanel().getHandleToSelectedCard().getName().equals(ZT.getName().fullName));
        command = FindCommand.COMMAND_WORD + " ZT";
        ModelHelper.setFilteredList(expectedModel, ZT);
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardDeselected();

        /* Case: find record in empty address book -> 0 records found */
        deleteAllRecords();
<<<<<<< HEAD
        command = FindCommand.COMMAND_WORD + " " + KEYWORD_MATCHING_MEIER;
=======
        command = FindCommand.COMMAND_WORD + " " + KEYWORD_MATCHING_BURSARY;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
        expectedModel = getModel();
        ModelHelper.setFilteredList(expectedModel, ZT);
        assertCommandSuccess(command, expectedModel);
        assertSelectedCardUnchanged();

        /* Case: mixed case command word -> rejected */
        command = "FiNd Income";
        assertCommandFailure(command, MESSAGE_UNKNOWN_COMMAND);
    }

    /**
     * Executes {@code command} and verifies that the command box displays an empty string, the result display
     * box displays {@code Messages#MESSAGE_RECORDS_LISTED_OVERVIEW} with the number of people in the filtered list,
     * and the model related components equal to {@code expectedModel}.
     * These verifications are done by
     * {@code ExpenseBookSystemTest#assertApplicationDisplaysExpected(String, String, Model)}.<br>
     * Also verifies that the status bar remains unchanged, and the command box has the default style class, and the
     * selected card updated accordingly, depending on {@code cardStatus}.
     * @see ExpenseBookSystemTest#assertApplicationDisplaysExpected(String, String, Model)
     */
    private void assertCommandSuccess(String command, Model expectedModel) {
        String expectedResultMessage = String.format(
                MESSAGE_RECORDS_LISTED_OVERVIEW, expectedModel.getFilteredRecordList().size());
<<<<<<< HEAD
=======

>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e

        executeCommand(command);
        assertApplicationDisplaysExpected("", expectedResultMessage, expectedModel);
        assertCommandBoxShowsDefaultStyle();
        assertStatusBarUnchanged();
    }

    /**
     * Executes {@code command} and verifies that the command box displays {@code command}, the result display
     * box displays {@code expectedResultMessage} and the model related components equal to the current model.
     * These verifications are done by
     * {@code ExpenseBookSystemTest#assertApplicationDisplaysExpected(String, String, Model)}.<br>
     * Also verifies that the browser url, selected card and status bar remain unchanged, and the command box has the
     * error style.
     * @see ExpenseBookSystemTest#assertApplicationDisplaysExpected(String, String, Model)
     */
    private void assertCommandFailure(String command, String expectedResultMessage) {
        Model expectedModel = getModel();

        executeCommand(command);
        assertApplicationDisplaysExpected(command, expectedResultMessage, expectedModel);
        assertSelectedCardUnchanged();
        assertCommandBoxShowsErrorStyle();
        assertStatusBarUnchanged();
    }
}

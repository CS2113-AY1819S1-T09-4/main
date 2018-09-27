package seedu.address.ui;

import static java.time.Duration.ofMillis;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static seedu.address.testutil.EventsUtil.postNow;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_RECORD;
import static seedu.address.testutil.TypicalRecords.getTypicalRecords;
import static seedu.address.ui.testutil.GuiTestAssert.assertCardDisplaysRecord;
import static seedu.address.ui.testutil.GuiTestAssert.assertCardEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

<<<<<<< HEAD
import guitests.guihandles.RecordListPanelHandle;
import org.junit.Test;

import guitests.guihandles.RecordCardHandle;
=======
import org.junit.Test;

import guitests.guihandles.RecordCardHandle;
import guitests.guihandles.RecordListPanelHandle;
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.commons.events.ui.JumpToListRequestEvent;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.XmlUtil;
import seedu.address.model.record.Record;
import seedu.address.storage.XmlSerializableAddressBook;

public class RecordListPanelTest extends GuiUnitTest {
    private static final ObservableList<Record> TYPICAL_RECORDS =
            FXCollections.observableList(getTypicalRecords());

    private static final JumpToListRequestEvent JUMP_TO_SECOND_EVENT = new JumpToListRequestEvent(INDEX_SECOND_RECORD);

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "sandbox");

    private static final long CARD_CREATION_AND_DELETION_TIMEOUT = 2500;

    private RecordListPanelHandle recordListPanelHandle;

    @Test
    public void display() {
        initUi(TYPICAL_RECORDS);

        for (int i = 0; i < TYPICAL_RECORDS.size(); i++) {
            recordListPanelHandle.navigateToCard(TYPICAL_RECORDS.get(i));
            Record expectedRecord = TYPICAL_RECORDS.get(i);
            RecordCardHandle actualCard = recordListPanelHandle.getRecordCardHandle(i);

            assertCardDisplaysRecord(expectedRecord, actualCard);
            assertEquals(Integer.toString(i + 1) + ". ", actualCard.getId());
        }
    }

    @Test
    public void handleJumpToListRequestEvent() {
        initUi(TYPICAL_RECORDS);
        postNow(JUMP_TO_SECOND_EVENT);
        guiRobot.pauseForHuman();

        RecordCardHandle expectedRecord = recordListPanelHandle.getRecordCardHandle(INDEX_SECOND_RECORD.getZeroBased());
        RecordCardHandle selectedRecord = recordListPanelHandle.getHandleToSelectedCard();
        assertCardEquals(expectedRecord, selectedRecord);
    }

    /**
     * Verifies that creating and deleting large number of records in {@code RecordListPanel} requires lesser than
     * {@code CARD_CREATION_AND_DELETION_TIMEOUT} milliseconds to execute.
     */
    @Test
    public void performanceTest() throws Exception {
        ObservableList<Record> backingList = createBackingList(10000);

        assertTimeoutPreemptively(ofMillis(CARD_CREATION_AND_DELETION_TIMEOUT), () -> {
            initUi(backingList);
            guiRobot.interact(backingList::clear);
        }, "Creation and deletion of record cards exceeded time limit");
    }

    /**
     * Returns a list of records containing {@code recordCount} records that is used to populate the
     * {@code RecordListPanel}.
     */
    private ObservableList<Record> createBackingList(int recordCount) throws Exception {
        Path xmlFile = createXmlFileWithRecords(recordCount);
        XmlSerializableAddressBook xmlAddressBook =
                XmlUtil.getDataFromFile(xmlFile, XmlSerializableAddressBook.class);
        return FXCollections.observableArrayList(xmlAddressBook.toModelType().getRecordList());
    }

    /**
     * Returns a .xml file containing {@code recordCount} records. This file will be deleted when the JVM terminates.
     */
    private Path createXmlFileWithRecords(int recordCount) throws Exception {
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
        builder.append("<addressbook>\n");
        for (int i = 0; i < recordCount; i++) {
            builder.append("<records>\n");
            builder.append("<name>").append(i).append("a</name>\n");
            builder.append("<date>10-10-2000</date>\n");
<<<<<<< HEAD
            builder.append("<income>1.1</income>\n");
            builder.append("<expense>0.1</expense>\n");
=======
            builder.append("<moneyFlow>-1.1</moneyFlow>\n");
>>>>>>> 12efdcfc71105647819ba78569b6ea0fdd33c31e
            builder.append("</records>\n");
        }
        builder.append("</addressbook>\n");

        Path manyRecordsFile = Paths.get(TEST_DATA_FOLDER + "manyRecords.xml");
        FileUtil.createFile(manyRecordsFile);
        FileUtil.writeToFile(manyRecordsFile, builder.toString());
        manyRecordsFile.toFile().deleteOnExit();
        return manyRecordsFile;
    }

    /**
     * Initializes {@code recordListPanelHandle} with a {@code RecordListPanel} backed by {@code backingList}.
     * Also shows the {@code Stage} that displays only {@code RecordListPanel}.
     */
    private void initUi(ObservableList<Record> backingList) {
        RecordListPanel recordListPanel = new RecordListPanel(backingList);
        uiPartRule.setUiPart(recordListPanel);

        recordListPanelHandle = new RecordListPanelHandle(getChildNode(recordListPanel.getRoot(),
                RecordListPanelHandle.RECORD_LIST_VIEW_ID));
    }
}

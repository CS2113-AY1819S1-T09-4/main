package seedu.planner.model.summary;

import java.util.HashMap;

import seedu.planner.model.record.Date;
import seedu.planner.model.record.Record;
import seedu.planner.model.record.exceptions.RecordNotFoundException;

/**
 * This object represents the in memory model of a HashMap containing {@Summary} as values and
 * retrieved using {@Date} as keys. It supports the usual addition, deletion, editing and find operations
 */
public class SummaryHashMap {

    private HashMap<Date, Summary> summaryMap;

    public SummaryHashMap() {
        summaryMap = new HashMap();
    }

    /**
     * Adds the record's moneyflow into the summary hashMap
     */
    public void add(Record record) {
        Date dateOfRecord = record.getDate();
        if (!isDatePresentInMap(dateOfRecord)) {
            summaryMap.put(dateOfRecord, new Summary(record));
        } else {
            summaryMap.get(dateOfRecord).add(record);
        }
    }

    /**
     * Subtracts the record's moneyflow from the summary hashMap
     * The date must exist in the hashMap.
     */
    public void remove(Record record) {
        Date dateOfRecord = record.getDate();
        if (!isDatePresentInMap(dateOfRecord)) {
            throw new RecordNotFoundException();
        }
        summaryMap.get(dateOfRecord).remove(record);
    }

    /**
     * Updates the summary map with the moneyflow of {@code target} and {@code editedRecord}
     * Subtracts target's moneyflow from summary hashMap before adding editedRecord's moneyflow to summary hashMap
     */
    public void update(Record target, Record editedRecord) {
        remove(target);
        add(target);
    }

    private boolean isDatePresentInMap(Date date) {
        return summaryMap.containsKey(date);
    }
}
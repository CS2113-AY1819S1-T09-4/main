package seedu.planner.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import seedu.planner.model.summary.CategoryStatistic;

/**
 * This class is responsible for converting data as a {@code ObservableList<CategoryStatistic>} into data that can be
 * easily read by the custom pieChart implementation which requires different values for the label and the legend
 */
public class MixedPieChartDataList {

    private static final String untaggedLabel = "<<untagged>>";

    private List<ChartData> expenseChartLabelData;

    private List<ChartData> incomeChartLabelData;
    private List<ChartData> expenseChartLegendData;
    private List<ChartData> incomeChartLegendData;

    private Double totalIncome = 0.0;
    private Double totalExpense = 0.0;

    public MixedPieChartDataList(ObservableList<CategoryStatistic> data) {
        expenseChartLabelData = new ArrayList<>();
        incomeChartLabelData = new ArrayList<>();
        for (CategoryStatistic d : data) {
            addToExpenseLabelData(d);
            addToIncomeLabelData(d);
        }
        expenseChartLegendData = expenseChartLabelData.stream().map(d -> convertToPercentages(d, totalExpense))
                .collect(Collectors.toList());
        incomeChartLegendData = incomeChartLabelData.stream().map(d -> convertToPercentages(d, totalIncome))
                .collect(Collectors.toList());
    }

    /**
     * Process given data and adds new ChartData to the incomeChartLabelData
     * @param data data to be added
     */
    private void addToIncomeLabelData(CategoryStatistic data) {
        if (data.getTotalIncome() > 0.0) {
            String label;
            if (data.getTags().isEmpty()) {
                label = untaggedLabel;
            } else {
                label = data.getTags().toString();
            }
            incomeChartLabelData.add(new ChartData(label, data.getTotalIncome()));
            totalIncome += data.getTotalIncome();
        } else {
            return;
        }
    }

    /**
     * Process given data and adds new ChartData to the expenseChartLabelData
     * @param data data to be added
     */
    private void addToExpenseLabelData(CategoryStatistic data) {
        if (data.getTotalExpense() > 0.0) {
            String label;
            if (data.getTags().isEmpty()) {
                label = untaggedLabel;
            } else {
                label = data.getTags().toString();
            }
            expenseChartLabelData.add(new ChartData(label, data.getTotalExpense()));
            totalExpense += data.getTotalExpense();
        } else {
            return;
        }
    }

    /**
     * Computes the proportion of a given {@code ChartData} data over the given total amount
     * @param data data to be converted
     * @param total reference total amount
     * @return
     */
    private ChartData convertToPercentages(ChartData data, Double total) {
        if (total > 0.0) {
            Double newValue = Double.parseDouble(String.format("%.2f", data.value / total * 100.0));
            return new ChartData(data.key, newValue);
        } else {
            return data;
        }
    }

    public boolean isExpenseDataEmpty() {
        return expenseChartLabelData.size() == 0 && expenseChartLegendData.size() == 0;
    }

    public boolean isIncomeDataEmpty() {
        return incomeChartLabelData.size() == 0 && incomeChartLegendData.size() == 0;
    }

    public List<ChartData> getExpenseChartLabelData() {
        return expenseChartLabelData;
    }

    public List<ChartData> getIncomeChartLabelData() {
        return incomeChartLabelData;
    }

    public List<ChartData> getExpenseChartLegendData() {
        return expenseChartLegendData;
    }

    public List<ChartData> getIncomeChartLegendData() {
        return incomeChartLegendData;
    }
}
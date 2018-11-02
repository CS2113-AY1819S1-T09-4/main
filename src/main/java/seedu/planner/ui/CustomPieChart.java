package seedu.planner.ui;

import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
//@@author tenvinc
/**
 * This class is a custom PieChart class that can be used to display statistics in FinancialPlanner
 */
public class CustomPieChart extends PieChart {

    public static final String CSS_FILE = "view/DarkTheme.css";

    public CustomPieChart(List<ChartData> labelData, List<ChartData> legendData) {
        super();
        ObservableList<Data> labelDataWithPercent = FXCollections.observableList(labelData.stream()
                .map(c -> new Data(c.key, c.value)).collect(Collectors.toList()));
        getStylesheets().add(CSS_FILE);
        setLegend(new CustomLegend(this, legendData));
        setData(labelDataWithPercent);
        labelDataWithPercent.forEach(data ->
                data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), "%")));
    }
    /**
     * This class represents a customized legend panel for the pieChart
     */
    class CustomLegend extends GridPane {

        CustomLegend(PieChart chart, List<ChartData> pieChartData) {
            setHgap(10);
            setVgap(10);
            int index = 0;
            for (ChartData d : pieChartData) {
                Label legendText = createLabel(d.key + "   " + convertToMoney(d.value));
                legendText.setWrapText(true);
                addRow(index, createSymbol(pieChartData.indexOf(d)), legendText);
                index++;
            }
        }

        private Label createLabel(String text) {
            Label label = new Label(text);
            label.getStyleClass().add("default-legend-text");
            return label;
        }

        private String convertToMoney(Double data) {
            return String.format("$%.2f", data);
        }

        /**
         * Creates the symbol to be placed at the side of the label
         */
        private Node createSymbol(int index) {
            Shape symbol = new Rectangle(10, 10, 10, 10);
            symbol.getStyleClass().add(String.format("default-color%d-chart-pie-legend", index % 8));
            return symbol;
        }

    }
}

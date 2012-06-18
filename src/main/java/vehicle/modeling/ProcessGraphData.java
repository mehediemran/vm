package vehicle.modeling;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;

/**
 * @author Atiqur Rahman
 * @since 6/18/12 3:20 PM
 */
public class ProcessGraphData {
    public static ChartPanel getChart(String graphTitle, String graphDataTitle, Dimension size) {

        XYSeriesCollection dataSet = getDataSet(graphTitle, graphDataTitle);

        JFreeChart chart = ChartFactory.createXYLineChart(graphTitle, // chart title
                "X", // domain axis label
                "Y", // range axis label
                dataSet, // data
                PlotOrientation.VERTICAL,
                false,
                true,
                false
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(size));
        chartPanel.setVisible(true);
        return chartPanel;
    }

    public static XYSeriesCollection getDataSet(String graphTitle, String graphDataTitle) {
        XYSeries series1 = new XYSeries(graphTitle);

        try {
            DataInputStream in = new DataInputStream(ProcessGraphData.class.getResourceAsStream("/graph-data.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str = br.readLine()) != null) {
                if (graphDataTitle.equalsIgnoreCase(str)) {
                    break;
                }
            }
            String dataX = "";
            String dataY = "";
            while ((str = br.readLine()) != null) {
                if ("$".equalsIgnoreCase(str)) {
                    break;
                }
                if (str.startsWith("x")) {
                    dataX = str;
                }
                if (str.startsWith("y")) {
                    dataY = str;
                }
            }

            dataX = dataX.replaceAll("x ", "").replaceAll("  ", " ");
            dataY = dataY.replaceAll("y ", "").replaceAll("  ", " ");

            String[] splitDataX = dataX.split(", ");
            String[] splitDataY = dataY.split(", ");

            for (int i = 0; i < splitDataX.length; i++) {
                series1.add(Double.valueOf(splitDataX[i]), Double.valueOf(splitDataY[i]));
            }

            in.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        XYSeriesCollection dataSet = new XYSeriesCollection();
        dataSet.addSeries(series1);
        return dataSet;
    }
}

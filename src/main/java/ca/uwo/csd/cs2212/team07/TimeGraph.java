package ca.uwo.csd.cs2212.team07;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.sql.Time;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.json.JSONException;

/**
 * TimeGraph Class: This class creates a Graph window to display time series
 * information
 *
 * @author Team07 CS2212
 */
public class TimeGraph extends ApplicationFrame {

    /**
     * CONSTRUCTOR METHOD: Creates a new TimeGraph
     *
     * @param title Title String of graph
     * @param yAxisTitle Y axis label string of graph (x axis will always be
     * time)
     * @param timeData TimeSeriesData object that will be used to populate data points on the graph
     */
    public TimeGraph(final String title, final String yAxisTitle, TimeSeriesData timeData) {
        super(title); // create new ApplicationFrame object with the title
        final XYDataset dataset = createDataset(timeData); // create dataset out of TimeSeriesData object that was paramatized
        final JFreeChart chart = createChart(dataset, title, yAxisTitle); // create JFreeChart using the dataset, title and y axis title
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370)); //set dimensions of Graph window

        chartPanel.setMouseZoomable(true, false); // set zoomable in the x axis, but not the y axis
        chartPanel.setRangeZoomable(false);
        setContentPane(chartPanel); 

        StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme(); // set chart theme
        chart.getPlot().setBackgroundPaint(Color.WHITE); // set background colour of chart

        chart.getTitle().setFont(new Font("Arial", 1, 24)); // set font and size of title

        chart.getXYPlot().setDomainCrosshairVisible(true); // show where user clicked
        chart.getXYPlot().setDomainCrosshairLockedOnData(true);
        chart.getXYPlot().setRangeCrosshairVisible(true);
        chart.getXYPlot().setRangeCrosshairLockedOnData(true);

    }

    /**
     * showGraph() method: Displays the window that holds the time series graph
     */
    private void showGraph() {
        this.pack();
        this.setVisible(true); // set the graph as visible
    }

    /**
     * createDataset() method: converts the TimeSeriesData object into a dataset that the graph can use for population
     * @param data TimeSeriesData that will be used to populate TimeGraph
     * @return XYDataset in proper format that JFreeChart API can use
     */
    private XYDataset createDataset(TimeSeriesData data) {
        
        final TimeSeries series = new TimeSeries("Fitbit Data");  //create TimeSeries object
        
        for (int i = 0; i < data.getDatasetLength(); i++) { // loop through every data point in the TimeSeriesData object
            try {
                TimePoint currentTimePoint = data.getTimePoint(i);
                
                // add each of these data points into the TimeSeries object, the time and the value
                series.add(new Minute(Time.valueOf(currentTimePoint.getTime())), currentTimePoint.getValue()); 

            } catch (SeriesException e) { // throw exception if there was a error parsing into the TimeSeries
                System.err.println("Error adding to series");
            }
        }

        return new TimeSeriesCollection(series); // return the TimeSeriesCollection that the chart will be able to use for population
    }

    /**
     * createChart() method: specifies the details of the chart
     * @param dataset data that will be used to populate chart
     * @param title title of graph
     * @param yAxisTitle String of title of Y axis (distance, calories, steps, heartrate)
     * @return the created Time Series Chart
     */
    private JFreeChart createChart(final XYDataset dataset, String title, String yAxisTitle) {
        return ChartFactory.createTimeSeriesChart(
                title,
                "Time",
                yAxisTitle,
                dataset,
                false,
                false,
                false);
    }

}

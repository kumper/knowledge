package pl.kp.vaadinchart;

import org.dussan.vaadin.dcharts.DCharts;
import org.dussan.vaadin.dcharts.base.elements.XYaxis;
import org.dussan.vaadin.dcharts.data.DataSeries;
import org.dussan.vaadin.dcharts.data.Ticks;
import org.dussan.vaadin.dcharts.events.click.ChartDataClickEvent;
import org.dussan.vaadin.dcharts.events.click.ChartDataClickHandler;
import org.dussan.vaadin.dcharts.events.mouseenter.ChartDataMouseEnterEvent;
import org.dussan.vaadin.dcharts.events.mouseenter.ChartDataMouseEnterHandler;
import org.dussan.vaadin.dcharts.events.mouseleave.ChartDataMouseLeaveEvent;
import org.dussan.vaadin.dcharts.events.mouseleave.ChartDataMouseLeaveHandler;
import org.dussan.vaadin.dcharts.events.rightclick.ChartDataRightClickEvent;
import org.dussan.vaadin.dcharts.events.rightclick.ChartDataRightClickHandler;
import org.dussan.vaadin.dcharts.metadata.renderers.AxisRenderers;
import org.dussan.vaadin.dcharts.metadata.renderers.SeriesRenderers;
import org.dussan.vaadin.dcharts.options.Axes;
import org.dussan.vaadin.dcharts.options.Highlighter;
import org.dussan.vaadin.dcharts.options.Options;
import org.dussan.vaadin.dcharts.options.SeriesDefaults;

import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MyChart extends VerticalLayout {

	public MyChart() {
		init();
	}

	private void init() {
		DataSeries dataSeries = new DataSeries().add(2, 6, 7, 10);

		SeriesDefaults seriesDefaults = new SeriesDefaults()
				.setRenderer(SeriesRenderers.BAR);

		Axes axes = new Axes().addAxis(new XYaxis().setRenderer(
				AxisRenderers.CATEGORY).setTicks(
				new Ticks().add("a", "b", "c", "d")));

		Highlighter highlighter = new Highlighter().setShow(false);

		Options options = new Options().setCaptureRightClick(true)
				.setSeriesDefaults(seriesDefaults).setAxes(axes)
				.setHighlighter(highlighter);

		DCharts chart = new DCharts();
		
		addComponent(chart);

		chart.setEnableChartDataMouseEnterEvent(true);
		chart.setEnableChartDataMouseLeaveEvent(true);
		chart.setEnableChartDataClickEvent(true);
		chart.setEnableChartDataRightClickEvent(true);

		chart.addHandler(new ChartDataMouseEnterHandler() {
			@Override
			public void onChartDataMouseEnter(ChartDataMouseEnterEvent event) {
				Notification.show(String.format("%s: %s",
						"CHART DATA MOUSE ENTER", event.getChartData()));
			}
		});

		chart.addHandler(new ChartDataMouseLeaveHandler() {
			@Override
			public void onChartDataMouseLeave(ChartDataMouseLeaveEvent event) {
				Notification.show(String.format("%s: %s",
						"CHART DATA MOUSE LEAVE", event.getChartData()));
			}
		});

		chart.addHandler(new ChartDataClickHandler() {
			@Override
			public void onChartDataClick(ChartDataClickEvent event) {
				Notification.show(String.format("%s: %s", "CHART DATA CLICK",
						event.getChartData()));
			}
		});

		chart.addHandler(new ChartDataRightClickHandler() {
			@Override
			public void onChartDataRightClick(ChartDataRightClickEvent event) {
				Notification.show(String.format("%s: %s",
						"CHART DATA RIGHT CLICK", event.getChartData()));
			}
		});

		chart.setDataSeries(dataSeries).setOptions(options).show();
	}
}

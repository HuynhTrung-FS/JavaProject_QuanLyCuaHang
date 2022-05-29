/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Chart;

import java.awt.Graphics2D;

/**
 *
 * @author ADMIN
 */
public abstract class BlankPlotChartRender {

    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Chart;

/**
 *
 * @author ADMIN
 */
public class ModelChart {
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the values
     */
    public double[] getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(double[] values) {
        this.values = values;
    }
    

    public ModelChart() {
    }

    public ModelChart(String label, double[] values) {
        this.label = label;
        this.values = values;
    }
    private String label;
    private double values[];
    public double getMaxValues(){
        double max = 0;
        for(double v : values){
            if (v > max){
                max = v;
            }
        }
        return max;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Calendar;

/**
 *
 * @author ADMIN
 */
public class DayChoose {

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public DayChoose(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public DayChoose() {
    }

    private int day;
    private int month;
    private int year;

    public boolean isToDay(DayChoose date) {
        return day == date.getDay() && month == date.getMonth() && year == date.getYear();
    }
}

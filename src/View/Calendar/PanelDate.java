/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Calendar;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class PanelDate extends javax.swing.JLayeredPane {
    
    private int month;
    private int year;
    public PanelDate(int month,int year) {
        initComponents();
        this.year = year;
        this.month = month;
        init();
    }
    private void init(){
        mon.asTitle();
        tue.asTitle();
        wed.asTitle();
        thu.asTitle();
        fri.asTitle();
        sat.asTitle();
        sun.asTitle();
        setDate();
    }
    private void setDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK)-1;
        calendar.add(Calendar.DATE, -startDay);
        DayChoose day = getDayChoose();
        for(Component com: getComponents()){
            CellDay cell = (CellDay)com;
            if(!cell.isTitle()){
                cell.setText(calendar.get(Calendar.DATE)+ "");
                cell.setDate(calendar.getTime());
                cell.currentMonth(calendar.get(Calendar.MONTH)== month -1);
                if(day.isToDay(new DayChoose(calendar.get(Calendar.DATE),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR)))){
                    cell.setAsDayChoose();
                }
                calendar.add(Calendar.DATE, 1);
            }
        }
    }
    private DayChoose getDayChoose(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return new DayChoose(calendar.get(Calendar.DATE),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.YEAR));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sun = new View.Calendar.CellDay();
        mon = new View.Calendar.CellDay();
        tue = new View.Calendar.CellDay();
        wed = new View.Calendar.CellDay();
        thu = new View.Calendar.CellDay();
        fri = new View.Calendar.CellDay();
        sat = new View.Calendar.CellDay();
        cellDay7 = new View.Calendar.CellDay();
        cellDay9 = new View.Calendar.CellDay();
        cellDay10 = new View.Calendar.CellDay();
        cellDay11 = new View.Calendar.CellDay();
        cellDay12 = new View.Calendar.CellDay();
        cellDay13 = new View.Calendar.CellDay();
        cellDay14 = new View.Calendar.CellDay();
        cellDay15 = new View.Calendar.CellDay();
        cellDay16 = new View.Calendar.CellDay();
        cellDay17 = new View.Calendar.CellDay();
        cellDay18 = new View.Calendar.CellDay();
        cellDay19 = new View.Calendar.CellDay();
        cellDay20 = new View.Calendar.CellDay();
        cellDay21 = new View.Calendar.CellDay();
        cellDay22 = new View.Calendar.CellDay();
        cellDay23 = new View.Calendar.CellDay();
        cellDay24 = new View.Calendar.CellDay();
        cellDay25 = new View.Calendar.CellDay();
        cellDay26 = new View.Calendar.CellDay();
        cellDay27 = new View.Calendar.CellDay();
        cellDay28 = new View.Calendar.CellDay();
        cellDay29 = new View.Calendar.CellDay();
        cellDay30 = new View.Calendar.CellDay();
        cellDay31 = new View.Calendar.CellDay();
        cellDay32 = new View.Calendar.CellDay();
        cellDay33 = new View.Calendar.CellDay();
        cellDay34 = new View.Calendar.CellDay();
        cellDay35 = new View.Calendar.CellDay();
        cellDay36 = new View.Calendar.CellDay();
        cellDay37 = new View.Calendar.CellDay();
        cellDay38 = new View.Calendar.CellDay();
        cellDay39 = new View.Calendar.CellDay();
        cellDay40 = new View.Calendar.CellDay();
        cellDay41 = new View.Calendar.CellDay();
        cellDay42 = new View.Calendar.CellDay();
        cellDay43 = new View.Calendar.CellDay();
        cellDay44 = new View.Calendar.CellDay();
        cellDay45 = new View.Calendar.CellDay();
        cellDay46 = new View.Calendar.CellDay();
        cellDay47 = new View.Calendar.CellDay();
        cellDay48 = new View.Calendar.CellDay();
        cellDay49 = new View.Calendar.CellDay();

        setLayout(new java.awt.GridLayout(7, 7));

        sun.setForeground(new java.awt.Color(255, 0, 0));
        sun.setText("Sun");
        sun.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(sun);

        mon.setText("Mon");
        mon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(mon);

        tue.setText("Tue");
        tue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(tue);

        wed.setText("Wed");
        wed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(wed);

        thu.setText("Thu");
        thu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(thu);

        fri.setText("Fri");
        fri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(fri);

        sat.setText("Sat");
        sat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(sat);

        cellDay7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay7);

        cellDay9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay9);

        cellDay10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay10);

        cellDay11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay11);

        cellDay12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay12);

        cellDay13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay13);

        cellDay14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay14);

        cellDay15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay15);

        cellDay16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay16);

        cellDay17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay17);

        cellDay18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay18);

        cellDay19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay19);

        cellDay20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay20);

        cellDay21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay21);

        cellDay22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay22);

        cellDay23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay23);

        cellDay24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay24);

        cellDay25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay25);

        cellDay26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay26);

        cellDay27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay27);

        cellDay28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay28);

        cellDay29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay29);

        cellDay30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay30);

        cellDay31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay31);

        cellDay32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay32);

        cellDay33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay33);

        cellDay34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay34);

        cellDay35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay35);

        cellDay36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay36);

        cellDay37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay37);

        cellDay38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay38);

        cellDay39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay39);

        cellDay40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay40);

        cellDay41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay41);

        cellDay42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay42);

        cellDay43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay43);

        cellDay44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay44);

        cellDay45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay45);

        cellDay46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay46);

        cellDay47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay47);

        cellDay48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay48);

        cellDay49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(cellDay49);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Calendar.CellDay cellDay10;
    private View.Calendar.CellDay cellDay11;
    private View.Calendar.CellDay cellDay12;
    private View.Calendar.CellDay cellDay13;
    private View.Calendar.CellDay cellDay14;
    private View.Calendar.CellDay cellDay15;
    private View.Calendar.CellDay cellDay16;
    private View.Calendar.CellDay cellDay17;
    private View.Calendar.CellDay cellDay18;
    private View.Calendar.CellDay cellDay19;
    private View.Calendar.CellDay cellDay20;
    private View.Calendar.CellDay cellDay21;
    private View.Calendar.CellDay cellDay22;
    private View.Calendar.CellDay cellDay23;
    private View.Calendar.CellDay cellDay24;
    private View.Calendar.CellDay cellDay25;
    private View.Calendar.CellDay cellDay26;
    private View.Calendar.CellDay cellDay27;
    private View.Calendar.CellDay cellDay28;
    private View.Calendar.CellDay cellDay29;
    private View.Calendar.CellDay cellDay30;
    private View.Calendar.CellDay cellDay31;
    private View.Calendar.CellDay cellDay32;
    private View.Calendar.CellDay cellDay33;
    private View.Calendar.CellDay cellDay34;
    private View.Calendar.CellDay cellDay35;
    private View.Calendar.CellDay cellDay36;
    private View.Calendar.CellDay cellDay37;
    private View.Calendar.CellDay cellDay38;
    private View.Calendar.CellDay cellDay39;
    private View.Calendar.CellDay cellDay40;
    private View.Calendar.CellDay cellDay41;
    private View.Calendar.CellDay cellDay42;
    private View.Calendar.CellDay cellDay43;
    private View.Calendar.CellDay cellDay44;
    private View.Calendar.CellDay cellDay45;
    private View.Calendar.CellDay cellDay46;
    private View.Calendar.CellDay cellDay47;
    private View.Calendar.CellDay cellDay48;
    private View.Calendar.CellDay cellDay49;
    private View.Calendar.CellDay cellDay7;
    private View.Calendar.CellDay cellDay9;
    private View.Calendar.CellDay fri;
    private View.Calendar.CellDay mon;
    private View.Calendar.CellDay sat;
    private View.Calendar.CellDay sun;
    private View.Calendar.CellDay thu;
    private View.Calendar.CellDay tue;
    private View.Calendar.CellDay wed;
    // End of variables declaration//GEN-END:variables
}

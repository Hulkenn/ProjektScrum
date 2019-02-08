package scrumprojekt;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import oru.inf.InfDB;
import oru.inf.InfException;

public class Kalender extends javax.swing.JFrame {
    
    private InfDB db;
    private int user_id = 1;
    private ArrayList<HashMap<String,String>> events_month;
    
    public Kalender() {
        initComponents();
        
        try{
            db=new InfDB(System.getProperty("user.dir")+"/scrumdb.fdb");
        } catch(InfException ex){
            
        }
        
        addDays();
        
        /*JLabel new_event = new JLabel("XD", SwingConstants.LEFT);
        day1.setLayout(new BoxLayout(day1, BoxLayout.PAGE_AXIS));
        day1.add(new_event, BorderLayout.PAGE_START);*/
        
        
    }
    
    public void resetDays() {
        lblEvent1.setText("");
        lblEvent2.setText("");
        lblEvent3.setText("");
        lblEvent4.setText("");
        lblEvent5.setText("");
        lblEvent6.setText("");
        lblEvent7.setText("");
        lblEvent8.setText("");
        lblEvent9.setText("");
        lblEvent10.setText("");
        lblEvent11.setText("");
        lblEvent12.setText("");
        lblEvent13.setText("");
        lblEvent14.setText("");
        lblEvent15.setText("");
        lblEvent16.setText("");
        lblEvent17.setText("");
        lblEvent18.setText("");
        lblEvent19.setText("");
        lblEvent20.setText("");
        lblEvent21.setText("");
        lblEvent22.setText("");
        lblEvent23.setText("");
        lblEvent24.setText("");
        lblEvent25.setText("");
        lblEvent26.setText("");
        lblEvent27.setText("");
        lblEvent28.setText("");
        lblEvent29.setText("");
        lblEvent30.setText("");
        lblEvent31.setText("");
        
    }
    
    public void addDays() {
        events_month = fetchEvents(db, Integer.parseInt(cbxYear.getSelectedItem().toString()), convertMonth(cbxMonth.getSelectedItem().toString()));
        
        if(events_month != null) {
            for(HashMap event : events_month) {
                String[] dateString = event.get("EVENTDATE").toString().split("-");
                int currDay = Integer.parseInt(dateString[2]);
                JLabel lbl = convertDay(currDay);
                lbl.setText("Events...");
            }
        }
    }

    public String convertMonth(String cbx){
        String cbxMonthString = cbx;
        String monthString = "";
        switch (cbxMonthString) {
            case "January":  monthString = "01";
                     break;
            case "February":  monthString = "02";
                     break;
            case "March":  monthString = "03";
                     break;
            case "April":  monthString = "04";
                     break;
            case "May":  monthString = "05";
                     break;
            case "June":  monthString = "06";
                     break;
            case "July":  monthString = "07";
                     break;
            case "August":  monthString = "08";
                     break;
            case "September":  monthString = "09";
                     break;
            case "October": monthString = "10";
                     break;
            case "November": monthString = "11";
                     break;
            case "December": monthString = "12";
                     break;
        }
        return monthString;
    }
    
    public JLabel convertDay(int day){
        JLabel lbl=null;
        switch(day){
            case 1: lbl = lblEvent1;
            break;
            case 2: lbl = lblEvent2;
            break;
            case 3: lbl = lblEvent3;
            break;
            case 4: lbl = lblEvent4;
            break;
            case 5: lbl = lblEvent5;
            break;
            case 6: lbl = lblEvent6;
            break;
            case 7: lbl = lblEvent7;
            break;
            case 8: lbl = lblEvent8;
            break;
            case 9: lbl = lblEvent9;
            break;
            case 10: lbl = lblEvent10;
            break;
            case 11: lbl = lblEvent11;
            break;
            case 12: lbl = lblEvent12;
            break;
            case 13: lbl = lblEvent13;
            break;
            case 14: lbl = lblEvent14;
            break;
            case 15: lbl = lblEvent15;
            break;
            case 16: lbl = lblEvent16;
            break;
            case 17: lbl = lblEvent17;
            break;
            case 18: lbl = lblEvent18;
            break;
            case 19: lbl = lblEvent19;
            break;
            case 20: lbl = lblEvent20;
            break;
            case 21: lbl = lblEvent21;
            break;
            case 22: lbl = lblEvent22;
            break;
            case 23: lbl = lblEvent23;
            break;
            case 24: lbl = lblEvent24;
            break;
            case 25: lbl = lblEvent25;
            break;
            case 26: lbl = lblEvent26;
            break;
            case 27: lbl = lblEvent27;
            break;
            case 28: lbl = lblEvent28;
            break;
            case 29: lbl = lblEvent29;
            break;
            case 30: lbl = lblEvent30;
            break;
            case 31: lbl = lblEvent31;
            break;
        }
        return lbl;
    } 

    public void insertEvent(InfDB db,String date,String description){
        int id = 0;
        try{
        id = Integer.parseInt(db.getAutoIncrement("EVENTS","IDEVENTS"));
        } catch(InfException ex){
            System.out.println("Error");
        }
        
        try{
        db.insert("INSERT INTO EVENTS VALUES("+id+",'"+date+"','"+description+"',0,0,1)");
        }catch(InfException e){
            System.out.println("något gick fel");
        }
    }
    
    public ArrayList<HashMap<String,String>> fetchEvents(InfDB db, int year, String month){
        ArrayList<HashMap<String,String>> dates = null;
        HashMap<String,String> dates2 =null;
        try{
        dates = db.fetchRows("SELECT EVENTDATE FROM EVENTS WHERE EVENTDATE LIKE '"+year+"-"+month+"%'");
        }catch(InfException ex){
            System.out.println("Error med sql år och månad");
        }
        return dates;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        cbxMonth = new javax.swing.JComboBox<>();
        cbxYear = new javax.swing.JComboBox<>();
        day1 = new javax.swing.JPanel();
        lblDay1 = new javax.swing.JLabel();
        lblEvent1 = new javax.swing.JLabel();
        day2 = new javax.swing.JPanel();
        lblDay2 = new javax.swing.JLabel();
        lblEvent2 = new javax.swing.JLabel();
        day3 = new javax.swing.JPanel();
        lblDay3 = new javax.swing.JLabel();
        lblEvent3 = new javax.swing.JLabel();
        day4 = new javax.swing.JPanel();
        lblDay4 = new javax.swing.JLabel();
        lblEvent4 = new javax.swing.JLabel();
        day5 = new javax.swing.JPanel();
        lblDay5 = new javax.swing.JLabel();
        lblEvent5 = new javax.swing.JLabel();
        day6 = new javax.swing.JPanel();
        lblDay6 = new javax.swing.JLabel();
        lblEvent6 = new javax.swing.JLabel();
        day7 = new javax.swing.JPanel();
        lblDay7 = new javax.swing.JLabel();
        lblEvent7 = new javax.swing.JLabel();
        day8 = new javax.swing.JPanel();
        lblDay8 = new javax.swing.JLabel();
        lblEvent8 = new javax.swing.JLabel();
        day9 = new javax.swing.JPanel();
        lblDay9 = new javax.swing.JLabel();
        lblEvent9 = new javax.swing.JLabel();
        day10 = new javax.swing.JPanel();
        lblDay10 = new javax.swing.JLabel();
        lblEvent10 = new javax.swing.JLabel();
        day11 = new javax.swing.JPanel();
        lblDay11 = new javax.swing.JLabel();
        lblEvent11 = new javax.swing.JLabel();
        day12 = new javax.swing.JPanel();
        lblDay12 = new javax.swing.JLabel();
        lblEvent12 = new javax.swing.JLabel();
        day13 = new javax.swing.JPanel();
        lblDay13 = new javax.swing.JLabel();
        lblEvent13 = new javax.swing.JLabel();
        day14 = new javax.swing.JPanel();
        lblDay14 = new javax.swing.JLabel();
        lblEvent14 = new javax.swing.JLabel();
        day15 = new javax.swing.JPanel();
        lblDay15 = new javax.swing.JLabel();
        lblEvent15 = new javax.swing.JLabel();
        day16 = new javax.swing.JPanel();
        lblDay16 = new javax.swing.JLabel();
        lblEvent16 = new javax.swing.JLabel();
        day17 = new javax.swing.JPanel();
        lblDay17 = new javax.swing.JLabel();
        lblEvent17 = new javax.swing.JLabel();
        day18 = new javax.swing.JPanel();
        lblDay18 = new javax.swing.JLabel();
        lblEvent18 = new javax.swing.JLabel();
        day19 = new javax.swing.JPanel();
        lblDay19 = new javax.swing.JLabel();
        lblEvent19 = new javax.swing.JLabel();
        dau20 = new javax.swing.JPanel();
        lblDay20 = new javax.swing.JLabel();
        lblEvent20 = new javax.swing.JLabel();
        day21 = new javax.swing.JPanel();
        lblDay21 = new javax.swing.JLabel();
        lblEvent21 = new javax.swing.JLabel();
        day22 = new javax.swing.JPanel();
        lblDay22 = new javax.swing.JLabel();
        lblEvent22 = new javax.swing.JLabel();
        day23 = new javax.swing.JPanel();
        lblDay23 = new javax.swing.JLabel();
        lblEvent23 = new javax.swing.JLabel();
        day24 = new javax.swing.JPanel();
        lblDay24 = new javax.swing.JLabel();
        lblEvent24 = new javax.swing.JLabel();
        day25 = new javax.swing.JPanel();
        lblDay25 = new javax.swing.JLabel();
        lblEvent25 = new javax.swing.JLabel();
        day26 = new javax.swing.JPanel();
        lblDay26 = new javax.swing.JLabel();
        lblEvent26 = new javax.swing.JLabel();
        day27 = new javax.swing.JPanel();
        lblDay27 = new javax.swing.JLabel();
        lblEvent27 = new javax.swing.JLabel();
        day28 = new javax.swing.JPanel();
        lblDay28 = new javax.swing.JLabel();
        lblEvent28 = new javax.swing.JLabel();
        day29 = new javax.swing.JPanel();
        lblDay29 = new javax.swing.JLabel();
        lblEvent29 = new javax.swing.JLabel();
        day30 = new javax.swing.JPanel();
        lblDay30 = new javax.swing.JLabel();
        lblEvent30 = new javax.swing.JLabel();
        day31 = new javax.swing.JPanel();
        lblDay31 = new javax.swing.JLabel();
        lblEvent31 = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        btnAddEvent = new javax.swing.JButton();
        tfDecription = new javax.swing.JTextField();
        tfTag = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(250, 249, 246));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(50, 121, 184));

        cbxMonth.setBackground(new java.awt.Color(50, 121, 184));
        cbxMonth.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cbxMonth.setForeground(new java.awt.Color(255, 255, 255));
        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "November", "December" }));
        cbxMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxMonthItemStateChanged(evt);
            }
        });

        cbxYear.setBackground(new java.awt.Color(50, 121, 184));
        cbxYear.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        cbxYear.setForeground(new java.awt.Color(255, 255, 255));
        cbxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", " " }));
        cbxYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxYearItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(538, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1140, -1));

        day1.setBackground(new java.awt.Color(204, 204, 204));
        day1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day1MouseClicked(evt);
            }
        });

        lblDay1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay1.setText("1");

        lblEvent1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day1Layout = new javax.swing.GroupLayout(day1);
        day1.setLayout(day1Layout);
        day1Layout.setHorizontalGroup(
            day1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay1)
                .addGap(18, 18, 18)
                .addComponent(lblEvent1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        day1Layout.setVerticalGroup(
            day1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        bg.add(day1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 140, 100));

        day2.setBackground(new java.awt.Color(204, 204, 204));
        day2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day2MouseClicked(evt);
            }
        });

        lblDay2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay2.setText("2");

        lblEvent2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day2Layout = new javax.swing.GroupLayout(day2);
        day2.setLayout(day2Layout);
        day2Layout.setHorizontalGroup(
            day2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay2)
                .addGap(18, 18, 18)
                .addComponent(lblEvent2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day2Layout.setVerticalGroup(
            day2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        day3.setBackground(new java.awt.Color(204, 204, 204));
        day3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day3MouseClicked(evt);
            }
        });

        lblDay3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay3.setText("3");

        lblEvent3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day3Layout = new javax.swing.GroupLayout(day3);
        day3.setLayout(day3Layout);
        day3Layout.setHorizontalGroup(
            day3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay3)
                .addGap(18, 18, 18)
                .addComponent(lblEvent3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day3Layout.setVerticalGroup(
            day3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        day4.setBackground(new java.awt.Color(204, 204, 204));
        day4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day4MouseClicked(evt);
            }
        });

        lblDay4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay4.setText("4");

        lblEvent4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day4Layout = new javax.swing.GroupLayout(day4);
        day4.setLayout(day4Layout);
        day4Layout.setHorizontalGroup(
            day4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay4)
                .addGap(18, 18, 18)
                .addComponent(lblEvent4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day4Layout.setVerticalGroup(
            day4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, -1, -1));

        day5.setBackground(new java.awt.Color(204, 204, 204));
        day5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day5MouseClicked(evt);
            }
        });

        lblDay5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay5.setText("5");

        lblEvent5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day5Layout = new javax.swing.GroupLayout(day5);
        day5.setLayout(day5Layout);
        day5Layout.setHorizontalGroup(
            day5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay5)
                .addGap(18, 18, 18)
                .addComponent(lblEvent5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day5Layout.setVerticalGroup(
            day5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        day6.setBackground(new java.awt.Color(204, 204, 204));
        day6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day6MouseClicked(evt);
            }
        });

        lblDay6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay6.setText("6");

        lblEvent6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day6Layout = new javax.swing.GroupLayout(day6);
        day6.setLayout(day6Layout);
        day6Layout.setHorizontalGroup(
            day6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay6)
                .addGap(18, 18, 18)
                .addComponent(lblEvent6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day6Layout.setVerticalGroup(
            day6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, -1, -1));

        day7.setBackground(new java.awt.Color(204, 204, 204));
        day7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day7MouseClicked(evt);
            }
        });

        lblDay7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay7.setText("7");

        lblEvent7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day7Layout = new javax.swing.GroupLayout(day7);
        day7.setLayout(day7Layout);
        day7Layout.setHorizontalGroup(
            day7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay7)
                .addGap(18, 18, 18)
                .addComponent(lblEvent7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day7Layout.setVerticalGroup(
            day7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 120, -1, -1));

        day8.setBackground(new java.awt.Color(204, 204, 204));
        day8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day8MouseClicked(evt);
            }
        });

        lblDay8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay8.setText("8");

        lblEvent8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day8Layout = new javax.swing.GroupLayout(day8);
        day8.setLayout(day8Layout);
        day8Layout.setHorizontalGroup(
            day8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay8)
                .addGap(18, 18, 18)
                .addComponent(lblEvent8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day8Layout.setVerticalGroup(
            day8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        day9.setBackground(new java.awt.Color(204, 204, 204));
        day9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day9MouseClicked(evt);
            }
        });

        lblDay9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay9.setText("9");

        lblEvent9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day9Layout = new javax.swing.GroupLayout(day9);
        day9.setLayout(day9Layout);
        day9Layout.setHorizontalGroup(
            day9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay9)
                .addGap(18, 18, 18)
                .addComponent(lblEvent9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        day9Layout.setVerticalGroup(
            day9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        day10.setBackground(new java.awt.Color(204, 204, 204));
        day10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day10MouseClicked(evt);
            }
        });

        lblDay10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay10.setText("10");

        lblEvent10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day10Layout = new javax.swing.GroupLayout(day10);
        day10.setLayout(day10Layout);
        day10Layout.setHorizontalGroup(
            day10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay10)
                .addGap(18, 18, 18)
                .addComponent(lblEvent10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        day10Layout.setVerticalGroup(
            day10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 140, -1));

        day11.setBackground(new java.awt.Color(204, 204, 204));
        day11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day11MouseClicked(evt);
            }
        });

        lblDay11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay11.setText("11");

        lblEvent11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day11Layout = new javax.swing.GroupLayout(day11);
        day11.setLayout(day11Layout);
        day11Layout.setHorizontalGroup(
            day11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay11)
                .addGap(18, 18, 18)
                .addComponent(lblEvent11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day11Layout.setVerticalGroup(
            day11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, -1));

        day12.setBackground(new java.awt.Color(204, 204, 204));
        day12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day12MouseClicked(evt);
            }
        });

        lblDay12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay12.setText("12");

        lblEvent12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day12Layout = new javax.swing.GroupLayout(day12);
        day12.setLayout(day12Layout);
        day12Layout.setHorizontalGroup(
            day12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay12)
                .addGap(18, 18, 18)
                .addComponent(lblEvent12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day12Layout.setVerticalGroup(
            day12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        day13.setBackground(new java.awt.Color(204, 204, 204));
        day13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day13MouseClicked(evt);
            }
        });

        lblDay13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay13.setText("13");

        lblEvent13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day13Layout = new javax.swing.GroupLayout(day13);
        day13.setLayout(day13Layout);
        day13Layout.setHorizontalGroup(
            day13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay13)
                .addGap(18, 18, 18)
                .addComponent(lblEvent13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day13Layout.setVerticalGroup(
            day13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day13, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        day14.setBackground(new java.awt.Color(204, 204, 204));
        day14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day14MouseClicked(evt);
            }
        });

        lblDay14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay14.setText("14");

        lblEvent14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day14Layout = new javax.swing.GroupLayout(day14);
        day14.setLayout(day14Layout);
        day14Layout.setHorizontalGroup(
            day14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay14)
                .addGap(18, 18, 18)
                .addComponent(lblEvent14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day14Layout.setVerticalGroup(
            day14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day14, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 230, -1, -1));

        day15.setBackground(new java.awt.Color(204, 204, 204));
        day15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day15MouseClicked(evt);
            }
        });

        lblDay15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay15.setText("15");

        lblEvent15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent15MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day15Layout = new javax.swing.GroupLayout(day15);
        day15.setLayout(day15Layout);
        day15Layout.setHorizontalGroup(
            day15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay15)
                .addGap(18, 18, 18)
                .addComponent(lblEvent15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day15Layout.setVerticalGroup(
            day15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent15, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        day16.setBackground(new java.awt.Color(204, 204, 204));
        day16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day16MouseClicked(evt);
            }
        });

        lblDay16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay16.setText("16");

        lblEvent16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day16Layout = new javax.swing.GroupLayout(day16);
        day16.setLayout(day16Layout);
        day16Layout.setHorizontalGroup(
            day16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay16)
                .addGap(18, 18, 18)
                .addComponent(lblEvent16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day16Layout.setVerticalGroup(
            day16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent16, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

        day17.setBackground(new java.awt.Color(204, 204, 204));
        day17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day17MouseClicked(evt);
            }
        });

        lblDay17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay17.setText("17");

        lblEvent17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day17Layout = new javax.swing.GroupLayout(day17);
        day17.setLayout(day17Layout);
        day17Layout.setHorizontalGroup(
            day17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay17)
                .addGap(18, 18, 18)
                .addComponent(lblEvent17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day17Layout.setVerticalGroup(
            day17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        day18.setBackground(new java.awt.Color(204, 204, 204));
        day18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day18MouseClicked(evt);
            }
        });

        lblDay18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay18.setText("18");

        lblEvent18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent18MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day18Layout = new javax.swing.GroupLayout(day18);
        day18.setLayout(day18Layout);
        day18Layout.setHorizontalGroup(
            day18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay18)
                .addGap(18, 18, 18)
                .addComponent(lblEvent18, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day18Layout.setVerticalGroup(
            day18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day18, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 340, -1, -1));

        day19.setBackground(new java.awt.Color(204, 204, 204));
        day19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day19MouseClicked(evt);
            }
        });

        lblDay19.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay19.setText("19");

        lblEvent19.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day19Layout = new javax.swing.GroupLayout(day19);
        day19.setLayout(day19Layout);
        day19Layout.setHorizontalGroup(
            day19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay19)
                .addGap(18, 18, 18)
                .addComponent(lblEvent19, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day19Layout.setVerticalGroup(
            day19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day19, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, -1, -1));

        dau20.setBackground(new java.awt.Color(204, 204, 204));
        dau20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dau20MouseClicked(evt);
            }
        });

        lblDay20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay20.setText("20");

        lblEvent20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout dau20Layout = new javax.swing.GroupLayout(dau20);
        dau20.setLayout(dau20Layout);
        dau20Layout.setHorizontalGroup(
            dau20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dau20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay20)
                .addGap(18, 18, 18)
                .addComponent(lblEvent20, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        dau20Layout.setVerticalGroup(
            dau20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dau20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dau20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay20, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(dau20, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, -1));

        day21.setBackground(new java.awt.Color(204, 204, 204));
        day21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day21MouseClicked(evt);
            }
        });

        lblDay21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay21.setText("21");

        lblEvent21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day21Layout = new javax.swing.GroupLayout(day21);
        day21.setLayout(day21Layout);
        day21Layout.setHorizontalGroup(
            day21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay21)
                .addGap(18, 18, 18)
                .addComponent(lblEvent21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day21Layout.setVerticalGroup(
            day21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day21, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 340, -1, -1));

        day22.setBackground(new java.awt.Color(204, 204, 204));
        day22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day22MouseClicked(evt);
            }
        });

        lblDay22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay22.setText("22");

        lblEvent22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day22Layout = new javax.swing.GroupLayout(day22);
        day22.setLayout(day22Layout);
        day22Layout.setHorizontalGroup(
            day22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay22)
                .addGap(18, 18, 18)
                .addComponent(lblEvent22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day22Layout.setVerticalGroup(
            day22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay22, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        day23.setBackground(new java.awt.Color(204, 204, 204));
        day23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day23MouseClicked(evt);
            }
        });

        lblDay23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay23.setText("23");

        lblEvent23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent23MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day23Layout = new javax.swing.GroupLayout(day23);
        day23.setLayout(day23Layout);
        day23Layout.setHorizontalGroup(
            day23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay23)
                .addGap(18, 18, 18)
                .addComponent(lblEvent23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day23Layout.setVerticalGroup(
            day23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent23, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay23, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        day24.setBackground(new java.awt.Color(204, 204, 204));
        day24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day24MouseClicked(evt);
            }
        });

        lblDay24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay24.setText("24");

        lblEvent24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day24Layout = new javax.swing.GroupLayout(day24);
        day24.setLayout(day24Layout);
        day24Layout.setHorizontalGroup(
            day24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay24)
                .addGap(18, 18, 18)
                .addComponent(lblEvent24, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day24Layout.setVerticalGroup(
            day24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent24, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        day25.setBackground(new java.awt.Color(204, 204, 204));
        day25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day25MouseClicked(evt);
            }
        });

        lblDay25.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay25.setText("25");

        lblEvent25.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent25MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day25Layout = new javax.swing.GroupLayout(day25);
        day25.setLayout(day25Layout);
        day25Layout.setHorizontalGroup(
            day25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay25)
                .addGap(18, 18, 18)
                .addComponent(lblEvent25, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        day25Layout.setVerticalGroup(
            day25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent25, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 140, -1));

        day26.setBackground(new java.awt.Color(204, 204, 204));
        day26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day26MouseClicked(evt);
            }
        });

        lblDay26.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay26.setText("26");

        lblEvent26.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day26Layout = new javax.swing.GroupLayout(day26);
        day26.setLayout(day26Layout);
        day26Layout.setHorizontalGroup(
            day26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay26)
                .addGap(18, 18, 18)
                .addComponent(lblEvent26, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day26Layout.setVerticalGroup(
            day26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent26, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day26, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, -1, -1));

        day27.setBackground(new java.awt.Color(204, 204, 204));
        day27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day27MouseClicked(evt);
            }
        });

        lblDay27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay27.setText("27");

        lblEvent27.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent27MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day27Layout = new javax.swing.GroupLayout(day27);
        day27.setLayout(day27Layout);
        day27Layout.setHorizontalGroup(
            day27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay27)
                .addGap(18, 18, 18)
                .addComponent(lblEvent27, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day27Layout.setVerticalGroup(
            day27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent27, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day27, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        day28.setBackground(new java.awt.Color(204, 204, 204));
        day28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day28MouseClicked(evt);
            }
        });

        lblDay28.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay28.setText("28");

        lblEvent28.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day28Layout = new javax.swing.GroupLayout(day28);
        day28.setLayout(day28Layout);
        day28Layout.setHorizontalGroup(
            day28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay28)
                .addGap(18, 18, 18)
                .addComponent(lblEvent28, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day28Layout.setVerticalGroup(
            day28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent28, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay28, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day28, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, -1, -1));

        day29.setBackground(new java.awt.Color(204, 204, 204));
        day29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day29MouseClicked(evt);
            }
        });

        lblDay29.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay29.setText("29");

        lblEvent29.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent29MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day29Layout = new javax.swing.GroupLayout(day29);
        day29.setLayout(day29Layout);
        day29Layout.setHorizontalGroup(
            day29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay29)
                .addGap(18, 18, 18)
                .addComponent(lblEvent29, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        day29Layout.setVerticalGroup(
            day29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent29, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay29, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 140, -1));

        day30.setBackground(new java.awt.Color(204, 204, 204));
        day30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day30MouseClicked(evt);
            }
        });

        lblDay30.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay30.setText("30");

        lblEvent30.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent30MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day30Layout = new javax.swing.GroupLayout(day30);
        day30.setLayout(day30Layout);
        day30Layout.setHorizontalGroup(
            day30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay30)
                .addGap(18, 18, 18)
                .addComponent(lblEvent30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day30Layout.setVerticalGroup(
            day30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay30, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day30, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 560, -1, -1));

        day31.setBackground(new java.awt.Color(204, 204, 204));
        day31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                day31MouseClicked(evt);
            }
        });

        lblDay31.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDay31.setText("31");

        lblEvent31.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEvent31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEvent31MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout day31Layout = new javax.swing.GroupLayout(day31);
        day31.setLayout(day31Layout);
        day31Layout.setHorizontalGroup(
            day31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDay31)
                .addGap(18, 18, 18)
                .addComponent(lblEvent31, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        day31Layout.setVerticalGroup(
            day31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(day31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(day31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblEvent31, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDay31, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        bg.add(day31, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 560, -1, -1));

        tfDate.setText("Datum");
        bg.add(tfDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 150, 40));

        btnAddEvent.setText("Add");
        btnAddEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEventActionPerformed(evt);
            }
        });
        bg.add(btnAddEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 680, -1, 40));

        tfDecription.setText("Event");
        bg.add(tfDecription, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 680, 290, 40));

        tfTag.setText("Tagg");
        bg.add(tfTag, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 680, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void day1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day1MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay1.getText());
    }//GEN-LAST:event_day1MouseClicked

    private void day2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day2MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay2.getText());
    }//GEN-LAST:event_day2MouseClicked

    private void day3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day3MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay3.getText());
    }//GEN-LAST:event_day3MouseClicked

    private void day4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day4MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay4.getText());
    }//GEN-LAST:event_day4MouseClicked

    private void day5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day5MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay5.getText());
    }//GEN-LAST:event_day5MouseClicked

    private void day6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day6MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay6.getText());
    }//GEN-LAST:event_day6MouseClicked

    private void day7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day7MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay7.getText());
    }//GEN-LAST:event_day7MouseClicked

    private void day8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day8MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay8.getText());
    }//GEN-LAST:event_day8MouseClicked

    private void day9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day9MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay9.getText());
    }//GEN-LAST:event_day9MouseClicked

    private void day10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day10MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay10.getText());
    }//GEN-LAST:event_day10MouseClicked

    private void day11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day11MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay11.getText());
    }//GEN-LAST:event_day11MouseClicked

    private void day12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day12MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay12.getText());
    }//GEN-LAST:event_day12MouseClicked

    private void day13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day13MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay13.getText());
    }//GEN-LAST:event_day13MouseClicked

    private void day14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day14MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay14.getText());
    }//GEN-LAST:event_day14MouseClicked

    private void day15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day15MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay15.getText());
    }//GEN-LAST:event_day15MouseClicked

    private void day16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day16MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay16.getText());
    }//GEN-LAST:event_day16MouseClicked

    private void day17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day17MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay17.getText());
    }//GEN-LAST:event_day17MouseClicked

    private void day18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day18MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay18.getText());
    }//GEN-LAST:event_day18MouseClicked

    private void day19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day19MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay19.getText());
    }//GEN-LAST:event_day19MouseClicked

    private void dau20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dau20MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay20.getText());
    }//GEN-LAST:event_dau20MouseClicked

    private void day21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day21MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay21.getText());
    }//GEN-LAST:event_day21MouseClicked

    private void day22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day22MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay22.getText());
    }//GEN-LAST:event_day22MouseClicked

    private void day23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day23MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay23.getText());
    }//GEN-LAST:event_day23MouseClicked

    private void day24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day24MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay24.getText());
    }//GEN-LAST:event_day24MouseClicked

    private void day25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day25MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay25.getText());
    }//GEN-LAST:event_day25MouseClicked

    private void day26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day26MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay26.getText());
    }//GEN-LAST:event_day26MouseClicked

    private void day27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day27MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay27.getText());
    }//GEN-LAST:event_day27MouseClicked

    private void day28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day28MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay28.getText());
    }//GEN-LAST:event_day28MouseClicked

    private void day29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day29MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay29.getText());
    }//GEN-LAST:event_day29MouseClicked

    private void day30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day30MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay30.getText());
    }//GEN-LAST:event_day30MouseClicked

    private void day31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_day31MouseClicked
        String monthString = convertMonth(cbxMonth.getSelectedItem().toString());
        tfDate.setText(cbxYear.getSelectedItem().toString()+"-" + monthString + "-"+lblDay31.getText());
    }//GEN-LAST:event_day31MouseClicked

    private void btnAddEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEventActionPerformed
        insertEvent(db,tfDate.getText(),tfDecription.getText());
        String[] days = tfDate.getText().split("-");
        String stringDay = days[2];
        int intDay = Integer.parseInt(stringDay);
        JLabel lbl = convertDay(intDay);
        lbl.setText("exempel...");
        
    }//GEN-LAST:event_btnAddEventActionPerformed

    private void cbxYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxYearItemStateChanged
        resetDays();
        addDays();
        
    }//GEN-LAST:event_cbxYearItemStateChanged

    private void cbxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxMonthItemStateChanged
        resetDays();
        addDays();
    }//GEN-LAST:event_cbxMonthItemStateChanged

    private void lblEvent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent1MouseClicked
//        if(lblEvent1.getText() != null)
//            new event.java.setVisible(true);     
    }//GEN-LAST:event_lblEvent1MouseClicked

    private void lblEvent2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent2MouseClicked
//        if(lblEvent2.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent2MouseClicked

    private void lblEvent3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent3MouseClicked
//        if(lblEvent3.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent3MouseClicked

    private void lblEvent4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent4MouseClicked
//        if(lblEvent4.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent4MouseClicked

    private void lblEvent5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent5MouseClicked
//        if(lblEvent5.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent5MouseClicked

    private void lblEvent6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent6MouseClicked
//        if(lblEvent6.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent6MouseClicked

    private void lblEvent7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent7MouseClicked
//        if(lblEvent7.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent7MouseClicked

    private void lblEvent8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent8MouseClicked
//        if(lblEvent8.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent8MouseClicked

    private void lblEvent9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent9MouseClicked
//        if(lblEvent9.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent9MouseClicked

    private void lblEvent10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent10MouseClicked
//        if(lblEvent10.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent10MouseClicked

    private void lblEvent11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent11MouseClicked
//        if(lblEvent12.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent11MouseClicked

    private void lblEvent12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent12MouseClicked
//        if(lblEvent12.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent12MouseClicked

    private void lblEvent13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent13MouseClicked
//        if(lblEvent13.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent13MouseClicked

    private void lblEvent14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent14MouseClicked
//        if(lblEvent14.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent14MouseClicked

    private void lblEvent15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent15MouseClicked
//        if(lblEvent15.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent15MouseClicked

    private void lblEvent16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent16MouseClicked
//        if(lblEvent16.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent16MouseClicked

    private void lblEvent17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent17MouseClicked
//        if(lblEvent17.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent17MouseClicked

    private void lblEvent18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent18MouseClicked
//        if(lblEvent18.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent18MouseClicked

    private void lblEvent19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent19MouseClicked
//        if(lblEvent19.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent19MouseClicked

    private void lblEvent20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent20MouseClicked
//        if(lblEvent20.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent20MouseClicked

    private void lblEvent21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent21MouseClicked
//        if(lblEvent21.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent21MouseClicked

    private void lblEvent22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent22MouseClicked
//        if(lblEvent22.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent22MouseClicked

    private void lblEvent23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent23MouseClicked
//        if(lblEvent23.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent23MouseClicked

    private void lblEvent24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent24MouseClicked
//        if(lblEvent24.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent24MouseClicked

    private void lblEvent25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent25MouseClicked
//        if(lblEvent25.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent25MouseClicked

    private void lblEvent26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent26MouseClicked
//        if(lblEvent26.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent26MouseClicked

    private void lblEvent27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent27MouseClicked
//        if(lblEvent27.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent27MouseClicked

    private void lblEvent28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent28MouseClicked
//        if(lblEvent28.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent28MouseClicked

    private void lblEvent29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent29MouseClicked
//        if(lblEvent29.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent29MouseClicked

    private void lblEvent30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent30MouseClicked
//        if(lblEvent30.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent30MouseClicked

    private void lblEvent31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEvent31MouseClicked
//        if(lblEvent31.getText() != null)
//            new event.java.setVisible(true);   
    }//GEN-LAST:event_lblEvent31MouseClicked

    
 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kalender.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kalender().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAddEvent;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JComboBox<String> cbxYear;
    private javax.swing.JPanel dau20;
    private javax.swing.JPanel day1;
    private javax.swing.JPanel day10;
    private javax.swing.JPanel day11;
    private javax.swing.JPanel day12;
    private javax.swing.JPanel day13;
    private javax.swing.JPanel day14;
    private javax.swing.JPanel day15;
    private javax.swing.JPanel day16;
    private javax.swing.JPanel day17;
    private javax.swing.JPanel day18;
    private javax.swing.JPanel day19;
    private javax.swing.JPanel day2;
    private javax.swing.JPanel day21;
    private javax.swing.JPanel day22;
    private javax.swing.JPanel day23;
    private javax.swing.JPanel day24;
    private javax.swing.JPanel day25;
    private javax.swing.JPanel day26;
    private javax.swing.JPanel day27;
    private javax.swing.JPanel day28;
    private javax.swing.JPanel day29;
    private javax.swing.JPanel day3;
    private javax.swing.JPanel day30;
    private javax.swing.JPanel day31;
    private javax.swing.JPanel day4;
    private javax.swing.JPanel day5;
    private javax.swing.JPanel day6;
    private javax.swing.JPanel day7;
    private javax.swing.JPanel day8;
    private javax.swing.JPanel day9;
    private javax.swing.JPanel header;
    private javax.swing.JLabel lblDay1;
    private javax.swing.JLabel lblDay10;
    private javax.swing.JLabel lblDay11;
    private javax.swing.JLabel lblDay12;
    private javax.swing.JLabel lblDay13;
    private javax.swing.JLabel lblDay14;
    private javax.swing.JLabel lblDay15;
    private javax.swing.JLabel lblDay16;
    private javax.swing.JLabel lblDay17;
    private javax.swing.JLabel lblDay18;
    private javax.swing.JLabel lblDay19;
    private javax.swing.JLabel lblDay2;
    private javax.swing.JLabel lblDay20;
    private javax.swing.JLabel lblDay21;
    private javax.swing.JLabel lblDay22;
    private javax.swing.JLabel lblDay23;
    private javax.swing.JLabel lblDay24;
    private javax.swing.JLabel lblDay25;
    private javax.swing.JLabel lblDay26;
    private javax.swing.JLabel lblDay27;
    private javax.swing.JLabel lblDay28;
    private javax.swing.JLabel lblDay29;
    private javax.swing.JLabel lblDay3;
    private javax.swing.JLabel lblDay30;
    private javax.swing.JLabel lblDay31;
    private javax.swing.JLabel lblDay4;
    private javax.swing.JLabel lblDay5;
    private javax.swing.JLabel lblDay6;
    private javax.swing.JLabel lblDay7;
    private javax.swing.JLabel lblDay8;
    private javax.swing.JLabel lblDay9;
    private javax.swing.JLabel lblEvent1;
    private javax.swing.JLabel lblEvent10;
    private javax.swing.JLabel lblEvent11;
    private javax.swing.JLabel lblEvent12;
    private javax.swing.JLabel lblEvent13;
    private javax.swing.JLabel lblEvent14;
    private javax.swing.JLabel lblEvent15;
    private javax.swing.JLabel lblEvent16;
    private javax.swing.JLabel lblEvent17;
    private javax.swing.JLabel lblEvent18;
    private javax.swing.JLabel lblEvent19;
    private javax.swing.JLabel lblEvent2;
    private javax.swing.JLabel lblEvent20;
    private javax.swing.JLabel lblEvent21;
    private javax.swing.JLabel lblEvent22;
    private javax.swing.JLabel lblEvent23;
    private javax.swing.JLabel lblEvent24;
    private javax.swing.JLabel lblEvent25;
    private javax.swing.JLabel lblEvent26;
    private javax.swing.JLabel lblEvent27;
    private javax.swing.JLabel lblEvent28;
    private javax.swing.JLabel lblEvent29;
    private javax.swing.JLabel lblEvent3;
    private javax.swing.JLabel lblEvent30;
    private javax.swing.JLabel lblEvent31;
    private javax.swing.JLabel lblEvent4;
    private javax.swing.JLabel lblEvent5;
    private javax.swing.JLabel lblEvent6;
    private javax.swing.JLabel lblEvent7;
    private javax.swing.JLabel lblEvent8;
    private javax.swing.JLabel lblEvent9;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfDecription;
    private javax.swing.JTextField tfTag;
    // End of variables declaration//GEN-END:variables
}

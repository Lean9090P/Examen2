/*
 * Created by JFormDesigner on Tue Dec 20 10:27:06 CLST 2022
 */

package guis;

import java.awt.event.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

import service.ServiceLauncher;
import model.Terremoto;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Lean9090P
 */
public class Launcher extends JFrame {
    public Launcher() {
        initComponents();
        getData();
    }

    //Singleton => se crea solo una vez
    ServiceLauncher service;

    public void setService(ServiceLauncher service) {
        this.service = service;
    }

    public void getData() {
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (Terremoto terremoto : service.read()) {
            model.addRow(new Object[] { terremoto.getId(), terremoto.getMagnitud(), terremoto.getCiudad(),
                    terremoto.getFecha().toLocalDate(),terremoto.getFecha().toLocalTime() });
        }
    }
    private Double roundTwoDecimals(double input) {
        long roundedInt = Math.round(input * 100);
        return (double) roundedInt/100;
    }

    private void button1MouseClicked(MouseEvent e) {
        Terremoto terremoto = new Terremoto(service.read().size()+1,roundTwoDecimals(((Math.random() * 9) + 0.5)),"Temuco", LocalDateTime.now());
        System.out.println(terremoto);
        service.create(terremoto);
        JOptionPane.showMessageDialog(null, "Se generó un Terremoto");
            }

            private void button2MouseClicked(MouseEvent e) {

            }

            private void button3MouseClicked(MouseEvent e) {
                int counter=0;
                for (Terremoto terremoto : service.read()) {
                    if (terremoto.getMagnitud()>=5.5) {
                        counter++;
                    }
                }
                JOptionPane.showMessageDialog(null, "Hay "+counter+" terremotos de magnitud mayor a 5.5");
            }

            private void button4MouseClicked(MouseEvent e) {
                int counter=0;
                    LocalDateTime fechaAnterior = null;
                for (Terremoto terremoto : service.read()) {
                    if (terremoto.getMagnitud() >= 6) {
                        assert fechaAnterior != null;
                        if ((terremoto.getFecha().toLocalDate().getDayOfMonth()==fechaAnterior.getDayOfMonth())&&(terremoto.getFecha().toLocalDate().getMonth()==fechaAnterior.getMonth())&&(terremoto.getFecha().toLocalDate().getYear()==fechaAnterior.getYear())) {
                            counter++;
                        }
                    }
                    fechaAnterior  = terremoto.getFecha();
                }
                if (counter>4) {
                    JOptionPane.showMessageDialog(null, "Hay " + counter + " terremotos de magnitud mayor a 6 en el mismo dia");
                }else{
                    JOptionPane.showMessageDialog(null, "No hay mas de 4 terremotos de magnitud mayor a 6 en el mismo dia");

                }
            }

            private void button5MouseClicked(MouseEvent e) {
                // TODO add your code here
            }

            private void button6MouseClicked(MouseEvent e) {
                // TODO add your code here
            }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Lean9090P
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label2 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        label3 = new JLabel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
                swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border
                . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067"
                ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel1. getBorder
                ( )) ); panel1. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
                .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException
                ( ); }} );

                //---- label1 ----
                label1.setText("Genedor y Lector de  Terremotos");

                //---- button1 ----
                button1.setText("Generar Terremotos");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });

                //---- button2 ----
                button2.setText("Ver Terremoto de mayor Intensidad");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button2MouseClicked(e);
                    }
                });

                //---- button3 ----
                button3.setText("Sismos de mas o igual a 5.5");
                button3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button3MouseClicked(e);
                    }
                });

                //---- button4 ----
                button4.setText("Existe alguna alerta?");
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button4MouseClicked(e);
                    }
                });

                //---- label2 ----
                label2.setText("(M\u00e1s de 4 lecturas consecutivas de mas de 6.0 )");

                //---- button5 ----
                button5.setText("\u00bfHay alerta de enjambre s\u00edsmico?");
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button5MouseClicked(e);
                    }
                });

                //---- button6 ----
                button6.setText("Salir del Sistema");
                button6.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button6MouseClicked(e);
                    }
                });

                //---- label3 ----
                label3.setText("Se considera enjambre s\u00edsmico, si se registran al menos 3 d\u00edas seguidos con escalada s\u00edsmica.");

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(label1))
                                .addComponent(button4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(label1)
                            .addGap(49, 49, 49)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2)
                                .addComponent(button4))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button5)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button6)
                            .addContainerGap(33, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Generar", panel1);

            //======== panel2 ========
            {

                //======== scrollPane1 ========
                {

                    //---- table1 ----
                    table1.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                        },
                        new String[] {
                            "Id", "Magnitud", "Ciudad", "Fecha", "Hora"
                        }
                    ));
                    scrollPane1.setViewportView(table1);
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 669, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 90, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Lista de terremotos", panel2);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Lean9090P
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label2;
    private JButton button5;
    private JButton button6;
    private JLabel label3;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

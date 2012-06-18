package vehicle.modeling;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Atiqur Rahman
 * @since 6/15/12 10:38 PM
 */
public class VehicleModeling {

    private JTabbedPane tabbedPane1;
    private JTextField txtvm;
    private JTextField txtwb;
    private JTextField txttw;
    private JTextField txtftc;
    private JTextField txtrtc;
    private JTextField txthoc;
    private JTextField txtaf;
    private JTextField txtib;
    private JTextField txtad;
    private JComboBox cbbst;
    private JButton saveDataInput;
    private JTextField textField10;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField15;
    private JTextField textField16;
    private JTextField textField18;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField11;
    private JTextField textField14;
    private JTextField textField17;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField time0TextField;
    private JComboBox cbsa;
    private JPanel imgPanel;
    private JPanel imgBodyShapeType;
    private JSlider slider1;
    private JComboBox comboBox5;
    private JTextField textField3;
    private JPanel imgWheelForceXAxis;


    public VehicleModeling() {
        saveDataInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                InitialData id = new InitialData(
                        txtvm.getText(), txtwb.getText(), txttw.getText(), txtftc.getText(),
                        txtrtc.getText(), txthoc.getText(), txtaf.getText(), txtib.getText(),
                        txtad.getText(), cbbst.getSelectedItem().toString());
                System.out.println(id);
            }
        });

        cbbst.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String bodyShapeType = cbbst.getSelectedItem().toString();
                if (!bodyShapeType.equals("Select")) {
                    try {
                        InputStream resourceAsStream = this.getClass().getResourceAsStream("/body-shape/" + bodyShapeType + ".jpg");
                        BufferedImage image = ImageIO.read(resourceAsStream);
                        ImageBackgroundPanel ibp = new ImageBackgroundPanel(image, imgBodyShapeType.getWidth(), imgBodyShapeType.getHeight());
                        imgBodyShapeType.add(BorderLayout.CENTER, ibp);
                        imgBodyShapeType.setVisible(true);
                        imgBodyShapeType.validate();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                time0TextField.setText("Time: " + String.valueOf(slider1.getValue()));
            }
        });
        comboBox5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String graphTitle = comboBox5.getSelectedItem().toString();
                String graphDataTitle = "wheel_force_x_axis_" + graphTitle.replaceAll(" ", "_").toLowerCase();

                Dimension size = imgWheelForceXAxis.getSize();
                size.setSize(size.getWidth() - 20, size.getHeight() - 20);

                ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, size);

                imgWheelForceXAxis.add(BorderLayout.CENTER, chartPanel);
                imgWheelForceXAxis.setVisible(true);
                imgWheelForceXAxis.validate();

            }
        });
        cbsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String graphTitle = "Steering " + cbsa.getSelectedItem().toString();
                String graphDataTitle = graphTitle.replaceAll(" ", "_").toLowerCase();

                Dimension size = imgPanel.getSize();
                size.setSize(size.getWidth() - 20, size.getHeight() - 20);

                ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, size);

                imgPanel.add(BorderLayout.CENTER, chartPanel);
                imgPanel.setVisible(true);
                imgPanel.validate();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String graphTitle = "Wheel Torque Front Left " + comboBox1.getSelectedItem().toString();
                String graphDataTitle = graphTitle.replaceAll(" ", "_").toLowerCase();

                Dimension size = imgPanel.getSize();
                size.setSize(size.getWidth() - 20, size.getHeight() - 20);

                ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, size);

                imgPanel.add(BorderLayout.CENTER, chartPanel);
                imgPanel.setVisible(true);
                imgPanel.validate();

            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String graphTitle = "Wheel Torque Front Right " + comboBox2.getSelectedItem().toString();
                String graphDataTitle = graphTitle.replaceAll(" ", "_").toLowerCase();

                Dimension size = imgPanel.getSize();
                size.setSize(size.getWidth() - 20, size.getHeight() - 20);

                ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, size);

                imgPanel.add(BorderLayout.CENTER, chartPanel);
                imgPanel.setVisible(true);
                imgPanel.validate();

            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String graphTitle = "Wheel Torque Rear Left " + comboBox3.getSelectedItem().toString();
                String graphDataTitle = graphTitle.replaceAll(" ", "_").toLowerCase();

                Dimension size = imgPanel.getSize();
                size.setSize(size.getWidth() - 20, size.getHeight() - 20);

                ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, size);

                imgPanel.add(BorderLayout.CENTER, chartPanel);
                imgPanel.setVisible(true);
                imgPanel.validate();

            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String graphTitle = "Wheel Torque Rear Right " + comboBox4.getSelectedItem().toString();
                String graphDataTitle = graphTitle.replaceAll(" ", "_").toLowerCase();

                Dimension size = imgPanel.getSize();
                size.setSize(size.getWidth() - 20, size.getHeight() - 20);

                ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, size);

                imgPanel.add(BorderLayout.CENTER, chartPanel);
                imgPanel.setVisible(true);
                imgPanel.validate();

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicle Modeling");
        frame.setContentPane(new VehicleModeling().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

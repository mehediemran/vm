package vehicle.modeling;

import org.jfree.chart.ChartPanel;

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
    private JPanel inputGraphPanel;
    private JPanel imgBodyShapeType;
    private JSlider slider1;
    private JComboBox comboBox5;
    private JTextField textField3;
    private JPanel imgWheelForceXAxis;
    private JPanel imgWheelForceYAxis;
    private JComboBox cmbWfYAxis;


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
                String bodyShapeUrl = "/body-shape/" + bodyShapeType + ".jpg";
                paintBodyShape(bodyShapeUrl, imgBodyShapeType);
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
                paintGraph(comboBox5, imgWheelForceXAxis, "", "wheel_force_x_axis_");
            }
        });
        cbsa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paintGraph(cbsa, inputGraphPanel, "Steering ", "");
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paintGraph(comboBox1, inputGraphPanel, "Wheel Torque Front Left ", "");
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paintGraph(comboBox2, inputGraphPanel, "Wheel Torque Front Right ", "");
            }
        });
        comboBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paintGraph(comboBox3, inputGraphPanel, "Wheel Torque Rear Left ", "");
            }
        });
        comboBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paintGraph(comboBox4, inputGraphPanel, "Wheel Torque Rear Right ", "");
            }
        });
        cmbWfYAxis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paintGraph(cmbWfYAxis, imgWheelForceYAxis, "", "wheel_force_y_axis_");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicle Modeling");
        VehicleModeling vehicleModeling = new VehicleModeling();
        frame.setContentPane(vehicleModeling.tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        paintBodyShape("/body-shape/Select.jpg", vehicleModeling.imgBodyShapeType);
        paintGraph(vehicleModeling.cbsa, vehicleModeling.inputGraphPanel, "Steering ", "");
        paintGraph(vehicleModeling.comboBox5, vehicleModeling.imgWheelForceXAxis, "", "wheel_force_x_axis_");
        paintGraph(vehicleModeling.cmbWfYAxis, vehicleModeling.imgWheelForceYAxis, "", "wheel_force_y_axis_");
    }

    private static void paintGraph(JComboBox comboBox, JPanel imgPanel, String graphTitlePrefix, String graphDataPrefix) {
        imgPanel.removeAll();

        String graphTitle = graphTitlePrefix + comboBox.getSelectedItem().toString();
        String graphDataTitle = graphDataPrefix + graphTitle.replaceAll(" ", "_").toLowerCase();

        int imgPanelWidth = (int) imgPanel.getSize().getWidth();
        int imgPanelHeight = (int) imgPanel.getSize().getHeight();
        Dimension preferredImageSize = new Dimension(imgPanelWidth, imgPanelHeight);

        ChartPanel chartPanel = ProcessGraphData.getChart(graphTitle, graphDataTitle, preferredImageSize);

        imgPanel.add(BorderLayout.CENTER, chartPanel);
        imgPanel.setVisible(true);
        imgPanel.validate();
    }

    private static void paintBodyShape(String bodyShapeUrl, JPanel imgBodyShapeType) {
        try {
            imgBodyShapeType.removeAll();
            InputStream resourceAsStream = VehicleModeling.class.getResourceAsStream(bodyShapeUrl);
            BufferedImage image = ImageIO.read(resourceAsStream);
            ImageBackgroundPanel ibp = new ImageBackgroundPanel(image, imgBodyShapeType.getWidth(), imgBodyShapeType.getHeight());
            imgBodyShapeType.add(BorderLayout.CENTER, ibp);
            imgBodyShapeType.validate();
            imgBodyShapeType.repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
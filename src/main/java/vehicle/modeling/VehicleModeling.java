package vehicle.modeling;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.PieDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
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
    private JScrollBar scrollBar1;
    private JTextField time0TextField;
    private JComboBox cbsa;
    private JPanel imgPanel;
    private JPanel imgBodyShapeType;


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
        scrollBar1.addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                time0TextField.setText("Time: " + String.valueOf(scrollBar1.getValue()));
            }
        });
        cbsa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                PieDataset pieDataset = Utils.createDataset();
                JFreeChart chart = Utils.createChart(pieDataset, "Sample Pie Chart");
                ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
                chartPanel.setVisible(true);

                imgPanel.add(BorderLayout.CENTER, chartPanel);
                imgPanel.setVisible(true);
                imgPanel.validate();

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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicle Modeling");
        frame.setContentPane(new VehicleModeling().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}

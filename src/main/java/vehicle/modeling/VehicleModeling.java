package vehicle.modeling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : Atiqur Rahman
 * @since : 6/15/12 10:38 PM
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
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Vehicle Modeling");
        frame.setContentPane(new VehicleModeling().tabbedPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

package vehicle.modeling;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Atiqur Rahman
 * @since 6/17/12 5:29 PM
 */
public class ImageBackgroundPanel extends JPanel {
    BufferedImage image;
    int panelWidth;
    int panelHeight;
    int imageWidth;
    int imageHeight;


    ImageBackgroundPanel(BufferedImage image, int panelWidth, int panelHeight) {
        this.image = image;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;

        this.imageWidth = image.getWidth();
        this.imageHeight = image.getHeight();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        resizeImage();
        g.drawImage(image, 0, 0, panelWidth, panelHeight, this);
        g.dispose();
    }

    protected void resizeImage() {
        if (panelWidth < panelHeight) {
            panelWidth = Math.round(panelWidth * ((float) imageHeight / imageWidth));
        } else if (panelHeight < panelWidth) {
            panelWidth = Math.round(panelHeight * ((float) imageWidth / imageHeight));
        }
    }
}

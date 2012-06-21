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
    int resizedImageWidth;
    int resizedImageHeight;


    ImageBackgroundPanel(BufferedImage image, int panelWidth, int panelHeight) {
        this.image = image;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;

        this.imageWidth = image.getWidth();
        this.imageHeight = image.getHeight();

        this.resizedImageWidth = this.imageWidth;
        this.resizedImageHeight = this.imageHeight;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        resizeImage();
        g.drawImage(image, 0, 0, resizedImageWidth, resizedImageHeight, this);
        g.dispose();
    }

    protected void resizeImage() {
        //assumption panelWidht > panelHeight

        if (imageWidth > panelWidth) {
            resizedImageWidth = panelWidth;
            resizedImageHeight = Math.round(imageHeight * ((float) panelWidth / imageWidth));
        }
    }
}

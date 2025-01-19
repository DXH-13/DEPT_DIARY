package utils;

import constant.IConstant;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * CAPTCHA utility class
 */
public class Captcha {

    public static String generateCaptchaText() {
        int length = 4;
        Random random = new Random();
        StringBuilder captchaText = new StringBuilder();
        for (int i = 0; i < length; i++) {
            captchaText.append(IConstant.CAPTCHA_CHARACTERS.charAt(random.nextInt(IConstant.CAPTCHA_CHARACTERS.length())));
        }
        return captchaText.toString();
    }

    public static BufferedImage generateCaptchaImage(String text) {
        int width = 200;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        Random random = new Random();

        for (int i = 0; i < text.length(); i++) {
            g.setFont(getRandomFont());
            g.setColor(getRandomColor());
            int x = 20 + i * 30;
            int y = 40;
            g.drawString(String.valueOf(text.charAt(i)), x, y);
        }

        for (int i = 0; i < 5; i++) {
            g.setColor(getRandomColor());
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }
        return image;
    }

    public static Color getRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public static Font getRandomFont() {
        Random random = new Random();
        return IConstant.FONTS[random.nextInt(IConstant.FONTS.length)];
    }
}

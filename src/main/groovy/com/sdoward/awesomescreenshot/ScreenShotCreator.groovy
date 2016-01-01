package com.sdoward.awesomescreenshot

import javax.imageio.ImageIO
import java.awt.Color
import java.awt.Font
import java.awt.FontMetrics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.geom.AffineTransform
import java.awt.geom.Rectangle2D
import java.awt.image.AffineTransformOp
import java.awt.image.BufferedImage


class ScreenShotCreator {

    int imageWidth = 768
    int imageHeight = 1280

    def createScreenShot(ScreenShot screenShot) {

        BufferedImage backgroundImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB)
        Graphics2D backgroundGraphics = backgroundImage.getGraphics()

        int yStart = backgroundImage.height - (backgroundImage.height * 0.8)
        int xStart = backgroundImage.width * 0.1

        drawBackground(backgroundGraphics, screenShot.backgroundColor)
        drawText(backgroundGraphics, screenShot.textColor, screenShot.header1, screenShot.header2)
        drawShadow(backgroundGraphics, screenShot.shadowColor, yStart)
        drawScreenShot(backgroundGraphics, new File(screenShot.fileIn), xStart, yStart)
        ImageIO.write(backgroundImage, "png", new File(screenShot.fileOut))
    }

    def drawBackground(Graphics2D graphics, Color background) {
        graphics.setColor(background)
        graphics.fill(new Rectangle2D.Double(0, 0, imageWidth, imageHeight))
    }

    def drawText(Graphics2D graphics, Color textColor, String first, String second) {
        graphics.setColor(textColor)
        graphics.setFont(new Font("Helvetica", Font.BOLD, 60f))
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        FontMetrics fontMetrics = graphics.getFontMetrics();
        int x = (imageWidth - fontMetrics.stringWidth(first)) / 2;
        graphics.drawString(first, x, 100)
        graphics.setFont(new Font("Helvetica", Font.PLAIN, 60f))
        fontMetrics = graphics.getFontMetrics();
        x = (imageWidth - fontMetrics.stringWidth(second)) / 2;
        graphics.drawString(second, x, 180)
    }

    def drawShadow(Graphics2D graphics, Color shadow, int yStart) {
        graphics.setColor(shadow)
        graphics.fill(new Rectangle2D.Double((imageWidth * 0.9)-1, yStart + ((imageHeight * 0.8) * 0.1), imageWidth, imageHeight))
        int[] xPoints = [(imageWidth * 0.9)-1, (imageWidth * 0.9)-1, imageWidth]
        int[] yPoints = [yStart, yStart + ((imageHeight * 0.8) * 0.1) + 1, yStart + ((imageHeight * 0.8) * 0.1) + 1]
        graphics.fillPolygon(xPoints, yPoints, 3)
    }

    def drawScreenShot(Graphics2D graphics, File file, int x, int y) {
        BufferedImage screenShotImage = ImageIO.read(file)
        BufferedImage after = new BufferedImage(screenShotImage.width, screenShotImage.height, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(0.8, 0.8);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        after = scaleOp.filter(screenShotImage, after);
        graphics.drawImage(after, null, x, y)
        graphics.dispose();
    }

}
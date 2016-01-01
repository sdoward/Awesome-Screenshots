package com.sdoward.awesomescreenshot

import java.awt.Color

class ScreenShot {

    String header1;
    String header2;
    Color backgroundColor;
    Color shadowColor;
    Color textColor;
    String fileIn;
    String fileOut

    ScreenShot(String header1, String header2, Color backgroundColor, Color shadowColor, Color textColor, String fileIn, String fileOut) {
        this.header1 = header1
        this.header2 = header2
        this.backgroundColor = backgroundColor
        this.shadowColor = shadowColor
        this.textColor = textColor
        this.fileIn = fileIn
        this.fileOut = fileOut
    }
}

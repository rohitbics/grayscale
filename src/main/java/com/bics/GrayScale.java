package com.bics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The GrayScale class provides functionality to convert a color image to grayscale using the luminosity method. The
 * luminosity method calculates the grayscale value by applying specific weights to the red, green, and blue components
 * of each pixel.
 */
public class GrayScale {

  public static void main(String[] args) {

    String inputPath = "C:\\Dev\\icons\\road-sign.png";
    String outputPath = "C:\\Dev\\icons\\gray-road-sign.png";

    BufferedImage img = null;
    File f;

    // read image
    try {
      f = new File(inputPath);
      img = ImageIO.read(f);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }

    // get image's width and height
    assert img != null;
    int width = img.getWidth();
    int height = img.getHeight();

    // get the pixels array
    int[] pixels = img.getRGB(0, 0, width, height, null, 0, width);

    // convert to grayscale using luminosity method
    for (int i = 0; i < pixels.length; i++) {
      int p = pixels[i];

      int a = (p >> 24) & 0xff;
      int r = (p >> 16) & 0xff;
      int g = (p >> 8) & 0xff;
      int b = p & 0xff;

      // calculate luminosity, adjust the weights if needed
      int gray = (int) (0.15 * r + 0.60 * g + 0.25 * b);

      // replace RGB value with gray
      p = (a << 24) | (gray << 16) | (gray << 8) | gray;

      pixels[i] = p;
    }
    img.setRGB(0, 0, width, height, pixels, 0, width);

    // write image
    try {
      f = new File(outputPath);
      ImageIO.write(img, "png", f);
      System.out.println("\nConverted to grayscale successfully!");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uwo.csd.cs2212.team07;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * A FileReader class that allows other classes to get files from the Resources
 * folder
 *
 * @author team07
 */
public class FileReader {

    /**
     * Creates a BufferedImage using a filename in order to find it in the
     * resources folder
     *
     * @param fileName the name of the file in the resources folder
     * @return a BufferedImage of the file
     */
    public static BufferedImage getImage(String fileName) {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);

        BufferedImage image = null;

        try {
            image = ImageIO.read(is);
            is.close();
        } catch (IOException e) {
            System.err.println("Unable to load image " + fileName);
        }

        return image;

    }

}

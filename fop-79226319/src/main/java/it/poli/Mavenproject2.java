package it.poli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.xmlgraphics.image.loader.ImageException;
import org.apache.xmlgraphics.image.loader.ImageInfo;
import org.apache.xmlgraphics.image.loader.ImageManager;
import org.apache.xmlgraphics.image.loader.ImageSource;

public class Mavenproject2 {

  public static void main(String[] args) throws FileNotFoundException, ImageException, IOException {
    Mavenproject2 me = new Mavenproject2();
    System.out.println(me.load("img.png"));
    System.out.println(me.load("img.tiff"));
    System.out.println(me.load("img.svg"));
  }

  public Mavenproject2() {
    URI base = URI.create("https://example.com/nowhere");
    FopFactoryBuilder ffb = new FopFactoryBuilder(base);
    this.imageManager = ffb.getImageManager();
  }

  private final ImageManager imageManager;

  public ImageInfo load(String ff) {
    try {
      File sourceFile = new File(ff);
      ImageInputStream iis = ImageIO.createImageInputStream(sourceFile);
      ImageInfo preloadImage =
          imageManager.preloadImage("image", new ImageSource(iis, "image", true));
      return preloadImage;
    } catch (IOException | ImageException ex) {
      Logger.getLogger(Mavenproject2.class.getName()).log(Level.SEVERE, "Loading " + ff, ex);
    }
    return null;
  }
}

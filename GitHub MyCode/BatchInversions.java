
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class BatchInversions {
    public ImageResource makeInversion(ImageResource image){
        DirectoryResource dr = new DirectoryResource();
    ImageResource inversion = new ImageResource(image.getWidth(), image.getHeight());
        for(File f : dr.selectedFiles()){
    for(Pixel pixel  : inversion.pixels()){
     Pixel getPixel = image.getPixel(pixel.getX(), pixel.getY());       
        pixel.setRed(255- getPixel.getRed());
        pixel.setBlue(255- getPixel.getBlue());
        pixel.setGreen(255- getPixel.getGreen());
    }}
    return inversion;
    }
    
    public void selectAndConvert(){
        DirectoryResource dr  = new DirectoryResource();
        for(File f : dr.selectedFiles()){
    ImageResource fr = new ImageResource(f);
    ImageResource convert = makeInversion(fr);
    convert.draw();

    }}
}

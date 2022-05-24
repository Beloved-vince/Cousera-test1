
/**
 * Write a description of GrayScale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import edu.duke.*;
public class GrayScale {
    public ImageResource grayWork(ImageResource inImage){
        DirectoryResource dr = new DirectoryResource();
        ImageResource outPut = new  ImageResource(inImage.getWidth(), inImage.getHeight());
        for(File f : dr.selectedFiles()){
            FileResource fr =new FileResource(f);
        for(Pixel px : outPut.pixels()){
        Pixel inpx = inImage.getPixel(px.getX(), px.getY());
        int average = (inpx.getRed() + inpx.getBlue() + inpx.getGreen())/3;
        px.setRed(average);
        px.setBlue(average);
        px.setGreen(average);
        String currName = outPut.getFileName();
        String setName ="After Coding";
        outPut.setFileName(setName);

    }
    }
        return outPut;
    }
    public void testGrayWork(){
        DirectoryResource dr = new DirectoryResource();
    for(File f : dr.selectedFiles()){
    ImageResource ir = new ImageResource(f);
    ImageResource get = grayWork(ir);
    get.draw();  
    get.save();
    }}}
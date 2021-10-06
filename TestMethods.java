package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class TestMethods {
	
	static PDDocument doc;
	//Path of PDF File
	String PDFPath  = "C:\\Users\\satee\\Desktop\\Rental Agreement Bangalore.pdf";
    //Path of text File
	String textPath = "C:\\Users\\satee\\Desktop\\sample.txt";
    //Variable to store the PDF Value
	String output = "";
    
  @Test
  public void readdatafromPDF() throws IOException {
	  //Calling the method to read data from PDF
	  output = readPDF(PDFPath);
	  }
  
  @BeforeTest
  public void beforetest() throws IOException {
	  //Loading the file from the Location  
      File file = new File(PDFPath);  
      doc = Loader.loadPDF(file);  
  }
  
  @AfterTest
  public void aftertext() throws IOException {
	  //Method to write the text from PDF to text File
	  writeText(textPath, output); 
  }
  
  public static String readPDF(String pathofPDF) throws IOException {  
      //Instantiate PDFTextStripper class  
      PDFTextStripper pdfStripper = new PDFTextStripper();  
      //Retrieving text from PDF document  
      String text = pdfStripper.getText(doc);  
      //Closing the document  
      doc.close(); 
      return text;
  }

  @SuppressWarnings("deprecation")
  public static void writeText(String pathofText, String text) throws IOException {
      //Writing the PDF Text to text file
      File DestFile = new File (pathofText);
      FileUtils.writeStringToFile(DestFile, text);
  }
  
}


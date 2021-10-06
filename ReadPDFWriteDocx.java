package sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDFWriteDocx {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {  
        
      //Loading an existing document  
        File file = new File("C:\\Users\\satee\\Desktop\\Rental Agreement Bangalore.pdf");  
        PDDocument doc = Loader.loadPDF(file);  
    
  //Instantiate PDFTextStripper class  
        PDFTextStripper pdfStripper = new PDFTextStripper();  

  //Retrieving text from PDF document  
        String text = pdfStripper.getText(doc);  
        System.out.println("Text in PDF\n---------------------------------");  
        System.out.println(text);  

  //Closing the document  
  doc.close();  
  
  File DestFile = new File ("C:\\Users\\satee\\Desktop\\sample.txt");
	FileUtils.writeStringToFile(DestFile, text);

	}

}

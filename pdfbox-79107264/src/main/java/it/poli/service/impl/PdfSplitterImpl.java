package it.poli.service.impl;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * @see PDRectangle
 */
public class PdfSplitterImpl {

  public void splitPdf(String pdfFileName) throws IOException {
    File pdfFile = new File(pdfFileName);
    File pdfTargetFile = new File(pdfFileName + ".a7.pdf");

    try (PDDocument pdfDocument = Loader.loadPDF(new RandomAccessReadBufferedFile(pdfFile));
        PDDocument pdfTargetDocument = new PDDocument(); ) {

      for (PDPage pdfPage : pdfDocument.getPages()) {
        PDRectangle cropBox = pdfPage.getCropBox();
        float upperRightX = cropBox.getUpperRightX();
        float upperRightY = cropBox.getUpperRightY();
        for (int j = 0; j < 2; ++j) {
          for (int i = 0; i < 4; ++i) {
            float cropLowerLeftX = upperRightX / 2 * j;
            float cropUpperRightX = upperRightX / 2 * (j + 1);
            float cropLowerLeftY = upperRightY / 4 * i;
            float cropUpperRightY = upperRightY / 4 * (i + 1);
            cropBox.setLowerLeftX(cropLowerLeftX);
            cropBox.setUpperRightX(cropUpperRightX);
            cropBox.setLowerLeftY(cropLowerLeftY);
            cropBox.setUpperRightY(cropUpperRightY);
            pdfPage.setCropBox(cropBox);
            pdfTargetDocument.importPage(pdfPage);
          }
        }
      }

      for (PDPage pdfTargetPage : pdfTargetDocument.getPages()) {
        pdfTargetPage.setRotation(90);
      }
      pdfTargetDocument.save(pdfTargetFile);
    }
  }
}

package it.poli;

import it.poli.service.impl.PdfSplitterImpl;

public class PdfBoxApplication {

  public static void main(String[] args) throws Exception {

    PdfSplitterImpl splitter = new PdfSplitterImpl();
    splitter.splitPdf("test_1.pdf");
  }
}

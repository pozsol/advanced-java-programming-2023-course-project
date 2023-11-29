package org.ppke.itk.registrationsystem.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.ppke.itk.registrationsystem.domain.Citizen;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GeneratePdfFromCitizen {

    public static ByteArrayOutputStream generatePdf(Citizen citizen) throws IOException, DocumentException {

        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.add(new Paragraph(citizen.toString()));
        document.close();
        outputStream.close();

        return outputStream;
    }
}

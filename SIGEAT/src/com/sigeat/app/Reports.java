/*
 * Classe responsável pelos relatórios do SIGEAT
 */
package com.sigeat.app;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.sigeat.model.bean.OS;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/*
 * SIGEAT/ Application /Reports
 * @author Junior
 * Version : 1.0.0
 */
public class Reports {

    public void tableReports(JTable table, String count, String selectedPath, String reportTitle) {
        Document relatorio = new Document();
        String reportPath = selectedPath;

        try {
            PdfWriter.getInstance(relatorio, new FileOutputStream(reportPath)); //Local do relatório
            if (reportTitle.equals("OS Cadastradas")) {
                relatorio.setPageSize(PageSize.A4.rotate());
            } else {
                relatorio.setPageSize(PageSize.A4);
            }
            relatorio.open();

            //data do relatorio
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - kk:mm:ss");
            Paragraph data = new Paragraph(sdf.format(date));
            data.setAlignment(Element.ALIGN_RIGHT);
            relatorio.add(data);

            //logo
            Image img = Image.getInstance("logo.png"); //Pasta da aplicação
            relatorio.add(img);

            // titulo do relatório
            Font bold = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD);
            Paragraph titulo = new Paragraph(reportTitle, bold);
            titulo.setAlignment(Element.ALIGN_CENTER);
            relatorio.add(titulo);

            //nome relatório
            bold = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
            Paragraph report = new Paragraph("Relatório de consulta à base de dados", bold);
            report.setAlignment(Element.ALIGN_CENTER);
            report.setLeading(2f, 2f);
            relatorio.add(report);

            //tabela com resultados
            PdfPTable resultado = new PdfPTable(table.getColumnCount());
            //adding table headers
            for (int i = 0; i < table.getColumnCount(); i++) {
                resultado.addCell(table.getColumnName(i));
            }
            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    resultado.addCell(table.getModel().getValueAt(rows, cols).toString());

                }
            }

            resultado.setSpacingAfter(5f);
            resultado.setSpacingBefore(5f);
            relatorio.add(resultado);

            Paragraph total = new Paragraph("Total : " + count);
            total.setAlignment(Element.ALIGN_RIGHT);
            total.setLeading(2f, 2f);
            relatorio.add(total);

            //Abrir relatório
            this.openReport(reportPath);

        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "DocumentException");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FileNotFoundException");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException");
        } finally {
            relatorio.close();
        }
    }

    public void osReport(OS os, String selectedPath) {
        Document relatorio = new Document();
        String reportPath = selectedPath;

        try {
            PdfWriter writer = PdfWriter.getInstance(relatorio, new FileOutputStream(reportPath));
            relatorio.setPageSize(PageSize.A4);
            relatorio.open();

            //data do relatorio
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - kk:mm:ss");
            Paragraph data = new Paragraph(sdf.format(date));
            data.setAlignment(Element.ALIGN_RIGHT);
            relatorio.add(data);

            //logo
            Image img = Image.getInstance("logo.png"); //Pasta da aplicação
            relatorio.add(img);

            // titulo do relatório
            Font bold = FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD);
            Paragraph titulo = new Paragraph("Ordem de serviço", bold);
            titulo.setAlignment(Element.ALIGN_CENTER);
            relatorio.add(titulo);

            //Campos do formulario
            PdfPTable title = new PdfPTable(1);
            Font font = FontFactory.getFont(FontFactory.TIMES, 16);
            PdfPCell iTitle = new PdfPCell(new Phrase("Número da OS: " + os.getNmr_os(), font));
            iTitle.setBackgroundColor(BaseColor.WHITE);
            title.addCell(iTitle);
            title.setSpacingAfter(5f);
            title.setSpacingBefore(20f);
            title.setWidthPercentage(40f);
            title.setHorizontalAlignment(0);
            relatorio.add(title);

            PdfPTable tipo = new PdfPTable(1);
            PdfPCell iTipo = new PdfPCell(new Phrase("Tipo: " + os.getTipo(), font));
            iTipo.setBackgroundColor(BaseColor.WHITE);
            tipo.addCell(iTipo);
            tipo.setSpacingAfter(5f);
            tipo.setSpacingBefore(20f);
            tipo.setWidthPercentage(40f);
            tipo.setHorizontalAlignment(0);
            relatorio.add(tipo);

            PdfPTable dtOs = new PdfPTable(1);
            Date os_data = os.getDt_os();
            sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fData = sdf.format(os_data);
            PdfPCell iData = new PdfPCell(new Phrase("Data da OS: " + fData, font));
            iData.setBackgroundColor(BaseColor.WHITE);
            dtOs.addCell(iData);
            dtOs.setSpacingAfter(5f);
            dtOs.setSpacingBefore(20f);
            dtOs.setWidthPercentage(50f);
            dtOs.setHorizontalAlignment(0);
            relatorio.add(dtOs);

            PdfPTable cliente = new PdfPTable(1);
            PdfPCell iCliente = new PdfPCell(new Phrase("Cliente: " + os.getCliente().getNome(), font));
            iCliente.setBackgroundColor(BaseColor.WHITE);
            cliente.addCell(iCliente);
            cliente.setSpacingAfter(5f);
            cliente.setSpacingBefore(20f);
            cliente.setWidthPercentage(70f);
            cliente.setHorizontalAlignment(0);
            relatorio.add(cliente);

            PdfPTable equipamento = new PdfPTable(1);
            PdfPCell iEquipamento = new PdfPCell(new Phrase("Equipamento: " + os.getEquipamento(), font));
            iEquipamento.setBackgroundColor(BaseColor.WHITE);
            equipamento.addCell(iEquipamento);
            equipamento.setSpacingAfter(5f);
            equipamento.setSpacingBefore(20f);
            equipamento.setWidthPercentage(90f);
            equipamento.setHorizontalAlignment(0);
            relatorio.add(equipamento);

            PdfPTable defeito = new PdfPTable(1);
            PdfPCell iDefeito = new PdfPCell(new Phrase("Defeito: " + os.getDefeito(), font));
            iDefeito.setBackgroundColor(BaseColor.WHITE);
            defeito.addCell(iDefeito);
            defeito.setSpacingAfter(5f);
            defeito.setSpacingBefore(20f);
            defeito.setWidthPercentage(90f);
            defeito.setHorizontalAlignment(0);
            relatorio.add(defeito);

            PdfPTable servico = new PdfPTable(1);
            PdfPCell iServico = new PdfPCell(new Phrase("Serviço: " + os.getServico(), font));
            iServico.setBackgroundColor(BaseColor.WHITE);
            servico.addCell(iServico);
            servico.setSpacingAfter(5f);
            servico.setSpacingBefore(20f);
            servico.setWidthPercentage(90f);
            servico.setHorizontalAlignment(0);
            relatorio.add(servico);

            PdfPTable tecnico = new PdfPTable(1);
            PdfPCell iTecnico = new PdfPCell(new Phrase("Técnico: " + os.getTecnico(), font));
            iTecnico.setBackgroundColor(BaseColor.WHITE);
            tecnico.addCell(iTecnico);
            tecnico.setSpacingAfter(5f);
            tecnico.setSpacingBefore(20f);
            tecnico.setWidthPercentage(70f);
            tecnico.setHorizontalAlignment(0);
            relatorio.add(tecnico);

            PdfPTable valor = new PdfPTable(1);
            PdfPCell iValor = new PdfPCell(new Phrase("Valor: R$" + os.getValor().toString().replace(".", ","), font));
            iValor.setBackgroundColor(BaseColor.WHITE);
            valor.addCell(iValor);
            valor.setSpacingAfter(5f);
            valor.setSpacingBefore(20f);
            valor.setWidthPercentage(50f);
            valor.setHorizontalAlignment(0);
            relatorio.add(valor);

            //Rodapé
            writer.setPageEvent(new MyFooter());

            //Abrir relatório
            this.openReport(reportPath);

        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "DocumentException");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "FileNotFoundException");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "IOException");
        } finally {
            relatorio.close();
        }
    }

    public void openReport(String path) {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(path);
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }
    }

    public void createUserReportFolder() {

        File reportsFolder = new File(System.getProperty("user.home") + "\\Documents\\SIGEAT\\Meus Relatórios");

        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }

    }

    public void createOSFolder() {

        File reportsFolder = new File(System.getProperty("user.home") + "\\Documents\\SIGEAT\\Minhas OS");

        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }

    }

    public void createTempFolder() {

        File reportsFolder = new File(System.getProperty("user.home") + "\\Documents\\SIGEAT\\temp");

        if (!reportsFolder.exists()) {
            reportsFolder.mkdirs();
        }

    }

    //Rodapé da página
    class MyFooter extends PdfPageEventHelper {

        public void onEndPage(PdfWriter writer, Document document) {
            PdfContentByte cb = writer.getDirectContent();
            ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, footer(),
                    (document.right() - document.left()) / 2 + document.leftMargin(),
                    document.bottom() + 10, 0);
        }

        private Phrase footer() {
            Font ffont = new Font(Font.FontFamily.UNDEFINED, 5, Font.ITALIC);
            Phrase p = new Phrase("GARANTIA DE 90 DIAS - NÃO COBRE MAU USO");
            return p;
        }
    }
}

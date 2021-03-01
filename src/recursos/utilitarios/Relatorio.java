/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.utilitarios;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Thyago
 */
public class Relatorio {

    public static void openReport(Connection conexao, String titulo, Map parametros, InputStream inputStream){
        try {         
            JasperPrint  print  = JasperFillManager.fillReport(inputStream, parametros, conexao);
            viewReportFrame( titulo, print );
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório:\n" + ex);
        }
    }
    
    public static void openReport(Connection conexao, String titulo, Map parametros, JasperReport report){
        try {         
            JasperPrint  print  = JasperFillManager.fillReport(report, parametros, conexao);
            viewReportFrame( titulo, print );
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório:\n" + ex);
        }
    }   
    
    public static void openReport(Connection conexao, String titulo, Map parametros, URL report){
        try {         
            JasperPrint  print  = JasperFillManager.fillReport(report.getPath(), parametros, conexao);
            viewReportFrame( titulo, print );
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório:\n" + ex);
        }
    }   
    
    public static void openReport(Connection conexao, String titulo, Map parametros, File file){
        try {         
            JasperPrint  print  = JasperFillManager.fillReport(file.getPath(), parametros, conexao);
            viewReportFrame( titulo, print );
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar gerar relatório:\n" + ex);
        }
    }       
    
    private static void viewReportFrame( String titulo, JasperPrint print ) {
        JRViewer viewer = new JRViewer( print );
        JFrame frameRelatorio = new JFrame( titulo );
        frameRelatorio.add( viewer, BorderLayout.CENTER );
        frameRelatorio.setSize( 500, 500 );
        frameRelatorio.setExtendedState( JFrame.MAXIMIZED_BOTH );
        frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frameRelatorio.setVisible( true );
}
    
    public static InputStream lerArquivoNet(String relatorio){
        InputStream is = null;
        try { 
            String urlString = "http://www.obadescontos.com.br/GerenciaEstoque" + relatorio;  
            URL    url       = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestProperty("Request-Method", "GET"); 
            
            connection.setDoInput(true); 
            connection.setDoOutput(false); 
            
            connection.connect();  
            is = connection.getInputStream();
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "URL mal formatada:\n" + ex);
        } catch(IOException ex){
            JOptionPane.showMessageDialog(null, "Erro de IO ao acessar arquivo:\n" + ex);
        }
        return is;
    }
}

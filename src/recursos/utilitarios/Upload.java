/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.utilitarios;

import java.io.FileInputStream;  
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;
import org.apache.commons.net.ftp.FTPClient;  
import org.apache.commons.net.ftp.FTPReply;
  
  
public class Upload {  
     
    String host  = ""; 
    String login = "";
    String senha = "";
    
    public Upload(String host, String login, String senha){
         this.host  = host;
         this.login = login;
         this.senha = senha;
    }

    public boolean enviar(String nome, String diretorio, String nomefinal) {  
        boolean res = false; 
        try {  
               FTPClient ftp = new FTPClient();  
               ftp.connect(host);  
               if( FTPReply.isPositiveCompletion( ftp.getReplyCode() ) ) { 
                    ftp.login(login, senha);  
                    ftp.enterLocalPassiveMode();
                    ftp.makeDirectory(diretorio);  
                    ftp.changeWorkingDirectory(diretorio);  
                    InputStream arqEnviar = new FileInputStream(nome);                     
                    if(nome.endsWith(".txt") || nome.endsWith(".doc") || nome.endsWith(".docx")) { 
                         ftp.setFileType( FTPClient.ASCII_FILE_TYPE ); 
                    }else if(nome.endsWith(".jpg") || nome.endsWith(".png")) { 
                         ftp.setFileType( FTPClient.BINARY_FILE_TYPE ); 
                    }else{ 
                         ftp.setFileType( FTPClient.ASCII_FILE_TYPE ); 
                    } 
                    
                    if (ftp.storeFile (nomefinal, arqEnviar)) {
                         res = true;
                    }else {
                         res = false;
                    }                         
               } else { 
                    ftp.disconnect(); 
                    JOptionPane.showMessageDialog(null, "Conexão recusada"); 
               }                    
        }catch (IOException ex) {  
               res = false;  
               JOptionPane.showMessageDialog(null, "Erro causado por:\n" + ex);
        }  
        return res;
    }  

     public void excluir(String nome) {
        try {  
               FTPClient ftp = new FTPClient();  
               ftp.connect(host);  
               if( FTPReply.isPositiveCompletion( ftp.getReplyCode() ) ) { 
                    ftp.login(login, senha);  
                    ftp.enterLocalPassiveMode();
                    ftp.deleteFile(nome); 
               } else { 
                    ftp.disconnect(); 
                    JOptionPane.showMessageDialog(null, "Conexão recusada"); 
               }                    
        }catch (IOException e) {  
            JOptionPane.showMessageDialog(null,"Erro ao fazer upload, causado por:\n" + e);  
        }           
     }
}  
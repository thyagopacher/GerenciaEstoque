/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.utilitarios;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import javax.swing.JOptionPane;
import vo.CepServiceVO;

/**
 *
 * @author ThyagoHenrique
 */
public class Cep {
     
     public CepServiceVO procuraCEP(String cep){	
          try {
               String urlString = "http://cep.republicavirtual.com.br/web_cep.php";
               Properties parameters = new Properties();
               parameters.setProperty("cep", cep);
               parameters.setProperty("formato", "xml");
               Iterator i = parameters.keySet().iterator();
               int counter = 0;
               while (i.hasNext()) {
                       String name = (String) i.next();
                       String value = parameters.getProperty(name);
                       urlString += (++counter == 1 ? "?" : "&") + name + "=" + value;
               }
               URL url = new URL(urlString);
               HttpURLConnection connection = (HttpURLConnection) url.openConnection();
               connection.setRequestProperty("Request-Method", "GET");
               connection.setDoInput(true);
               connection.setDoOutput(false);
               connection.connect();
                StringBuilder newData;
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                newData = new StringBuilder();
                String s = "";
                while (null != ((s = br.readLine()))) {
                       newData.append(s);
                }
               XStream xstream = new XStream(new DomDriver());
               Annotations.configureAliases(xstream, CepServiceVO.class);
               xstream.alias("webservicecep", CepServiceVO.class);
               CepServiceVO cepServiceVO = (CepServiceVO) xstream.fromXML(newData.toString());
               return cepServiceVO;
          } catch (Exception ex) {
                  JOptionPane.showMessageDialog(null, "Erro ao procurar CEP causado por:\n" + ex);
          }  
          return null;
     }
}

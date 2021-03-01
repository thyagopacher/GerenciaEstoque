/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.utilitarios;

import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Thyago
 */
public class Mascara {

    
    private static final Locale       BRASIL = new Locale ("pt", "BR");     
    private static final NumberFormat nf     = NumberFormat.getCurrencyInstance(BRASIL);  

    public Date convertePDate(String data){
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
          Date             dte = null;    
          try {
               dte = sdf.parse(data);
          } catch (ParseException ex) {
               JOptionPane.showMessageDialog(null,"Erro ocasionado por:\n" + ex);
          }
          return dte;         
    }
    
    public String mascaraData(String formato, Date data){
          SimpleDateFormat out = new SimpleDateFormat(formato);    
          String           d1  = out.format(data);      
          return d1;
    }    
    
    public String ColocaVirgula(Double metro){
         return String.valueOf(metro).replace(".", ",") + 0;
    }
    
    public Double TiraVirgula(String metro){
         return Double.valueOf(metro.replace(",", "."));
    }    
    
    public static String formatMoeda(Double d){  
            return nf.format (d);  
    }  

    public static Double formatToDouble(String s){  
        double retorno;
        try {  
            if(s.contains("R$ ")){
                 s = s.replace("R$ ", "");
            } 
            retorno = (nf.parse ("R$ " + s)).doubleValue();
        } catch (ParseException ex) {
            retorno = 0;
            System.out.println("Erro causado por:\n" + ex);
        }
        return retorno;
    }      

    public void mascaraInteiro(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (! ((c==KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_DELETE)|| (c== KeyEvent.VK_ENTER) || (c == KeyEvent.VK_TAB) || (Character.isDigit(c)))) {
            evt.consume() ;
        }
    }

public boolean valida_cpf(String strCpf)    {          
     int     d1, d2;          
     int     digito1, digito2, resto;          
     int     digitoCPF;          
     String  nDigResult;          
     
     d1 = d2 = 0;          
     digito1 = digito2 = resto = 0;          
     
     for (int nCount = 1; nCount < strCpf.length() -1; nCount++)          
     {            
         digitoCPF = Integer.valueOf (strCpf.substring(nCount -1,nCount)).intValue();             
         d1 = d1 + ( 11 - nCount ) * digitoCPF;             
         d2 = d2 + ( 12 - nCount ) * digitoCPF;          
     }          
     
     resto = (d1 % 11);          
     
     if (resto < 2) {
        digito1 = 0;
    }          
     else {
        digito1 = 11 - resto;
    }          
     
     d2 += 2 * digito1;          
     resto = (d2 % 11);          
     
     if (resto < 2) {
        digito2 = 0;
    }          
     else {
        digito2 = 11 - resto;
    }          
     
     String nDigVerific = strCpf.substring(strCpf.length()-2, strCpf.length());          
     nDigResult = String.valueOf(digito1) + String.valueOf(digito2); 
     
     return nDigVerific.equals(nDigResult);       
 }

    public boolean valida_cnpj(String cnpj) {
        if (!cnpj.substring(0, 1).isEmpty()) {
            try {
                cnpj = cnpj.replace('.', ' ');
                cnpj = cnpj.replace('/', ' ');
                cnpj = cnpj.replace('-', ' ');
                cnpj = cnpj.replaceAll(" ", "");
                int soma = 0, dig;
                String cnpj_calc = cnpj.substring(0, 12);

                if (cnpj.length() != 14) {
                    return false;
                }
                char[] chr_cnpj = cnpj.toCharArray();
                for (int i = 0; i < 4; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                        soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                        dig);
                soma = 0;
                for (int i = 0; i < 5; i++) {
                    if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                        soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                        soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                dig = 11 - (soma % 11);
                cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                        dig);
                return cnpj.equals(cnpj_calc);
            }
            catch (Exception e) {
                return false;
            }
        }
        else {
            return false;
        }
    }
        
}

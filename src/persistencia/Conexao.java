/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Thyago
 */
public class Conexao {
    public SessionFactory f; 
    public Session s;
    public Transaction    t;

    public String conectarBanco(){
      String msg = "";
      try{
          f = new Configuration().configure("persistencia/hibernate.cfg.xml").buildSessionFactory();
          s = f.openSession();
      }catch(Exception ex){
          msg = "Erro ao tentar conectar causado por:\n" + ex;
      }catch(Throwable ex){
          msg = "Erro ao tentar conectar causado por:\n" + ex;
      }
      return msg;
    }
    
    public void conectar(){
        if(s == null || f.isClosed()){
            s = f.openSession(); 
        }else{
            t = s.beginTransaction();
        }
    }
    
    public void desconectar(){
        t.commit();
        s.flush();  
    }
    
    public void desconectarTudo(){
        s.close();
    }    
    
}

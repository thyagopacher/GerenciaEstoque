/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.UsuarioPers;
import vo.Usuario;

/**
 *
 * @author Thyago
 */
public class UsuarioRN {
   
    UsuarioPers pp = new UsuarioPers();
    
    public String valida(Usuario p){
         String msg = "";
         if(p != null){
              if(p.getEmail() == null || p.getEmail().isEmpty()){
                   msg += "\nE-mail em branco";
              }
              if(p.getPrimeironome() == null || p.getPrimeironome().isEmpty()){
                   msg += "\nPrimeiro nome em branco";
              }
              if(p.getUltimonome() == null || p.getUltimonome().isEmpty()){
                   msg += "\nÚltimo nome em branco";
              }
              if(p.getSenha() == null || p.getSenha().isEmpty()){
                   msg += "\nSenha em branco";
              }
         }else{
              msg += "\nUsuario veio nula";
         }
         return msg;
    }
    
    public String inserirUsuario(Conexao cx, Usuario p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirUsuario(cx, p);
         }
    }
    
    public String updateUsuario(Conexao cx, Usuario p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateUsuario(cx, p);
         } 
    } 
    
    public String excluirUsuario(Conexao cx, Usuario p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirUsuario(cx, p);
         } 
    }     
    
    public Usuario procuraCodUsuario(Conexao cx, int codigo){
        return pp.procuraCodUsuario(cx, codigo);
    }

    public Usuario procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
   
    public List<Usuario> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       
  
    public List<Usuario> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

     public Usuario procuraVendedor(Conexao cx, Integer codigo) {
          return pp.procuraVendedor(cx, codigo);
     }

     public Usuario verificarLogin(Conexao cx, String login, String senha) {
          return pp.verificarLogin(cx, login, senha);
     }
  
}

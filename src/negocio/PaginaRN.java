/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.PaginaPers;
import vo.Pagina;

/**
 *
 * @author Thyago
 */
public class PaginaRN {
   
    PaginaPers pp = new PaginaPers();
    
    public String valida(Pagina p){
         String msg = "";
         if(p != null){
              if(p.getConteudo() == null || p.getConteudo().isEmpty()){
                   msg += "\nConteúdo nulo";
              }
              if(p.getTitulo() == null || p.getTitulo().isEmpty()){
                   msg += "\nRegião nulo";
              }
         }else{
              msg += "\nPaís nulo";
         }
         return msg;
    }     
    
    public String inserirPagina(Conexao cx, Pagina p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirPagina(cx, p);
         }
    }
    
    public String updatePagina(Conexao cx, Pagina p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updatePagina(cx, p);
         }   
    } 
    
    public String excluirPagina(Conexao cx, Pagina p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirPagina(cx, p);
         }   
    }     
    
    public Pagina procuraCodPagina(Conexao cx, int codigo){
        return pp.procuraCodPagina(cx, codigo);
    }

    public Pagina procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);       
    }
 
    public List<Pagina> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }
   
    public List<Pagina> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      

}

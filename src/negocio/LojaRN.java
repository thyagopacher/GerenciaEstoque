/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.LojaPers;
import vo.Loja;

/**
 *
 * @author Thyago
 */
public class LojaRN {
   
    LojaPers pp = new LojaPers();
    
    public String valida(Loja p){
        String msg = "";
        
        if(p.getSite() == null || p.getSite().isEmpty()){
            msg += "\nSite em branco" + "\n";
        }
        if(p.getLinkftp() == null || p.getLinkftp().isEmpty()){
            msg += "\nLink FTP em branco" + "\n";
        }   
        if(p.getLogin() == null || p.getLogin().isEmpty()){
            msg += "\nLogin FTP em branco" + "\n";
        }        
        if(p.getSenha() == null || p.getSenha().isEmpty()){
            msg += "\nSenha FTP em branco" + "\n";
        }                
        return msg;
    }     
    
    public String inserirLoja(Conexao cx, Loja p){
        String res = this.valida(p);
        if(res == null || res.isEmpty()){
             Loja proc = this.procuraCodLoja(cx, p.getCodigo());
             if(proc != null && proc.getSite() != null){
                 return "Loja já dispõe de uma configuração, se quiser mudar atualize!!!"; 
             }else{
                 return pp.inserirLoja(cx, p);
             }
        }else{
            return res;
        } 
    }
    
    public String updateLoja(Conexao cx, Loja p){
        String res = this.valida(p);
        if(res == null || res.isEmpty()){
            return pp.updateLoja(cx, p);
        }else{
            return res;
        }     
    } 
    
    public String excluirLoja(Conexao cx, Loja p){
        String res = this.valida(p);
        if(res == null || res.isEmpty()){
            return pp.excluirLoja(cx, p);
        }else{
            return res;
        }  
    }     
    
    public Loja procuraCodLoja(Conexao cx, int codigo){
        return pp.procuraCodLoja(cx, codigo);
    } 
    
    public Loja procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }

     public List<Loja> procuraNomeParcial(Conexao cx, String nome) {
          return pp.procuraNomeParcial(cx, nome);        
     }

     public List<Loja> procuraTodos(Conexao cx) {
          return pp.procuraTodos(cx);
     }

}

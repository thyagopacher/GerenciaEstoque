/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.PessoaPers;
import vo.Pessoa;

/**
 *
 * @author Thyago
 */
public class PessoaRN {
   
    PessoaPers pp = new PessoaPers();
    
    public String valida(Pessoa p){
         String msg = "";
         if(p != null){
              if(p.getNome() == null || p.getNome().isEmpty()){
                   msg += "\nNome em branco";
              }
              if(p.getCpf() == null || p.getCpf().isEmpty()){
                   msg += "\nCPF em branco";
              }
              if(p.getTelefone() == null || p.getTelefone().isEmpty()){
                   msg += "\nTelefone em branco";
              }
         }else{
              msg += "\nPessoa veio nula";
         }
         return msg;
    }
    
    public String inserirPessoa(Conexao cx, Pessoa p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirPessoa(cx, p);
         }
    }
    
    public String updatePessoa(Conexao cx, Pessoa p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updatePessoa(cx, p);
         } 
    } 
    
    public String excluirPessoa(Conexao cx, Pessoa p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirPessoa(cx, p);
         } 
    }     
    
    public Pessoa procuraCodPessoa(Conexao cx, int codigo){
        return pp.procuraCodPessoa(cx, codigo);
    }

    public Pessoa procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
   
    public List<Pessoa> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       
  
    public List<Pessoa> procuraTtipo(Conexao cx, String tipo){
        return pp.procuraTtipo(cx, tipo);
    }      
    
    public List<Pessoa> procuraTodos(Conexao cx){
        return pp.procuraTodos(cx);
    }      
  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.EnderecoPers;
import vo.Endereco;

/**
 *
 * @author Thyago
 */
public class EnderecoRN {
   
    EnderecoPers pp = new EnderecoPers();
    
    public String valida(Endereco e){
         String msg = "";
         if(e != null){
              if(e.getEndereco() == null || e.getEndereco().isEmpty()){
                   msg += "\nEndereço não pode vir nulo";
              }
              if(e.getCep() == null || e.getCep().isEmpty()){
                   msg += "\nCEP não pode vir nulo";
              }
              if(e.getCidade() == null || e.getCidade().isEmpty()){
                   msg += "\nCidade não pode vir nulo";
              }
              if(e.getEstado() == null || e.getEstado().getNome() == null){
                   msg += "\nEstado não pode vir nulo";
              }
         }else{
              msg += "\nEndereço não pode vir nulo";
         }
         return msg;
    }
    
    public String inserirEndereco(Conexao cx, Endereco p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.inserirEndereco(cx, p);
         }
    }
    
    public String updateEndereco(Conexao cx, Endereco p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.updateEndereco(cx, p);
         }
    } 
    
    public String excluirEndereco(Conexao cx, Endereco p){
         String msg = this.valida(p);
         if(msg != null && !msg.isEmpty()){
              return msg;
         }else{
              return pp.excluirEndereco(cx, p);
         }
    }     
    
    public Endereco procuraCodEndereco(Conexao cx, int codigo){
        return pp.procuraCodEndereco(cx, codigo);
    }

    public Endereco procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }
 
    public List<Endereco> procuraNomeParcial(Conexao cx, String nome) {
        return pp.procuraNomeParcial(cx, nome);
    }       

     public List<Endereco> procuraCodPessoa(Conexao cx, Integer codigo) {
        return pp.procuraCodPessoa(cx, codigo);
     }    
    
    public List<Endereco> procuraTodos(Conexao cx) {
        return pp.procuraTodos(cx);
    }  

}

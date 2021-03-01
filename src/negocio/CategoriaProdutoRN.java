/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.CategoriaProdutoPers;
import vo.CategoriaProduto;

/**
 *
 * @author Thyago
 */
public class CategoriaProdutoRN {
   
    CategoriaProdutoPers pp = new CategoriaProdutoPers();
    
    public String valida(CategoriaProduto p){
        String msg = "";
        
        if(p.getNome() == null || p.getNome().isEmpty()){
            msg += "Nome em branco" + "\n";
        }
        return msg;
    }     
    
    public String inserirCategoriaProduto(Conexao cx, CategoriaProduto p){
        return pp.inserirCategoriaProduto(cx, p);
    }
    
    public String updateCategoriaProduto(Conexao cx, CategoriaProduto p){
        String res = this.valida(p);
        if(res == null || res.isEmpty()){
            return pp.updateCategoriaProduto(cx, p);
        }else{
            return res;
        }     
    } 
    
    public String excluirCategoriaProduto(Conexao cx, CategoriaProduto p){
            return pp.excluirCategoriaProduto(cx, p);
    }     
    
    public CategoriaProduto procuraCodCategoriaProduto(Conexao cx, int codigo){
        return pp.procuraCodCategoriaProduto(cx, codigo);
    } 
    
    public CategoriaProduto procuraNomeExato(Conexao cx, String nome) {
        return pp.procuraNomeExato(cx, nome);        
    }

     public List<CategoriaProduto> procuraNomeParcial(Conexao cx, String nome) {
          return pp.procuraNomeParcial(cx, nome);        
     }

     public List<CategoriaProduto> procuraTodos(Conexao cx) {
          return pp.procuraTodos(cx);
     }

}

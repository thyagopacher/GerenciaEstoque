/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.List;
import persistencia.Conexao;
import persistencia.CategoriasProdutoPers;
import vo.CategoriasProduto;

/**
 *
 * @author Thyago
 */
public class CategoriasProdutoRN {
   
    CategoriasProdutoPers pp = new CategoriasProdutoPers();
    
    public String valida(CategoriasProduto p){
        String msg = "";
        
        if(p.getCategoria() == null || p.getCategoria().getNome() == null){
            msg += "Categoria em branco\n";
        }
        if(p.getProduto() == null || p.getProduto() == null){
             msg += "Produto em branco\n";
        }
        return msg;
    }     
    
    public String inserirCategoriasProduto(Conexao cx, CategoriasProduto p){
          CategoriasProduto proc = this.procuraCategoriaProduto(cx, p.getCategoria().getCodigo(), p.getProduto().getCodigo());
          if(proc != null && proc.getCodigo() != null){
               return pp.updateCategoriasProduto(cx, p);
          }else{
               return pp.inserirCategoriasProduto(cx, p);
          }
    }
    
    public String updateCategoriasProduto(Conexao cx, CategoriasProduto p){
        String res = this.valida(p);
        if(res == null || res.isEmpty()){
            return pp.updateCategoriasProduto(cx, p);
        }else{
            return res;
        }     
    } 
    
    public String excluirCategoriasProduto(Conexao cx, CategoriasProduto p){
            return pp.excluirCategoriasProduto(cx, p);
    }     
    
    public CategoriasProduto procuraCodCategoriasProduto(Conexao cx, int codigo){
        return pp.procuraCodCategoriasProduto(cx, codigo);
    } 

     public List<CategoriasProduto> procuraTodos(Conexao cx) {
          return pp.procuraTodos(cx);
     }

     public CategoriasProduto procuraCatProduto(Conexao cx, Integer codigo1, Integer codigo2) {
         return pp.procuraCatProduto(cx, codigo1, codigo2);
     }

     public List<CategoriasProduto> procuraProduto(Conexao cx, Integer codigo) {
          return pp.procuraCatProduto(cx, codigo);
     }

     public CategoriasProduto procuraCategoriaProduto(Conexao cx, int codcategoria, int codproduto){
         return pp.procuraCategoriaProduto(cx, codcategoria, codproduto);
     }
}

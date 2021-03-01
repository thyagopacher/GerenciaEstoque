/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.CategoriaProduto;
import vo.CategoriasProduto;

/**
 *
 * @author Thyago
 */
public class CategoriasProdutoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirCategoriasProduto(Conexao cx, CategoriasProduto p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateCategoriasProduto(Conexao cx, CategoriasProduto p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirCategoriasProduto(Conexao cx, CategoriasProduto p){ 
        try{
            cx.conectar();
            String query = "delete from CategoriasProduto where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public CategoriasProduto procuraCodCategoriasProduto(Conexao cx, int codigo){
        cx.conectar();
        return (CategoriasProduto)cx.s.get(CategoriasProduto.class,codigo);
    }

    public List<CategoriasProduto> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from CategoriasProduto";
        return cx.s.createQuery(query).list();
    }    

     public CategoriasProduto procuraCatProduto(Conexao cx, Integer codigo1, Integer codigo2) {
        cx.conectar();
        String                query = "from CategoriasProduto where categoria.codigo = '" + codigo1 + "' and produto.codigo = '" + codigo2 + "'";
        CategoriasProduto     c     = new CategoriasProduto();
        Iterator              it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (CategoriasProduto)it.next();
        } 
        cx.desconectar();
        return c;
     }

     public List<CategoriasProduto> procuraCatProduto(Conexao cx, Integer codigo) {
        cx.conectar();
        String                query = "from CategoriasProduto where produto.codigo = '" + codigo + "'";
        return cx.s.createQuery(query).list();
     }

     public CategoriasProduto procuraCategoriaProduto(Conexao cx, int codcategoria, int codproduto) {
        cx.conectar();
        String                query = "from CategoriasProduto where categoria.codigo = '" + codcategoria + "' and produto.codigo = '" + codproduto + "'";
        CategoriasProduto     c     = new CategoriasProduto();
        Iterator              it    = cx.s.createQuery(query).list().iterator();
        while(it.hasNext()){
            c = (CategoriasProduto)it.next();
        } 
        cx.desconectar();
        return c;
     }
}

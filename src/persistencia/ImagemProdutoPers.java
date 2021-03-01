/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.Iterator;
import java.util.List;
import vo.ImagemProduto;

/**
 *
 * @author Thyago
 */
public class ImagemProdutoPers {
    
    String  msg = "";
    Conexao cx  = new Conexao(); 
    
    public String inserirImagemProduto(Conexao cx, ImagemProduto p){
        try{
            cx.conectar();
            cx.s.save(p);
            cx.desconectar();
        }catch(Exception ex){
            msg = "Erro ao inserir: " + ex;
        }
        return msg;
    }
    
    public String updateImagemProduto(Conexao cx, ImagemProduto p){
        try{
            cx.conectar();
            cx.s.merge(p);
            cx.desconectar();            
        }catch(Exception ex){
            msg = "Erro ao update: " + ex;
        }
        return msg;        
    } 
    
    public String excluirImagemProduto(Conexao cx, ImagemProduto p){ 
        try{
            cx.conectar();
            String query = "delete from ImagemProduto where codigo = '" + p.getCodigo() + "'";
            cx.s.createQuery(query).executeUpdate();
            cx.desconectar();
        }catch(Exception e){
            msg = "Erro ao excluir:\n" + e;
        }       
        return msg;        
    }     
    
    public List<ImagemProduto> procuraCodImagemProduto(Conexao cx, int codigo){
        cx.conectar();
        String query = "from ImagemProduto where produto.codigo = '" + codigo + "'";
        return cx.s.createQuery(query).list();
    }

    public List<ImagemProduto> procuraNomeExato(Conexao cx, String nome) {
        String query = "from ImagemProduto where nome = '" + nome + "'";
        return cx.s.createQuery(query).list();
    }    
 
    public List<ImagemProduto> procuraNomeParcial(Conexao cx, String nome) {
        cx.conectar();
        String      query = "from ImagemProduto where nome like '%" + nome + "%' order by imagem ASC";
        return cx.s.createQuery(query).list();
    }    
 
    public List<ImagemProduto> procuraTodos(Conexao cx){
        cx.conectar();
        String       query = "from ImagemProduto order by nome ASC";
        return cx.s.createQuery(query).list();
    }    

     public ImagemProduto procuraCodigo(Conexao cx, int codigo) {
        cx.conectar();
        return (ImagemProduto)cx.s.get(ImagemProduto.class,codigo);
     }

}

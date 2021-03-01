/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.utilitarios;

/**
 *
 * @author Thyago
 */
import javax.swing.table.AbstractTableModel;
 
public class TableModel extends AbstractTableModel {
        private Object[]   tituloColunas;
        private Object[][] data;
        private int        linhas;
        private int        colunas;

        public TableModel(Object[] tituloColunas, int numLinhas, int numColunas){
                this.tituloColunas = tituloColunas;
                this.data          = new Object[numLinhas][numColunas];
                linhas             = numLinhas;
                colunas            = numColunas;
        }

    @Override
        public String getColumnName(int col){
                return tituloColunas[col].toString();
        }

        @Override
        public int getColumnCount() {
                return colunas;
        }
 
        @Override
        public int getRowCount() {
                return linhas;
        }
 
        @Override
        public Object getValueAt(int linha, int coluna) {
                return data[linha][coluna];
        }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
            data[linha][coluna]=valor.toString();
            fireTableCellUpdated(linha, coluna);
    }

    public void removeLinha(int indiceLinha) {
        for(int j = 0; j < getColumnCount(); j++){
            data[indiceLinha][j] = "";
        }
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }    
  
    @Override
    public boolean isCellEditable(int row, int column) {  
        return false;  
    }  

    public void substituiConteudo(int linha, int coluna, String dado){
        data[linha][coluna] = dado;
        fireTableRowsInserted(linha,coluna);  
    }
}
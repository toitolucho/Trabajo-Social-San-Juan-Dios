package org.quarkbit.trabajosocialsanjuan.utils.componentes;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.TableColumnModel;


public class JTableHorario extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	private HashMap m_tDataAwareColorMap = new HashMap();

	@SuppressWarnings("unchecked")
	public void setM_tDataAwareColorMap(HashMap m_tDataAwareColorMap) {
		this.m_tDataAwareColorMap = m_tDataAwareColorMap;
	}

	@SuppressWarnings("unchecked")
	public HashMap getM_tDataAwareColorMap() {
		return m_tDataAwareColorMap;
	}
	
	public JTableHorario()
	{
		super(); 
	}
	
	public JTableHorario(int nRow, int nColumn) {
        super(nRow, nColumn);
    }

    public JTableHorario(Object[][] datos, Object[] columnas){
    	super(datos, columnas);
    }
    

    @SuppressWarnings("unchecked")
	public HashMap getDataAwareColorMap() {
        return m_tDataAwareColorMap;
    }

    @SuppressWarnings("unchecked")
	public void setDataAwareColor(Object tObject, Color clr) {
        m_tDataAwareColorMap.put(tObject, clr);
    }

    public void updateUI() {
        super.updateUI();
        int nColumnCount = this.getColumnCount();
        TableColumnModel tcm = this.getColumnModel();
        for (int i = 0; i < nColumnCount ;i++)
        {
            tcm.getColumn(i).setCellRenderer( new JLabelTableCellRenderer());
        }
    }    
    
}

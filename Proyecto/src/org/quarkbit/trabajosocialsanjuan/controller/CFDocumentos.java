package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.FormView;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ComidaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Documento;
import org.quarkbit.trabajosocialsanjuan.dao.domain.DocumentoExample;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.DocumentoMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FDocumentos;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloDocumentos;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

public class CFDocumentos extends MouseAdapter implements ActionListener, ListSelectionListener {
	
	FDocumentos formDocumento;
	SqlSession session;
	DocumentoMapper daoDocumentoMapper;
	ModeloDocumentos modeloDocumento;
	String tipoOperacion = "";
	Documento documentoActual;
	
	public CFDocumentos(FDocumentos formDocumento)
	{
		this.formDocumento = formDocumento;
		documentoActual = new Documento();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoDocumentoMapper = session.getMapper(DocumentoMapper.class);
		modeloDocumento = new ModeloDocumentos();
		
		formDocumento.getjTableDocumento().setModel(modeloDocumento);
		formDocumento.getTxtCodigo().setEnabled(false);	
		
		formDocumento.getBtnAceptar().addActionListener(this);
		formDocumento.getBtnNuevo().addActionListener(this);
		formDocumento.getBtnCancelar().addActionListener(this);
		formDocumento.getBtnModificar().addActionListener(this);
		formDocumento.getBtnEliminar().addActionListener(this);
		formDocumento.getBtnCerrar().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
		modeloDocumento.setListDocumento(daoDocumentoMapper.selectByExample(null));
		formDocumento.getjTableDocumento().getSelectionModel().addListSelectionListener(this);
		formDocumento.getjTableDocumento().getColumn("Codigo").setPreferredWidth(5);
		formDocumento.getjTableDocumento().addMouseListener(this);
		FormUtilities.centrar(formDocumento);
		
//		mostrarParaInsercion(null);
	}
	

	
	public void mostrarParaInsercionListado(Documento Documento, boolean lista)
	{
		if(Documento != null) //para edicion
		{
			tipoOperacion = "E";
		}
		else
		{
			tipoOperacion = "I";
		}
		
		limpiarControles();
		habilitarControles(true);
		habilitarBotones(false, true, false, false, false);
		formDocumento.mostrorSoloControles(lista);
		FormUtilities.centrar(formDocumento);
	}
	
	public void limpiarControles()
	{
		formDocumento.getTxtCodigo().setText("");
		formDocumento.getTxtDescripcion().setText("");
		formDocumento.getTxtNombre().setText("");
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formDocumento.getTxtNombre().setEnabled(estadHabilitacion);
		formDocumento.getTxtDescripcion().setEnabled(estadHabilitacion);
//		formDocumento.getjTableDocumento().setEnabled(estadHabilitacion);
	}
	
	public boolean validarControles()
	{
		if(formDocumento.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formDocumento, "A\u00FAn no ha ingresado el nombre del Documento", "Documento", JOptionPane.ERROR_MESSAGE);
			formDocumento.getTxtNombre().grabFocus();
			return false;
		}
		
		DocumentoExample filtro = new DocumentoExample();
		filtro.or().andNombreDocumentoEqualTo(formDocumento.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoDocumentoMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formDocumento, "El nombre de la Documento ya se encuentra registrada", "Categoria Documento", JOptionPane.ERROR_MESSAGE);
			formDocumento.getTxtNombre().grabFocus();
			return false;
		}
		
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formDocumento.getBtnAceptar().setEnabled(aceptar);
		formDocumento.getBtnNuevo().setEnabled(nuevo);
		formDocumento.getBtnCancelar().setEnabled(cancelar);
		formDocumento.getBtnModificar().setEnabled(modificar);
		formDocumento.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Documento DocumentoAux)
	{
		if(DocumentoAux != null)
		{
			this.documentoActual = DocumentoAux;
			formDocumento.getTxtCodigo().setText(DocumentoAux.getCodigoDocumento().toString());
			formDocumento.getTxtNombre().setText(DocumentoAux.getNombreDocumento());
			formDocumento.getTxtDescripcion().setText(DocumentoAux.getDescripcion());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formDocumento.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					documentoActual = new Documento();
					documentoActual.setCodigoDocumento(-1);
					documentoActual.setNombreDocumento(formDocumento.getTxtNombre().getText().toUpperCase());
					documentoActual.setDescripcion(formDocumento.getTxtDescripcion().getText());
					if(tipoOperacion.compareTo("I")==0)
					{
						daoDocumentoMapper.insert(documentoActual);
						session.commit();
						
						Map<String, Integer> mapa = new HashMap<String, Integer>();
						mapa.put("ultimoId", 0);
						daoDocumentoMapper.obtenerUltimoId(mapa); //("myMappedStatement",myParams);
						documentoActual.setCodigoDocumento(mapa.get("ultimoId"));
						
//					System.out.println("codigo actual = " + DocumentoActual.getCodigoDocumento());
						modeloDocumento.AnadirDocumento(documentoActual);
					}
					else
					{
						modeloDocumento.setDocumento(formDocumento.getjTableDocumento().getSelectedRow(), documentoActual);
						documentoActual.setCodigoDocumento(Integer.parseInt(formDocumento.getTxtCodigo().getText()));
						daoDocumentoMapper.updateByPrimaryKey(documentoActual);
						session.commit();	
					}
					
					if(!formDocumento.getBtnNuevo().isVisible())
					{
						
						formDocumento.setVisible(false);
						formDocumento.dispose();
						return;
					}
					tipoOperacion ="";
					habilitarBotones(true, false, false, true, true);
					habilitarControles(false);
					JOptionPane.showMessageDialog(formDocumento, "Registro almacenado correctamente", "Documentos", JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(formDocumento, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(formDocumento.getBtnNuevo().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);
			limpiarControles();
			tipoOperacion = "I";
			formDocumento.getjTableDocumento().clearSelection();
		}
		if(formDocumento.getBtnCerrar().equals(event.getSource()))
		{
			formDocumento.setVisible(false);
			formDocumento.dispose();
			
		}
		if(formDocumento.getBtnModificar().equals(event.getSource()))
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(formDocumento.getBtnEliminar().equals(event.getSource()))
		{
			if(JOptionPane.showConfirmDialog(formDocumento, "¿Se encuentra seguro de eliminar el registro actual?", "Documentos", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + Integer.parseInt(formDocumento.getTxtCodigo().getText()));
				
				modeloDocumento.eliminarDocumento(formDocumento.getjTableDocumento().getSelectedRow());
				
				
				daoDocumentoMapper.deleteByPrimaryKey(Integer.parseInt(formDocumento.getTxtCodigo().getText()));
				
				session.commit();
				
				limpiarControles();
				JOptionPane.showMessageDialog(formDocumento, "Objeto eliminado correctamente", "Documento", JOptionPane.INFORMATION_MESSAGE);
				habilitarBotones(true, false, false, false, false);
			}
			
		}
		
		if(formDocumento.getBtnCancelar().equals(event.getSource()))
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false);
			tipoOperacion = "";
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if(e.getValueIsAdjusting())
			return;
		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
		cargarDatos(modeloDocumento.obtenerDocumento(indice));
		
	}
	
	@Override
    public void mousePressed(MouseEvent e) {
        if (e.getClickCount() == 2) {
            this.formDocumento.setVisible(false);
        }
    }

}

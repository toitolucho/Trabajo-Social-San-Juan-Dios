package org.quarkbit.trabajosocialsanjuan.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.PartidaExample;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Partida;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.PartidaMapper;
import org.quarkbit.trabajosocialsanjuan.formularios.FPartidas;
import org.quarkbit.trabajosocialsanjuan.formularios.tablemodels.ModeloPartidas;
import org.quarkbit.trabajosocialsanjuan.utils.FJTree;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;
import org.quarkbit.trabajosocialsanjuan.utils.FJTree.Element;

public class CFPartidas extends MouseAdapter implements ActionListener, TreeSelectionListener{
	
	FPartidas formPartida;
	SqlSession session;
	PartidaMapper daoPartidaMapper;
	
	DefaultTreeModel modeloPartida;
	String tipoOperacion = "";
	Partida partidaActual;
	int codigoUsuario = 1;
	
	
	
	public CFPartidas(FPartidas formPartidasCategorias)
	{
		this.formPartida = formPartidasCategorias;
		partidaActual = new Partida();
	}
	
	public void onLoad()
	{
		session = Coneccion.getSqlSessionFactory().openSession();
		daoPartidaMapper = session.getMapper(PartidaMapper.class);		
		
		
		
		formPartida.getTxtCodigo().setEnabled(false);	
		
		formPartida.getBtnAceptar().addActionListener(this);
		formPartida.getBtnNuevo().addActionListener(this);
		formPartida.getBtnCancelar().addActionListener(this);
		formPartida.getBtnModificar().addActionListener(this);
		formPartida.getBtnEliminar().addActionListener(this);
		formPartida.getBtnCerrar().addActionListener(this);
		
		formPartida.getMntmEliminar().addActionListener(this);
		formPartida.getMntmModificar().addActionListener(this);
		formPartida.getMntmnuevo().addActionListener(this);
		formPartida.getMntmSalida().addActionListener(this);
		
		
		habilitarControles(false);
		habilitarBotones(true, false, false, false, false);
//		modeloPartida.setListPartida(daoPartidaMapper.selectByExample(null));
		
//		formPartida.getjTablePartida().getColumn("Codigo").setPreferredWidth(5);
		FormUtilities.centrar(formPartida);
		
		// builds a map of elements object returned from store
		Map<String, Partida> values = new HashMap<String, Partida>();
		for (Partida tipo : daoPartidaMapper.selectByExample(null)) {
			formPartida.getcBoxPartidaPadre().addItem(tipo);			
		}
		
		for (Partida tipo : daoPartidaMapper.selectByExample(null)) {			
			values.put(tipo.getCodigoPartida(), tipo);
		}
		
		// creates a result list
        Collection<Partida> result = new ArrayList<Partida>();

        // for each element in the result list that has a parent, put it into it
        // otherwise it is added to the result list
        for (Partida e : values.values()) {
//        	System.out.println(e);
            if (e.getCodigoPartidaPadre()!= null) {
                values.get(e.getCodigoPartidaPadre()).getPartidas().add(e);
            } else {
                result.add(e);
            }
        }
        
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Partidas");
        modeloPartida = new DefaultTreeModel(root);
        
        createTreeNodesForElement(root, result);

        formPartida.getjTreePartida().setModel(modeloPartida);
        
        formPartida.getjTreePartida().setSelectionRow(1);
        formPartida.getjTreePartida().setExpandsSelectedPaths(true);
        formPartida.getjTreePartida().addTreeSelectionListener(this);
        formPartida.getjTreePartida().addMouseListener(this);
//		mostrarParaInsercion(null);
	}
	
	void createTreeNodesForElement(final DefaultMutableTreeNode dmtn, final Collection<Partida> elements) {
        // for each element a tree node is created
        for (Partida child : elements) {
            DefaultMutableTreeNode created = new DefaultMutableTreeNode(child);
            dmtn.add(created);
            createTreeNodesForElement(created, child.getPartidas());
        }
    }
	
	public void mostrarParaInsercion(Partida Partida)
	{
		if(Partida != null) //para edicion
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
		formPartida.mostrorSoloControles();
	}
	
	public void limpiarControles()
	{
		formPartida.getTxtCodigo().setText("");
		formPartida.getTxtDescripcion().setText("");		
		formPartida.getTxtNombre().setText("");		
		formPartida.getcBoxPartidaPadre().setSelectedIndex(-1);
	}
	
	public void habilitarControles(boolean estadHabilitacion)
	{
		formPartida.getTxtCodigo().setEnabled(estadHabilitacion);
		formPartida.getTxtDescripcion().setEnabled(estadHabilitacion);
		formPartida.getTxtNombre().setEnabled(estadHabilitacion);
		formPartida.getcBoxPartidaPadre().setEnabled(estadHabilitacion);

	}
	
	public boolean validarControles()
	{
		if(formPartida.getTxtCodigo().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formPartida, "A\u00FAn no ha ingresado el Codigo de Partida", "Partida", JOptionPane.ERROR_MESSAGE);
			formPartida.getTxtCodigo().grabFocus();
			return false;
		}
		
		if(formPartida.getTxtNombre().getText().trim().isEmpty())
		{
			JOptionPane.showMessageDialog(formPartida, "A\u00FAn no ha ingresado el Nombre de Partida", "Partida", JOptionPane.ERROR_MESSAGE);
			formPartida.getTxtNombre().grabFocus();
			return false;
		}
//		if(formPartida.getcBoxPartidaPadre().getSelectedIndex() < 0)
//		{
//			JOptionPane.showMessageDialog(formPartida, "A\u00FAn no ha seleccionado el Tipo", "Partida", JOptionPane.ERROR_MESSAGE);
//			formPartida.getcBoxPartidaPadre().grabFocus();
//			return false;
//		}
		
		PartidaExample filtro = new PartidaExample();
		filtro.or().andNombrePartidaEqualTo(formPartida.getTxtNombre().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoPartidaMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formPartida, "El nombre de la Partida ya se encuentra registrada", "Categoria Partida", JOptionPane.ERROR_MESSAGE);
			formPartida.getTxtNombre().grabFocus();
			return false;
		}
		
		filtro.clear();
		filtro.or().andCodigoPartidaEqualTo(formPartida.getTxtCodigo().getText().toUpperCase());
		if(tipoOperacion.compareTo("I") == 0 && daoPartidaMapper.countByExample(filtro) > 0)
		{
			JOptionPane.showMessageDialog(formPartida, "El Identificador de la Partida ya se encuentra registrada", "Categoria Partida", JOptionPane.ERROR_MESSAGE);
			formPartida.getTxtCodigo().grabFocus();
			return false;
		}
		
		
		return true;
	}
	
	public void habilitarBotones(boolean nuevo, boolean aceptar, boolean cancelar,
			boolean modificar, boolean eliminar)
	{
		formPartida.getBtnAceptar().setEnabled(aceptar);
		formPartida.getBtnNuevo().setEnabled(nuevo);
		formPartida.getBtnCancelar().setEnabled(cancelar);
		formPartida.getBtnModificar().setEnabled(modificar);
		formPartida.getBtnEliminar().setEnabled(eliminar);
	}
	
	public void cargarDatos(Partida partidaAux)
	{
		if(partidaAux != null)
		{
			partidaActual = partidaAux;
			formPartida.getTxtCodigo().setText(partidaAux.getCodigoPartida().toString());			
			formPartida.getTxtDescripcion().setText(partidaAux.getDescripcion());
			formPartida.getTxtNombre().setText(String.valueOf(partidaAux.getNombrePartida()));
			formPartida.getcBoxPartidaPadre().setSelectedItem(partidaAux.getPartidaPadre());
			habilitarBotones(true, false, true, true, true);
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(formPartida.getBtnAceptar().equals(event.getSource()))
		{
			if(validarControles())
			{
				try {
					partidaActual = new Partida();
					partidaActual.setCodigoPartida(formPartida.getTxtCodigo().getText().toUpperCase());				
					partidaActual.setDescripcion(formPartida.getTxtDescripcion().getText());
					partidaActual.setNombrePartida(formPartida.getTxtNombre().getText().toUpperCase());
					
					
					if(formPartida.getcBoxPartidaPadre().getSelectedIndex() >= 0)
					{
						partidaActual.setPartidaPadre((Partida) formPartida.getcBoxPartidaPadre().getSelectedItem());
						partidaActual.setCodigoPartidaPadre(partidaActual.getPartidaPadre().getCodigoPartida());
					}
					
					
					
					
					if(tipoOperacion.compareTo("I")==0)
					{
						daoPartidaMapper.insert(partidaActual);
						session.commit();
						formPartida.getcBoxPartidaPadre().addItem(partidaActual);
						
//					DefaultMutableTreeNode nodoSeleccion = new  DefaultMutableTreeNode(partidaActual.getPartidaPadre());
//					formPartida.getjTreePartida().setSelectionPath(new TreePath(nodoSeleccion));
//					nodoSeleccion = (DefaultMutableTreeNode)formPartida.getjTreePartida().getLastSelectedPathComponent();
//					TreeNode[] nodes = modeloPartida.getPathToRoot(nodoSeleccion);
//					TreePath path = new TreePath(nodes);
//					formPartida.getjTreePartida().scrollPathToVisible(path);
//					formPartida.getjTreePartida().setSelectionPath(path);
//					
						
						DefaultTreeModel model = (DefaultTreeModel)formPartida.getjTreePartida().getModel();
						DefaultMutableTreeNode root = (DefaultMutableTreeNode)formPartida.getjTreePartida().getLastSelectedPathComponent();
						root.add(new DefaultMutableTreeNode(partidaActual));
						model.reload(root);
						
						DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(partidaActual);

						
						if(partidaActual.getPartidaPadre() != null)
						{
							TreePath path = formPartida.getjTreePartida().getNextMatch(partidaActual.getPartidaPadre().getNombrePartida(), 0, Position.Bias.Forward);
							
	//						formPartida.getjTreePartida().scrollPathToVisible(path);
	//						formPartida.getjTreePartida().setSelectionPath(path);
	//						DefaultMutableTreeNode nodoSeleccion = (DefaultMutableTreeNode)path.getLastPathComponent();
	//						modeloPartida.insertNodeInto(nNode, nodoSeleccion, nodoSeleccion.getChildCount());
	//						
							path = formPartida.getjTreePartida().getNextMatch(partidaActual.getNombrePartida(), 0, Position.Bias.Forward);
							formPartida.getjTreePartida().scrollPathToVisible(path);
							formPartida.getjTreePartida().setSelectionPath(path);
						}

						
						
						
					}
					else
					{
//					modeloPartida.setPartida(formPartida.getjTablePartida().getSelectedRow(), PartidaActual);
						partidaActual.setCodigoPartida(formPartida.getTxtCodigo().getText());
						
						daoPartidaMapper.updateByPrimaryKey(partidaActual);
						session.commit();
						
						
						DefaultMutableTreeNode node = (DefaultMutableTreeNode)
				                formPartida.getjTreePartida().getLastSelectedPathComponent();
						node.setUserObject(partidaActual);
						
						DefaultTreeModel model = (DefaultTreeModel)formPartida.getjTreePartida().getModel();
						DefaultMutableTreeNode root = (DefaultMutableTreeNode)formPartida.getjTreePartida().getLastSelectedPathComponent();
						model.reload(root);
						
					}
					
					if(!formPartida.getBtnNuevo().isVisible())
					{
						
						formPartida.setVisible(false);
						formPartida.dispose();
						return;
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
//					JOptionPane.showMessageDialog(formPartida, "Ocurri\u00F3 la siguiente excepcion " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				tipoOperacion ="";
				habilitarBotones(true, false, false, true, true);
				habilitarControles(false);
				JOptionPane.showMessageDialog(formPartida, "Se registr\u00F3 correctamente el registro actual", "Partidas Presupuestarias", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
//		if(formPartida.getBtnNuevo().equals(event.getSource()))
		if(event.getActionCommand().compareTo("Nuevo") == 0)	
		{
			
			
			//seleccionamos el elemento que ha sido seleccionado
			if(formPartida.getjTreePartida().getSelectionPath() != null)
			{
				DefaultMutableTreeNode selectedElement 
				   =(DefaultMutableTreeNode)formPartida.getjTreePartida().getSelectionPath().getLastPathComponent();
				if(selectedElement != null)
				{
					habilitarBotones(false, true, true, false, false);
					habilitarControles(true);
					limpiarControles();
					tipoOperacion = "I";
					
					
					formPartida.getcBoxPartidaPadre().setSelectedItem(selectedElement.getUserObject());
					formPartida.getTxtCodigo().grabFocus();
				}
				else{
					JOptionPane.showMessageDialog(formPartida, "A\u00FAn no ha seleccionado la categoria", "Crear nueva partida", JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				JOptionPane.showMessageDialog(formPartida, "A\u00FAn no ha seleccionado la categoria", "Crear nueva partida", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(formPartida.getBtnCerrar().equals(event.getSource()))
		{
			formPartida.setVisible(false);
			formPartida.dispose();
			
		}
		if(event.getActionCommand().compareTo("Modificar") == 0)
		{
			habilitarBotones(false, true, true, false, false);
			habilitarControles(true);			
			tipoOperacion = "E";
			
		}
		if(event.getActionCommand().compareTo("Eliminar") == 0)
		{
			if(JOptionPane.showConfirmDialog(formPartida, "¿Se encuentra seguro de eliminar el registro actual?", "Partidas", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			{
				System.out.println("Elemento a eliminar " + formPartida.getTxtCodigo().getText());
				
//				modeloPartida.eliminarPartida(formPartida.getjTablePartida().getSelectedRow());
				
				
				daoPartidaMapper.deleteByPrimaryKey(formPartida.getTxtCodigo().getText());
				
				session.commit();
				
				deleteSelectedItems();
				
				limpiarControles();
				JOptionPane.showMessageDialog(formPartida, "Objeto eliminado correctamente", "Partida", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(formPartida.getBtnCancelar().equals(event.getSource()))
		{
			limpiarControles();
			habilitarControles(false);
			habilitarBotones(true, false, false, false, false);
			tipoOperacion = "";
		}
	}

//	@Override
//	public void valueChanged(ListSelectionEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getValueIsAdjusting())
//			return;
//		int indice = ((ListSelectionModel) e.getSource()).getMinSelectionIndex();
////		System.out.println("indice = " + indice);
//		cargarDatos(modeloPartida.obtenerPartida(indice));
//		
//	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                formPartida.getjTreePartida().getLastSelectedPathComponent();

		/* if nothing is selected */ 
		if (node == null) { partidaActual = null; return;}
		
		if(node.getUserObject()!= null && node.getUserObject() instanceof Partida)
		{
			/* retrieve the node that was selected */ 
			Partida partidaSeleccionada = (Partida) node.getUserObject();			
			
//			Object partidaSeleccionada =  node.getUserObject();
//			System.out.println(partidaSeleccionada);
			/* React to the node selection. */
			cargarDatos(partidaSeleccionada);
		}
		else
			limpiarControles();
			
		
	}
	
	 @Override
    public void mouseClicked(MouseEvent e) {

        if (SwingUtilities.isRightMouseButton(e) && (formPartida.getjTreePartida().getSelectionCount() > 0)) {

            int row = formPartida.getjTreePartida().getClosestRowForLocation(e.getX(), e.getY());
            formPartida.getjTreePartida().setSelectionRow(row);
            formPartida.getPopupMenu().show(e.getComponent(), e.getX(), e.getY());
        }
    }
	 
	 protected void deleteSelectedItems() {
		 DefaultMutableTreeNode node;
		 DefaultTreeModel model = (DefaultTreeModel) (formPartida.getjTreePartida().getModel());
		 TreePath[] paths = formPartida.getjTreePartida().getSelectionPaths();
		 for (int i = 0; i < paths.length; i++) {
			 node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
			 model.removeNodeFromParent(node);
		 }
	 }

}

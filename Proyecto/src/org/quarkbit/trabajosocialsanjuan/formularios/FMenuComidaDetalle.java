package org.quarkbit.trabajosocialsanjuan.formularios;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.ibatis.session.SqlSession;
import org.quarkbit.trabajosocialsanjuan.dao.Coneccion;
import org.quarkbit.trabajosocialsanjuan.dao.domain.CategoriaComida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Comida;
import org.quarkbit.trabajosocialsanjuan.dao.domain.MenuComidaDetalle;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.CategoriaComidaMapper;
import org.quarkbit.trabajosocialsanjuan.dao.persistence.ComidaMapper;
import org.quarkbit.trabajosocialsanjuan.utils.FormUtilities;

import com.toedter.calendar.JDateChooser;

public class FMenuComidaDetalle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlBotones;
	private JPanel pnlDatos;
	private JTextField txtCantidad;
	private JTextField txtPrecioUnitario;
	private JComboBox<Comida> cBoxComida;
	private JComboBox<CategoriaComida> cBoxCategoria;
	private JDateChooser dateFechaMenu;
	private JSpinner timeHoraInicio;
	private JSpinner timeHoraFin;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblFechaDiaHora;

	private SqlSession session;
	private ComidaMapper daoComida;
	private CategoriaComidaMapper daoCategoriaComida;
	public MenuComidaDetalle menuDetalle ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FMenuComidaDetalle frame = new FMenuComidaDetalle(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FMenuComidaDetalle(JFrame owner) {
		super(owner, true);
		setTitle("Men\u00FA de Comidas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 357, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnlBotones = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlBotones.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		contentPane.add(pnlBotones, BorderLayout.SOUTH);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Aceptar01.png")));
		pnlBotones.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FComidas.class.getResource("/imagenes/BOTONES/Cancelar01.png")));
		pnlBotones.add(btnCancelar);
		
		pnlDatos = new JPanel();
		pnlDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		FlowLayout flowLayout = (FlowLayout) pnlDatos.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		contentPane.add(pnlDatos, BorderLayout.CENTER);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblCategoria);
		
		cBoxCategoria = new JComboBox<CategoriaComida>();
		cBoxCategoria.setEnabled(false);
		cBoxCategoria.setPreferredSize(new Dimension(150, 25));
		pnlDatos.add(cBoxCategoria);
		
		cBoxCategoria.setSelectedIndex(-1);
		
		JLabel lblComida = new JLabel("Comida");
		lblComida.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblComida);
		
		cBoxComida = new JComboBox<Comida>();
		cBoxComida.setPreferredSize(new Dimension(150, 25));
		pnlDatos.add(cBoxComida);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblFecha);
		
		dateFechaMenu = new JDateChooser();
		dateFechaMenu.setPreferredSize(new Dimension(150, 25));
		dateFechaMenu.setDateFormatString("dd-MM-yyyy");
		dateFechaMenu.setMinimumSize(new Dimension(190, 20));
		pnlDatos.add(dateFechaMenu);
		
		JLabel lblHora = new JLabel("Hora Inicio");
		lblHora.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblHora);
		
		
		timeHoraInicio = new JSpinner( new SpinnerDateModel() );
		timeHoraInicio.setEnabled(false);
		timeHoraInicio.setPreferredSize(new Dimension(145, 30));
		JSpinner.DateEditor de_timeHoraInicio = new JSpinner.DateEditor(timeHoraInicio, "HH:mm:ss");
		de_timeHoraInicio.setPreferredSize(new Dimension(120, 19));
		timeHoraInicio.setEditor(de_timeHoraInicio);
		pnlDatos.add(timeHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora Fin");
		lblHoraFin.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblHoraFin);
		
		timeHoraFin = new JSpinner( new SpinnerDateModel() );
		timeHoraFin.setEnabled(false);
		timeHoraFin.setPreferredSize(new Dimension(145, 30));
		JSpinner.DateEditor de_timeHoraFin = new JSpinner.DateEditor(timeHoraFin, "HH:mm:ss");
		de_timeHoraFin.setPreferredSize(new Dimension(120, 19));
		timeHoraFin.setEditor(de_timeHoraFin);
		pnlDatos.add(timeHoraFin);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblCantidad);
		
		txtCantidad = new JTextField();		
		txtCantidad.setPreferredSize(new Dimension(6, 25));
		pnlDatos.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblPrecioUnit = new JLabel("Precio Unit.");
		lblPrecioUnit.setPreferredSize(new Dimension(95, 14));
		pnlDatos.add(lblPrecioUnit);
		
		txtPrecioUnitario = new JTextField();		
		txtPrecioUnitario.setPreferredSize(new Dimension(6, 25));
		txtPrecioUnitario.setColumns(10);
		pnlDatos.add(txtPrecioUnitario);
		
		lblFechaDiaHora = new JLabel("New label");
		contentPane.add(lblFechaDiaHora, BorderLayout.NORTH);
		
		
		
		session = Coneccion.getSqlSessionFactory().openSession();
		daoCategoriaComida = session.getMapper(CategoriaComidaMapper.class);
		daoComida = session.getMapper(ComidaMapper.class);
		
		
		for (Comida comida : daoComida.selectByExample(null)) {
			cBoxComida.addItem(comida);
		}
		for (CategoriaComida catComida : daoCategoriaComida.selectByExample(null)) {
			cBoxCategoria.addItem(catComida);
		}
		cBoxComida.setSelectedIndex(-1);
		
		
		ChangeListener spinListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				System.out.println("Value " + (Date) timeHoraInicio.getValue());
				if(!lblFechaDiaHora.getText().isEmpty())
				{
					Calendar cal2, cal3, cal1 = Calendar.getInstance();
					cal2 =  Calendar.getInstance();
					cal3 =  Calendar.getInstance();
					if(dateFechaMenu.getDate() != null)
					{
					cal1.setTime(dateFechaMenu.getDate());
					cal2.setTime((Date) timeHoraInicio.getValue());
					cal3.setTime((Date) timeHoraFin.getValue());
					lblFechaDiaHora.setText("Dia : " + FormUtilities.obtenerNombreDia( cal1.get(Calendar.DAY_OF_WEEK))
							+ " de " +  FormUtilities.obtenerHora((Date) timeHoraInicio.getValue())  + " a " + FormUtilities.obtenerHora((Date) timeHoraFin.getValue()) );
					}
				}

	        }

	    };
		
	    
	    final PropertyChangeListener pcl = new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent evt) {
	        	
	        	if (evt.equals(dateFechaMenu) && "date".equals(evt.getPropertyName())) {		            
		            Date date = dateFechaMenu.getDate(); // your date
		            if(date != null)
		            {
			            Calendar cal = Calendar.getInstance();
			            cal.setTime(date);			            
			            int day = cal.get(Calendar.DAY_OF_WEEK);
			            
			            lblFechaDiaHora.setText("Dia : " + FormUtilities.obtenerNombreDia(day));
			            
			            
		            }
		        }
	        }


	    };
	    dateFechaMenu.addPropertyChangeListener(pcl);
	    
	    timeHoraInicio.addChangeListener(spinListener);
	    timeHoraFin.addChangeListener(spinListener);
	    
	    
	    
	    txtCantidad.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				FormUtilities.keyTyped(e, "entero", getOwner());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    txtPrecioUnitario.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				FormUtilities.keyTyped(e, "decimal", getOwner());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    
	    btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(validarComponentes())
				{
					obtenerMenuDetalle();
					setVisible(false);
				}

			}
		});
	    
	    btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuDetalle = null;
				setVisible(false);
			}
		});
	}
	
	
	
	public MenuComidaDetalle obtenerMenuDetalle()
	{
		menuDetalle = new MenuComidaDetalle();
		menuDetalle.setCantidadPersonas(Integer.parseInt(txtCantidad.getText()));
		menuDetalle.setPrecioUnitario(Double.parseDouble(txtPrecioUnitario.getText()));
		menuDetalle.setFecha(dateFechaMenu.getDate());
		menuDetalle.setHoraFin((Date) timeHoraFin.getValue());
		menuDetalle.setHoraInicio((Date) timeHoraInicio.getValue());
		
		menuDetalle.setCategoriaComida( (CategoriaComida) cBoxCategoria.getSelectedItem());
		menuDetalle.setComida( (Comida) cBoxComida.getSelectedItem());
		menuDetalle.setCodigoCategoria(menuDetalle.getCategoriaComida().getCodigoCategoria());
		menuDetalle.setCodigoComida(menuDetalle.getComida().getCodigoComida());
		
		return menuDetalle;
	}
	
	public void limpiarComponentes()
	{
		cBoxCategoria.setSelectedIndex(-1);
		cBoxComida.setSelectedIndex(-1);
		dateFechaMenu.setDate(null);
		timeHoraInicio.setValue(null);
		timeHoraFin.setValue(null);
		txtCantidad.setText("");
		txtPrecioUnitario.setText("");
	}
	
	public void habilitarComponentes(boolean estadoHabilitacion)
	{
		cBoxCategoria.setEnabled(estadoHabilitacion);
		cBoxComida.setEnabled(estadoHabilitacion);
		dateFechaMenu.setEnabled(estadoHabilitacion);
		timeHoraInicio.setEnabled(estadoHabilitacion);
		timeHoraFin.setEnabled(estadoHabilitacion);
		txtCantidad.setEnabled(estadoHabilitacion);
		txtPrecioUnitario.setEnabled(estadoHabilitacion);
	}
	
	public boolean validarComponentes()
	{
		if(cBoxCategoria.getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(this, "Aun no ha seleccionado la Categoria", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			cBoxCategoria.grabFocus();
			return false;
		}
		if(cBoxComida.getSelectedIndex() < 0)
		{
			JOptionPane.showMessageDialog(this, "Aun no ha seleccionado el tipo de Comida", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			cBoxComida.grabFocus();
			return false;
		}
		
		if(dateFechaMenu.getDate() == null)
		{
			JOptionPane.showMessageDialog(this, "Aun no ha seleccionado la Fecha", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			dateFechaMenu.grabFocus();
			return false;
		}
		
		if(timeHoraInicio.getValue() == null)
		{
			JOptionPane.showMessageDialog(this, "Aun no ha ingresado la Hora de Inicio", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			timeHoraInicio.grabFocus();
			return false;
		}
		
		if(timeHoraFin.getValue() == null)
		{
			JOptionPane.showMessageDialog(this, "Aun no ha ingresado la Hora Fin", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			timeHoraFin.grabFocus();
			return false;
		}
		
		if( (((Date)timeHoraInicio.getValue()).after(((Date)timeHoraFin.getValue()) )))  
		{
			JOptionPane.showMessageDialog(this, "La hora de culminacion debe ser mayor a la inicial", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			timeHoraFin.grabFocus();
			return false;
		}
		
		if(txtCantidad.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Aun no ha ingresado la cantidad", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			txtCantidad.grabFocus();
			return false;
		}
		if(txtPrecioUnitario.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Aun no ha ingresado el precio unitario", "Configuracion Comidas-Menu", JOptionPane.ERROR_MESSAGE);
			txtPrecioUnitario.grabFocus();
			return false;
		}
		
		return true;
	}
	
	public void cargarDatos(MenuComidaDetalle menuDetalle)
	{
		if(menuDetalle != null)
		{
			if(menuDetalle.getCategoriaComida() != null)
			{
				cBoxCategoria.setSelectedItem(menuDetalle.getCategoriaComida());
				timeHoraInicio.setValue(menuDetalle.getCategoriaComida().getHoraInicio());
				timeHoraFin.setValue(menuDetalle.getCategoriaComida().getHoraFin());
			}
			else
			{
				cBoxCategoria.setSelectedIndex(-1);
				timeHoraInicio.setValue(null);
				timeHoraFin.setValue(null);
			}
			if(menuDetalle.getComida()!= null)
			{
				txtPrecioUnitario.setText(String.valueOf(menuDetalle.getComida().getPrecioEstimado()));
			}
			else
			{
				txtPrecioUnitario.setText("");
			}
			if(menuDetalle.getFecha() != null)
			{
				dateFechaMenu.setDate(menuDetalle.getFecha());
			}
			else
			{
				dateFechaMenu.setDate(null);
			}
			
			cBoxComida.setSelectedIndex(-1);
			txtCantidad.setText("");
			
		}
	}

}

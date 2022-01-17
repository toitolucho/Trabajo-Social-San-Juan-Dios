import java.net.URL;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.quarkbit.trabajosocialsanjuan.formularios.FAutenticacion;
import org.quarkbit.trabajosocialsanjuan.utils.ThemesLoader;

import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;



public class TataJuanDiosMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 try {
//	            // Set System L&F
////	        UIManager.setLookAndFeel(
////	            UIManager.getSystemLookAndFeelClassName());
//			 
//			 UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//	    } 
//	    catch (UnsupportedLookAndFeelException e) {
//	       // handle exception
//	    }
//	    catch (ClassNotFoundException e) {
//	       // handle exception
//	    }
//	    catch (InstantiationException e) {
//	       // handle exception
//	    }
//	    catch (IllegalAccessException e) {
//	       // handle exception
//	    }

		 
		 try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception e) {
			    // If Nimbus is not available, you can set the GUI to another look and feel.
			}
		
		
		FAutenticacion formAutenticacion = new FAutenticacion();
		formAutenticacion.setLocationRelativeTo(null);
//		NimRODLookAndFeel nf;
//		NimRODTheme nt;
//		nf = new NimRODLookAndFeel();
//	    nt = new NimRODTheme();
//	    NimRODLookAndFeel.setCurrentTheme(nt);
//	    ThemesLoader tlCargador = new ThemesLoader();	    
//	    try {
//			UIManager.setLookAndFeel( nf);
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    Class sasdedeClass = TataJuanDiosMain.class; 
		URL url = sasdedeClass.getResource("TataJuanDiosMain.class");			
		String rutaLocal = url.getPath().substring(1).replaceAll("TataJuanDiosMain.class", "theme3.theme").trim();		
		if (rutaLocal.contains("%20"))
		{
			rutaLocal = rutaLocal.replace("%20", " ");
		}
		
//		System.out.println(rutaLocal  + ",  Path =" + System.getenv());
//		for (String string : System.getenv().toString().substring(1).split(",")) {
//			System.out.println(string);
//		}
	    
	    
//	    tlCargador.seleccionarTemadeArchivo(formAutenticacion, rutaLocal);
	    JFrame.setDefaultLookAndFeelDecorated( true);
		//FormUtilities.centrar(formAutenticacion);
	    
		formAutenticacion.setVisible(true);	
	}

}

//
//\u00E1 \u00E9 \u00ED \u00F3 \u00FA
//á		é	í	ó	ú
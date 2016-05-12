package co.edu.udea.iw.logicaNegocio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.ExceptionDao;
import co.edu.udea.iw.exception.IWServiceException;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService usuarioService;

	@Test
	public void guardarCliente() {
		try {
			String mensaje=usuarioService.guardarCliente("Jorge", "123", "Jorge Luis","Bojaca Vallejo", "jor@h.com", "32422","CLL 3 # 2-4");
			System.out.println(mensaje);
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
//	@Test
	public void autenticarUsuario(){
		
		try {
			Usuario user=usuarioService.autenticarUsuario("diana", "123");
			System.out.println("Bienvenido "+user.getNombres());
			System.out.println("Rol: "+user.getRol().getNombre());
			
		} catch (ExceptionDao e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} catch (IWServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	

}

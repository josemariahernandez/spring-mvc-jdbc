package ejemplo.springjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private JdbcOperations jdbc;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insertarUsuario(){
		if(jdbc.update("insert into usuario (id, username, password, email, nombre, apellidos, activo) " +
						"values (?, ?, ?, ?, ?, ?, ?)",
						3,
						"pepe",
						"123456",
						"pepe",
						"gotera",
						"pepe@gotera.com",
						0) > 0){
			return "right";
		}
		return "wrong";
					
		
		
	}
}

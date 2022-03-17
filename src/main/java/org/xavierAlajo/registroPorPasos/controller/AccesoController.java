package org.xavierAlajo.registroPorPasos.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xavierAlajo.registroPorPasos.colecciones.Colecciones;
import org.xavierAlajo.registroPorPasos.model.Usuario;

@Controller
@RequestMapping("/acceso")
public class AccesoController {

// -------------------------------- PASO1 --------------------------------------------
	@GetMapping("formulario1")
	public ModelAndView formulario1datosPersonales(HttpServletRequest solicitud) {

		// Se crea una sesion
		HttpSession session = solicitud.getSession();
		
		

		ModelAndView modelAV = new ModelAndView();


		// Añadimos las colecciones
		modelAV.addObject("listaGenerosOrdenada", Colecciones.listaGenerosOrdenada);
		modelAV.addObject("listaNacionalidades", Colecciones.listaNacionalidades);
		modelAV.addObject("listaEstadoCivil", Colecciones.listaEstadoCivil);
		modelAV.addObject("datosNavegacion", Colecciones.datosNavegacion);

		// fragmento
		modelAV.addObject("formulario","formulario1");
		
		// nos muestra la vista del formulario paso1
		modelAV.setViewName("formulario1");

		if (session.getAttribute("usuario1") != null) {
			modelAV.addObject("usuario", session.getAttribute("usuario1"));
		} else {
			modelAV.addObject("usuario", new Usuario());
		}
		return modelAV;

	}

	@PostMapping("paso1")
	public ModelAndView recibirDatosPersonales(HttpServletRequest solicitud, @ModelAttribute Usuario usuario) {

		// Creamos un objeto de la clase sesion
		HttpSession session = solicitud.getSession();
		session.setAttribute("usuario1", usuario);

		if (session.getAttribute("resumenDatos") == null) {
			session.setAttribute("resumenDatos", new Usuario());
		}

		// Se realiza un casteo porque lo que se recibe es un objeto
		Usuario resumenDatos = (Usuario) session.getAttribute("resumenDatos");
		resumenDatos.setUsuarioPaso1(usuario);
		session.setAttribute("resumenDatos", resumenDatos); // actualiza lo datos

		// Creamos un objeto ModelandView
		ModelAndView modelAV = new ModelAndView();

		modelAV.setViewName("redirect:/acceso/formulario2");

		return modelAV;
	}

// -------------------------------- PASO2 --------------------------------------------

	@GetMapping("formulario2")
	public ModelAndView formulario2DatosPRofesionales(HttpServletRequest solicitud) {

		// Se crea una sesion
		HttpSession session = solicitud.getSession();

		ModelAndView modelAV = new ModelAndView();

		// Añadimos las coleccionesnecesarias para repintar el formulario
		modelAV.addObject("listaDepartamentos", Colecciones.listaDepartamentos);
		modelAV.addObject("datosNavegacion", Colecciones.datosNavegacion);
		
		// fragmento
		modelAV.addObject("formulario","formulario2");

		if (session.getAttribute("usuario2") != null) {
			modelAV.addObject("usuario", session.getAttribute("usuario2"));
		} else {
			modelAV.addObject("usuario", new Usuario());
		}

		// nos muestra la vista del formulario paso2
		modelAV.setViewName("formulario2");

		return modelAV;

	}

	@PostMapping("paso2")
	public ModelAndView recibirDatosProfesionales(HttpServletRequest solicitud, @ModelAttribute Usuario usuario) {

		HttpSession session = solicitud.getSession();
		session.setAttribute("usuario2", usuario);

		if (session.getAttribute("resumenDatos") == null) {
			session.setAttribute("resumenDatos", new Usuario());
		}

		Usuario resumenDatos = (Usuario) session.getAttribute("resumenDatos");
		resumenDatos.setUsuarioPaso2(usuario);
		session.setAttribute("resumenDatos", resumenDatos);

		ModelAndView modelAV = new ModelAndView();
		modelAV.setViewName("redirect:/acceso/formulario3");

		return modelAV;
	}

// ------------------------------ PASO 3 ------------------------------------------

	@GetMapping("formulario3")
	public ModelAndView formulario3DatosBancarios(HttpServletRequest solicitud) {

		HttpSession session = solicitud.getSession();
		
		
		ModelAndView modelAV = new ModelAndView();
		
	// Pasamos la lista datos de navegacion 
		modelAV.addObject("datosNavegacion", Colecciones.datosNavegacion);
		
		// fragmento
		modelAV.addObject("formulario","formulario3");
	

		if (session.getAttribute("resumenDatos") == null) {
			session.setAttribute("resumenDatos", new Usuario());
		}

		if (session.getAttribute("usuario3") != null) {
			modelAV.addObject("usuario", session.getAttribute("usuario3"));

		} else {
			modelAV.addObject("usuario", new Usuario());
		}
		modelAV.setViewName("formulario3");

		return modelAV;
	}

	@PostMapping("paso3")
	public ModelAndView recibirDatosBancarios(HttpServletRequest solicitud, @ModelAttribute Usuario usuario) {

		HttpSession session = solicitud.getSession();
		session.setAttribute("usuario3", usuario);

		if (session.getAttribute("resumenDatos") == null) {
			session.setAttribute("resumenDatos", new Usuario());
		}

		Usuario resumenDatos = (Usuario) session.getAttribute("resumenDatos");
		resumenDatos.setUsuarioPaso3(usuario);
		session.setAttribute("resumenDatos", resumenDatos);

		ModelAndView modelAV = new ModelAndView();

		modelAV.setViewName("redirect:/acceso/resumenDatos");
		return modelAV;

	}

// ------------------------------- Ultimo paso Resumen ----------------------------
	@GetMapping("resumenDatos")
	public ModelAndView formularioResumen(HttpServletRequest solicitud) {

		ModelAndView modelAV = new ModelAndView();

		HttpSession session = solicitud.getSession();

	// Si no hay ningun campo introducido redirige a la vista formulario 1 
		if (session.getAttribute("usuario1") == null || session.getAttribute("usuario2") == null
				|| session.getAttribute("usuario3") == null || session.getAttribute("resumenDatos") == null)
			//return new ModelAndView("redirect:/acceso/formulario1");
			
		
	// Se envia las colecciones y todos los datos introducidos para repintar la vista resumenDatos
		modelAV.addObject("listaGeneros", Colecciones.listaGenerosOrdenada);
		modelAV.addObject("listaDepartamentos", Colecciones.listaDepartamentos);
		modelAV.addObject("listaNacionalidades", Colecciones.listaNacionalidades);
		
		// fragmento
		modelAV.addObject("formulario","resumenDatos");
		
	// Se pasa la lista datosNavegacion para que funcione el fragmento	
		modelAV.addObject("datosNavegacion", Colecciones.datosNavegacion);
		
		modelAV.addObject("usuario", session.getAttribute("resumenDatos"));
				
		modelAV.setViewName("resumenDatos");
		return modelAV;
	}
	
	
	@PostMapping("resumen")
		public ModelAndView recibirResumenDatos(HttpServletRequest solicitud) {

	solicitud.getSession().invalidate();
			ModelAndView modelAV = new ModelAndView();

			modelAV.setViewName("redirect:/acceso/formulario1");
			return modelAV;
			
	
	}
}

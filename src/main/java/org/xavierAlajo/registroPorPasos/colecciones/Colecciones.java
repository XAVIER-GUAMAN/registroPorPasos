package org.xavierAlajo.registroPorPasos.colecciones;

import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Colecciones {

	public static SortedMap<String, String> listaGenerosOrdenada= new TreeMap<String, String>();
	public static SortedMap<String, String> listaNacionalidades = new TreeMap<String, String>();
	public static SortedMap<String, String> listaEstadoCivil = new TreeMap<String, String>();
	public static SortedMap<String, String> listaDepartamentos = new TreeMap<String, String>();
	public static LinkedHashMap<String,String> datosNavegacion = new LinkedHashMap<String,String>();
	
	
	static { // se usa static por que es un valor que no se va a modificar

	// Listado Genero
		listaGenerosOrdenada.put("H", "Hombre");
		listaGenerosOrdenada.put("M", "Mujer");
		listaGenerosOrdenada.put("O", "Otro");
		
	// Lista NAcuonalidades
		listaNacionalidades.put("ES", "Española");
		listaNacionalidades.put("FR", "Francesa");
		listaNacionalidades.put("IT", "Italiana");
		listaNacionalidades.put("PT", "Portuguesa");

	// Lista Estado Civil
		listaEstadoCivil.put("C", "Casado");
		listaEstadoCivil.put("PH", "Pareja de hecho");
		listaEstadoCivil.put("H", "Hijos");
		
	// Lista Departamentos 
		listaDepartamentos.put("F", "Finanzas");
		listaDepartamentos.put("M", "Marketing");
		listaDepartamentos.put("RRHH", "Recursos Humanos");
		
	// Datos de navegacion 
		datosNavegacion.put("formulario1", "/img/Number-1-icon.png");
		datosNavegacion.put("formulario2", "/img/Number-2-icon.png");
		datosNavegacion.put("formulario3", "/img/Number-3-icon.png");	
		datosNavegacion.put("resumenDatos","/img/checkered-flag-icon.png");
		
	
	}
}



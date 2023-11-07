/**
 * 
 */
package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Empleado;
import com.example.demo.services.EmpleadoServiceImpl;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl empleadoServiceImpl;

	/**
	 * Deveuelve todos los empleados
	 * 
	 * @return List<Empleado>
	 */
	@GetMapping("/empleados")
	public List<Empleado> allEmpleado() {
		return empleadoServiceImpl.getAllEmpleado();
	}

	/**
	 * Devuelve un empleado en especifico
	 * 
	 * @param dni
	 * @return Empleado
	 */
	@GetMapping("/empleados/{dni}")
	public Empleado showEmpleado(@PathVariable(name = "dni") String dni) {

		Empleado articulo_xid = new Empleado();

		articulo_xid = empleadoServiceImpl.getIdEmpleado(dni);

		return articulo_xid;
	}

	/**
	 * Añade un empleado a la base de datos
	 * 
	 * @param empleado
	 * @return Empleado
	 */
	@PostMapping("/empleados")
	public Empleado newEmpleado(@RequestBody Empleado empleado) {

		return empleadoServiceImpl.addEmpleado(empleado);
		
	}

	/**
	 * Actualiza un empleado
	 * 
	 * @param empleado
	 * @return Empleado
	 */
	@PutMapping("/empleados/{dni}")
	public Empleado editEmpleado(@PathVariable(name = "dni") String dni, @RequestBody Empleado empleado) {

		Empleado empleado_seleccionado = new Empleado();
		Empleado empleado_actualizado = new Empleado();

		empleado_seleccionado = empleadoServiceImpl.getIdEmpleado(dni);

		empleado_seleccionado.setNombre(empleado.getNombre());
		empleado_seleccionado.setApellidos(empleado.getApellidos());
		empleado_seleccionado.setDepartamento(empleado.getDepartamento());

		empleado_actualizado = empleadoServiceImpl.updateEmpleado(empleado_seleccionado);

		return empleado_actualizado;
	}

	/**
	 * Elimina un articulo
	 * 
	 * @param dni
	 */
	@DeleteMapping("/empleados/{dni}")
	public void eleiminarEmpleado(@PathVariable(name = "dni") String dni) {
		empleadoServiceImpl.deleteEmpleado(dni);
	}
}

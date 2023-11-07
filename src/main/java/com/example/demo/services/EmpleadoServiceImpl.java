/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.dto.Empleado;

/**
 * 
 */
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	IEmpleadoDAO daoEmpleado;

	/**
	 * Deveuelve todos los empleados
	 * 
	 * @return List<Empleado>
	 */
	public List<Empleado> getAllEmpleado() {
		return daoEmpleado.findAll();
	}

	/**
	 * Devuelve un empleado en especifico
	 * 
	 * @param dni
	 * @return Empleado
	 */
	public Empleado getIdEmpleado(String dni) {
		return daoEmpleado.findByTrabajo(dni);
	}

	/**
	 * Añade un empleado a la base de datos
	 * 
	 * @param empleado
	 * @return Empleado
	 */
	public Empleado addEmpleado(Empleado empleado) {
		return daoEmpleado.save(empleado);
	}

	/**
	 * Actualiza un empleado
	 * 
	 * @param empleado
	 * @return Empleado
	 */
	public Empleado updateEmpleado(Empleado empleado) {
		return daoEmpleado.save(empleado);
	}

	/**
	 * Elimina un empleado
	 * 
	 * @param dni
	 */
	public void deleteEmpleado(String dni) {
		daoEmpleado.deleteById(dni);
	}
}

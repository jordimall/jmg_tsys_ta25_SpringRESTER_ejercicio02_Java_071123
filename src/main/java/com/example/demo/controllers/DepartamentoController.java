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

import com.example.demo.dto.Departamento;
import com.example.demo.services.DepartamentoServiceImpl;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl departamentoServiceImpl;

	/**
	 * Deveuelve todos los departamentos
	 * 
	 * @return List<Departamento>
	 */
	@GetMapping("/departamentos")
	public List<Departamento> allDepartamentos() {
		return departamentoServiceImpl.getAllDepartamento();
	}

	/**
	 * Devuelve un departamento en especifico
	 * 
	 * @param id
	 * @return Departamento
	 */
	@GetMapping("/departamentos/{id}")
	public Departamento showDepartamento(@PathVariable(name = "id") int id) {

		Departamento departamento_xid = new Departamento();

		departamento_xid = departamentoServiceImpl.getIdDepartamento(id);

		return departamento_xid;
	}

	/**
	 * Añade un departamento a la base de datos
	 * 
	 * @param departamento
	 * @return Departamento
	 */
	@PostMapping("/departamentos")
	public Departamento newDepartamento(@RequestBody Departamento departamento) {

		return departamentoServiceImpl.addDepartamento(departamento);
	}

	/**
	 * Actualiza un departamento
	 * 
	 * @param departamento
	 * @return Departamento
	 */
	@PutMapping("/departamentos/{id}")
	public Departamento editDepartamento(@PathVariable(name = "id") int id, @RequestBody Departamento departamento) {

		Departamento departamento_seleccionado = new Departamento();
		Departamento departamento_actualizado = new Departamento();

		departamento_seleccionado = departamentoServiceImpl.getIdDepartamento(id);

		departamento_seleccionado.setNombre(departamento.getNombre());
		departamento_seleccionado.setPresupuesto(departamento.getPresupuesto());

		departamento_actualizado = departamentoServiceImpl.updateDepartamento(departamento_seleccionado);

		return departamento_actualizado;
	}

	/**
	 * Elimina un fabricante
	 * 
	 * @param id
	 */
	@DeleteMapping("/departamentos/{id}")
	public void eleiminarDepartamento(@PathVariable(name = "id") int id) {
		departamentoServiceImpl.deleteDepartamento(id);
	}

}

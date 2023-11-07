/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDepartamentoDAO;
import com.example.demo.dto.Departamento;

/**
 * 
 */
@Service
public class DepartamentoServiceImpl implements IDepartamentoService{
	
	@Autowired
	IDepartamentoDAO daoDepartamento;
	
	/**
	 * Deveuelve todos los departamentos
	 * 
	 * @return List<Departamento>
	 */
	public List<Departamento> getAllDepartamento(){
		return daoDepartamento.findAll();
	}

	/**
	 * Devuelve un departamento en especifico
	 * 
	 * @param id
	 * @return Departamento
	 */
	public Departamento getIdDepartamento(int id) {
		return daoDepartamento.findById(id).get();
	};

	/**
	 * Añade un departamento a la base de datos
	 * 
	 * @param departamento
	 * @return Departamento
	 */
	public Departamento addDepartamento(Departamento departamento) {
		return daoDepartamento.save(departamento);
	}

	/**
	 * Actualiza un departamento
	 * 
	 * @param departamento
	 * @return Departamento
	 */
	public Departamento updateDepartamento(Departamento departamento) {
		return daoDepartamento.save(departamento);
	};

	/**
	 * Elimina un departamento
	 * 
	 * @param id
	 */
	public void deleteDepartamento(int id) {
		daoDepartamento.deleteById(id);
	}

}

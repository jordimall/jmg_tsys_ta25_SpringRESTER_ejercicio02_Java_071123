/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Departamento;

/**
 * 
 */
public interface IDepartamentoService {

	/**
	 * Deveuelve todos los departamento
	 * 
	 * @return List<Departamento>
	 */
	public List<Departamento> getAllDepartamento();

	/**
	 * Devuelve un departamento en especifico
	 * 
	 * @param id
	 * @return Departamento
	 */
	public Departamento getIdDepartamento(int id);

	/**
	 * Añade un departamento a la base de datos
	 * 
	 * @param departamento
	 * @return Departamento
	 */
	public Departamento addDepartamento(Departamento departamento);

	/**
	 * Actualiza un departamento
	 * 
	 * @param departamento
	 * @return Departamento
	 */
	public Departamento updateDepartamento(Departamento departamento);

	/**
	 * Elimina un departamento
	 * 
	 * @param id
	 */
	public void deleteDepartamento(int id);
}

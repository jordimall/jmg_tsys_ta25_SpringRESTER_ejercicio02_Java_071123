/**
 * 
 */
package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "departamentos")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Codigo")
	private int codigo;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Presupuesto")
	private String presupuesto;

	@OneToMany
	@JoinColumn(name = "DNI")
	private List<Empleado> empleado;

	/**
	 * 
	 */
	public Departamento() {
	}

	/**
	 * @param codigo
	 * @param nombre
	 * @param presupuesto
	 */
	public Departamento(int codigo, String nombre, String presupuesto) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the presupuesto
	 */
	public String getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @return the empleado
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Empleado")
	public List<Empleado> getEmpleado() {
		return empleado;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param presupuesto the presupuesto to set
	 */
	public void setPresupuesto(String presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", presupuesto=" + presupuesto + ", empleado="
				+ empleado + "]";
	}

}

package com.github.silviorss.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PRODUTO")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Produto extends PanacheEntity {

	private String nome;
	
	private BigDecimal valor;
	
	@CreationTimestamp
	private Date dataCriacao;
	
	@UpdateTimestamp
	private Date dataAtualizacao;
}

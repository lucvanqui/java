package com.example.basic.entity;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value={"created_at","updated_at"},allowGetters = true)
public abstract class Audit {

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
}

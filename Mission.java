/**
 * Copyright 2015 - 2020 mitostar project.
 * 
 * Licensed under the Mitostar License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.mitostar.com/licenses/LICENSE-1.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mitos.radien.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mitos.radien.entity.base.BaseEntity;

/**
 * @author Steven
 */
@Entity
@Table(name = "tb_mission")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Mission extends BaseEntity {
	private static final long serialVersionUID = -5617416329621393326L;
	/**
	 * @Column:
	 * @--name: ="columnName";
	 * @--boolean unique() default false;
	 * @--boolean nullable() default true;
	 * @--boolean insertable() default true;
	 * @--boolean updatable() default true;
	 * @--String columnDefinition() default "";
	 * @--String table() default "";
	 * @--int length() default 255;
	 * @--int precision() default 0; // decimal precision
	 * @--int scale() default 0; // decimal scale
	 */
	
	/**
	 * 任务描述
	 */
	@Column(nullable = false)
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 创建日期
	 */
	@Column(nullable = false)
	private LocalDateTime datecreated;
	public LocalDateTime getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(LocalDateTime datecreated) {
		this.datecreated = datecreated;
	}
	
	
	/**
	 * 任务状态
	 */
	@Column(nullable = false)
	private String status = "undefined";
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 任务与创建者多对一双向关联
	 */
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinTable(name = "tb_user_mission",
			   joinColumns = { @JoinColumn(name = "mission_id") },
			   inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private User founder;
	public User getFounder() {
		return founder;
	}
	public void setFounder(User founder) {
		this.founder = founder;
	}
	// get founder id
	public long getFounderid() {
		return founder.getId();
	}
	
	
	/**
	 * 任务和打点一对多双向关联
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "rssi", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Rssi.class)
	private Set<Rssi> rssi = new HashSet<>();
	public Set<Rssi> getRssis() {
		return rssi;
	}
	public void setRssis(Set<Rssi> rssi) {
		this.rssi = rssi;
	}
	
	
	@Override
	public String toString() {
		return "Mission [description=" + description + ", datecreated=" + datecreated 
				+ ", status=" + status + ", getId()=" + getId() + ", getAlias()=" + getAlias() + "]";
	}
}

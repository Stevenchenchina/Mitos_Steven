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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mitos.radien.entity.base.BaseEntity;

/**
 * @author Steven
 *
 */

@Entity
@Table(name = "tb_rssi")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Rssi  extends BaseEntity {
	private static final long serialVersionUID = 5983909867625129094L;
	
	@Column(nullable = false)
	private double rssi;
	public double getRssi() {
		return rssi;
	}
	public void setRssi(double rssi) {
		this.rssi = rssi;
	}
	
	@Column(nullable = false)
	private double longitude;
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Column(nullable = false)
	private double latitude;
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	private double altitude;
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	
	private double  accuracy;
	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	private String measurer = "none";	
	public String getMeasurer() {
		return measurer;
	}
	public void setMeasurer(String measurer) {
		this.measurer = measurer;
	}

	private double speed;
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Column(nullable = false)
	private double bearing;
	public double getBearing() {
		return bearing;
	}
	public void setBearing(double bearing) {
		this.bearing = bearing;
	}

	@Column(nullable = false)
	private LocalDateTime timeStamp;
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	/**
	 * 打点记录与任务多对一双向关联
	 */
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinTable(name = "tb_rssi_mission",
			   joinColumns = { @JoinColumn(name = "rssi_id") },
			   inverseJoinColumns = { @JoinColumn(name = "mission_id") })
	private Mission mission;
	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	// get missionid
	public long getMissionid() {
		return mission.getId();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Rssi [ getAlias()=" + getAlias() + ", getId()=" + getId() + "]";
	}
}

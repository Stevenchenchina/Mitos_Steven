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
 * See the License for the specific language governing perrssis and
 * limitations under the License.
 */
package com.mitos.radien.viewobj;

import java.time.LocalDateTime;

import com.mitos.radien.entity.Rssi;
import com.mitos.radien.entity.User;
import com.mitos.radien.viewobj.base.BaseViewObj;

/**
 * @author old cat
 *
 */
public class RssiViewObj extends BaseViewObj<Rssi> {
	private double rssi;
    private double longitude;
    private double latitude;
    private double altitude;
    private double  accuracy;
    private String measurer = "none";	
    private double speed;
    private double bearing;
    private LocalDateTime timeStamp;
	public RssiViewObj() {}

	public RssiViewObj(Rssi rssi) {
		super(rssi);
		this.id = rssi.getId();
		this.alias = rssi.getAlias();
		this.longitude = rssi.getLongitude();
		this.latitude = rssi.getLatitude();
		this.altitude = rssi.getAltitude();
		this.accuracy = rssi.getAccuracy();
		this.measurer = rssi.getMeasurer();
		this.speed = rssi.getSpeed();
		this.bearing = rssi.getBearing();
		this.timeStamp = rssi.getTimeStamp();
	}
	

	
	public double getRssi() {
		return rssi;
	}
	public void setRssi(double rssi) {
		this.rssi = rssi;
	}
	

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	

	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	

	public double getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	
	public String getMeasurer() {
		return measurer;
	}
	public void setMeasurer(String measurer) {
		this.measurer = measurer;
	}


	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getBearing() {
		return bearing;
	}
	public void setBearing(double bearing) {
		this.bearing = bearing;
	}


	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "RssiViewObj [id=" + getId() + ", alias=" + getAlias() + "]";
	}

}

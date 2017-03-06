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
package com.mitos.radien.viewobj;

import java.time.LocalDateTime;

import com.mitos.radien.entity.Mission;
import com.mitos.radien.entity.User;
import com.mitos.radien.viewobj.base.BaseViewObj;

/**
 * @author old cat
 *
 */
public class MissionViewObj extends BaseViewObj<Mission> {

	private String status;
	private String description;
	private LocalDateTime datecreated;
	private User founder;
	
	public MissionViewObj() {}

	public MissionViewObj(Mission mission) {
		super(mission);
		this.id = mission.getId();
		this.alias = mission.getAlias();
		this.status = mission.getStatus();
		this.description = mission.getDescription();
		this.datecreated = mission.getDatecreated();
		this.founder = mission.getFounder();
	}
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDateTime getDatecreated() {
		return datecreated;
	}

	public void setDatecreated(LocalDateTime datecreated) {
		this.datecreated = datecreated;
	}
	
	@Override
	public String toString() {
		return "MissionViewObj [description=" + description + ", datecreated=" + datecreated 
				+ ", status=" + status + ", getId()=" + getId() + ", getAlias()=" + getAlias() + "]";
	}

}

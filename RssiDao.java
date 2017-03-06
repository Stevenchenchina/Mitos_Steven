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
package com.mitos.radien.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mitos.radien.entity.Rssi;
import com.mitos.radien.repository.base.BaseDao;

/**
 * @author Steven
 *
 */
public interface RssiDao extends BaseDao<Rssi, Long> {
	/*
	@Query(value = "SELECT * FROM tb_rssi WHERE mission_id = ?1)", nativeQuery = true)
	
    public List<Rssi> loadByMissionId(String missionid);
    */
}

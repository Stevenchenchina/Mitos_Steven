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
package com.mitos.radien.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mitos.radien.entity.Organization;
import com.mitos.radien.entity.Mission;
import com.mitos.radien.entity.User;
import com.mitos.radien.repository.MissionDao;
import com.mitos.radien.repository.base.BaseDao;
import com.mitos.radien.security.authority.AuthorityManager;
import com.mitos.radien.service.base.BaseService;
import com.mitos.radien.service.exception.EntityAlreadyExistException;
import com.mitos.radien.service.exception.EntityNotFoundException;


/**
 * @author Steven
 */
@Component
public class MissionService extends BaseService<Mission, Long> {


    @Autowired 
    private MissionDao missionDao;

    
    @Autowired
    protected AuthorityManager authorityManager;


    @Autowired
    @Qualifier("missionDao")
	protected void setBaseDao(BaseDao<Mission, Long> baseDao) {
        this.baseDao = baseDao;	
	}

    
    /**
     * 创建任务
     * @param mission
     * @param user
     * @return Mission
     */
    @Transactional(value="transactionManager")
    public Mission create(User user, Mission mission) {
    	if (user == null || mission == null)
    		return null;
    	
    	return doCreate(user, mission);
	}
    
	//////////////////////////////////////////////////////////////////////////
	// local methods:
	
	private Mission doCreate(User user, Mission mission) {
		try {
			mission.setFounder(user);
			mission.setStatus("NEW");
			mission.setDatecreated(LocalDateTime.now());

			mission = save(mission);
			return mission;
		}	catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

}

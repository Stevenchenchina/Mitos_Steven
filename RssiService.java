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

import com.mitos.radien.entity.Rssi;
import com.mitos.radien.entity.User;
import com.mitos.radien.repository.RssiDao;
import com.mitos.radien.repository.base.BaseDao;
import com.mitos.radien.service.base.BaseService;
import com.mitos.radien.service.exception.EntityNotFoundException;

/**
 * @author old cat
 */
@Component
public class RssiService extends BaseService<Rssi, Long> {

    @Autowired 
    private RssiDao rssiDao;

    @Autowired
    @Qualifier("rssiDao")
	protected void setBaseDao(BaseDao<Rssi, Long> baseDao) {
        this.baseDao = baseDao;	
	}
    
    public void create(Rssi rssi){
		rssi.setTimeStamp(LocalDateTime.now());
		save(rssi);
	}
    /*
	public Rssi loadLatest(long userId){
		return rssiDao.loadLatest(userId);
	}

    	
    private User getLoginUser() throws EntityNotFoundException{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((User) principal).getUsername();
    	if (username == null || username.isEmpty())
    		throw new EntityNotFoundException(User.class.getSimpleName(), "username", username);
    	
		User cur = userService.loadByUsername(username);
    	if (cur == null)
    		throw new EntityNotFoundException(User.class.getSimpleName(), "username", username);
    	return cur;
    }
    	*/
}

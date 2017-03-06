/**
 * 
 */
package com.mitos.radien.service.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.mitos.radien.entity.Mission;
import com.mitos.radien.entity.User;
import com.mitos.radien.service.MissionService;
import com.mitos.radien.service.exception.EntityAlreadyExistException;
import com.mitos.radien.service.exception.EntityNotFoundException;

/**
 * @author Steven
 *
 */
@Component
public class MissionServiceAuth {
	@Autowired
	private MissionService missionService;

    public Mission create(User user, Mission mission) {
    	return missionService.create(user, mission);
    }

}

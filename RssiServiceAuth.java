/**
 * 
 */
package com.mitos.radien.service.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.mitos.radien.entity.Rssi;
import com.mitos.radien.service.RssiService;
import com.mitos.radien.service.exception.EntityAlreadyExistException;
import com.mitos.radien.service.exception.EntityNotFoundException;

/**
 * @author Steven
 *
 */
@Component
public class RssiServiceAuth {
	@Autowired
	private RssiService rssiService;
	
	public void create(Rssi rssi) {
		rssiService.create(rssi);
	}
	
	/*
	@PreAuthorize("hasRole('ROLE_USER')")
	public Rssi loadLatest(long userId){
		return rssiService.loadLatest(userId);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Rssi> loadLatestInBatch(List<Long> ids){
		List<Rssi> lst = new ArrayList<>();
		for (Long id : ids){
			Rssi obj = rssiService.loadLatest(id.longValue());
			lst.add(obj);
		}
		return lst;
	}	*/
}

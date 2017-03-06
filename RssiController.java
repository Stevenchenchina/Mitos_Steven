/**
 * 
 */
package com.mitos.uss.app.controller.web.pro;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.engine.jdbc.env.spi.IdentifierCaseStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitos.uss.app.controller.base.BaseController;
import com.mitos.nusion.common.logger.Logger;
import com.mitos.radien.entity.Mission;
import com.mitos.radien.entity.Rssi;
import com.mitos.radien.entity.User;
import com.mitos.radien.service.wrapper.RssiServiceAuth;
import com.mitos.radien.viewobj.MissionViewObj;


/**
 * @author Steven
 *
 */
@Controller("RssiProController")
@RequestMapping(value = "/web/pro/rssi")
public class RssiController extends BaseController {

	@Autowired
	RssiServiceAuth rssiServiceAuth;
	
	/**
	 * Update rssi information
	 * @param rssi
	 */
	@ResponseBody
	@RequestMapping(value = "/create", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseEntity<Object> update(@ModelAttribute("rssi") @Valid Rssi rssi){
		Logger.log("/rssi/create.do");
		try {
			rssiServiceAuth.create(rssi);
			return ResponseEntity.ok().body("ok"); 
		}
		catch (Exception e) {
			Logger.ex(e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	/*
	@ResponseBody
	@RequestMapping(value = "/load/latest/batch", method = { RequestMethod.POST, RequestMethod.GET })
	public ResponseEntity<List<Rssi>> loadLatestInBatch(@RequestParam String userIds){
		Logger.log("/rssi/load/latest/batch.do");
		try {
			String array[] = userIds.split(",");
			List<Long> ids = new ArrayList<>();
			for (String idStr :  array){
				ids.add(Long.parseLong(idStr));
			}
			List<Rssi> lst = rssiService.loadLatestInBatch(ids);
			return ResponseEntity.ok().body(lst); 
		}
		catch (Exception e) {
			Logger.ex(e);
			return ResponseEntity.badRequest().body(null);
		}
	}
	*/
}

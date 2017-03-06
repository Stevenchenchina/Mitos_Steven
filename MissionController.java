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
package com.mitos.uss.app.controller.web.pro;

import java.util.Set;

import javax.validation.Valid;

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

import com.mitos.nusion.common.logger.Logger;
import com.mitos.radien.entity.Group;
import com.mitos.radien.entity.Mission;
import com.mitos.radien.entity.User;
import com.mitos.radien.service.exception.LogParamErrorException;
import com.mitos.radien.service.wrapper.MissionServiceAuth;
import com.mitos.radien.viewobj.GroupViewObj;
import com.mitos.radien.viewobj.OrganizationViewObj;
import com.mitos.radien.viewobj.UserViewObj;
import com.mitos.radien.viewobj.MissionViewObj;
import com.mitos.uss.app.controller.base.BaseController;



/**
 * @author Steven
 */

@Controller("MissionProController")
@RequestMapping(value = "/web/pro/mission")
public class MissionController extends BaseController {

	@Autowired
	private MissionServiceAuth missionServiceAuth;

	/**
	 * 创建任务
	 * @param authentication
	 * @return Mission
	 */
	@ResponseBody
	@RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<MissionViewObj> create(@ModelAttribute("mission") @Valid Mission mission,Authentication authentication){
		Logger.log("/web/pro/mission/create.do");
		User userCur = getAuthenticationUser(authentication);
		try {
			Mission m = missionServiceAuth.create(userCur, mission);
			return ResponseEntity.ok().body(new MissionViewObj(m));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}

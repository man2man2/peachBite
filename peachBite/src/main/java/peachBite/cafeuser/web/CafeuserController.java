/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package peachBite.cafeuser.web;

import peachBite.com.DefaultVO;
import peachBite.com.cmmn.EgovUserDetailsHelper;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmodules.validation.commons.DefaultBeanValidator;

import peachBite.cafeuser.service.CafeuserService;
import peachBite.cafeuser.service.CafeuserVO;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class CafeuserController {

	@Resource(name = "cafeuserService")
	private CafeuserService cafeuserService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value="/cafeuser/logout.do", method=RequestMethod.GET)
	public String invalidate(HttpServletRequest request) {
	  request.getSession().invalidate();
	  return "forward:/cafeuser/loginPage.do";
	}
	
	@RequestMapping(value = "/cafeuser/loginPage.do")
	public String loginPage(@ModelAttribute("cafeuserVO") CafeuserVO cafeuserVO, HttpServletRequest request, ModelMap model) throws Exception {
		
		if(request.getSession().getAttribute("CafeuserVO") != null) {
			model.addAttribute("userInfo", request.getSession().getAttribute("cafeuserInfo"));
			return "cafeuser/mainView";
		}
		return "loginView";
	}

	@RequestMapping(value = "/cafeuser/mainView.do")
	public String mainView(@ModelAttribute("cafeuserVO") CafeuserVO 
			cafeuserVO, HttpServletRequest request, ModelMap model) throws Exception {

		// 1. 일반 로그인 처리
		CafeuserVO resultVO = cafeuserService.actionLogin(cafeuserVO);
		
		boolean loginPolicyYn = true;

		if (resultVO != null && resultVO.getCfuserid() != null && !"".equals(resultVO.getCfuserid()) && loginPolicyYn) {

			request.getSession().setAttribute("cafeuserInfo", resultVO);

			model.addAttribute("userInfo", resultVO);
			return "cafeuser/mainView";
		} else {
//			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "forward:/cafeuser/loginPage.do";
		}
	}

}

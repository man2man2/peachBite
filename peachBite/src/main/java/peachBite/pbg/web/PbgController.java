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
package peachBite.pbg.web;

import peachBite.com.DefaultVO;

import org.egovframe.rte.fdl.property.EgovPropertyService;
//import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import peachBite.pbg.service.PbgService;
import peachBite.pbg.service.PbgVO;

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
public class PbgController {

	/** EgovSampleService */
//	@Resource(name = "sampleService")
//	private EgovSampleService sampleService;

	@Resource(name = "pbgService")
	private PbgService pbgService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@GetMapping(value = "/pbgList.do")
	public String pbgList(@ModelAttribute("searchVO") DefaultVO searchVO, ModelMap model) throws Exception {

    	Map<String, Object> resultMap = new HashMap<String, Object>();
		List<PbgVO> resultList= pbgService.getPbgList(searchVO);
		
		resultMap.put("success", true);
		resultMap.put("data", resultList);
		
		model.addAttribute("pbgList", resultList);

		return "jsonView";
	}

	@PostMapping(value = "/addPbg.do")
	public String addPbg(PbgVO createVO, ModelMap model) throws Exception {

		int rsltCnt = pbgService.addPbg(createVO);
		
		model.addAttribute("rsltCnt", rsltCnt);

		return "jsonView";
	}

	@PostMapping(value = "/updPbg.do")
	public String updPbg(PbgVO updateVO, ModelMap model) throws Exception {

		int rsltCnt = pbgService.updPbg(updateVO);
		
		model.addAttribute("rsltCnt", rsltCnt);

		return "jsonView";
	}
	
	@PostMapping(value = "/delPbg.do")
	public String delPbg(PbgVO deleteVO, ModelMap model) throws Exception {

		int rsltCnt = pbgService.delPbg(deleteVO);
		
		model.addAttribute("rsltCnt", rsltCnt);

		return "jsonView";
	}
	
}
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
package peachBite.cafemain.web;


import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springmodules.validation.commons.DefaultBeanValidator;

import peachBite.cafemain.service.CafemainService;
import peachBite.cafemain.service.CafemainVO;
import peachBite.cafeuser.service.CafeuserService;
import peachBite.cafeuser.service.CafeuserVO;
import peachBite.com.DefaultVO;
import peachBite.com.cmmn.EgovUserDetailsHelper;
import peachBite.pbg.service.PbgService;
import peachBite.pbg.service.PbgVO;
import peachBite.pbw.service.PbwService;
import peachBite.pbw.service.PbwVO;

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
public class CafemainController {

	@Resource(name = "cafemainService")
	private CafemainService cafemainService;

	@Resource(name = "cafeuserService")
	private CafeuserService cafeuserService;

	@Resource(name = "pbgService")
	private PbgService pbgService;

	@Resource(name = "pbwService")
	private PbwService pbwService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** Validator */
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;

	@RequestMapping(value="/cafemain/logout.do", method=RequestMethod.GET)
	public String invalidate(HttpServletRequest request) {
	  request.getSession().invalidate();
	  return "forward:/cafemain/loginPage.do";
	}
	
	@RequestMapping(value = "/cafemain/loginPage.do")
	public String loginPage(@ModelAttribute("cafemainVO") CafemainVO cafemainVO, HttpServletRequest request, ModelMap model) throws Exception {

		if(request.getSession().getAttribute("cafemainInfo") != null) {
			model.addAttribute("cafemainInfo", request.getSession().getAttribute("cafemainInfo"));
			return "cafemain/cafemainMainView";
		} else {
			model.addAttribute("message", request.getAttribute("message"));
		}

		return "cafemainLogin";
	}
	@RequestMapping(value = "/cafemain/main.do")
	public String mainView(@ModelAttribute("cafemainVO") CafemainVO 
			cafemainVO , HttpServletRequest request, ModelMap model) throws Exception {
	
		// 1. 일반 로그인 처리
		CafemainVO resultVO = cafemainService.actionLoginCafemain(cafemainVO);
		boolean loginPolicyYn = true;
	
		if (resultVO != null && resultVO.getCafeid() != null && !"".equals(resultVO.getCafeid()) && loginPolicyYn) {
			request.getSession().setAttribute("cafemainInfo", resultVO);
			model.addAttribute("cafemainInfo", resultVO);
			return "cafemain/cafemainMainView";
		} else {
			model.addAttribute("message", "로그인에 실패하였습니다");
			return "forward:/cafemain/loginPage.do";
		}
	}

	@RequestMapping(value = "/cafemain/manageWatch.do")
	public String manageWatch(@ModelAttribute("searchVO") DefaultVO searchVO , HttpServletRequest request, ModelMap model) throws Exception {

		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}
		
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		List<?> rsltList = pbwService.getPbwList(searchVO);
		model.addAttribute("resultList", rsltList);

		int totCnt = pbwService.getPbwListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
			
		return "cafemain/manageWatch";
	}

	@RequestMapping(value = "/cafemain/manageGateway.do")
	public String manageGateway(@ModelAttribute("searchVO") DefaultVO searchVO , HttpServletRequest request, ModelMap model) throws Exception {
		
		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}
		
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		List<?> rsltList = pbgService.getPbgList(searchVO);
		model.addAttribute("resultList", rsltList);

		int totCnt = pbgService.getPbgListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

//		
		return "cafemain/manageGateway";
	}

	@RequestMapping(value = "/cafemain/manageUser.do")
	public String manageUser(@ModelAttribute("searchVO") DefaultVO searchVO , HttpServletRequest request, ModelMap model) throws Exception {

		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}

		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		List<?> cafeuserList = cafeuserService.getCafeuserList(searchVO);
		model.addAttribute("resultList", cafeuserList);

		int totCnt = cafeuserService.getCafeuserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "cafemain/manageUser";
	}

	@RequestMapping(value = "/cafemain/cafeuserList.do")
	public String selectCafeuserList(@ModelAttribute("searchVO") DefaultVO searchVO, ModelMap model) throws Exception {

		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}

		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	//	List<?> sampleList = sampleService.selectSampleList(searchVO);
		List<?> cafeuserList = cafeuserService.getCafeuserList(searchVO);
		model.addAttribute("resultList", cafeuserList);

		int totCnt = cafeuserService.getCafeuserListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

//		return "cafeuser/mainView";
//		return "sample/egovSampleList";
		return "jsonView";
	}

	@PostMapping(value = "/cafemain/updCafeuser.do")
	public String updCafeuser(@ModelAttribute("cafeuserVO") CafeuserVO cafeuserVO, ModelMap model) throws Exception {
		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}
		
		int rsltCnt = 0;
		
		if("Y".equals(cafeuserVO.getNewYn())) {
			cafeuserService.addCafeuser(cafeuserVO);
		} else {			
			cafeuserService.updCafeuser(cafeuserVO);
		}
		model.addAttribute("rsltCnt", rsltCnt);
		return "jsonView";
	}

	@PostMapping(value = "/cafemain/updGateway.do")
	public String updGateway(@ModelAttribute("pbgVO") PbgVO pbgVO, ModelMap model) throws Exception {
		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}
		
		int rsltCnt = 0;
		if("Y".equals(pbgVO.getNewYn())) {
			pbgService.addPbg(pbgVO);
		} else {			
			pbgService.updPbg(pbgVO);
		}
		model.addAttribute("rsltCnt", rsltCnt);

		return "jsonView";
	}

	@PostMapping(value = "/cafemain/updWatch.do")
	public String updWatch(@ModelAttribute("pbwVO") PbwVO pbwVO, ModelMap model) throws Exception {
		Boolean isAuthenticated = EgovUserDetailsHelper.isMainAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", "접속이 종료되었습니다.");
			return "forward:/cafemain/loginPage.do";
		}

		int rsltCnt = 0;
		
		if("Y".equals(pbwVO.getNewYn())) {
			pbwService.addPbw(pbwVO);
		} else {			
			pbwService.updPbw(pbwVO);
		}
		model.addAttribute("rsltCnt", rsltCnt);
		return "jsonView";
	}

}

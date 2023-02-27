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
package peachBite.cafeuser.service.impl;

import peachBite.cafeuser.service.CafeuserService;
import peachBite.cafeuser.service.CafeuserVO;
import peachBite.com.DefaultVO;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
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

@Service("cafeuserService")
public class CafeuserServiceImpl extends EgovAbstractServiceImpl implements CafeuserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CafeuserServiceImpl.class);

	@Resource(name="cafeuserManageMapper")
	private CafeuserManageMapper cafeuserManageMapper;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public CafeuserVO actionLogin(CafeuserVO cafeuserVO) throws Exception {
		return cafeuserManageMapper.selectCafeuser(cafeuserVO);
	}

	@Override
	public CafeuserVO getCafeuser(CafeuserVO cafeuserVO) throws Exception {
		return cafeuserManageMapper.selectCafeuser(cafeuserVO);
	}

	@Override
	public int addCafeuser(CafeuserVO cafeuserVO) throws Exception {
		return  cafeuserManageMapper.insertCafeuser(cafeuserVO);
	}

	@Override
	public int updCafeuser(CafeuserVO cafeuserVO) throws Exception {
		return  cafeuserManageMapper.updateCafeuser(cafeuserVO);
	}

	@Override
	public int delCafeuser(CafeuserVO cafeuserVO) throws Exception {
		return  cafeuserManageMapper.deleteCafeuser(cafeuserVO);
	}

		@Override
	public List<CafeuserVO> getCafeuserList(DefaultVO searchVO) throws Exception {
		return cafeuserManageMapper.selectCafeuserList(searchVO);
	}

	@Override
	public int getCafeuserListTotCnt(DefaultVO searchVO) throws Exception {
		return cafeuserManageMapper.selectCafeuserTotCnt(searchVO);
	}
}
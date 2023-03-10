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
package peachBite.pbw.service.impl;

import peachBite.com.DefaultVO;
import peachBite.pbw.service.PbwService;
import peachBite.pbw.service.PbwVO;

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

@Service("pbwService")
public class PbwServiceImpl extends EgovAbstractServiceImpl implements PbwService{ 

	private static final Logger LOGGER = LoggerFactory.getLogger(PbwServiceImpl.class);

	@Resource(name="pbwManageMapper")
	private PbwManageMapper pbwManageMapper;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	@Override
	public List<PbwVO> getPbwList(DefaultVO searchVO) throws Exception{
		
		return pbwManageMapper.selectPbwList(searchVO);
	}

	@Override
	public int getPbwListTotCnt(DefaultVO searchVO) throws Exception {
		return pbwManageMapper.selectTotCnt(searchVO);
	}
	
	@Override
	public int addPbw(PbwVO pbwVO) throws Exception {
		return pbwManageMapper.insertPbw(pbwVO);
	}

	@Override
	public int updPbw(PbwVO pbwVO) throws Exception {
		return pbwManageMapper.updatePbw(pbwVO);
	}

	@Override
	public int delPbw(PbwVO pbwVO) throws Exception {
		return pbwManageMapper.deletePbw(pbwVO);
		
	}


}

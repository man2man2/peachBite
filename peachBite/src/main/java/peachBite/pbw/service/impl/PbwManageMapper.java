/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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

import java.util.List;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import peachBite.com.DefaultVO;
import peachBite.pbw.service.PbwVO;

/**
 * sample에 관한 데이터처리 매퍼 클래스
 *
 * @author  표준프레임워크센터
 * @since 2014.01.24
 * @version 1.0
 * @see <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 * </pre>
 */
@Mapper("pbwManageMapper")
public interface PbwManageMapper {
	public PbwVO selectPbw(PbwVO vo) throws Exception;
	public List<PbwVO> selectPbwList(DefaultVO vo) throws Exception;
	public int selectTotCnt(DefaultVO searchVO) throws Exception;
	public int insertPbw(PbwVO pbwVO) throws Exception;
	public int updatePbw(PbwVO pbwVO) throws Exception;
	public int deletePbw(PbwVO pbwVO) throws Exception;
}

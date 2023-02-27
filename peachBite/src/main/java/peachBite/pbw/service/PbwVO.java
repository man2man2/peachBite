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
package peachBite.pbw.service;

import peachBite.com.DefaultVO;

/**
 * @Class Name : PbwVo.java
 * @Description : PbwVO.Class
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
public class PbwVO extends DefaultVO {

	private static final long serialVersionUID = 1L;

	private int pbwid;
	private String version;
	private String macaddr;
	private int useflag;
	private int regflag;
	private String createat;
	private int pbgid;
	private String newYn;

	public String getNewYn() {
		return newYn;
	}
	public void setNewYn(String newYn) {
		this.newYn = newYn;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMacaddr() {
		return macaddr;
	}
	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}
	public int getUseflag() {
		return useflag;
	}
	public void setUseflag(int useflag) {
		this.useflag = useflag;
	}
	public int getRegflag() {
		return regflag;
	}
	public void setRegflag(int regflag) {
		this.regflag = regflag;
	}
	public String getCreateat() {
		return createat;
	}
	public void setCreateat(String createat) {
		this.createat = createat;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getPbwid() {
		return pbwid;
	}
	public void setPbwid(int pbwid) {
		this.pbwid = pbwid;
	}
	public int getPbgid() {
		return pbgid;
	}
	public void setPbgid(int pbgid) {
		this.pbgid = pbgid;
	}
}
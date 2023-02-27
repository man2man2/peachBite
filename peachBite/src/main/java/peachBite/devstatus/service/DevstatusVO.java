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
package peachBite.devstatus.service;

import peachBite.com.DefaultVO;

/**
 * @Class Name : DevstatusVO.java
 * @Description : DevstatusVO Class
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
public class DevstatusVO extends DefaultVO {

	private static final long serialVersionUID = 1L;

	private String cafeid;
	private String macaddr;
	private String pbgid;
	private String pbwid;
	private String useflag;
	private String userid;
	
	public String getCafeid() {
		return cafeid;
	}
	public void setCafeid(String cafeid) {
		this.cafeid = cafeid;
	}
	public String getMacaddr() {
		return macaddr;
	}
	public void setMacaddr(String macaddr) {
		this.macaddr = macaddr;
	}
	public String getPbgid() {
		return pbgid;
	}
	public void setPbgid(String pbgid) {
		this.pbgid = pbgid;
	}
	public String getPbwid() {
		return pbwid;
	}
	public void setPbwid(String pbwid) {
		this.pbwid = pbwid;
	}
	public String getUseflag() {
		return useflag;
	}
	public void setUseflag(String useflag) {
		this.useflag = useflag;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

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
package peachBite.pbgact.service;

import peachBite.com.DefaultVO;

/**
 * @Class Name : PbgactVO.java
 * @Description : PbgactVO.Class
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
public class PbgactVO extends DefaultVO {

	private static final long serialVersionUID = 1L;
	private String id ;
	private String pincode;
	private String userid;
	private String typeG;
	private String ver;
	private String gId;
	private String dFrom;
	private String verEx;
	private String dId;
	private int aTemp;
	private int sTemp;
	private int bLevel;
	private int vT;
	private int vX;
	private int vY;
	private int vZ;
	private int lati;
	private int longi;
	private int rssi;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTypeG() {
		return typeG;
	}
	public void setTypeG(String typeG) {
		this.typeG = typeG;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getdFrom() {
		return dFrom;
	}
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}
	public void setdFrom(String dFrom) {
		this.dFrom = dFrom;
	}
	public String getVerEx() {
		return verEx;
	}
	public void setVerEx(String verEx) {
		this.verEx = verEx;
	}
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public int getaTemp() {
		return aTemp;
	}
	public void setaTemp(int aTemp) {
		this.aTemp = aTemp;
	}
	public int getsTemp() {
		return sTemp;
	}
	public void setsTemp(int sTemp) {
		this.sTemp = sTemp;
	}
	public int getbLevel() {
		return bLevel;
	}
	public void setbLevel(int bLevel) {
		this.bLevel = bLevel;
	}
	public int getvT() {
		return vT;
	}
	public void setvT(int vT) {
		this.vT = vT;
	}
	public int getvX() {
		return vX;
	}
	public void setvX(int vX) {
		this.vX = vX;
	}
	public int getvY() {
		return vY;
	}
	public void setvY(int vY) {
		this.vY = vY;
	}
	public int getvZ() {
		return vZ;
	}
	public void setvZ(int vZ) {
		this.vZ = vZ;
	}
	public int getLati() {
		return lati;
	}
	public void setLati(int lati) {
		this.lati = lati;
	}
	public int getLongi() {
		return longi;
	}
	public void setLongi(int longi) {
		this.longi = longi;
	}
	public int getRssi() {
		return rssi;
	}
	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
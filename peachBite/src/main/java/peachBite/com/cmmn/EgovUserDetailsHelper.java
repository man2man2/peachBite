package peachBite.com.cmmn;

import java.util.ArrayList;
import java.util.List;

//import egovframework.com.cmm.CafeuserVO;

import org.egovframe.rte.fdl.string.EgovObjectUtil;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import peachBite.cafemain.service.CafemainVO;
import peachBite.cafeuser.service.CafeuserVO;

/**
 * EgovUserDetails Helper 클래스
 * 
 * @author sjyoon
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2009.03.10  sjyoon    최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */

public class EgovUserDetailsHelper {

	/**
	 * 인증된 사용자객체를 VO형식으로 가져온다.
	 * @return Object - 사용자 ValueObject
	 */
	public static Object getAuthenticatedUser() {
		return (CafeuserVO)RequestContextHolder.getRequestAttributes().getAttribute("CafeuserVO", RequestAttributes.SCOPE_SESSION)==null ? 
				new CafeuserVO() : (CafeuserVO) RequestContextHolder.getRequestAttributes().getAttribute("cafeuserInfo", RequestAttributes.SCOPE_SESSION);

	}

	/**
	 * 인증된 사용자의 권한 정보를 가져온다.
	 * 예) [ROLE_ADMIN, ROLE_USER, ROLE_A, ROLE_B, ROLE_RESTRICTED, IS_AUTHENTICATED_FULLY, IS_AUTHENTICATED_REMEMBERED, IS_AUTHENTICATED_ANONYMOUSLY]
	 * @return List - 사용자 권한정보 목록
	 */
	public static List<String> getAuthorities() {
		List<String> listAuth = new ArrayList<String>();
		
		if (EgovObjectUtil.isNull((CafeuserVO) RequestContextHolder.getRequestAttributes().getAttribute("cafeuserInfo", RequestAttributes.SCOPE_SESSION))) {
			// log.debug("## authentication object is null!!");
			return null;
		}
		
		return listAuth;
	}
	
	/**
	 * 인증된 사용자 여부를 체크한다.
	 * @return Boolean - 인증된 사용자 여부(TRUE / FALSE)	
	 */
	public static Boolean isAuthenticated() {
		
		if (EgovObjectUtil.isNull((CafeuserVO) RequestContextHolder.getRequestAttributes().getAttribute("cafeuserInfo", RequestAttributes.SCOPE_SESSION))) {
//				 log.debug("## authentication object is null!!");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	/**
	 * 인증된 사용자객체를 VO형식으로 가져온다.
	 * @return Object - 사용자 ValueObject
	 */
	public static Object getMainAuthenticated() {
		return (CafemainVO)RequestContextHolder.getRequestAttributes().getAttribute("CafemainVO", RequestAttributes.SCOPE_SESSION)==null ? 
				new CafemainVO() : (CafemainVO) RequestContextHolder.getRequestAttributes().getAttribute("cafemainInfo", RequestAttributes.SCOPE_SESSION);

	}

	/**
	 * 인증된 사용자의 권한 정보를 가져온다.
	 * 예) [ROLE_ADMIN, ROLE_USER, ROLE_A, ROLE_B, ROLE_RESTRICTED, IS_AUTHENTICATED_FULLY, IS_AUTHENTICATED_REMEMBERED, IS_AUTHENTICATED_ANONYMOUSLY]
	 * @return List - 사용자 권한정보 목록
	 */
	public static List<String> getMainAuthorities() {
		List<String> listAuth = new ArrayList<String>();
		
		if (EgovObjectUtil.isNull((CafemainVO) RequestContextHolder.getRequestAttributes().getAttribute("cafemainInfo", RequestAttributes.SCOPE_SESSION))) {
			// log.debug("## authentication object is null!!");
			return null;
		}
		
		return listAuth;
	}
	
	/**
	 * 인증된 사용자 여부를 체크한다.
	 * @return Boolean - 인증된 사용자 여부(TRUE / FALSE)	
	 */
	public static Boolean isMainAuthenticated() {
		
		if (EgovObjectUtil.isNull((CafemainVO) RequestContextHolder.getRequestAttributes().getAttribute("cafemainInfo", RequestAttributes.SCOPE_SESSION))) {
//				 log.debug("## authentication object is null!!");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
}

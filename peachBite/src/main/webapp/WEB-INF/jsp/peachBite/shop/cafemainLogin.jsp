 <%--
  Class Name : index.jsp
  Description : 최초화면으로 메인화면으로 이동한다.(system)
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31  JJY       경량환경 버전 생성
 
    author   : 실행환경 개발팀 JJY
    since    : 2011.08.31
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javaScript">document.location.href="<c:url value='/uat/uia/egovLoginUsr.do'/>"</script>
<!-- 
<jsp:forward page="/egovSampleList.do"/>
 -->
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
	<meta http-equiv="content-language" content="ko">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    
        <!-- Custom fonts for this template-->
    <link href="/assets/dist/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Bootstrap core CSS -->
	<link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>peachBite</title>
    <!-- Custom styles for this template-->
    <!-- Custom styles for this template -->
    <link href="/css/sb-admin-2.min.css" rel="stylesheet">
  </head>
	<body class="bg-gradient-primary" onload="fnInit();">
    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-register-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">PeachBite 관리자 페이지</h1>
                                    </div>
                                    <form:form name="loginForm" method="post" action="#LINK" class="user">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="email" name="email" aria-describedby=""
                                                placeholder="Enter E-mail">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="passwd"  name="passwd" 
                                                onkeydown="javascript:if (event.keyCode == 13) { actionLogin(); }"
                                                placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input"  name="checkId" onclick="javascript:saveid(this.form);" id="checkId" >
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <!-- 
                                         -->
                                        <a href="javascript:actionLogin()" class="btn btn-primary btn-user btn-block mb-5">
                                            Login
                                        </a>
                                        <!-- 
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Login with Google
                                        </a>
                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook
                                        </a>
                                         -->
                            		</form:form>
                                    <hr class="mt-5 mb-5">
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/assets/dist/jquery/jquery.min.js"></script>
    <script src="/assets/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/assets/dist/jquery-easing/jquery.easing.min.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="/js/sb-admin-2.min.js"></script>
    <script type="text/javascript">
    
		function actionLogin() {
			if (document.loginForm.email.value =="") {
				alert("아이디를 입력하세요");
				return false;
			} else if (document.loginForm.passwd.value =="") {
				alert("비밀번호를 입력하세요");
				return false;
			} else {
				document.loginForm.action="/cafemain/main.do";
				document.loginForm.submit();
			}
		}

		function setCookie (name, value, expires) {
			document.cookie = name + "=" + escape (value) + "; path=/; expires=" + expires.toGMTString();
		}

		function getCookie(Name) {
			var search = Name + "="
			if (document.cookie.length > 0) { // 쿠키가 설정되어 있다면
				offset = document.cookie.indexOf(search)
				if (offset != -1) { // 쿠키가 존재하면
					offset += search.length
					// set index of beginning of value
					end = document.cookie.indexOf(";", offset)
					// 쿠키 값의 마지막 위치 인덱스 번호 설정
					if (end == -1)
						end = document.cookie.length
					return unescape(document.cookie.substring(offset, end))
				}
			}
			return "";
		}

		function saveid(form) {
			var expdate = new Date();
			// 기본적으로 30일동안 기억하게 함. 일수를 조절하려면 * 30에서 숫자를 조절하면 됨
			if (form.checkId.checked)
				expdate.setTime(expdate.getTime() + 1000 * 3600 * 24 * 30); // 30일
			else
				expdate.setTime(expdate.getTime() - 1); // 쿠키 삭제조건
			setCookie("saveid", form.email.value, expdate);
		}

		function getid(form) {
			form.checkId.checked = ((form.email.value = getCookie("saveid")) != "");
		}

		function fnInit() {
			var message = '${message}';
			if (message != "") {
				alert(message);
			}
			getid(document.loginForm);
		}
	</script>
  </body>
</html> 

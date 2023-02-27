
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
--%>


<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="content-language" content="ko">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Custom fonts for this template-->
<link href="/assets/dist/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="/assets/dist/css/bootstrap.min.css" rel="stylesheet">
<title>peachBite</title>
<!-- Custom styles for this template-->
<!-- Custom styles for this template -->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<style>
th.centered {
  text-align: center;
}
td.centered {
  text-align: center;
}

</style>
</head>
		  
</head>
<body id="page-top" onload="fnInit();">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="/cafemain/logout.do">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">${cafemain.cname}</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item "><a class="nav-link"
				href="/cafemain/main.do"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>home</span></a></li>

            <hr class="sidebar-divider d-none d-md-block">
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="/cafemain/manageGateway.do">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Gateway</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/cafemain/manageBluetooth.do">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Bluetooth</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/cafemain/manageUser.do">
                    <i class="fas fa-fw fa-table"></i>
                    <span>사용자 관리</span></a>
            </li>
			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Begin Page Content -->
                <div class="container-fluid mt-3">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">고객 목록</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive" id="table" >
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class='centered'>ID</th>
                                            <th class='centered'>고객명</th>
                                            <th class='centered'>전화번호</th>
                                            <th class='centered'>e-mail</th>
                                            <th class='centered'>상세보기</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tablebody">
                                    </tbody>
                                </table>
                            </div>
                                    	<!-- /List -->
							<div id="pagingx">
							</div>
									
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright &copy; Your Website 2021</span>
				</div>
			</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!--` Logout Modal
	-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">
				
				Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>
      <form class="form" role="form" id="form-content" style="display:none" >
        <div class="form-group">
          <label for="username">고객명</label>
          <input type="username" class="form-control" id="username" name="username" placeholder="고객명"></input>
        </div>
        <div class="form-group">
          <label for="phonenum">전화번호</label>
          <input type="phonenum" class="form-control" id="phonenum" name="phonenum" ></input>
        </div>
        <div class="form-group">
          <label for="email">e-mail</label>
          <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" ></input>
        </div>
      </form>

	<!-- Bootstrap core JavaScript-->
	<script src="/assets/dist/jquery/jquery.min.js"></script>
	<script src="/assets/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/assets/dist/jquery-easing/jquery.easing.min.js"></script>
	<!-- Custom scripts for all pages-->
	<script src="/js/sb-admin-2.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.5.2/bootbox.min.js" ></script>
	<script type="text/javascript">
		function fnInit() {
			
			//call_ajax();
			
			
			$.ajax({
				  url : "/cafemain/cafeuserList.do",
				  dataType: 'json',
				  success : function(data, textStatus, jqXHR) {
					var rowsData = data.resultList; 
					for (var i = 0; i < rowsData.length; i++) {
						  // create a new table row
						var newRow = $("<tr id ="+rowsData[i].cfuserid+">");

						  // add cells to the row
						var idCell = $("<td class='centered'>").text(rowsData[i].cfuserid);
						var nameCell = $("<td class='centered'>").text(rowsData[i].username);
						var phoneCell = $("<td class='centered'>").text(rowsData[i].phonenum);
						var emailCell = $("<td class='centered'>").text(rowsData[i].email);

						  // add a button cell with a click event handler
						var buttonCell = $("<td class='centered'>");
						var button = $("<button class='btn btn-info btn-circle btn-sm' ><i class='fas fa-info-circle'></i>");
						button.click(function() {
							var id = $(this).closest("tr").find("td:first").text();
						    showDetail(id);
						});
						buttonCell.append(button);

						  // append the cells to the row
						  newRow.append(idCell);
						  newRow.append(nameCell);
						  newRow.append(phoneCell);
						  newRow.append(emailCell);
						  newRow.append(buttonCell);

						  // append the new row to the table body
						  $("#tablebody").append(newRow);
						}
				  }, 
				  error : function(jqXHR, textStatus, errorThrown){
					  console.log("err");
					 	console.log(jqXHR);
					 	console.log(textStatus);
					 	console.log(errorThrown);
				    //Error시, 처리
				}
				});
		}
		
		
		/* 검색 초기화 버튼 */
		function fn_egov_reset() {
		  document.listForm.reset();
		  $("#pageIndex").attr('value', "1");
		}

		/* 사용자 목록 화면 function */
		function fn_egov_selectUserList() {
		  $("#pageIndex").attr('value', "1");
		  call_ajax();
		}

		/* pagination 페이지 링크 function */
		function fn_egov_link_page(pageNo){
		  // 선택한 페이지 번호 저장
		  $("#pageIndex").attr('value', pageNo.toString());
		  call_ajax();
		}

		/* ajax로 인물 목록 및 페이징 정보 받기 */
		function call_ajax() {
		  $.ajax({
		    type : 'POST',
		    data : $("#listForm").serialize(),
		    datatype : 'json',
		    url : "<c:url value='/cafemain/cafeuserList.do'/>",
		    success: function(result) {
		    	
		    	console.log(result);
		    	console.log(result.paginationInfo);
		    	
		      updateUserTable(result.paginationInfo,  result.resultList);
		    },
		    error : function(error) {
		      console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		    }
		  })
		}

		function updateUserTable(paginationInfo, resultList) {
			console.log(paginationInfo);
			console.log(resultList)
		}
		function showDetail(id) {
			var rowData = getRowData(id);
			
			$('#username').val(rowData.username);
			$('#email').val(rowData.email);
			$('#phonenum').val(rowData.phonenum);
			
			bootbox.dialog({
	            title: '고객 수정',
	            message:  $('#form-content'),
	            show: false,
	            centerVertical: true,
				buttons: [
				  {
					label: "저장",
					className: "btn btn-primary pull-left",
					callback: function() {

						$.ajax({
							  url : "/cafemain/updCafeuser.do",
							data: {
								cfuserid : id,
								username : $('#username').val(),
								email: $('#email').val(),
								phonenum: $('#phonenum').val(),
							} ,
							  dataType: 'json',
							  success : function(data, textStatus, jqXHR) {
								  console.log(data);
								  console.log(textStatus);
								  if(data.rsltCnt == 1){
								  debugger;
									  
								  }
							  }, 
							  error : function(jqXHR, textStatus, errorThrown){
								  console.log("err");
									 console.log(jqXHR);
									 console.log(textStatus);
									 console.log(errorThrown);
								//Error시, 처리
							}
							});
					 
					  return false;
					}
				  },
				  {
					label: "닫기",
					className: "btn btn-default pull-left",
					callback: function() {
					  console.log("just do something on close");
					}
				  }
				],
	        }).on("shown.bs.modal", function (e) {
	            $('#form-content').show()

	        }).on('hide.bs.modal', function (e) {
	            $('#form-content').hide().appendTo('body');
	        })
			.modal('show');
		}

		function getRowData(id) {
		  var rowData = {};
		  var row = $('#' + id);
		  rowData.cfuserid= id;
		  rowData.username = row.find('td:nth-child(2)').text();
		  rowData.phonenum = row.find('td:nth-child(3)').text();
		  rowData.email = row.find('td:nth-child(4)').text();
		
		  return rowData;
		}
		
	</script>
</body>
</html>
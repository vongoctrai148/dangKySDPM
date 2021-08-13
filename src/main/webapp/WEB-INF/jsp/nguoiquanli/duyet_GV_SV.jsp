<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Duyệt mượn phòng máy</title>

    <!-- Custom fonts for this template-->
    <link rel="stylesheet" type="text/css" href="style.css">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">


    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <div class="tab">
                    <button class="tablinks btn btn-primary" onclick="openCity(event, 'London')">Giáo Viên</button>
                    <button class="tablinks btn btn-primary" onclick="openCity(event, 'Paris')">Sinh Viên</button>
                </div>
                <div id="London" class="tabcontent">
                    <div class="container-fluid">
                        <!-- Page Heading -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">Danh sách giáo viên đã yêu cầu đăng ký phòng máy ${loginUser.phongMay.maphong}</h6>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead align="center">
                                        <tr>
                                            <th>STT</th>
                                            <th>Mã giáo viên</th>
                                            <th>Tên giáo viên</th>
                                            <th>Thời gian đăng ký</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody align="center">
                                        <c:forEach items="${ttdkgvs}" var="ttdkgv">
                                        <tr>
                                            <td>${ttdkgv.id}</td>
                                            <td>${ttdkgv.user.username}</td>
                                            <td>${ttdkgv.user.hoten}</td>
                                            <td>${ttdkgv.thoigiandk}</td>
                                            <td><a href="/NQL/chitietdkgv/${ttdkgv.id}" class="btn btn-info btn-icon-split">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-info-circle"></i>
                                                        </span>
                                                <span class="text">Xem chi tiết</span>
                                            </a></td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="Paris" class="tabcontent">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Danh sách sinh viên đã yêu cầu đăng ký phòng máy ${loginUser.phongMay.maphong}</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTableSV" width="100%" cellspacing="0">
                                    <thead align="center">
                                    <tr>
                                        <th>STT</th>
                                        <th>Mã sinh viên</th>
                                        <th>Tên sinh viên</th>
                                        <th>Thời gian đăng ký</th>
                                        <th>Máy đăng ký</th>
                                        <th colspan="2">Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody align="center">
                                    <c:forEach items="${ttdksvs}" var="ttdksv">
                                    <tr>
                                        <td>${ttdksv.id}</td>
                                        <td>${ttdksv.user.username}</td>
                                        <td>${ttdksv.user.hoten}</td>
                                        <td>${ttdksv.thoigiandk}</td>
                                        <td>${ttdksv.mamay.mamay}</td>
                                        <td align="center"><a href="/NQL/aceptDKSV/${ttdksv.id}" class="btn btn-primary">Đồng ý</a></td>
                                        <td align="center"><a href="/NQL/denyDKSV/${ttdksv.id}"  class="btn btn-primary">Từ chối</a></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                                <div class="row-cols-md-4" align="l" style="margin-left: 10%">
                                    <a href="/NQL/denyAll"  class="btn btn-danger btn-icon-split">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-trash"></i>
                                    </span>
                                        <span class="text">Từ chối tất cả</span>
                                    </a>
                                    <a href="/NQL/aceptAll" class="btn btn-success btn-icon-split" style="margin-left: 40%">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-check"></i>
                                    </span>
                                        <span class="text">Đồng ý tất cả</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/chart-area-demo.js"></script>
<script src="js/demo/chart-pie-demo.js"></script>
<script>
    function openCity(evt, cityName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(cityName).style.display = "block";
        evt.currentTarget.className += " active";
    }
</script>
</body>

</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Chi tiết ĐK phòng</title>
<!-- Page Wrapper -->
<link href="/sinhvien/history.css" rel="stylesheet"/>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">CHI TIẾT ĐĂNG KÝ</h1>
    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
</div>
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">
        <!-- Begin Page Content -->
        <div class="container-fluid">
            <div class="detail" style="margin: 5%;">
                <div class="row">
                    <label class="col-md-2">Họ tên:</label>
                    <h5 class="col-md-4" style="color: #0000CD;">${ttdkgv.user.hoten}</h5>
                </div>
                <div class="row">
                    <label class="col-md-2">Ngày:</label>
                    <div class="col-md-3" style="color: #000000">${ttdkgv.ngaysd}</div>
                    <label class="col-md-2">Thời gian:</label>
                    <div class="col-md-3" style="color: #000000">Từ ${ttdkgv.giobatdau} - ${ttdkgv.gioketthuc}h</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Phòng máy:</label>
                    <div class="col-md-3" style="color: #000000">${ttdkgv.phongmay.maphong}</div>
                    <label class="col-md-2">Lớp học phần:</label>
                    <div class="col-md-3" style="color: #000000">${ttdkgv.lophp.malhp}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Mục đích:</label>
                    <div class="col-md-3" style="color: #000000">${ttdkgv.mucdich}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Ứng dụng:</label>
                    <c:forEach items="${phanmems}" var="phanmem">
                        <div class="col-md-3" style="color: #000000">${phanmem.phanmem.tenphanmem} || </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <label class="col-md-2">Kết quả:</label>
                    <div class="col-md-4" >
                        <script>
                        if(${ttdkgv.ketqua} == 1 )
                            document.write("<p style=\"color: #080;\">Đã duyệt</p>");
                        else if(${ttdkgv.ketqua} == 0)
                            document.write("<p style=\"color: #2b6aad;\">Đang chờ duyệt</p>");
                        else if(${ttdkgv.ketqua} == 2)
                            document.write("<p style=\"color: red;\">Đã từ chối</p>");
                    </script>
                    </div>
                </div>
                <a href="/NQL/kiemtraphong/${ttdkgv.id}" class="btn btn-primary" style="margin-left: 20%; margin-top: 1%">Kiểm tra</a>
                <i style="color: black; margin-left: 5%">${message} </i>
            </div>
            ${notification}
            <div class="button" style="margin-bottom: 5%">
                <a href="/NQL/denyTTDKGV/${ttdkgv.id}" class="btn btn-primary" style="margin-left: 20%">Từ chối</a>
                <a href="/NQL/aceptTTDKGV/${ttdkgv.id}" class="btn btn-primary" style="margin-left: 25%">Đồng ý</a>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
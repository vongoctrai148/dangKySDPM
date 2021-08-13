<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Chi tiết ĐK máy</title>
<!-- Page Wrapper -->
<link href="/sinhvien/history.css" rel="stylesheet"/>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">CHI TIẾT ĐĂNG KÝ</h1>
</div>
<div id="content-wrapper" class="d-flex flex-column">

    <!-- Main Content -->
    <div id="content">
        <!-- Begin Page Content -->
        <div class="container-fluid">
            <div class="detail" style="margin: 5%;">
                <div class="row">
                    <label class="col-md-2">Họ tên:</label>
                    <h5 class="col-md-4" style="color: #0000CD;">${ttdksv.user.hoten}</h5>
                </div>
                <div class="row">
                    <label class="col-md-2">Ngày:</label>
                    <div class="col-md-3" style="color: #000000">${ttdksv.ngaysd}</div>
                    <label class="col-md-2">Thời gian:</label>
                    <div class="col-md-3" style="color: #000000">Từ tiết ${ttdksv.tutiet} đến tiết ${ttdksv.dentiet}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Phòng máy:</label>
                    <div class="col-md-3" style="color: #000000">${ttdksv.maphong.maphong}</div>
                    <label class="col-md-2">Máy số:</label>
                    <div class="col-md-3" style="color: #000000">${ttdksv.mamay.mamay}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Ứng dụng:</label>
                    <c:forEach items="${phanmems}" var="phanmem">
                        <div class="col-md-3" style="color: #000000">${phanmem.phanmem.tenphanmem} || </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <label class="col-md-2">Kết quả:</label>
                    <div class="col-md-4" style="color: #080;">
                        <script>
                        if(${ttdksv.ketqua} == 1 )
                            document.write("<p>Đã duyệt</p>");
                        else if(${ttdksv.ketqua} == 0)
                            document.write("<p>Đang chờ duyệt</p>");
                        else if(${ttdksv.ketqua} == 2)
                            document.write("<p>Đã từ chối</p>");
                    </script>
                    </div>
                </div>
            </div>
            <div class="button">
                <a href="/SV/lichsudk" class="btn btn-primary" style="margin-left: 20%">Lịch sử</a>
                <a href="/SV/baocaomay/${ttdksv.id}" class="btn btn-primary" style="margin-left: 25%">Báo cáo</a>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
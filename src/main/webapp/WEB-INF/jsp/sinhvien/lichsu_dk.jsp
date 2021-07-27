<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Lịch sử ĐK máy</title>

<!-- Page Wrapper -->
<link href="/sinhvien/history.css" rel="stylesheet"/>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">LỊCH SỬ ĐĂNG KÝ</h1>
</div>
<div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
        <!-- Begin Page Content -->
        <div class="container-fluid">
            <!-- Page Heading -->
            <c:forEach items="${ttdksvs}" var="ttdk">
                <div class="history-item">
                <h5> <i class="fas fa-caret-right"></i> Đăng ký phòng máy ${ttdk.maphong.maphong}</h5>
                    <p>Đã đăng ký phòng ${ttdk.maphong.maphong}, máy ${ttdk.mamay.mamay},
                    ngày ${ttdk.ngaysd}, từ ${ttdk.giobatdau}h - ${ttdk.gioketthuc}h</p>
                <div class="history-link">
                    <a href="/SV/chitietlichsu/${ttdk.id}" class="detail">Xem chi tiết <i class="fas fa-angle-double-right"></i></a>
                    <a href="/SV/baocaomay/${ttdk.id}" class="report">Báo cáo<i class="fas fa-angle-double-right"></i></a>
                </div>
            </div>
            </c:forEach>
        </div>
        <!-- /.container-fluid -->

    </div>
</div>
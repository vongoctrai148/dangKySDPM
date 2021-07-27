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
            </div>
            <div class="button">
                <a href="/GV/lichsudk" class="btn btn-primary" style="margin-left: 20%">Lịch sử</a>
                <a class="btn btn-primary" style="margin-left: 25%" data-toggle="collapse" data-target="#collapseThree"
                   aria-expanded="true" aria-controls="collapseTwo">Báo cáo</a>
                <div id="collapseThree" class="collapse" style="margin-left: 50%" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Danh mục:</h6>
                        <a class="collapse-item" href="/GV/baocaophong/${ttdkgv.id}">Máy tính</a>
                    </div>
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="#">Thiết bị</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
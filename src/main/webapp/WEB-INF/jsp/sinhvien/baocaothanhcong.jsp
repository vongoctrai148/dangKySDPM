<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>Báo cáo tình trạng</title>
<!-- Page Wrapper -->
<link href="/sinhvien/history.css" rel="stylesheet"/>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">BÁO CÁO THÀNH CÔNG</h1>
</div>
<div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
        <!-- Begin Page Content -->
        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="detail" style="margin: 5%;">
                <div class="row">
                    <label class="col-md-2">Họ tên:</label>
                    <h5 class="col-md-4" style="color: #0000CD;">${ttbcsv.thongTinDKSV.user.hoten}</h5>
                </div>
                <div class="row">
                    <label class="col-md-2">Thời gian báo cáo:</label>
                    <div class="col-md-3" style="color: #000;">${ttbcsv.ngaybc}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Thời gian sử dụng:</label>
                    <div class="col-md-3" style="color: #000;">${ttbcsv.thongTinDKSV.ngaysd}</div>
                    <label class="col-md-3" style="color: #000;">Thời gian: Từ ${ttbcsv.thongTinDKSV.giobatdau} - ${ttbcsv.thongTinDKSV.gioketthuc}h</label>
                </div>
                <div class="row">
                    <label class="col-md-2">Phòng máy:</label>
                    <div class="col-md-3" style="color: #000;">${ttbcsv.thongTinDKSV.maphong.maphong}</div>
                    <div class="col-md-3" style="color: #000;">Máy: ${ttbcsv.thongTinDKSV.mamay.mamay}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Tình trạng:</label>
                    <div class="col-md-4" style="color: #000;">${ttbcsv.tinhtrang}</div>
                </div>
                <p style="color: red; margin-left: 15%;"><i>Cảm ơn bạn đã báo cáo tình trạng phòng máy</i></p>
            </div>
            <div class="button" style="margin-left: 10%;">
                <a href="/SV/lichsudk" class="btn btn-primary" >Lịch sử</a>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
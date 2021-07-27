<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>Trả lời báo cáo - chi tiết</title>
<!-- Page Wrapper -->
<link href="/sinhvien/history.css" rel="stylesheet"/>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Chi tiết báo cáo</h1>
    <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
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
                    <label class="col-md-2">Tình trạng báo cáo:</label>
                    <div class="col-md-4" style="color: #000;">${ttbcsv.tinhtrang}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Tình trạng xử lí:</label>
                    <div class="col-md-4" style="color: #000;"><script>
                        if(${ttbcsv.tinhtrangxl} == 1 )
                        document.write("<p style='color: green'>Đã xử lí</p>");
                        else if(${ttbcsv.tinhtrangxl} == 0)
                        document.write("<p style='color: #2a62bc'>Đang chờ duyệt</p>");
                        else if(${ttbcsv.tinhtrangxl} == 2)
                        document.write("<p style='color: #f4b30d'>Đã quan tâm</p>");
                    </script></div>
                </div>
            </div>
            <div class="button" style="margin-left: 10%;">
                <a href="/NQL/quantam/${ttbcsv.id}" class="btn btn-primary" >Quan tâm</a>
                <a href="/NQL/xuli/${ttbcsv.id}" class="btn btn-primary" style="margin-left: 30%" >Đã xử lí</a>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
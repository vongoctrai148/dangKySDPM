<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Báo cáo tình trạng</title>

<!-- Page Wrapper -->
<link href="/sinhvien/history.css" rel="stylesheet"/>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">BÁO CÁO TÌNH TRẠNG MÁY</h1>
</div>
<div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
        <!-- Begin Page Content -->
        <div class="container-fluid">
            <!-- Page Heading -->
            <form action="/SV/baocaomay" method="POST" style="margin: 10px;">
                <input type="hidden" name="id" value="${ttdksv.id}"/>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label>Ngày: ${ttdksv.ngaysd}</label>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Từ ${ttdksv.tutiet} - ${ttdksv.dentiet}h</label>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Phòng: ${ttdksv.maphong.maphong}</label>
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label>Máy: ${ttdksv.mamay.mamay}</label>
                    </div>
                    <div class="form-group col-md-5">
                        <label>Tình trạng:</label>
                        <textarea type="text" name="tinhtrang" class="form-control"
                                  placeholder="Mời nhập tình trạng của máy"></textarea>
                    </div>
                </div>
                <div class="row">
                    <button type="submit" class="btn btn-primary" style="margin-left: 30%; margin-top: 5%">Gửi</button>
                </div>
            </form>

        </div>
        <!-- /.container-fluid -->

    </div>
</div>
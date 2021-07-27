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
            <form action="/GV/baocaomay" method="POST" style="margin: 10px;">
                <input type="hidden" name="id" value="${ttdkgv.id}"/>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label>Ngày: ${ttdkgv.ngaysd}</label>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Từ ${ttdkgv.giobatdau} - ${ttdkgv.gioketthuc}h</label>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Phòng: ${ttdkgv.phongmay.maphong}</label>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-2">
                        <label>Máy tính:</label>
                    </div>
                    <div class="form-group col-md-2">
                        <select class="form-control" name="maytinh">
                            <c:forEach items="${maytinhs}" var="maytinh">
                                <option value="${maytinh.mamay}">${maytinh.mamay}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-2">
                        <label>Mô tả tình trạng:</label>
                    </div>
                    <div class="form-group col-md-5">
                        <textarea name="noidung" class="form-control" placeholder="Nhập tình trạng..."></textarea>
                    </div>
                </div>
                <div class="row">
                    <button type="submit" class="btn btn-primary" style="margin-left: 30%; margin-top: 2%">Thêm báo cáo</button>
                </div>
            </form>

        </div>
        <!-- /.container-fluid -->

    </div>
</div>
<script type="text/javascript">
    $(".chosen-select").chosen();
</script>
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
            <form action="/GV/baocaophong" method="POST" style="margin: 10px;">
                <input type="hidden" name="id" value="${ttdkgv.id}"/>
                <div class="form-row">
                    <div class="form-group col-md-3">
                        <label>Ngày: ${ttdkgv.ngaysd}</label>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Từ tiết ${ttdkgv.tutiet} đến ${ttdkgv.dentiet}</label>
                    </div>
                    <div class="form-group col-md-3">
                        <label>Phòng: ${ttdkgv.phongmay.maphong}</label>
                    </div>
                </div>
                <div class="form-row" style="margin-top: 1%">
                    <div class="form-group col-md-2">
                        <label>Vệ sinh phòng máy:</label>
                    </div>
                    <div class="form-group col-md-3">
                        <select class="form-control">
                            <option>Tốt</option>
                            <option>Chưa tốt</option>
                            <option>Ý kiến khác</option>
                        </select>
                    </div>
                    <div class="form-group col-md-3">
                        <input type="text" class="form-control" placeholder="Nhập ý kiến...">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-2">
                        <label>Máy tính:</label>
                    </div>
                    <div class="form-group col-md-2">
                        <a href="/GV/baocaomay/${ttdkgv.id}" class="btn btn-primary" style="margin-left: 20%;">Thêm báo cáo máy</a>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-8">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataMayTinh" width="100%" cellspacing="0">
                                    <thead align="center">
                                    <tr>
                                        <th>STT</th>
                                        <th>Mã máy</th>
                                        <th>Tình trạng</th>
                                        <th colspan="2">Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tfoot align="center">
                                    <tr>
                                        <th>STT</th>
                                        <th>Mã máy</th>
                                        <th>Tình trạng</th>
                                        <th colspan="2">Thao tác</th>
                                    </tr>
                                    </tfoot>
                                    <tbody align="center">
                                    <c:forEach items="${bcmays}" var="bcmay">
                                    <tr>
                                        <td>${bcmay.id}</td>
                                        <td>${bcmay.mayTinh.mamay}</td>
                                        <td>${bcmay.noidungbc}</td>
                                        <td align="center"><a href="/GV/suadkpm/${bcmay.id}" title="Chỉnh sửa"><i class="fa fa-pen"></i></a></td>
                                        <td align="center"><a href="/GV/deletettdk/${bcmay.id}" title="Hủy đăng ký"><i class="fa fa-trash"></i></a></td>
                                    </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <button type="submit" class="btn btn-primary" style="margin-left: 30%; margin-top: 2%">Gửi báo cáo</button>
                </div>
            </form>

        </div>
        <!-- /.container-fluid -->

    </div>
</div>
<script type="text/javascript">
    $(".chosen-select").chosen();
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                    <h5 class="col-md-4" style="color: #0000CD;">${ttdkgv.user.hoten}</h5>
                </div>
                <div class="row">
                    <label class="col-md-2">Mã giáo viên:</label>
                    <h5 class="col-md-4" style="color: #0000CD;">${ttdkgv.user.username}</h5>
                </div>
                <div class="row">
                    <label class="col-md-2">Phòng đã mượn:</label>
                    <h5 class="col-md-4" style="color: #0000CD;">${ttdkgv.phongmay.maphong}</h5>
                </div>
                <div class="row">
                    <label class="col-md-2">Thời gian mượn:</label>
                    <div class="col-md-3" style="color: #000;">${ttdkgv.ngaysd}</div>
                </div>
                <div class="row">
                    <label class="col-md-2">Từ tiết:</label>
                    <div class="col-md-3" style="color: #000;">${ttdkgv.tutiet} đến ${ttdkgv.dentiet}</div>
                </div>
                <div class="row">
                    <div class="form-group col-md-10">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataMayTinh" width="100%" cellspacing="0">
                                    <thead align="center">
                                    <tr>
                                        <th>STT</th>
                                        <th>Mã máy</th>
                                        <th>Nội dung báo cáo</th>
                                        <th>Tình trạng xử lí</th>
                                        <th colspan="2">Thao tác</th>
                                    </tr>
                                    </thead>
                                    <tbody align="center">
                                    <c:forEach items="${dsachbcmay}" var="bcmay">
                                        <tr>
                                            <td>${bcmay.id}</td>
                                            <td>${bcmay.mayTinh.mamay}</td>
                                            <td>${bcmay.noidungbc}</td>
                                            <td><script>
                                                if(${bcmay.tinhtrang} == 1 )
                                                document.write("<p style='color: green'>Đã xử lí</p>");
                                                else if(${bcmay.tinhtrang} == 0)
                                                document.write("<p style='color: #2a62bc'>Đang chờ duyệt</p>");
                                                else if(${bcmay.tinhtrang} == 2)
                                                document.write("<p style='color: #f4b30d'>Đã quan tâm</p>");
                                            </script></td>
                                            <td align="center"><a href="/NQL/quantamBCGV/${bcmay.id}" title="Đã quan tâm">Đã quan tâm</a></td>
                                            <td align="center"><a href="/NQL/xuliBCGV/${bcmay.id}" title="Đã xử lí">Đã xử lí</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<title>Cập nhật TTĐK phòng máy</title>
<!-- Page Wrapper -->

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Trang người quản lí phòng máy</h1>
    <a href="/NQL/reportTTDKGV" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
            class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
</div>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <a class="btn btn-success btn-icon-split" style="margin-left:3%">
            <span class="text">Chào mừng người quản lí phòng máy ${loginUser.hoten}</span>
        </a>
    </div>

</div>
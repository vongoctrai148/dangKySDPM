<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Danh sách báo cáo</title>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách sinh viên báo cáo tình trạng máy phòng ${loginUser.phongMay.maphong}</h6>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead align="center">
                <tr>
                    <th>ID</th>
                    <th>Mã sinh viên</th>
                    <th>Tên sinh viên</th>
                    <th>Thời gian báo cáo</th>
                    <th>Nội dung báo cáo</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach items="${dsachbcsv}" var="dsachbc">
                    <tr>
                        <td>${dsachbc.id}</td>
                        <td>${dsachbc.thongTinDKSV.user.username}</td>
                        <td>${dsachbc.thongTinDKSV.user.hoten}</td>
                        <td>${dsachbc.ngaybc}</td>
                        <td>${dsachbc.tinhtrang}</td>
                        <td><a href="/NQL/chitietBC/${dsachbc.thongTinDKSV.id}" class="btn btn-info btn-icon-split">
                                                        <span class="icon text-white-50">
                                                            <i class="fas fa-info-circle"></i>
                                                        </span>
                            <span class="text">Xem chi tiết</span>
                        </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
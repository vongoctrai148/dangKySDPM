<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">

    <!-- Page Heading -->
    <p class="mb-4">*Bạn sẽ đồng ý hoặc từ chối cho sinh viên mượn máy tại phòng này vào thời gian bạn đang dạy
        Nếu bạn không đồng ý hoặc từ chối, hệ thống sẽ tự động từ chối khi quá thời gian yêu cầu
    </p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Bảng yêu cầu đăng ký mượn phòng máy phòng ${ttdkgv.phongmay.maphong}</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã sinh viên</th>
                        <th>Tên sinh viên</th>
                        <th>Thời gian</th>
                        <th colspan="2">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ttdksvs}" var="ttdksv">
                    <tr>
                        <td>${ttdksv.id}</td>
                        <td>${ttdksv.user.username}</td>
                        <td>${ttdksv.user.hoten}</td>
                        <td>${ttdksv.thoigiandk}</td>
                        <td align="center"><a href="/GV/aceptDKSV/${ttdksv.id}" class="btn btn-primary">Đồng ý</a></td>
                        <td align="center"><a href="/GV/denyDKSV/${ttdksv.id}"  class="btn btn-primary">Từ chối</a></td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="row-cols-md-4" align="l" style="margin-left: 10%">
                    <a href="#"  class="btn btn-danger btn-icon-split">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-trash"></i>
                                    </span>
                        <span class="text">Từ chối tất cả</span>
                    </a>
                    <a href="/GV/aceptAll" class="btn btn-success btn-icon-split" style="margin-left: 40%">
                                    <span class="icon text-white-50">
                                        <i class="fas fa-check"></i>
                                    </span>
                        <span class="text">Đồng ý tất cả</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
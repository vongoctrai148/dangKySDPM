<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Cập nhật TTĐK phòng máy</title>
<!-- Page Wrapper -->

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <h1 class="h3 mb-0 text-gray-800">Cập nhật thông tin đăng ký</h1>
</div>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <a href="/GV/themdkpm" class="btn btn-success btn-icon-split" style="margin-left:3%">
            <span class="text">Đăng ký mới</span>
        </a>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead align="center">
                    <tr>
                        <th>STT</th>
                        <th>Phòng đăng ký</th>
                        <th>Ngày đăng ký</th>
                        <th>Ngày sử dụng</th>
                        <th>Giờ mượn phòng</th>
                        <th>Tình trạng</th>
                        <th colspan="3">Thao tác</th>
                    </tr>
                </thead>
                <tfoot align="center">
                    <tr>
                        <th>STT</th>
                        <th>Phòng đăng ký</th>
                        <th>Ngày đăng ký</th>
                        <th>Ngày sử dụng</th>
                        <th>Giờ mượn phòng</th>
                        <th>Tình trạng</th>
                        <th colspan="3">Thao tác</th>
                    </tr>
                </tfoot>
                <tbody align="center">
                <c:forEach items="${ttdkgv}" var="ttdkgv">
                    <tr>
                        <td>${ttdkgv.id}</td>
                        <td>${ttdkgv.phongmay.maphong}</td>
                        <td>${ttdkgv.thoigiandk}</td>
                        <td>${ttdkgv.ngaysd}</td>
                        <td>${ttdkgv.giobatdau} - ${ttdkgv.gioketthuc} h</td>
                        <td>
                            <script>
                                if(${ttdkgv.ketqua} == 1 )
                                document.write("<p>Đã duyệt</p>");
                                else if(${ttdkgv.ketqua} == 0)
                                document.write("<p>Đang chờ duyệt</p>");
                                else if(${ttdkgv.ketqua} == 2)
                                document.write("<p>Đã từ chối</p>");
                            </script>
                        </td>
                        <td align="center"><a href="/GV/chitietlichsu/${ttdkgv.id}" title="Chi tiết"><i class="fa fa-info-circle"></i></a></td>
                        <td align="center"><a href="/GV/suadkpm/${ttdkgv.id}" title="Chỉnh sửa"><i class="fa fa-pen"></i></a></td>
                        <td align="center"><a href="/GV/deletettdk/${ttdkgv.id}" title="Hủy đăng ký"><i class="fa fa-trash"></i></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
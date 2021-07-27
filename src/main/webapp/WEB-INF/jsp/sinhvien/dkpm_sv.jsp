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
        <a href="/SV/themdkpm" class="btn btn-success btn-icon-split" style="margin-left:3%">
            <span class="text">Đăng ký mới</span>
        </a>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead align="center">
                    <tr>
                        <th>Mã ĐK</th>
                        <th>Phòng đăng ký</th>
                        <th>Máy đăng ký</th>
                        <th>Ngày đăng ký</th>
                        <th>Ngày sử dụng</th>
                        <th>Giờ mượn phòng</th>
                        <th>Tình trạng</th>
                        <th colspan="3">Thao tác</th>
                    </tr>
                </thead>
                <tfoot align="center">
                    <tr>
                        <th>Mã ĐK</th>
                        <th>Phòng đăng ký</th>
                        <th>Máy đăng ký</th>
                        <th>Ngày đăng ký</th>
                        <th>Ngày sử dụng</th>
                        <th>Giờ mượn phòng</th>
                        <th>Tình trạng</th>
                        <th colspan="3">Thao tác</th>
                    </tr>
                </tfoot>
                <tbody align="center">
                    <c:forEach items="${thongtindk}" var="thongtindksv">
                    <tr>
                        <td>${thongtindksv.id}</td>
                        <td>${thongtindksv.maphong.maphong}</td>
                        <td>${thongtindksv.mamay.mamay}</td>
                        <td>${thongtindksv.thoigiandk}</td>
                        <td>${thongtindksv.ngaysd}</td>
                        <td>${thongtindksv.giobatdau} - ${thongtindksv.gioketthuc} h</td>
                        <td>
                            <script>
                                if(${thongtindksv.ketqua} == 1 )
                                    document.write("<p>Đã duyệt</p>");
                                else if(${thongtindksv.ketqua} == 0)
                                    document.write("<p>Đang chờ duyệt</p>");
                                else if(${thongtindksv.ketqua} == 2)
                                    document.write("<p>Đã từ chối</p>");
                            </script>
                        </td>
                        <td align="center"><a href="/SV/chitietlichsu/${thongtindksv.id}" title="Chi tiết"><i class="fa fa-info-circle"></i></a></td>
                        <td align="center"><a href="/SV/suadkpm/${thongtindksv.id}" title="Chỉnh sửa"><i class="fa fa-pen"></i></a></td>
                        <td align="center"><a href="/SV/deletettdk/${thongtindksv.id}" title="Hủy đăng ký"><i class="fa fa-trash"></i></a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
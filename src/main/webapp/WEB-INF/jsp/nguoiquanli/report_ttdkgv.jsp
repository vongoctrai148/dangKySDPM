<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Danh sách báo cáo</title>

<div class="card shadow mb-4">

    <div class="card-header py-3">
        <h6 class="m-0 font-weight-bold text-primary">Danh sách giáo viên đăng ký mượn phòng ${loginUser.phongMay.maphong}</h6>
        <input id="searchName" style="margin-top: 1%" type="text" class="form-control col-md-3" placeholder="Tìm kiếm tên giáo viên..." >
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead align="center">
                <tr>
                    <th>ID</th>
                    <th>Mã giáo viên</th>
                    <th>Tên giáo viên</th>
                    <th>Phòng đăng ký</th>
                    <th>Thời gian đăng ký</th>
                    <th>Mã lớp học phần</th>
                    <th>Ngày sử dụng</th>
                    <th>Giờ sử dụng</th>
                    <th>Tình trạng</th>
                </tr>
                </thead>
                <tbody align="center" id="myTable">
                <c:forEach items="${ttdkgvs}" var="ttdkgv">
                    <tr>
                        <td>${ttdkgv.id}</td>
                        <td>${ttdkgv.user.username}</td>
                        <td>${ttdkgv.user.hoten}</td>
                        <td>${ttdkgv.phongmay.maphong}</td>
                        <td>${ttdkgv.thoigiandk}</td>
                        <td>${ttdkgv.lophp.malhp}</td>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $("#searchName").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#myTable tr").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>
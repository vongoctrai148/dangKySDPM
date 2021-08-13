<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Thêm đăng ký mới</title>
<h2 align="center">Đăng ký phòng máy</h2>
<form action="/GV/themdkpm" method="post" >
    <div class="form-group" style="margin-top: 2%">
            <label>Chọn ngày</label>
            <input type="date" id="start" name="ngaysd"
                   class="form-control" id="dateTime" value=""
                   min="2021-01-01" max="2050-12-31" style="width: 17%; display: inline;" required/>
            <label style="margin-top: 1%; margin-left: 8%">Từ tiết: </label>
            <select name="startTime" required>
                <c:forEach begin="1" end="12" step="1" var="items">
                    <option value="${items}">${items}</option>
                </c:forEach>
            </select>
            <label style="margin-top: 1%; margin-left: 3%;">Đến tiết: </label>
            <select name="endTime" required>
                <c:forEach begin="2" end="13" step="1" var="items">
                    <option value="${items}">${items}</option>
                </c:forEach>
            </select>
    </div>
    <div class="form-group">
        <label>Mục đích:</label>
        <select type="text" id="mucdichId" class="chosen-select" multiple
                name="mucdich" style="display: inline; width: 60%; margin-left: 2%" required>
                <option value="hocbu/">Học bù</option>
                <option value="/kiemtra">Kiểm tra</option>
        </select>
    </div>
    <div class="form-group">
        <label>Chọn phòng:</label>
        <select type="text" class="form-control" name="phongmay" required
                style="display: inline; width: 20%; margin-left: 2%">
            <c:forEach items="${phongmays}" var="phongmay">
                <option value="${phongmay.maphong}">${phongmay.maphong}</option>
            </c:forEach>
        </select>
    </div>
    ${message}
    <div class="form-group">
        <label>Mã lớp học phần:</label>
        <select type="text" class="form-control" name="lophocphan" required
               style="display: inline; width: 20%; margin-left: 2%">
            <c:forEach items="${lophp}" var="lhp">
                <option selected value="${lhp.malhp}">${lhp.malhp}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Nhập số lượng sinh viên:</label>
        <input type="number" class="form-control" name="soluongsv" required
               placeholder="Nhập số lượng sinh viên" min="1" max="30"
               style="width: 20%; display: inline; margin-left: 2%">
    </div>

    <button type="submit" class="btn btn-primary" style="margin-left: 30%; margin-top: 1%">Submit</button>
</form>
<script type="text/javascript">
    $(".chosen-select").chosen();
    var phanmems = $('#phanmemId').val();
</script>
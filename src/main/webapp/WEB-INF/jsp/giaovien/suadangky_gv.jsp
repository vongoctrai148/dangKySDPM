<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Sửa đăng ký</title>
<h2 align="center">Đăng ký phòng máy</h2>
<form action="/GV/suadkpm" method="post" >
    <div class="form-group" style="margin-top: 2%">
        <input type="hidden" value="${ttdkgv.id}" name="id">
            <label>Chọn ngày</label>
            <input type="date" id="start" name="ngaysd"
                   class="form-control" id="dateTime" value="${ttdkgv.ngaysd}"
                   min="2021-01-01" max="2050-12-31" style="width: 17%; display: inline;" required/>
            <label style="margin-top: 1%; margin-left: 8%">Giờ bắt đầu: </label>
            <select name="startTime" required>
                <c:forEach begin="6" end="18" step="1" var="items">
                    <option value="${items}">${items}</option>
                </c:forEach>
            </select>
            <label style="margin-top: 1%; margin-left: 3%;">Giờ kết thúc: </label>
            <select name="endTime" required>
                <c:forEach begin="7" end="20" step="1" var="items">
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
        ${message}
        <label>Chọn phòng:</label>
        <select type="text" class="form-control" name="phongmay"
                style="display: inline; width: 20%; margin-left: 2%">
            <option selected value="${ttdkgv.phongmay.maphong}">${ttdkgv.phongmay.maphong}</option>
            <c:forEach items="${phongmays}" var="phongmay">
                <option value="${phongmay.maphong}">${phongmay.maphong}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Mã lớp học phần:</label>
        <select type="text" class="form-control" name="lophocphan"
               style="display: inline; width: 20%; margin-left: 2%">
            <option selected value="${ttdkgv.lophp.malhp}">${ttdkgv.lophp.malhp}</option>
            <c:forEach items="${lophp}" var="lhp">
                <option value="${lhp.malhp}">${lhp.malhp}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Nhập số lượng sinh viên:</label>
        <input type="number" class="form-control" name="soluongsv" required
               placeholder="Nhập số lượng sinh viên" min="1" max="30"
               style="width: 20%; display: inline; margin-left: 2%" value="${ttdkgv.soluongsv}">
    </div>

    <button type="submit" class="btn btn-primary" style="margin-left: 30%; margin-top: 1%">Submit</button>
</form>
<script type="text/javascript">
    $(".chosen-select").chosen();
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Sửa đăng ký</title>
<h2 align="center">Đăng ký mượn máy</h2>
<form method="POST" action="/SV/suadkpm">
    <div class="form-group" style="margin-top: 2%">
        <input type="hidden" value="${ttdk.id}"  name="id" id="id">
            <label>Chọn ngày</label>
            <input type="date" id="ngaysd" name="thoigiansd"
                   class="form-control" id="dateTime" value="${ttdk.ngaysd}"
                   min="2021-01-01" max="2050-12-31" style="width: 17%; display: inline;" required/>
            <label style="margin-top: 1%; margin-left: 8%">Từ tiết: </label>
            <select name="startTime" id="start" required>
                <option selected value="${ttdk.tutiet}">${ttdk.tutiet}</option>
                <c:forEach begin="1" end="12" step="1" var="item">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
            <label style="margin-top: 1%; margin-left: 3%;">Đến tiết: </label>
            <select name="endTime" id="end" required>
                <option selected value="${ttdk.dentiet}">${ttdk.dentiet}</option>
                <c:forEach begin="2" end="13" step="1" var="item">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
    </div>
    <div class="form-group">
        <label>Chọn phòng:</label>
        <select type="text" class="form-control" id="phongmayId" required name="phongmay"
                 style="display: inline; width: 20%; margin-left: 2%">
            <option selected value="${ttdk.maphong.maphong}">${ttdk.maphong.maphong}</option>
            <c:forEach items="${phongmay}" var="phongmay">
                <option value="${phongmay.maphong}">${phongmay.maphong}</option>
            </c:forEach>
        </select>
    </div>
    ${message}
    <div class="form-group">
        <label>Chọn máy:</label>
        <select class="form-control" id ="maytinhId" name="maytinh" style="display: inline; width: 20%; margin-left: 2%">
            <option selected value="${ttdk.mamay.mamay}">${ttdk.mamay.mamay}</option>
            <option value="">Chọn máy tính</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
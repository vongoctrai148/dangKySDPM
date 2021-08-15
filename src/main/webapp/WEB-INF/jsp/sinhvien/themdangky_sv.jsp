<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Thêm đăng ký mới</title>
<h2 align="center">Đăng ký mượn máy</h2>
<form method="POST" action="/SV/themdkpm">
    <div class="form-group" style="margin-top: 2%">
            <label>Chọn ngày</label>
            <input type="date" id="ngaysd" name="thoigiansd"
                   class="form-control" id="dateTime" value=""
                   min="2021-01-01" max="2050-12-31" style="width: 17%; display: inline;"/>
            <label style="margin-top: 1%; margin-left: 8%">Từ tiết: </label>
            <select name="startTime" id="start">
                <c:forEach begin="1" end="12" step="1" var="item">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
            <label style="margin-top: 1%; margin-left: 3%;">Đến tiết: </label>
            <select name="endTime" id="end">
                <c:forEach begin="2" end="13" step="1" var="item">
                    <option value="${item}">${item}</option>
                </c:forEach>
            </select>
    </div>
    <div class="form-group">
        <label>Chọn phòng:</label>
        <select type="text" class="form-control" id="phongmayId"
                 style="display: inline; width: 20%; margin-left: 2%">
            <c:forEach items="${phongmay}" var="phongmay">
                <option selected value="${phongmay.maphong}">${phongmay.maphong}</option>
            </c:forEach>
        </select>
    </div>
    ${message}
    <div class="form-group">
        <label>Chọn máy:</label>
        <select class="form-control" id ="maytinhId" name="maytinh" style="display: inline; width: 20%; margin-left: 2%">
            <option selected value="">Chọn máy tính</option>
        </select>
    </div>
    <div class="form-group">
        <i>Lưu ý: Nếu sau khi bạn đăng ký và trang trả về danh sách đăng ký, thì có nghĩa đã có giáo viên đăng ký mượn phòng đó!</i>
    </div>
    <div class="form-group">
        <i>Vì vậy bạn chỉ có thể đăng ký vào và ngồi theo vị trí sắp xếp của giáo viên đó!</i>
    </div>
    <div class="form-group">
        <i>Nếu không muốn, bạn có thể chỉnh sửa trước khi giáo viên duyệt TTDK (Xem tình trạng)</i>
    </div>
    <button type="submit" class="btn btn-primary" style="align-content: center">Submit</button>
</form>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Sửa đăng ký</title>
<h2 align="center">Đăng ký mượn máy</h2>
<form method="POST" action="/SV/suaungdung">
    <div class="form-group">
        <label>Phần mềm:</label>
        <select type="text" id="phanmemId" class="chosen-select form-control" multiple
                name="phanmem" style="display: inline; width: 60%; margin-left: 2%">
            <c:forEach items="${phanmems}" var="phanmem">
                <option value="${phanmem.maphanmem}">${phanmem.tenphanmem}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary" style="align-content: center">Submit</button>
</form>

<script type="text/javascript">
    $(".chosen-select").chosen();
    var phanmems = $('#phanmemId').val();

</script>
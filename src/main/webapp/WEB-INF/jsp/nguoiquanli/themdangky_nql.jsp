<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<title>Thêm đăng ký mới</title>
<h2 align="center">Đăng ký mượn máy</h2>
<form>
    <div class="form-group" style="margin-top: 2%">
            <label>Chọn ngày</label>
            <input type="date" id="start" name="trip-start"
                   class="form-control" id="dateTime"
                   min="2021-01-01" max="2050-12-31" style="width: 17%; display: inline;"/>
            <label style="margin-top: 1%; margin-left: 8%">Giờ bắt đầu: </label>
            <select name="startTime">
                <option value="7">7</option>
                <option value="8">8</option>
            </select>
            <label style="margin-top: 1%; margin-left: 3%;">Giờ kết thúc: </label>
            <select name="endTime">
                <option value="9">9</option>
                <option value="10">10</option>
            </select>
    </div>
    <div class="form-group">
        <label>Phần mềm:</label>
        <table class="table table-bordered" id="dataTable" style="width: 50%">
            <thead align="center">
            <tr>
                <th>STT</th>
                <th>Tên phần mềm</th>
                <th colspan="2">Thao tác</th>
            </tr>
            </thead>
            <tbody align="center">
            <tr>
                <td>1</td>
                <td>Visual studio</td>
                <td align="center"><a href="#" title="Chỉnh sửa" data-toggle="modal" data-target="#themPhanMem"><i class="fa fa-pen"></i></a></td>
                <td align="center"><a href="#" title="Xóa"><i class="fa fa-trash"></i></a></td>
            </tr>
            </tbody>
        </table>
        <a class="btn btn-primary" href="#" data-toggle="modal" data-target="#themPhanMem">
            Thêm phần mềm
        </a>
    </div>
    <div class="form-group">
        <label>Chọn phòng:</label>
        <select type="text" class="form-control" id="phong"
                style="display: inline; width: 20%; margin-left: 2%">
            <option value="">B101</option>
            <option value="">B102</option>
            <option value="">B201</option>
        </select>
    </div>
    <div class="form-group">
        <label>Chọn máy:</label>
        <select type="text" class="form-control" id="may"
                style="display: inline; width: 20%; margin-left: 2%">
            <option value="">M105</option>
            <option value="">M106</option>
            <option value="">M107</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
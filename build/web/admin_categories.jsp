<%-- 
    Document   : admin_categories
    Created on : Feb 20, 2024, 12:27:23 AM
    Author     : HuuThanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Danh sách sản phẩm | Quản trị Admin</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Main CSS-->
        <link rel="stylesheet" type="text/css" href="view/assets/admin/css/main.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <!-- or -->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

        <!-- Font-icon css-->
        <link rel="stylesheet" type="text/css"
              href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    </head>

   <body onload="time()" class="app sidebar-mini rtl">
    <!-- Navbar-->
    <%@include file="../../common/admin/sidebar.jsp"%>
    <main class="app-content">
        <div class="app-title">
            <ul class="app-breadcrumb breadcrumb side">
                <li class="breadcrumb-item active"><a href="#"><b>Danh sách danh mục</b></a></li>
            </ul>
            <div id="clock"></div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tile">
                    <div class="tile-body">
                        <div class="row element-button">
                            <div class="col-sm-2">
                                <a class="btn btn-add btn-sm" href="ManageCategoryServlet?action=Insert" title="Thêm">
                                    <i class="fas fa-plus"></i> Tạo mới danh mục
                                </a>
                            </div>
                            <div class="col-sm-2">
                                <button class="btn btn-delete btn-sm print-file" type="button" title="In" onclick="myApp.printTable()">
                                    In
                                </button>
                            </div>
                        </div>
                        <h3 style="color: green; text-align: center; margin: 20px 0">${requestScope.mess}</h3>
                        <table class="table table-hover table-bordered" id="sampleTable">
                            <thead>
                                <tr>
                                    <th>Mã</th>
                                    <th>Tên danh mục</th>
                                    <th>Loại</th>
                                    <th>Chức năng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${LIST_CATEGORIES}" var="c">
                                    <tr>
                                        <td>${c.id}</td>
                                        <td>${c.name}</td>
                                        <td>
                                            <c:forEach items="${requestScope.LIST_TYPES}" var="t">
                                                <c:if test="${c.type.id == t.id}">
                                                    ${t.name}
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td>
                                            <a class="btn btn-primary btn-sm trash" data-toggle="modal" data-target="#modal_box" href="#" onclick="confirmDelete('modal_box', ${c.id})">
                                                <i class="fas fa-trash-alt"></i>
                                            </a>
                                            <button class="btn btn-primary btn-sm edit" type="button" title="Sửa" data-toggle="modal" data-target="#ModalUP${c.id}">
                                                <i class="fas fa-edit"></i>
                                            </button>
                                        </td>
                                    </tr>

                                    <!-- Modal for Editing Category -->
                                    <div class="modal fade" id="ModalUP${c.id}" tabindex="-1" role="dialog" aria-labelledby="modalTitle${c.id}" aria-hidden="true" data-backdrop="static" data-keyboard="false">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="modalTitle${c.id}">Chỉnh sửa thông tin danh mục</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="EditCategoryServlet" method="GET">
                                                        <div class="form-group">
                                                            <label class="control-label">Mã danh mục</label>
                                                            <input class="form-control" type="text" readonly name="category_id" value="${c.id}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label">Tên</label>
                                                            <input class="form-control" type="text" name="category_name" value="${c.name}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="exampleSelect1" class="control-label">Danh mục</label>
                                                            <select name="type_id" class="form-control" id="exampleSelect1">
                                                                <c:forEach items="${LIST_TYPES}" var="type">
                                                                    <option ${c.type.id == type.id ? "selected" : ""} value="${type.id}">${type.name}</option>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button class="btn btn-save" type="submit">Lưu lại</button>
                                                            <button type="button" class="btn btn-cancel" data-dismiss="modal">Hủy bỏ</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </main>

    <div class="modal fade" id="modal_box" role="dialog" aria-labelledby="confirmDeleteTitle" aria-hidden="true"></div>

    <!-- Essential javascripts for application to work -->
    <script src="view/assets/admin/js/jquery-3.2.1.min.js"></script>
    <script src="view/assets/admin/js/popper.min.js"></script>
    <script src="view/assets/admin/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="view/assets/admin/js/main.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
    <script type="text/javascript" src="view/assets/admin/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="view/assets/admin/js/plugins/dataTables.bootstrap.min.js"></script>

    <script type="text/javascript">
        function confirmDelete(modalID, cid) {
            let modalElement = document.getElementById(modalID);
            let modalContent = `
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content" style="width:500px; margin: 0 auto">
                        <div class="modal-header" style="color: black; font-size:28px; font-weight: 600; margin: 15px auto">Cảnh báo</div>
                        <div class="modal-body">
                            <p>Bạn có chắc chắn là muốn xóa danh mục này?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy bỏ</button>
                            <a href="DeleteCategoryServlet?cid=${cid}" class="btn btn-danger">Xác nhận</a>
                        </div>
                    </div>
                </div>`;
            modalElement.innerHTML = modalContent;
        }

        // In
        var myApp = new function () {
            this.printTable = function () {
                var tab = document.getElementById('sampleTable');
                var win = window.open('', '', 'height=700,width=700');
                win.document.write(tab.outerHTML);
                win.document.close();
                win.print();
            };
        };
    </script>
</body>


</html>

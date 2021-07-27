    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib  prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <!DOCTYPE html>
        <html lang="en">
        <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" type="image/png" href="img/UTELOGO.png"/>

        <%--        Chosen multiselected--%>
        <link href="/css/chosen.min.css" rel="stylesheet">

        <!-- Custom fonts for this template-->
        <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="/css/sb-admin-2.min.css" rel="stylesheet">
        <script type="text/javascript" src="/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="/js/chosen.jquery.min.js"></script>
        </head>

        <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

        <%--    SideBar--%>
        <tiles:insertAttribute name="sidebar"/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

        <%--    TopBar--%>
        <tiles:insertAttribute name="topbar"/>
        <!-- Begin Page Content -->
        <div class="container-fluid">

        <tiles:insertAttribute name="body"/>

        </div>
        </div>

        <!-- End of Main Content -->

        <%--    Footer--%>
        <tiles:insertAttribute name="footer"/>
        </div>
        <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">×</span>
        </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
        <a class="btn btn-primary" href="/logout">Logout</a>
        </div>
        </div>
        </div>
        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="/vendor/jquery/jquery.min.js"></script>
        <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="/js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="/vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="/js/demo/chart-area-demo.js"></script>
        <script src="/js/demo/chart-pie-demo.js"></script>
            <script type="text/javascript">
            $(document).ready(function(){
            $('#phongmayId').on('change',function(){
            var phongmayId = $(this).val();
            $.ajax({
            type: 'GET',
            url: "/chonphong/" + phongmayId,
            success: function(result) {
            var result = JSON.parse(result);
            var s = '';
            for(var i = 0; i < result.length; i++) {
            s += '<option value="' + result[i].mamay + '">' + result[i].mamay + '</option>';
            }
            $('#maytinhId').html(s);
            }
            });

            });

            $('#phongmayId').on('change',function(){
            var phongmayId = $(this).val();
            $.ajax({
            type: 'GET',
            url: "/chonmay/" + phongmayId,
            success: function(result) {
            var result = JSON.parse(result);
            var s = '';
            for(var i = 0; i < result.length; i++) {
            s += '<option value="' + result[i].maphanmem + '">' + result[i].tenphanmem + '</option>';
            }
            $('#phanmemId').html(s);
            }
            });
            });
            });
            </script>
        <script type="text/javascript">
        $(".chosen-select").chosen();
        $('button').click(function(){
        $(".chosen-select").val('').trigger("chosen:updated");
        });
        </script>
        </body>

        </html>
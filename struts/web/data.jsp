
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Nunito:400,600,700,800&display=swap" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/css/dropify.css" rel="stylesheet">
    <title>Admin</title>
</head>
<body onload="loaduser();">
<div class="container">
    <div class="main-body" style="text-align: center">

        <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
            </ol>
        </nav>

        <div class="row gutters-sm">


            <div class="container col-md-10">
                <table class="table" id="tbl">
                    <thead>
                    <tr>
                        <th>Edit</th>
                        <th>ID</th>
                        <th>User Name</th>
                        <th>Email Address</th>
                        <th>Password</th>
                        <th>delete</th>
                    </tr>
                    </thead>
                    <tbody id="tblUser">
<%--                    <tr>--%>
<%--                        <td><button type='button' onclick='productDisplay(this);' class='btn btn-default click'>--%>
<%--                            <span class='glyphicon glyphicon-edit' /></button></td>--%>
<%--                        <td>1</td>--%>
<%--                        <td>sandun</td>--%>
<%--                        <td>Colombo</td>--%>
<%--                        <td>s@gmail.com</td>--%>
<%--                        <td>077-0297604</td>--%>
<%--                        <td><button type='button' onclick='productDelete(this);' class='btn btn-default'>--%>
<%--                            <span class='glyphicon glyphicon-remove' /></td>--%>
<%--                    </tr>--%>
                    </tbody>

                </table>
            </div>



            <div class="col-md-8 container">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">User ID</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" id="id1" disabled>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">User Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" id="username1" name="user_name">
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="email" id="email1" disabled >
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Password</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" id="password1" >
                            </div>
                        </div>

                        <hr>
                        <div class="row">
                            <div class="col-sm-12">
                                <button class="btn btn-outline-primary" id="updateUser">edit</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>


        </div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.0/sweetalert.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Dropify/0.2.2/js/dropify.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
    function loaduser(){
        clear();
        $("#tblUser").empty();
        $.ajax({
            url: 'loadData',
            dataType : "json",
            async: true,
            success: function (response,textState, xhr) {
                for (var i=0; i<response.length; i++) {
                        var row = "<tr><td>" + "<button type='button' onclick='productDisplay();' class='btn btn-default'>" +
                            "<span class='glyphicon glyphicon-edit' />" +
                            "</button>" + "</td>" +
                        "<td>" + response[i].id + "</td>" +
                        "<td>" + response[i].user_name + "</td>" +
                        "<td>" + response[i].email_address + "</td>" +
                            "<td>" + response[i].password + "</td>" +
                        "<td>"+
                            "<button type='button' onclick='productDelete();' class='btn btn-default'>" +
                            "<span class='glyphicon glyphicon-remove' />" +
                            "</button>"+
                        "</td></tr>" ;
                    $("#tblUser").append(row);
                    console.log(response[i].id);
                }
            }
        });
    }

    function productDisplay(){
        var table = document.getElementById('tbl');

        for(var i = 0; i < table.rows.length; i++)
        {
            table.rows[i].onclick = function()
            {
                document.getElementById("id1").value = this.cells[1].innerHTML;
                document.getElementById("username1").value = this.cells[2].innerHTML;
                document.getElementById("email1").value = this.cells[3].innerHTML;
                document.getElementById("password1").value = this.cells[4].innerHTML;
            };
        }
    }

    function productDelete(){
        var table = document.getElementById('tbl');


        for(var i = 0; i < table.rows.length; i++)
        {
            table.rows[i].onclick = function()
            {
                var id= this.cells[1].innerHTML;
                $.ajax({
                    type:"POST",
                    url:"deleteuser.action",
                    data:"id="+ id,
                    success: function(data){
                            alert(data.msg)

                    },
                    error:function(data){
                        alert("Some error occured.");
                        loaduser();
                    }
                });
            };
        }
    }


    $('#updateUser').click(function () {

        var id = $("#id1").val();
        var userName = $("#username1").val();
        var email = $("#email1").val();
        var password = $("#password1").val();

        console.log("hello")

        $.ajax({
            type:"POST",
            url:"updateuser.action",
            data:"id="+$("#id1").val()+"&user_name="+$("#username1").val()+"&email_address="+$("#email1").val()+
                "&password="+$("#password1").val(),
            success:function(result){
                var ht= result.msg;
            },
            error: function(result){
                alert("Some error occured.");
                loaduser();
            }
        });
    });

    function clear(){
        $("#id1").val("");
        $("#username1").val("");
        $("#email1").val("");
        $("#password1").val("");
    }
</script>
</body>
</html>

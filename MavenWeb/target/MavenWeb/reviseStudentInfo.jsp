<%@ page import="lyg.enetity.Student" %><%--<%@ page import="lyg.enetity.Student" %>&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: 李沅罡--%>
<%--  Date: 2021/3/23--%>
<%--  Time: 15:23--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<% Student student = (Student) request.getAttribute("student");%>--%>


<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>北城跑腿系统</title>
    <style type="text/css">
        *, *:before, *:after {
            box-sizing: border-box;
        }

        html {
            overflow-y: scroll;
        }

        body {
            background: #c1bdba;
            font-family: 'Titillium Web', sans-serif;
        }

        a {
            text-decoration: none;
            color: #1ab188;
            transition: .5s ease;
        }
        a:hover {
            color: #179b77;
        }

        .form {
            background: rgba(19, 35, 47, 0.9);
            padding: 40px;
            max-width: 600px;
            margin: 40px auto;
            border-radius: 4px;
            box-shadow: 0 4px 10px 4px rgba(19, 35, 47, 0.3);
        }

        .tab-group {
            list-style: none;
            padding: 0;
            margin: 0 0 40px 0;
        }
        .tab-group:after {
            content: "";
            display: table;
            clear: both;
        }
        .tab-group li a {
            display: block;
            text-decoration: none;
            padding: 15px;
            background: rgba(160, 179, 176, 0.25);
            color: #a0b3b0;
            font-size: 20px;
            float: left;
            width: 50%;
            text-align: center;
            cursor: pointer;
            transition: .5s ease;
        }
        .tab-group li a:hover {
            background: #179b77;
            color: #ffffff;
        }
        .tab-group .active a {
            background: #1ab188;
            color: #ffffff;
        }

        .tab-content > div:last-child {
            display: none;
        }

        h1 {
            text-align: center;
            color: #ffffff;
            font-weight: 300;
            margin: 0 0 40px;
        }

        label {
            position: absolute;
            -webkit-transform: translateY(6px);
            transform: translateY(6px);
            left: 13px;
            color: rgba(255, 255, 255, 0.5);
            transition: all 0.25s ease;
            -webkit-backface-visibility: hidden;
            pointer-events: none;
            font-size: 22px;
        }
        label .req {
            margin: 2px;
            color: #1ab188;
        }

        label.active {
            -webkit-transform: translateY(50px);
            transform: translateY(50px);
            left: 2px;
            font-size: 14px;
        }
        label.active .req {
            opacity: 0;
        }

        label.highlight {
            color: #ffffff;
        }

        input, textarea {
            font-size: 30px;
            display: block;
            width: 100%;
            height: 100%;
            padding: 5px 10px;
            background: none;
            background-image: none;
            border: 1px solid #a0b3b0;
            color: #ffffff;
            border-radius: 0;
            transition: border-color .25s ease, box-shadow .25s ease;
        }
        input:focus, textarea:focus {
            outline: 0;
            border-color: #1ab188;
        }

        .aaa {
            width: 20px;
            height: 20px;
        }

        textarea {
            border: 2px solid #a0b3b0;
            resize: vertical;
        }

        .field-wrap {
            position: relative;
            margin-bottom: 40px;
        }


        .top-row:after {
            content: "";
            display: table;
            clear: both;
        }
        .top-row > div {
            float: left;
            width: 48%;
            margin-right: 4%;
        }
        .top-row > div:last-child {
            margin: 0;
        }

        .button {
            border: 0;
            outline: none;
            border-radius: 0;
            padding: 15px 0;
            font-size: 2rem;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: .1em;
            background: #1ab188;
            color: #ffffff;
            transition: all 0.5s ease;
            -webkit-appearance: none;
        }
        .button:hover, .button:focus {
            background: #179b77;
        }

        .button-block {
            display: block;
            width: 100%;
        }

        .forgot {
            margin-top: -20px;
            text-align: right;
        }
    </style>
</head>
<body>
<div class="form" style="background-color: darkcyan;">
    <ul class="tab-group">
        <li class="tab">
            <a href="#signup">学员新增</a>
        </li>
        <li class="tab active"><a href="#login">学员信息修改</a></li>
    </ul>
    <div class="tab-content">
        <div id="signup">
            <h1>员工信息注册</h1>

            <form action="studentServlet?cmd=addStudent" method="post">
                <div class="field-wrap">
                    <label>
                        学员学号<span class="req">*</span>
                    </label>
                    <input type="text" name="sId" value="学号自动生成，不需要填写此栏" readonly>
                </div>
                <div class="field-wrap">
                    <label>
                        姓名<span class="req">*</span>
                    </label>
                    <input type="text" name="sName" >
                </div>
                <div class="field-wrap">
                    <label>
                        性别<span class="req">*</span>
                    </label>
                    <input type="text" name="sGender">
                </div>
                <div class="field-wrap">
                    <label>
                        出生日期<span class="req">*</span>
                    </label>
                    <input type="text" name="sBorn">
                </div>
                <div class="field-wrap">
                    <label>
                        邮箱<span class="req">*</span>
                    </label>
                    <input type="text" name="sEmail">
                </div>

                <button type="submit" class="button button-block" style="margin-button:300px;margin-top: 100px;">添加学员</button>
            </form>
        </div>

        <% Student student = (Student) request.getAttribute("student");%>
        <div id="login">
            <form action="studentServlet?cmd=reviseUpdate" method="post">
                <h1>学员信息修改</h1>
                <div class="field-wrap">
                    <label>
                        学员学号<span class="req">*</span>
                    </label>
                    <input type="text" name="sId" value="<%=student.getsId()%>" readonly>
                </div>
                <div class="field-wrap">
                    <label>
                        姓名<span class="req">*</span>
                    </label>
                    <input type="text" name="sName" value= "<%=student.getsName()%>">
                </div>
                <div class="field-wrap">
                    <label>
                        性别<span class="req">*</span>
                    </label>
                    <input type="text" name="sGender"value= "<%=student.getsGender()%>">
                </div>
                <div class="field-wrap">
                    <label>
                        出生日期<span class="req">*</span>
                    </label>
                    <input type="text" name="sBorn"value= "<%=student.getsBorn()%>">
                </div>
                <div class="field-wrap">
                    <label>
                        邮箱<span class="req">*</span>
                    </label>
                    <input type="text" name="sEmail"value= "<%=student.getsEmail()%>">
                </div>

                <button class="button button-block"/>修改</button>
            </form>

        </div>
    </div>
</div>
<!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script  >
    $('.form').find('input, textarea').on('keyup blur focus', function (e) {

        var $this = $(this),
            label = $this.prev('label');

        if (e.type === 'keyup') {
            if ($this.val() === '') {
                label.removeClass('active highlight');
            } else {
                label.addClass('active highlight');
            }
        } else if (e.type === 'blur') {
            if( $this.val() === '' ) {
                label.removeClass('active highlight');
            } else {
                label.removeClass('highlight');
            }
        } else if (e.type === 'focus') {

            if( $this.val() === '' ) {
                label.removeClass('highlight');
            }
            else if( $this.val() !== '' ) {
                label.addClass('highlight');
            }
        }

    });

    $('.tab a').on('click', function (e) {

        e.preventDefault();

        $(this).parent().addClass('active');
        $(this).parent().siblings().removeClass('active');

        target = $(this).attr('href');

        $('.tab-content > div').not(target).hide();

        $(target).fadeIn(600);

    });
</script>
</body>
</html>

 var InterValObj; //timer变量，控制时间
        var count = 60; //间隔函数，1秒执行
        var curCount;//当前剩余秒数
//        var code = ""; //验证码
//        var codeLength = 6;//验证码长度
        function sendMessage() {
            curCount = count;
//            var dealType; //验证方式
//            var uid=$("#uid").val();//用户uid
//            if ($("#phone").attr("checked") == true) {
//                dealType = "phone";
//            }
//            else {
//                dealType = "email";
//            }
            //产生验证码
//            for (var i = 0; i < codeLength; i++) {
//                code += parseInt(Math.random() * 9)+"";
//            }
            //设置button效果，开始计时
            $("#get_pass").attr("disabled", "true");
            $("#get_pass").val("请在" + curCount + "秒内输入");
            InterValObj = window.setInterval(SetRemainTime, 1000); //启动计时器，1秒执行一次
        //向后台发送处理数据
            var email = {
                    "email": $("input[name='email']").val()
                }
            $.ajax({
                type: "POST", //用POST方式传输
                url:"/Store/emailcode", //目标地址 是一个servlet
                data:email,
                error: function (XMLHttpRequest, textStatus, errorThrown) { },
                success: function (msg){ 
                	
                }
            });
        }
        //timer处理函数
        function SetRemainTime() {
            if (curCount == 0) {
                window.clearInterval(InterValObj);//停止计时器
                $("#get_pass").removeAttr("disabled");//启用按钮
                $("#get_pass").val("重新发送验证码");
                code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效
            }
            else {
                curCount--;
                $("#get_pass").val("请在" + curCount + "秒内输入验证码");
            }
        }
//        /* 点击验证码改变有验证码的Js事件 */
//        function changeImage(){
//            /* 调用servlet进行显示 */
//            document.getElementById("image").src = "ChecKImageServlet?"+ new Date().getTime();
//        }
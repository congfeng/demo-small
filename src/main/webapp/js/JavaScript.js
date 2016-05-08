$(function(){ 

    // 微信消息数量
    $.ajax({
         type: 'POST',
         datatype:"json",
         url: "talk/init",
         success:function(data){
           $(".top_n").text(data.userNick);
         }
    });

    $("#menu li").click(function(){
       $(this).addClass("cur").siblings().removeClass("cur");
       $(".con").eq($(this).index()).show().siblings().hide();
    });


    //注册+重置
    $("#submit1").on("click",function(){ 
         var username = $("#name1").val();
         var password = $("#password1").val();
         $.ajax({
              type: 'POST',
              datatype:"json",
              url: "user/register",
              data: {username:username,password:password},
              success:function(data){
                  console.log(data);
                  if(data.s==0){
                      alert("失败信息"+data.m);
                  }else{
                      window.location.href="weixin.html";
                  }
              }
         });
    });

    $("#submit2").on("click",function(){ 
         var username = $("#name2").val();
         var password = $("#password2").val();
         var newPassword1 = $("#password3").val();
         var newPassword2 = $("#password4").val();

         $.ajax({
              type: 'POST',
              datatype:"json",
              url: "user/resetPassword",
              data: {username:username,password:newPassword1},
              success:function(data){
                  console.log(data);
                  if(username.password||newPassword1==newPassword2){
                        alert("重置成功")
                  }else{
                        alert("失败信息"+data.newPassword);
                  }  
              }
         });
    });


    // 登录
    $("#btn").on("click",function(){
         var username = $("#username").val();
         var password = $("#password").val();
         $.ajax({
              type: 'POST',
              datatype:"json",
              url: "profile/login",
              data: {username:username,password:password},
              success:function(data){
                  console.log(data);
                  if(data.s==0){
                      alert("失败信息"+data.m);
                  }else{
                      window.location.href="me.html";
                  }
              }
         });
    });

    
    //me
    $.ajax({
          type: 'POST',
          datatype:"json",
          url: "profile/info",
          success:function(data){
            $(".name").text(data.userNick);
            $(".number-user").text(data.userNum);
            $(".user-pic img").attr("src",data.userPortrait);
          }
    });


})
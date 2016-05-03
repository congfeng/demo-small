$(function(){ 
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
    })

})
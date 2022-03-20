$(function () {
    var flag = null;
    var i = null;
    $(".top>li ul").addClass("active");
    $(".item").click(function(){
        flag = $(this).parents("li").index(); 
        var i = flag + 1;
        if($(".top>li:nth-of-type("+ i +") ul").hasClass("active")){
            $(".top>li:nth-of-type("+ i +") ul").removeClass("active").parents("li").siblings().children("ul").addClass("active");
        }else{
            $(".top>li:nth-of-type("+ i +") ul").addClass("active");
        }
        return flag;
        return i;
    })

})
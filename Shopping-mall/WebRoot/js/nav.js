$(function () {
    $(".nav_head li:nth-of-type(1) a:nth-of-type(1)").addClass('active_a');
    $(".nav_head li:nth-of-type(1)").addClass('active_li');
    $(".item").click(function(){
        flag = $(this).index(); 
        var i = flag + 1;
        $("ul:nth-of-type("+ i +")").show().siblings("ul").hide();
        $(".nav_head li:nth-of-type("+i+")").addClass("active_li").siblings().removeClass("active_li");
        $(".nav_head li:nth-of-type("+i+") a:nth-of-type(1)").addClass("active_a").parents("li").siblings().children("a").removeClass("active_a");
    })

})
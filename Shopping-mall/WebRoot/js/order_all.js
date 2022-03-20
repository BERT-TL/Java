$(function () {
    $(".nodo").hide();
    $(".sale").mousedown(function () {
    	var name = $(".name").html();
    	window.location.href = "Mygoods?op="+yes+"&name="+name+"";
    	
        var i = $(this).index();
        $(this).parents(".doit").hide();
        $(this).parents(".doit").siblings(".nodo").show().children(".do_sale").show().siblings(".do_delete").hide();
    })

    $(".delete").mousedown(function () {
    	var name = $(".name").html();
    	window.location.href = "Mygoods?op="+no+"&name="+name+"";
        var i = $(this).index();
        $(this).parents(".doit").hide();
        $(this).parents(".doit").siblings(".nodo").show().children(".do_delete").show().siblings(".do_sale").hide();
    })
})
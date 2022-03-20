
$(function(){
	// 全选按钮
	$(".checkAll").change(function(){
		$(".m_check,.checkAll").prop("checked",$(this).prop("checked"));
		if($(this).prop("checked")){
			$(".main").addClass("bg_color");
		}else{
			$(".main").removeClass("bg_color");
		}
		getSum();
	});
	// 选择功能
	$(".m_check").change(function(){
		if($(".m_check:checked").length === $(".m_check").length){
			$(".checkAll").prop("checked",true);
		}else{
			$(".checkAll").prop("checked",false);
		}
		if($(this).prop("checked")){
			$(this).parents(".main").addClass("bg_color");
		}else{
			$(this).parents(".main").removeClass("bg_color");
		}
		getSum();
	});
	// 数量加功能
	$(".increase").click(function(){
		var n = $(this).siblings(".t_val").val();
		n++;
		$(this).siblings(".t_val").val(n);
		var p = $(this).parents(".m_num").siblings(".m_price").html().substr(1);
		var price = (p * n).toFixed(2);
		$(this).parents(".m_num").siblings(".m_sum").html("￥"+price);
		getSum();
	});
	// 数量减功能
	$(".decrease").click(function(){
		var n = $(this).siblings(".t_val").val();
		if(n==1){
			return false;
		}
		n--;
		$(this).siblings(".t_val").val(n);
		var p = $(this).parents(".m_num").siblings(".m_price").html().substr(1);
		var price = (p * n).toFixed(2);
		$(this).parents(".m_num").siblings(".m_sum").html("￥"+price);
		getSum()
	});
	// 直接改变数量功能
	$(".t_val").keyup(function(){
		var n = 0,
            p = $(this).parents(".m_num").siblings(".m_price").html().substr(1), 
            price = 0;
        if($(this).val()==''){
            $(this).val('1');
        }
        $(this).val($(this).val().replace(/\D|^0/g,''));
        n = $(this).val();
        price = (p * n).toFixed(2);
        $(this).attr('value',n);
        $(this).parents(".m_num").siblings(".m_sum").html('￥'+price);
		getSum();
	})
	
	// 结算功能
	function getSum(){
		var count = 0;
		var money = 0;
		$(".m_check").each(function(){	
			if($(this).prop("checked")){
				var goods = parseInt($(this).parents(".m_checkbox").siblings(".m_num").find(".t_val").val());
				var sum = parseFloat($(this).parents(".m_checkbox").siblings(".m_sum").text().substr(1));
				count += goods;
				money += sum;
			}
		});
		$(".s_goods em").text(count);
		$(".t_sum em").text("￥" + money.toFixed(2));
		
		if(count!=0 && money!=0){
            if(!$(".t_submit a").hasClass('submit_bg')){
                $(".t_submit a").addClass('submit_bg');
            }
        }else{
            if($(".t_submit a").hasClass('submit_bg')){
                $(".t_submit a").removeClass('submit_bg');
            }
        }
	}

	//是否有数据
	if( ($(".prompt").html() == "")||($(".prompt").html() == "null")){ 
        $(".prompt").hide();
        $("table").show();
    }else{
        $("table").hide();
        $(".prompt").show();
    }
	
	// 删除操作
	$(".m_action a").click(function(){
		$(this).parents(".main").remove();
		getSum();
	});
	$(".clearSome").click(function(){
		$(".m_check:checked").parents(".main").remove();
		getSum();
	});
	$(".clearAll").click(function(){
		$(".main").remove();
		getSum();
	});
	
	
	// 支付
	$(".pay").hide();

	$(".t_submit a").click(function () {
			$(".pay").show();
			$(".money").html($(".t_sum em").html());
	});

	$(".t_submit a").on("click", function(e){
		$(".pay").show();
	
		$(document).one("click", function(){
			$(".pay").hide();
		});
	
		e.stopPropagation();
	});
	$(".pay").on("click", function(e){
		e.stopPropagation();
	});
	
})


        //联动事件
        var kindArr = ['电子产品', '生活用品', '学习用品', '其他分类'];
        var detailArr = [
                ['手机', '电脑', '相机', '耳机', '充电线','其他'],
                ['衣服', '洗衣液', '书桌', '其他'],
                ['考研资料', '专业资料', '文学小说', '文具用品','其他'],
                ['健身器材', '花卉', '其他']
        ];

        //第一种方法
        var kind = document.getElementById('kind'),
            detail = document.getElementById('detail');

        //种类的获取
        var kindStr = '';
        for (var i = 0; i < kindArr.length; i++) {
        
            kindStr += '<option value=' + kindArr[i] + '>' + kindArr[i] + '</option>';
        
           }
           kind.innerHTML = kindStr;

           //index 属性可返回下拉列表中选项的索引位置
        var x=document.getElementById("kind").selectedIndex;
        var y=document.getElementById("kind").options;

       
       
        //具体分类的获取
        var detailStr = '';
        for (var i = 0; i < detailArr[y[x].index].length; i++) {
        
            detailStr += '<option>' + detailArr[y[x].index][i] + '</option>';

        }
        detail.innerHTML = detailStr;
    
    
        //联动事件
        kind.onchange = function () { //学院改变 ---专业会变

            //index 属性可返回下拉列表中选项的索引位置
            var x=document.getElementById("kind").selectedIndex;
            var y=document.getElementById("kind").options;
        
            var detailStr = '';
            for (var i = 0; i < detailArr[y[x].index].length; i++) {
            
                detailStr += '<option>' + detailArr[y[x].index][i] + '</option>';
            }
            detail.innerHTML = detailStr;
        }   


// 判断所有的输入值是否符合规则

//检测商品名称是否符合规则
function checkName(){  
    var name = document.getElementById("name").value;  
    var spanNode = document.getElementById("nameSpan");  
    //商品名称的规则： 昵称的长度为1-15，包含任意的字母、数字、中文，不可以使用其他符号
    var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9]){1,15}$/i;      
    if(reg.test(name)){  
        //符合规则   
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "商品名称只能是任意的字母、数字、中文";  
        return false;  
    }     
}   
//2.检查价格
function checkPrice(){  
    var price = document.getElementById("price").value;  
    var spanNode = document.getElementById("priceSpan");  
    //价格的规则： 只能是数字
    var reg = /^([0-9]){1,}$/i;      
    if(reg.test(price)){  
        //符合规则  
        return true;  
    }else{  
        //不符合规则  
        spanNode.innerHTML = "价格只能是数字";    
        return false;  
    }     
}   
//3.检查数量  
function checkNum(){  
    var num = document.getElementById("num").value;  
    var spanNode = document.getElementById("numSpan");  
       //检测数量 
    var reg = /^[^0]([0-9]){0,}$/i;   
    if(reg.test(num)){  
        //符合规则    
        return true;  
    }else{  
        //不符合规则   
        spanNode.innerHTML = "数量只能是数字，且开头不能为0，请重新填写！";  
        return false;  
    }     
}  

    //8.检查用户所有的输入的所有是否符合规则
    function checkAll(){  
        var name = checkName();  
        var price = checkPrice();  
        var num = checkNum();  
        if(name&&price&&num){  
            return true;  
        }else{  
            return false;  
        } 
    }    

       
    //重置按键
    $(function () {
        $("#reset").click(function () {
            for(var i=0; i<3; i++){
                $("li>span")[i].innerHTML="";
            }
        })
    
         // 当再次获取焦点时，提醒消失
        $("#name").focus(function () {
            $("#nameSpan")[0].innerHTML=" ";
        })
        $("#price").focus(function () {
            $("#priceSpan")[0].innerHTML=" ";
        })
        $("#num").focus(function () {
            $("#numSpan")[0].innerHTML=" ";
        })
    
               
    })
    

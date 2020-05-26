//使用js实现鼠标单选中被选项
$(function(){
    $("li").click(function() {
        $(this).siblings('li').removeClass('checked');    // 删除其他li的边框样式
        $(this).addClass('checked');                            // 为当前li添加边框样式
    });
    $('#up').click(function() {
    	var num = document.getElementById("num");
    	 num.value = parseInt(num.value) + 1;
    });
    $('#down').click(function() {
    	var num = document.getElementById("num");
    	if(num.value>0){
       	 num.value = parseInt(num.value) - 1;
    	}
    });
});
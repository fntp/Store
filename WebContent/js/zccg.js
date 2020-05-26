 window.onload = load();
function load()
{
	   $.ajax({
           type: "POST", //用POST方式传输
           url:"/Store/Success", //目标地址 是一个servlet
           error: function (XMLHttpRequest, textStatus, errorThrown) { },
           success: function (msg){ 
           	$('#welcome').html(msg);
           	$('#register').css("display","none");
           	$('#hreflogin').attr('href','#');
           }
       });
	   
}

window.onload = load();
function load()
{
	   $.ajax({
           type: "POST", //用POST方式传输
           url:"/Store/list", //目标地址 是一个servlet
           error: function (XMLHttpRequest, textStatus, errorThrown) { },
           dataType:"json",
           success: function (data){    
           	if(data.shangpinname!=null&&data.price!=null&&data.maijia!=null){
           		$('#tishi').css("display","none");
           		if(data.maijia=="珠韵首饰"){
           			$('#dier').css("display","none");
           			maijia1=data.maijia;
           			document.getElementById("maijia1").innerText = data.maijia;	
//           			document.getElementById("price1").innerText = data.price;	
//           			$("#price1").html(data.price);
           			name1=data.shangpinname;
           			document.getElementById("name1").innerText = data.shangpinname;	
           		}else if(data.maijia=="海瞳首饰"){
           			console.log(maijia1+""+name1);
           			document.getElementById("maijia1").innerText ="珠韵首饰";
           			document.getElementById("name1").innerText ="珠韵首饰冰韵天然白色正圆S925银扣珍珠项链";
           			document.getElementById("maijia2").innerText = data.maijia;							
//           			document.getElementById("price2").innerText = data.price;	
           			document.getElementById("name2").innerText = data.shangpinname;	
           	}
           }else{
              	$('#shoplist').css("display","none");
           }
           }
       });
	   
}
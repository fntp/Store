					var maijia=null;
					var img=null;
					var name = null;
					var price = null;
					var chima=null;
					var color=null;
				$(document).ready(function(){
			//根据ul的id来获取下面所有的li元素 并且为每个li配置点击事件
			              $("#cmlb li").click(function(){
			//获取选中的li里面的值
			              chima=$(this).text(); 
			//把值放在span里面，显示
//			                   $("#tresult").text(v);
			            
//							window.alert("chima是："+chima);
			              })  			              
			       })
			    $(document).ready(function(){
			       $("#yslb li").click(function(){
			            	 color=$(this).text(); 
//			            	  window.alert("color是："+color);
			             }) 
			     })
			 $('#sub').on('click', function(){  
//				 window.alert("点击按钮好使");
			 var spname=document.getElementById('spname');
			 name=spname.innerText;
			 var sprice=document.getElementById('price');
			 price=sprice.innerText;
			 img=document.getElementById("img").src;
			 var mj =document.getElementById('maijia');
			 maijia=mj.innerText;
	    	 var num = document.getElementById("num").value;
	    	 console.log("数量是："+num)
			 $.ajax({
	                type: "POST", //用POST方式传输
	                url:"/Store/shopcart", //目标地址 是一个servlet
	                data:{"chima":chima,"color":color,"number":num,"name":name,"price":price,"img":img,"maijia":maijia},
	                async:false,
			        dataType:"json",
	                error: function (XMLHttpRequest, textStatus, errorThrown) { },
	                success: function (msg){ 
	                	if(msg){
//	                		 window.location.href = 'cgaddtocart.html';
	                		window.alert("鑫软心选提示您！已成功添加至购物车！");
	                		window.location.href = 'searchList.html';
	                	}
	                }
	            });

	     }); 
			   
				
				
		
				
		            
//				<!-- 	<script src="js/detail.js" charset="UTF-8"></script>
//				<script src="js/dpost.js" charset="UTF-8"></script> -->
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
		            
//		            
//		     				var chima = null;
//				var color = null;
//				var  num  = null;
//				$(document).ready(function(){
//			//根据ul的id来获取下面所有的li元素 并且为每个li配置点击事件
//			              $("#cmlb li").click(function(){
//			//获取选中的li里面的值
//			              chima=$(this).text(); 
//			//把值放在span里面，显示
////			                   $("#tresult").text(v);
//			              }) 
//			             $("#yslb li").click(function(){
//			            	color=$(this).text(); 
//			             }) 
//			              			              
//			       })
//				$(function pd(){
//			    num = document.getElementById("num").value;
//				window.alert("color是："+color);
//				window.alert("chima是："+chima);
//				window.alert(+"num是："+num);
//				 $.ajax({
//		                type: "POST", //用POST方式传输
//		                url:"/Store/shopcart", //目标地址 是一个servlet
//		                data:{"chima":chima,"color":color,"number":num},
//		                async:false,
//				        dataType:"json",
//		                error: function (XMLHttpRequest, textStatus, errorThrown) { }
//		            });})
			       
		            
		            
		            
		            
/*****************************************************************************
 * Copyright (c) 2015, www.qingshixun.com
 *
 * All rights reserved
 *
 *****************************************************************************/
/**
 * 自定义搜索js
 *
 * ****************************************************************************/

$(function(){
 
 $('.ss1').bind('keypress',function(event){
	 event.preventDefault();
	 if(event.keyCode == "13")    
	 {
	  var name =$('.ss1').val()
	  alert(name)
	 }
	 $.ajax({
		 async:false,
		  url:'sach',
		  data:{name:name},
		
		  type: 'POST',
		  success: function (res) {
	   
	      }
		  
		   });
 });
});



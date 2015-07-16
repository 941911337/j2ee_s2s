$(function() {
	$("#username").change(ajax_name);
	$("#btn_submit").click(check)
})

function ajax_name() {
	$.post("ajax.do",{account : $("#username").val(),flag:"register"}, function(data){
		var obj = eval('('+data+')');
		if(obj!=null)
		{
			$("#tip_name").text("帐号已存在");
			$("#flag").val("false");
		}
		else{
			$("#tip_name").text("帐号可以使用");
			$("#flag").val("true");
		}
	})
}
function check() {
	var flag= $("#flag").val();
	if($("#username").val()=="")
	{
		alert("帐号不能为空");
		return false;
	}
	if($("#password").val()=="")
	{
		alert("密码不能为空");
		return false;
	}
	if($("#surepwd").val()=="")
	{
		alert("确认密码不能为空");
		return false;
	}
	if($("#surepwd").val()!=$("#password").val())
	{
		alert("两次密码不一致");
		return false;
	}
	
	if($("#email").val()!="")
	{
		checkMail();
	}
	
	if($("#flag").val() == 'false')
	{
		return false;
	}
	
	
}
function checkMail() {
	 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 var mail=$("#email").val();
	 if (filter.test(mail)) {
		 return true;
	 }
	 else {	 
		 alert('您的电子邮件格式不正确');
	 	$("#flag").val("false");
	 }
}

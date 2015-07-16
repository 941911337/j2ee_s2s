$(function() {
	$("#username").change(ajax_name);
	$("#btn").click(check)
})
function ajax_name() {
	var flag=$("#flag").val();
	if($("#username").val()!="")
	{
		$.post("ajax.do",{account :$("#username").val(), flag:"login"},function(data){
			var obj=eval('('+data+')')
			if(obj==null)
			{
				$("#tip1").text("帐号不存在");
				$("#flag").val("false");
			}
			else{
				$("#tip1").text("");
				$("#flag").val("true");
			}
		});
	}
	
}


function check() {
	
	if($("#username").val()=="")
	{
		alert("帐号不能为空");
		return false;
	}
	else if($("#password").val()=="")
	{
		alert("密码不能为空");
		return false;
	}
	else if($("#username").val()!="")
	{
		$.post("ajax.do",{account :$("#username").val(),password :$("#password").val() ,flag:"login"},function(data){
			var obj=eval('('+data+')')
			if(obj==null )
			{
				$("#flag").val("false");
				$("#tip2").text("密码不正确");
				return false;
			}
			else{
				$("form").submit();
			}
		});
	}
	
	
	
}
$(function() {
	$("#oldpwd").change(ajax_oldpwd);
	$("#btn_submit").click(submit1);
})


function ajax_oldpwd() {
	$.post("ajax.do",{flag:"editpwd",password:$("#oldpwd").val()},function(data){
		var obj=eval('('+data+')');
		if(obj==null)
		{
			$("#tip_pwd").text("密码错误");
			$("#flag").val("false");
		}
		if(obj!=null)
		{
			$("#tip_pwd").text("");
			$("#flag").val("true");
		}
	})
}
function submit1() {
	
	if($("#oldpwd").val()=="")
	{
		alert("旧密码不能为空");
		return false;
	}
	if($("#newpwd").val()=="")
	{
		alert("新密码不能为空");
		return false;
	}
	if($("#confirmpwd").val()=="")
	{
		alert("确认密码不能为空");
		return false;
	}
	if($("#oldpwd").val()==$("#newpwd").val())
	{
		alert("新旧密码不能一致");
		return false;
	}
	if($("#newpwd").val()!=$("#confirmpwd").val())
	{
		alert("新密码确认密码不一致");
		return false;
	}
	if($("#flag").val()=="false"){
		alert("submit");
		return false;
	};
	
}
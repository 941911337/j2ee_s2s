$(function() {
		$("#sub_btn").click(check);
		$("#btn").click(back);
	});


function check() {
	var title=$("#title").val();
	if(title=="")
	{
		alert("标题不能为空!!!");
		return false;
	}
}
function back() {
	window.location.href="personal/personal!newsList";
}
$(document).ready(function() {
	
	const contextPath = sessionStorage.getItem("contextpath");
	
	$(document).on("click", "input:radio[name='result']", function(){
		let id = $(this).attr('id');
		
		let data = {"id" : id};
		$.ajax({
			url : `${contextPath}/searchAdmin`,
			type : "post",
			data : JSON.stringify(data),
			dataType : "json",
			contentType : "application/json",
			success : function(result){
				let strContent = "<td>" + result[0].a_name + "</td>" +
				"<td>" + result[0].a_phone + "</td>"
				$("#content").html(strContent);
			},
			error : function(error){
				alert(error.status.Text);
			}
		})
	})
	
	
	$("#search").on("click", function() {
		$.ajax({
			url : `${contextPath}/searchData`,
			type : "post",
			contentType : "application/json",
			success : function(data){
				for(let i=0; i < data.length; i++){
					if(i == 0){
						let str = "<label><input type='radio' id='" +
						data[i].a_id + "' " + 
						"name = 'result' class='result' checked>" + 
						data[i].a_id +
						"</label><br>"
						
						$("#result").append(str);
						let strContent = "<td>" + data[i].name + "</td><td>" +
						data[i].a_phone + "</td>"
						$("#content").html(strContent);
					} else {
						let str = "<label><input type='radio' id='" + 
							data[i].a_id + "' name='result' >" +
							data[i].a_id +"</label><br>";
						$("#result").append(str);
					}
				}
			},
			error : function(error){
				alert(error.status.Text);
			}
		})
	});
	
	
	$("#AjaxTest").on("click", function() {
		let data = {
			"player" : "son",
			"age" : "30"
		};
		$.ajax({
			url : `${contextPath}/goTest`,
			type : "post",
			data : JSON.stringify(data),
			dataType : "json",
			contentType : "application/json",
			success : function(result) {
				alert(result.goal);
			},
			error : function(error) {
				alert(error.statusText);
			}
		})
	})
})

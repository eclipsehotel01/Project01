$(document).ready(
			function() {
				$("#showlist").click(function() {
					location.href = "open_reserve_list"
				});
				$("#delreserve").click(
						function() {
							location.href = "del_reserve?reservecode="
									+ $("#reservecode").val()
						});
				$("#updatereserve").click(
						function() {
							location.href = "updatereserve?reservecode="
									+ $("#reservecode").val() + "&m_num="
									+ $("#m_num").val() + "&rnum="
									+ $("#rnum").val()
						});
			});
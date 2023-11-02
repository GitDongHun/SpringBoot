$(document).ready(function (e) {
    var regex = new RegExp("(.*?)\.(jpg|jpeg|png|gif|bmp)$");
    var maxSize = 5242880;  // 5MB

    function checkExtention (fileName, fileSize) {
        if (fileSize >= maxSize) {
            alert("파일 사이즈 초과");
            return false;
        }

        if (!regex.test(fileName)) {
            alert("해당 종류의 파일은 업로드할 수 없습니다.");
            return false;
        }

        return true;
    }

    function showUploadResult(data) {
        if (!uploadResultArr || uploadResultArr.length == 0) { return; }

        var uploadUL = $(".uploadResult ul");
        uploadUL.empty();

        var str = "";

        data.forEach(function (fileInfo) {
            var liElement = $("<li>");
            liElement.attr("data-path", fileInfo.uploadFilePath);
            liElement.attr("data-uuid", fileInfo.uuid);

            var divElement = $("<div>");

            var buttonElement = $("<button>");
            buttonElement.attr("type", "button");
            buttonElement.attr("data-file", fileInfo.uploadFilePath);
            buttonElement.addClass("btn btn-warning btn-circle");

            var iElement = $("<i>");
            iElement.addClass("fa fa-times");

            var imgElement = $("<img>");
            imgElement.attr("src", fileInfo.uploadFilePath);

            buttonElement.append(iElement);
            divElement.append(buttonElement).append("<br>").append(imgElement);
            liElement.append(divElement);
            uploadUL.append(liElement);
        });
    }
            
    // 파일 선택이 변경되었을 때 AJAX 호출
	$("#files").on("change", function () {
		console.log("file changed");

		var formData = new FormData();
		var files = $(this).get(0).files;

		for (var i = 0; i < files.length; i++) {
            if (!checkExtention(files[i].name, files[i].size)) {
                return false;
            }
			formData.append("files", files[i]);
		}
		
		$.ajax({
			url: "/foodexp/upload",
			type: "POST",
			data: formData,
			processData: false,
			contentType: false,
			success: function (data) {
				var responseDiv = $("#response");
				responseDiv.empty()
				data.forEach(function (fileInfo) {
					var fileElement = $("<div>");
					fileElement.text("File Name: "+ fileInfo.uploadFileName+"file path:" + fileInfo.uploadFilePath);
					responseDiv.append(fileElement);
				});
			}
		});
	});

});
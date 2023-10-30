function openModal() {
	var modal = document.getElementById("myModal");
	modal.style.display = "flex";
}

// 모들 우측 상부 X 버튼으로 닫기
function closeModal() {
	var modal = document.getElementById("myModal");
	modal.style.display = "none";
}
		
// DOM 먼저 로드하기
document.addEventListener("DOMContentLoaded", function() {
	// 모달 닫기 (취소 버튼)
	document.getElementById("cancleBtn").addEventListener("click", closeModal);
	
	// 모달 닫기 (선택 완료 버튼)
	document.getElementById("submitBtn").addEventListener("click", function() {
	document.getElementById("myModal").style.display = "none";
	// 여기에 선택 완료 버튼을 클릭했을 때 수행할 작업을 추가하세요.
	var h_area1Value = document.getElementById("h_area1").value;
	var h_area2Value = document.getElementById("h_area2").value;
	
	// URL 생성		-------> 	수정 필요
    var searchUrl = "@{/foodexp/rst(h_area1=${h_area1Value}, h_area2=${h_area2Value})}"; 
    

    // 페이지 이동
    window.location.href = searchUrl;
	});
});

// 모달 외부를 클릭하여 모달 닫기
window.onclick = function(event) {
	if (event.target == document.getElementById("myModal")) {
		document.getElementById("myModal").style.display = "none";
	}
};
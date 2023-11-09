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
    
        // 선택한 h_area1과 h_area2의 텍스트 값을 가져오기
        var h_area1Select = document.getElementById("h_area1");
        var h_area1Text = h_area1Select.options[h_area1Select.selectedIndex].text;

        var h_area2Select = document.getElementById("h_area2");
        var h_area2Text = h_area2Select.options[h_area2Select.selectedIndex].text;
    
        // nav 태그 안의 input 요소에 값을 설정
        document.getElementById("searchinput").value = h_area1Text + " " + h_area2Text;
        
        
        // 검색 실행 (선택한 값으로 자동 검색)
        // 버튼 자동 클릭 (검색 버튼을 id로 선택하고 클릭)
        var searchButton = document.getElementById("searchbtn");
        if (searchButton) {
            searchButton.click();
            console.log("지도 전국 기준으로 수정해야 함");
        }
    });
    
    // 모달 외부를 클릭하여 모달 닫기
    window.onclick = function(event) {
        if (event.target == document.getElementById("myModal")) {
            document.getElementById("myModal").style.display = "none";
        }
    };
});




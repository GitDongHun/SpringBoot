//var region_data = require("/region_data.js");
console.log("main.js 실행완료");

var region_data = [{
    "h_area1": "강원도",
    "h_area2": "강릉시",
    "h_area3": [
        "강남동",
        "강동면",
        "경포동",
        "교1동",
        "교2동",
        "구정면",
        "내곡동",
        "사천면",
        "성덕동",
        "성산면",
        "송정동",
        "연곡면",
        "옥계면",
        "옥천동",
        "왕산면",
        "주문진읍",
        "중앙동",
        "초당동",
        "포남1동",
        "포남2동",
        "홍제동"
    ]
}];

























document.addEventListener("DOMContentLoaded", function () {
    var openModalBtn = document.getElementById("openModal");
    var closeModalBtn = document.getElementById("closeModal");
    var modal = document.getElementById("myModal");

    // 모달 창 열기
    function openModal() {
        modal.style.display = "flex";
    }

    // 모달 닫기
    function closeModal() {
        modal.style.display = "none";
    }

    // 모달 열기 버튼에 클릭 이벤트 리스너 추가
    openModalBtn.addEventListener("click", function () {
        openModal();
    });

    closeModalBtn.addEventListener("click", function () {
        closeModal();
    });


    // 모달 닫기 (취소 버튼)
    document.getElementById("cancleBtn").addEventListener("click", function (event) {
        event.preventDefault(); // 기본 동작 중지
        closeModal();
    });

    // 모달 닫기 (선택 완료 버튼)
    document.getElementById("submitBtn").removeEventListener("click", handleSubmitClick);

    document.getElementById("submitBtn").addEventListener("click", handleSubmitClick);

    function handleSubmitClick(event) {
        event.preventDefault(); // 기본 동작 중지

        var h_area1Select = document.getElementById("h_area1");
        var h_area2Select = document.getElementById("h_area2");
        var h_area3Select = document.getElementById("h_area3");

        if (h_area1Select.value === "" || h_area2Select.value === "" || h_area3Select.value === "") {
            alert("지역을 선택하세요!");
            return; // 선택되지 않은 경우, 이후의 코드 실행을 막음
        }

        var h_area1Text = h_area1Select.options[h_area1Select.selectedIndex].text;
        var h_area2Text = h_area2Select.options[h_area2Select.selectedIndex].text;
        var h_area3Text = h_area3Select.options[h_area3Select.selectedIndex].text;

        document.getElementById("searchinput").value = h_area1Text + " " + h_area2Text + " " + h_area3Text;

        closeModal();

        // 검색 실행 (선택한 값으로 자동 검색)
        var searchButton = document.getElementById("searchbtn");
        if (searchButton) {
            searchButton.click();
        }
    }

    // 모달 외부를 클릭하여 모달 닫기
    window.onclick = function (event) {
        if (event.target == modal) {
            closeModal();
        }
    };

    // 데이터를 가져와서 옵션들을 채움 (region.js 파일 사용)
    /*
    fetch('http://localhost:8090/foodexp/main')
        .then(response => response.json())
        .then(regionData => {
            localStorage.setItem('regionData', JSON.stringify(regionData));
            populateOptions(regionData); // 모달에 데이터 채우기
        })
        .catch(error => console.error('Error:', error));
    
    fetch('region.json')
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error fetching region.json:', error));
    */

});


function populateOptions(data) {
    const hArea1 = document.getElementById("h_area1");
    const hArea2 = document.getElementById("h_area2");
    const hArea3 = document.getElementById("h_area3");

    hArea1.innerHTML = '<option value="">-광역시도-</option>';
    hArea2.innerHTML = '<option value="">-시군구-</option>';
    hArea3.innerHTML = '<option value="">-읍면동-</option>';

    data.forEach(region => {
        const option1 = document.createElement('option');
        option1.value = region.h_area1;
        option1.textContent = region.h_area1;
        hArea1.appendChild(option1);
    });

    hArea1.addEventListener('change', function () {
        const selectedArea1 = this.value;
        const selectedAreaData = data.find(region => region.h_area1 === selectedArea1);
        hArea2.innerHTML = '<option value="">-시군구-</option>';
        hArea3.innerHTML = '<option value="">-읍면동-</option>';
        if (selectedAreaData) {
            selectedAreaData.h_area2.forEach(area2 => {
                const option2 = document.createElement('option');
                option2.value = area2;
                option2.textContent = area2;
                hArea2.appendChild(option2);
            });
        }
    });

    hArea2.addEventListener('change', function () {
        const selectedArea1 = hArea1.value;
        const selectedArea2 = this.value;
        const selectedAreaData = data.find(region => region.h_area1 === selectedArea1);
        const selectedArea2Data = selectedAreaData.h_area2.find(subArea => subArea === selectedArea2);
        hArea3.innerHTML = '<option value="">-읍면동-</option>';
        if (selectedArea2Data) {
            selectedArea2Data.h_area3.forEach(area3 => {
                const option3 = document.createElement('option');
                option3.value = area3;
                option3.textContent = area3;
                hArea3.appendChild(option3);
            });
        }
    });
}
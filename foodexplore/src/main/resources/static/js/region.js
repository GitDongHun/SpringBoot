//region_data.js 파일 불러오기
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

console.log("region.js 실행완료");

function populateOptions(region_data) {
    const hArea1 = document.getElementById("h_area1");
    const hArea2 = document.getElementById("h_area2");
    const hArea3 = document.getElementById("h_area3");

    hArea1.innerHTML = '<option value="">-광역시도-</option>';
    hArea2.innerHTML = '<option value="">-시군구-</option>';
    hArea3.innerHTML = '<option value="">-읍면동-</option>';

    region_data.forEach(region => {
        const option1 = document.createElement('option');
        option1.value = region.h_area1;
        option1.textContent = region.h_area1;
        hArea1.appendChild(option1);
    });

    hArea1.addEventListener('change', function () {
        const selectedArea1 = this.value;
        const selectedAreaData = region_data.find(region => region.h_area1 === selectedArea1);
        hArea2.innerHTML = '<option value="">-시군구-</option>';
        hArea3.innerHTML = '<option value="">-읍면동-</option>';
        if (selectedAreaData) {
            if (Array.isArray(selectedAreaData.h_area2)) {
                selectedAreaData.h_area2.forEach(area2 => {
                    const option2 = document.createElement('option');
                    option2.value = area2;
                    option2.textContent = area2;
                    hArea2.appendChild(option2);
                });
            } else {
                const option2 = document.createElement('option');
                option2.value = selectedAreaData.h_area2;
                option2.textContent = selectedAreaData.h_area2;
                hArea2.appendChild(option2);
            }
        }
    });

    hArea2.addEventListener('change', function () {
        const selectedArea1 = hArea1.value;
        const selectedArea2 = this.value;
        const selectedArea1Data = region_data.find(region => region.h_area1 === selectedArea1);

        if (selectedArea1Data) {
            let selectedArea2Data;
            if (Array.isArray(selectedArea1Data.h_area2)) {
                // h_area2가 배열인 경우
                selectedArea2Data = selectedArea1Data.h_area2.find(subArea => subArea.name === selectedArea2);
            } else {
                // h_area2가 배열이 아닌 경우
                selectedArea2Data = selectedArea1Data.h_area2;
            }

            hArea3.innerHTML = '<option value="">-읍면동-</option>';

            if (selectedArea2Data && Array.isArray(selectedArea2Data.h_area3)) {
                selectedArea2Data.h_area3.forEach(area3 => {
                    const option3 = document.createElement('option');
                    option3.value = area3;
                    option3.textContent = area3;
                    hArea3.appendChild(option3);
                });
            } else if (selectedArea2Data) {
                const option3 = document.createElement('option');
                option3.value = selectedArea2Data.h_area3;
                option3.textContent = selectedArea2Data.h_area3;
                hArea3.appendChild(option3);
            }
        }
    });

}

// 스크립트 실행
populateOptions(region_data);



/*
function populateOptions(region_data) {
    const hArea1 = document.getElementById("h_area1");
    const hArea2 = document.getElementById("h_area2");
    const hArea3 = document.getElementById("h_area3");

    hArea1.innerHTML = '<option value="">-광역시도-</option>';
    hArea2.innerHTML = '<option value="">-시군구-</option>';
    hArea3.innerHTML = '<option value="">-읍면동-</option>';

    region_data.forEach(region => {
        const option1 = document.createElement('option');
        option1.value = region.h_area1; // 'h_area1' 값 할당
        option1.textContent = region.h_area1; // 'h_area1' 텍스트 할당
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
                option2.value = area2; // 'h_area2' 값 할당
                option2.textContent = area2; // 'h_area2' 텍스트 할당
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
                option3.value = area3; // 'h_area3' 값 할당
                option3.textContent = area3; // 'h_area3' 텍스트 할당
                hArea3.appendChild(option3);
            });
        }
    });
}


*/
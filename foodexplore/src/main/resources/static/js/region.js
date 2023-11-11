document.addEventListener("DOMContentLoaded", function() {
    const storedData = localStorage.getItem('regionData');

    if (!storedData) {
        fetch('http://localhost:8090/foodexp/main')
            .then(response => response.json())
            .then(regionData => {
                localStorage.setItem('regionData', JSON.stringify(regionData));
                populateOptions(regionData); // 모달에 데이터 채우기
                console.log(regionData);
            })
            .catch(error => console.error('Error:', error));
    } else {
        const regionData = JSON.parse(storedData);
        populateOptions(regionData); // 저장된 데이터를 사용하여 모달에 데이터 채우기
        console.log(regionData);
    }
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

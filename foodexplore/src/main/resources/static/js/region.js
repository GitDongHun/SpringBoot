console.log("region.js 실행완료");
//region_data.js 파일 불러오기
fetch('/foodexp/region_data')
    .then(response => response.text())
    .then(scriptText => {
        // scriptText 변수에는 로드한 JavaScript 파일의 내용이 들어 있습니다.
        // 여기에서 scriptText를 실행하거나 다른 작업을 수행할 수 있습니다.
        // scriptText를 이 js내용에 포함시키고싶어 <<<<<<<<<<<
        eval(scriptText);
        populateOptions(region_data);
    })
    .catch(error => console.error('Script loading errrrrrrrror:', error));

function populateOptions(region_data) {
    // 셀렉트 박스 엘리먼트를 가져옵니다.
    const hArea1 = document.getElementById("h_area1");
    const hArea2 = document.getElementById("h_area2");
    const hArea3 = document.getElementById("h_area3");

    // 셀렉트 박스의 내용을 초기화합니다.
    hArea1.innerHTML = '<option value="">-광역시도-</option>';
    hArea2.innerHTML = '<option value="">-시군구-</option>';
    hArea3.innerHTML = '<option value="">-읍면동-</option>';

    // 광역시/도 목록을 가져와 중복을 제거한 후 각각의 셀렉트 박스에 추가합니다.
    const provinces = [...new Set(region_data.map(item => item.h_area1))];
    provinces.forEach(province => {
        const option = document.createElement("option");
        option.value = province;
        option.text = province;
        hArea1.appendChild(option);
    });

    // 광역시/도가 선택되면 해당 시/군/구 목록을 가져오도록 이벤트 리스너를 등록합니다.
    hArea1.addEventListener("change", function () {
        const selectedProvince = this.value;

        // 시/군/구 및 읍면동 목록을 초기화합니다.
        hArea2.innerHTML = '<option value="">-시군구-</option>';
        hArea3.innerHTML = '<option value="">-읍면동-</option>';

        // 선택된 광역시/도에 해당하는 시/군/구 목록을 가져와 중복을 제거한 후 각각의 셀렉트 박스에 추가합니다.
        const cities = region_data.filter(item => item.h_area1 === selectedProvince)
            .map(item => item.h_area2);
        const uniqueCities = [...new Set(cities)];

        uniqueCities.forEach(city => {
            const option = document.createElement("option");
            option.value = city;
            option.text = city;
            hArea2.appendChild(option);
        });
    });

    // 시/군/구가 선택되면 해당 읍면동 목록을 가져오도록 이벤트 리스너를 등록합니다.
    hArea2.addEventListener("change", function () {
        const selectedCity = this.value;

        // 읍면동 목록을 초기화합니다.
        hArea3.innerHTML = '<option value="">-읍면동-</option>';

        // 선택된 시/군/구에 해당하는 읍면동 목록을 가져와 중복을 제거한 후 각각의 셀렉트 박스에 추가합니다.
        const districts = region_data.filter(item => item.h_area2 === selectedCity)
            .map(item => item.h_area3)
            .flat(); // 중첩된 배열을 평탄화합니다.
        const uniqueDistricts = [...new Set(districts)];

        uniqueDistricts.forEach(district => {
            const option = document.createElement("option");
            option.value = district;
            option.text = district;
            hArea3.appendChild(option);
        });
    });
}


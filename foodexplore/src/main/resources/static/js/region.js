function loadRegionData() {
    fetch('/regions')
        .then(response => response.json())
        .then(data => {
            populateOptions(data);
        })
        .catch(error => console.error('Error:', error));
}


document.addEventListener("DOMContentLoaded", function() {
    loadRegionData();
});

function loadRegionData() {
    fetch('/regions')
        .then(response => response.json())
        .then(data => {
            populateOptions(data);
        })
        .catch(error => console.error('Error:', error));
}

function populateOptions(data) {
    const hArea1 = document.getElementById("h_area1");
    const hArea2 = document.getElementById("h_area2");
    const hArea3 = document.getElementById("h_area3");

    // Clear previous options
    hArea1.innerHTML = '<option value="">-광역시도-</option>';
    hArea2.innerHTML = '<option value="">-시군구-</option>';
    hArea3.innerHTML = '<option value="">-읍면동-</option>';

    data.forEach(region => {
        const option1 = document.createElement('option');
        option1.value = region.h_area1;
        option1.textContent = region.h_area1;
        hArea1.appendChild(option1);
    });

    hArea1.addEventListener('change', function() {
        const selectedArea1 = this.value;
        const area = data.find(region => region.h_area1 === selectedArea1);

        hArea2.innerHTML = '<option value="">-시군구-</option>';
        hArea3.innerHTML = '<option value="">-읍면동-</option>';

        area.h_area2.forEach(area2 => {
            const option2 = document.createElement('option');
            option2.value = area2;
            option2.textContent = area2;
            hArea2.appendChild(option2);
        });

        hArea2.removeEventListener('change', hArea2ChangeListener);

        hArea2.addEventListener('change', hArea2ChangeListener);
    });

    function hArea2ChangeListener() {
        const selectedArea2 = this.value;
        const area2 = area.h_area3.find(subArea => subArea === selectedArea2);

        hArea3.innerHTML = '<option value="">-읍면동-</option>';
        area2.h_area3.forEach(area3 => {
            const option3 = document.createElement('option');
            option3.value = area3;
            option3.textContent = area3;
            hArea3.appendChild(option3);
        });
    }

    hArea2.addEventListener('change', hArea2ChangeListener);
        });
    });
}

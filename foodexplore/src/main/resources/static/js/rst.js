// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
		level: 6
		// 지도의 확대 레벨
	};

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(map);

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({ zIndex: 1, disableAutoPan: true });

// 내위치
var myLocationMarker;

//내위치에 마커를 생성합니다
function myLocationMapView() {
	var onSuccess = function (position) {
		var my_lat = position.coords.latitude;
		var my_lng = position.coords.longitude;
		var myLocation = new kakao.maps.LatLng(my_lat, my_lng);

		// 이전 마커가 존재하는지 확인
		if (myLocationMarker) {
			// 이전 마커가 존재한다면 제거
			myLocationMarker.setMap(null);
		}

		// 새로운 현재 위치 마커 생성
		myLocationMarker = new kakao.maps.Marker({
			map: map,
			position: myLocation,
			title: '현재 위치'
		});

		// 지도 중심 및 확대 레벨 설정
		map.setCenter(myLocation);
		map.setLevel(6);

		// 이제 위치 정보가 준비되었으므로 검색을 시작
		//searchPlaces();
	};

	var onError = function (error) {
		console.error('내 위치 정보를 가져오는 데 실패했습니다.', error);

		// 위치 정보를 가져오지 못했을 때도 검색을 시작
		//searchPlaces();
	};

	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(onSuccess, onError);
	} else {
		console.error('브라우저가 Geolocation을 지원하지 않습니다.');

		// 위치 정보를 가져오지 못했을 때도 검색을 시작
		//searchPlaces();
	}
}




// 확대,축소,이동시 재검색할지 설정
var isWheel = false;
kakao.maps.event.addListener(map, 'idle', searchPlacesWheel);

// 키워드 검색을 요청하는 함수입니다
function searchFunction() {

	var keyword = document.getElementById('keyword').value;
	if (!keyword.replace(/^\s+|\s+$/g, '')) {
		return false;
	}

	// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
	ps.keywordSearch(keyword, placesSearchCB, { useMapBounds: true });
}
function searchPlaces() {
	isWheel = false;
	ps = new kakao.maps.services.Places();
	searchFunction();
}
function searchPlacesWheel() {
	if (document.getElementById("isCenter").checked) {
		isWheel = true;
		ps = new kakao.maps.services.Places(map);
		searchFunction();
	}
}

function searchPlaceMine() {
	isWheel = true;
	myLocationMapView();
	ps = new kakao.maps.services.Places(map);
	searchFunction();
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
	if (status === kakao.maps.services.Status.OK) {

		// 정상적으로 검색이 완료됐으면
		// 검색 목록과 마커를 표출합니다
		displayPlaces(data);

		// 페이지 번호를 표출합니다
		displayPagination(pagination);

	} else if (status === kakao.maps.services.Status.ZERO_RESULT) {
		return;

	} else if (status === kakao.maps.services.Status.ERROR) {
		return;
	}
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {
	var listEl = document.getElementById('placesList'),
		menuEl = document.getElementById('menu_wrap'),
		fragment = document.createDocumentFragment(),
		bounds = new kakao.maps.LatLngBounds(), listStr = '';

	// 검색 결과 목록에 추가된 항목들을 제거합니다
	removeAllChildNods(listEl);

	// 지도에 표시되고 있는 마커를 제거합니다
	removeMarker();
	for (var i = 0; i < places.length; i++) {

		// 마커를 생성하고 지도에 표시합니다
		var placePosition = new kakao.maps.LatLng(places[i].y,
			places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
				i, places[i]); // 검색 결과 항목 Element를 생성합니다

		// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
		// LatLngBounds 객체에 좌표를 추가합니다
		bounds.extend(placePosition);

		// 마커와 검색결과 항목에 mouseover 했을때
		// 해당 장소에 인포윈도우에 장소명을 표시합니다
		// mouseout 했을 때는 인포윈도우를 닫습니다
		(function (marker, title, i, placePosition) {
			kakao.maps.event.addListener(marker, 'mouseover',
				function () {
					displayInfowindow(marker, title);
				});

			kakao.maps.event.addListener(marker, 'mouseout',
				function () {
					infowindow.close();
				});

			itemEl.onmouseover = function () {
				displayInfowindow(marker, title);

			};

			itemEl.onmouseout = function () {
				infowindow.close();
			};
			itemEl.onclick = function () {
				map.setCenter(placePosition);
				map.setLevel(6);
			};

		})(marker, places[i].place_name, i, placePosition);

		fragment.appendChild(itemEl);
	}

	// 검색결과 항목들을 검색결과 목록 Element에 추가합니다
	listEl.appendChild(fragment);
	menuEl.scrollTop = 0;

	// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	if (!isWheel) {
		map.setBounds(bounds);
	}
}
/*

id					String		장소 ID		-> kakao   유니크 
place_name			String		장소명, 업체명
category_name		String		카테고리 이름
category_group_code	String		중요 카테고리만 그룹핑한 카테고리 그룹 코드
category_group_name	String		중요 카테고리만 그룹핑한 카테고리 그룹명
phone				String		전화번호
address_name		String		전체 지번 주소
road_address_name	String		전체 도로명 주소
x					String		X 좌표값, 경위도인 경우 longitude (경도)
y					String		Y 좌표값, 경위도인 경우 latitude(위도)
place_url			String		장소 상세페이지 URL
distance			String		중심좌표까지의 거리 (단, x,y 파라미터를 준 경우에만 존재)
								단위 meter
*/
// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {
	var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
		+ (index + 1)
		+ '"></span>'
		+ '<div class="info">'
		+ '   <h5>' + places.place_name + '</h5>'
		+ '   <h5>' + places.id + '</h5>'
		;

	if (places.road_address_name) {
		itemStr += '    <span>' + places.road_address_name + '</span>'
			+ '   <span class="jibun gray">' + places.address_name
			+ '</span>';
	} else {
		itemStr += '    <span>' + places.address_name + '</span>';
	}

	itemStr += '  <span class="tel">' + places.phone + '</span>'
		+ '</div>';

	el.innerHTML = itemStr;
	el.className = 'item';

	return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
	var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
		imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
		imgOptions = {
			spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
			spriteOrigin: new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
			offset: new kakao.maps.Point(13, 37)
			// 마커 좌표에 일치시킬 이미지 내에서의 좌표
		}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
			imgOptions), marker = new kakao.maps.Marker({
				position: position, // 마커의 위치
				image: markerImage
			});

	marker.setMap(map); // 지도 위에 마커를 표출합니다
	markers.push(marker); // 배열에 생성된 마커를 추가합니다

	return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}
	markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
	var paginationEl = document.getElementById('pagination'), fragment = document
		.createDocumentFragment(), i;

	// 기존에 추가된 페이지번호를 삭제합니다
	while (paginationEl.hasChildNodes()) {
		paginationEl.removeChild(paginationEl.lastChild);
	}

	for (i = 1; i <= pagination.last; i++) {
		var el = document.createElement('a');
		el.href = "#";
		el.innerHTML = i;

		if (i === pagination.current) {
			el.className = 'on';
		} else {
			el.onclick = (function (i) {
				return function () {
					pagination.gotoPage(i);
				}
			})(i);
		}

		fragment.appendChild(el);
	}
	paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
	var content = '<div style="width:auto;padding:5px;z-index:1;">' + title
		+ '</div>';

	infowindow.setContent(content);
	infowindow.open(map, marker);
}

// 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
	while (el.hasChildNodes()) {
		el.removeChild(el.lastChild);
	}
}
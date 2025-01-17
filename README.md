# SpringBoot 활용한 프로젝트 

## 프로젝트 팀원
- 팀장: 김동훈
- 팀원: 박서현, 신현빈, 이주안, 조민지

## 프로젝트 주제
**먹스플로어** - 위치정보 기반 주변 음식점 정보 제공 서비스 개발

## 프로젝트 수행 방향

### 개요
사용자 위치 기반의 음식점 정보를 제공하며, 음식점 리뷰를 이용하여 원하는 음식점의 정보를 공유할 수 있습니다. 즐겨찾기 기능을 통한 맞춤 음식점을 제공하고 즐겨찾기한 음식점들을 지도에서 보여주는 나만의 맛집 지도 페이지를 제공할 것입니다.

### 주요 기능
- 다양한 위치 기반 검색: 음식점 검색 결과 페이지에서 사용자의 현재 위치, 전국 어디든, 지도 범위를 기반으로 검색을 가능하게 하여 원하는 장소 어디에서든 검색 기능을 제공합니다.
- 나만의 맛집 지도: 한반도 지도 상에 사용자가 즐겨찾기한 음식점들을 먹스플로어 아이콘으로 표시하여, 나만의 맛집 지도를 만들 수 있는 서비스를 제공합니다.
- 사용자 리뷰 및 평가 기능: 사용자들이 음식점을 방문한 후 리뷰를 작성하고 평가할 수 있는 기능을 제공합니다.

## 프로젝트 수행 도구
- 언어: Java(JDK1.8), HTML, CSS, JavaScript
- 서버: Apache Tomcat 9.0
- 프레임워크: Spring Boot (Type: Maven, Java 8)
- DB: Oracle, NaverCloud
- IDE: Eclipse, SQL Developer
- 라이브러리: jQuery
- API: Kakao Maps API
- 협업: Notion, GitHub

## 프로젝트 목적
MZ세대는 음식을 먹는 행위를 통한 자기만족뿐만 아니라 맛집을 찾아서 줄을 서는 경험, 매장 내 인테리어 및 메뉴 구성에 관한 공유 문화 등이 결합한 복합적인 미식 문화를 형성하고 있습니다. 이 문화의 핵심은 자신만의 취향과 입맛이 확고한 고객들을 고려하여 메뉴 옵션을 다양하게 구성하는 데에 있습니다. 다양한 메뉴 옵션은 소비자들에게 더 많은 선택 폭을 제공하며, 이는 고객의 만족도를 높이고 더 자주 찾아오게끔 유도하는 효과를 가져오고 있습니다. 먹스플로어를 통해 다양한 음식 종류와 맛집 정보를 소개함으로써, 고객들은 자신만의 취향을 발견하고 즐길 수 있습니다.

### 프로젝트의 주요 목표
- **음식점 탐색 편의 제공**: 먹스플로어는 사용자들이 주변이나 원하는 지역의 다양한 음식점을 편리하게 찾을 수 있도록 합니다. 위치 기반 정보와 함께 음식점의 종류, 평점, 리뷰 등을 제공하여 선택을 도와줍니다.
- **다양한 음식 경험 제공**: 먹스플로어는 다양한 음식 종류와 스타일의 음식점을 소개함으로써 사용자들이 새로운 음식을 발견하고 즐길 수 있는 기회를 제공합니다.
- **사용자 리뷰와 평가 제공**: 사용자들이 음식점을 방문한 후 리뷰와 평가를 남길 수 있도록 함으로써, 다른 이용자들이 해당 음식점에 대한 정보를 신뢰성 있게 얻을 수 있습니다.
- **지역 경제 활성화**: 먹스플로어는 지역의 다양한 음식점을 홍보하여 해당 지역의 경제를 활성화할 수 있습니다.

## 필수 기능
- 회원 가입 및 로그인: 데이터베이스를 이용해 사용자 정보를 관리합니다.
- 아이디/비번 찾기: STMP Gmail을 이용해 아이디/비번 찾기 기능을 제공합니다.
- 다양한 위치 기반 검색: 음식점 검색 결과 페이지에서 사용자의 현재 위치, 전국 어디든, 지도 범위를 기반으로 검색을 가능하게 하여 원하는 장소 어디에서든 검색 기능을 제공합니다.
- 사용자 리뷰 및 평가 기능: 사용자들이 음식점을 방문한 후 리뷰를 작성하고 평가할 수 있는 기능을 제공합니다.
- 파일 업로드: NCP Object Storage를 이용하여 파일 업로드 기능을 제공합니다.
- 나만의 맛집 지도: 한반도 지도 상에 사용자가 즐겨찾기한 음식점들을 먹스플로어 아이콘으로 표시하여, 나만의 맛집 지도를 만들 수 있는 서비스를 제공합니다.
- 즐겨찾기 기능: 사용자가 자주 방문하거나 특별히 관심 있는 음식점을 즐겨찾기에 추가할 수 있는 기능을 제공합니다.
- 전국 Top10: 메인 화면에서는 여러 사용자의 평점순으로 나열한 Top10의 음식점을 제공하여 우선 추천합니다.
- 메뉴 카테고리화: 음식 종류에 따른 분류로 카테고리를 나눠서 원하는 음식에 대한 식당 명단을 손쉽게 볼 수 있다.

## 포함 기술
- Spring MVC 구조를 사용한 웹페이지 구성
- Mybatis를 이용하여 웹서버와 DB 간 연동
- GitHub를 이용한 협업 및 버전 관리
- Thymeleaf를 이용한 화면 처리 및 동적 웹 페이지 구성
- 리뷰 사진을 위한 Object Storage 파일 업로드
- Kakao Map API와 검색 API를 이용한 주변 식당 정보 표시

## 발표PPT
![Image](https://github.com/user-attachments/assets/ea0c0ccd-0158-4e83-936e-823d77375de8)
![Image](https://github.com/user-attachments/assets/771881f5-a69d-44b7-9648-39ee0e96f093)
![Image](https://github.com/user-attachments/assets/113d2eba-b7a3-49d4-bc25-8297178decf9)
![Image](https://github.com/user-attachments/assets/3d1cf9c7-6a76-4495-a564-8e407c5e56da)
![Image](https://github.com/user-attachments/assets/d1362db1-305b-4152-b9b9-c29809da693f)
![Image](https://github.com/user-attachments/assets/a0f3a8fe-6907-4d51-860b-b63b5f979ad5)
![Image](https://github.com/user-attachments/assets/14c02b54-42e9-4a0e-8e89-9cb40a122ae5)
![Image](https://github.com/user-attachments/assets/b7c3f6fb-3d7b-4682-9ba0-90fdad2bd1a4)
![Image](https://github.com/user-attachments/assets/e67a10b7-437b-4b46-a343-c9d28fc278a1)
![Image](https://github.com/user-attachments/assets/d3a65873-e776-47d6-92b2-a268e2550138)
![Image](https://github.com/user-attachments/assets/efba4548-788f-4243-ba06-1c9f7ec0601f)
![Image](https://github.com/user-attachments/assets/96cd279f-bbcc-4991-b904-310c2f346a07)
![Image](https://github.com/user-attachments/assets/ed7a4501-401b-46e5-a9c7-c2ba3c0c8a55)
![Image](https://github.com/user-attachments/assets/442fe349-b9ce-4850-9411-0e38b57b5987)
![Image](https://github.com/user-attachments/assets/87f826ce-1bdc-4526-abac-46ed65be181f)
![Image](https://github.com/user-attachments/assets/e3639f47-cf7f-46e9-8e5c-a2065974d9ea)
![Image](https://github.com/user-attachments/assets/7a294af1-1710-411b-9bb8-b859d3815594)
![Image](https://github.com/user-attachments/assets/f02022aa-c5e0-47ff-a3ac-313fff5ab2dc)
![Image](https://github.com/user-attachments/assets/a1f19d0b-3ebc-428c-a440-fb9e9e504b49)
![Image](https://github.com/user-attachments/assets/13697067-f7ff-4efd-8cdf-5446d943bde6)
![Image](https://github.com/user-attachments/assets/71bbe104-6af8-4e20-821b-a0ecd7b42a04)
![Image](https://github.com/user-attachments/assets/25434dc3-f522-4dd7-82be-cd2bb9b9b967)
![Image](https://github.com/user-attachments/assets/28c5a786-1e37-48c3-8e73-c05474d9bf7b)
![Image](https://github.com/user-attachments/assets/81d3bd0e-c703-4c3b-b969-6d79a86bfeb4)
![Image](https://github.com/user-attachments/assets/16747856-61a1-43a5-baaa-9b7b725e36a1)
![Image](https://github.com/user-attachments/assets/aefb0bf8-85c6-4554-85cd-42f48e75b973)
![Image](https://github.com/user-attachments/assets/2ce67874-7b61-4fcc-9d32-60ce325072bd)

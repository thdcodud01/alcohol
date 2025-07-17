# 🥃 Spirits - 위스키 정보 커뮤니티 & 관리자 대시보드

**Spirits**는 다양한 위스키 제품 정보와 사용자 리뷰를 공유하고, 관리자가 제품/회원/리뷰를 효율적으로 관리할 수 있도록 설계된 위스키 중심 커뮤니티 웹 서비스입니다.

---

## 📌 프로젝트 개요

- **프로젝트명**: Sprits
- **개발 기간**: 2023.07 ~ 2023.08 (약 1개월)
- **참여 인원**: 총 4명 (FE 2명, BE 2명)
- **기획 목표**: 주류 입문자도 쉽게 다양한 주류 정보를 탐색할 수 있도록, 사용자 맞춤형 추천 기능과 정보 제공을 동시에 구현

---

## 📌 목차
- [🛠 기술 스택](#-기술-스택)
- [💡 서비스 주요 기능](#-서비스-주요-기능)
- [🧾 페이지 구성](#-페이지-구성)
- [🛠 관리자 대시보드](#-관리자-대시보드)
- [📁 프로젝트 구조](#-프로젝트-구조)
- [🤝 협업 방식](#-협업-방식)
- [🧯 트러블슈팅 및 회고](#-트러블슈팅-및-회고)

---

## 🛠 기술 스택

| 분류 | 기술 |
|------|------|
| Backend | Java 17, Spring Boot, JPA |
| Frontend | Thymeleaf, HTML/CSS, JavaScript |
| DB | MySQL |
| 인증 | Spring Security, kakao OAuth2 |
| 메일 | Gmail SMTP 연동 |
| 배포 | Docker, AWS EC2 (Ubuntu), GitHub Actions |

---

## 💡 서비스 주요 기능

### 👥 사용자 기능
- 일반 회원가입 / 로그인 / OAuth2 로그인(kakao)
- 제품 리스트 조회 및 상세페이지 열람
- 리뷰 작성, 수정, 삭제
- 마이페이지: 내 리뷰 관리

### 🧑‍💼 관리자 기능
- 제품 등록 / 수정 / 삭제
- 회원 정보 확인 및 삭제
- 리뷰 삭제
- 수정/삭제 시 확인 알림창 표시

---

## 🧾 페이지 구성

### 📦 메인 페이지
- 제품 리스트 및 필터 기능
- 가격/도수/국가/캐스크/향 등 기준별 필터링 제공
- 검색 기능

### 🔍 제품 상세 페이지
- 제품 이미지, 설명, 원산지, 도수, 향 등 상세 정보 제공
- 리뷰 목록 출력

### ✍ 리뷰 작성 폼
- 유효성 검증 및 리턴 메시지 출력
- 리뷰 수정 및 삭제

### 🧑‍💻 마이페이지
- 내가 쓴 리뷰, 회원 정보 열람
- 회원탈퇴 기능 (관리자만)

---

## 🛠 관리자 대시보드

> 주소: `/admin/page`

### ✅ 기능 구성

#### 📦 Product Management
- **Add Product**: 제품 등록 페이지 이동
- **Edit 버튼**: 수정 폼으로 이동  
- **Delete 버튼**: 삭제 확인 후 제품 제거

![Product Management](<제품관리 스크린샷 링크>)

#### 💬 Review Management
- 리뷰 리스트 출력
- **Delete 버튼**: 리뷰 삭제

![Review Management](<리뷰관리 스크린샷 링크>)

#### 👥 User Management
- 가입된 유저 정보 출력
- **Delete 버튼**: 회원 탈퇴 처리

![User Management](<유저관리 스크린샷 링크>)

> ✳️ Edit 클릭 시 확인 창: “정말로 수정하시겠습니까?”

![Edit 확인창](<Edit 확인창 이미지 링크>)

#### 📝 제품 등록/수정 화면
- 필수 정보 입력
- 복수 선택 가능한 태그형 필드 (향, 캐스크 등)
- 파일 업로드 필드 포함

![제품 등록폼](<제품등록 폼 이미지 링크>)

---

## 🚀 주요 기능

### 👤 사용자 인증
- 회원가입 및 로그인
- 이메일 인증 (SMTP)
- 세션 기반 로그인 유지

### 🥃 주류 탐색 및 추천
- 카테고리 기반 Ajax 필터링
- 키워드 기반 검색 기능
- 유저 맞춤형 주류 추천 알고리즘 적용

### 🧾 상세 페이지
- 주류 상세 설명 및 이미지 제공
- 유사 주류 추천 리스트 함께 노출

### 🛠️ 백엔드 담당 역할
- ERD 설계 및 JPA 매핑
- 게시판, 상품, 회원 관련 CRUD API 구현
- 이미지 업로드 기능 개발
- AWS Lightsail 및 RDS 기반 서비스 배포

---

## 🗂️ ERD 및 구조

> ERD 예시 이미지 삽입 (혹은 DB 설계 요약 표 작성)

![ERD](./assets/erd_sprits.png)

---

## 📸 주요 UI

| 화면 | 설명 |
|------|------|
| ![Login](./assets/sprits_login.png) | 로그인 및 인증 |
| ![Main](./assets/sprits_main.png) | 메인 화면 |
| ![Recommend](./assets/sprits_recommend.png) | 추천 결과 페이지 |
| ![Detail](./assets/sprits_detail.png) | 주류 상세 페이지 |
| ![Category](./assets/sprits_category.png) | 카테고리 필터링 화면 |
| ![Signup](./assets/sprits_signup.png) | 회원가입 화면 |
| ![Email](./assets/sprits_email.png) | 이메일 인증 UI |
| ![Upload](./assets/sprits_upload.png) | 이미지 업로드 페이지 |

---

## 🐛 Trouble Shooting

### 🔐 Spring Security + 세션 인증 문제 해결
- 로그인 유지 안 되는 문제 → 세션 설정 및 필터 정리
- 인증 실패 로그 분석 및 예외 처리 핸들링

### 🔄 비동기 Ajax 통신 오류
- CORS 관련 문제 해결
- Controller 매핑 경로 및 응답 객체 구조 수정

---

## 💬 느낀 점

> 사용자 관점에서 필요한 기능이 무엇인지 고민하고,  
> 백엔드 전반을 직접 구성하며 웹 서비스 전체 흐름을 실무처럼 경험했습니다.  
> 특히, **AWS 배포 경험**과 **비동기 요청 처리**, **세션 인증 처리** 등  
> 백엔드의 실질적인 핵심 기술을 체득하는 계기가 되었습니다.

---

## 📎 참고 링크

| 구분 | 링크 |
|------|------|
| 🔗 GitHub | [https://github.com/thdcodud01/sprits](https://github.com/thdcodud01/sprits) |
| 🧾 Notion 화면 구성 | [https://shocking-tadpole-c28.notion.site/d8637b6ef4794891b633ab96844c0d6d](https://shocking-tadpole-c28.notion.site/d8637b6ef4794891b633ab96844c0d6d) |
| 📄 발표자료 | [Google Drive Link](https://drive.google.com/) |
| 🧑‍💻 기술 문서 (Wiken 등) | [Wiken Page Link](https://wiken.io/) |

---

## ⚙️ 실행 방법

```bash
# clone repository
git

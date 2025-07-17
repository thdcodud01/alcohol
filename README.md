# 🍶 Sprits – 사용자 맞춤 주류 추천 플랫폼

> **카테고리 기반 탐색 + 개인 맞춤 주류 추천 기능**을 갖춘  
> **초보자 친화형 주류 정보 플랫폼**

---

## 📌 프로젝트 개요

- **프로젝트명**: Sprits
- **개발 기간**: 2023.07 ~ 2023.08 (약 1개월)
- **참여 인원**: 총 4명 (FE 2명, BE 2명)
- **기획 목표**: 주류 입문자도 쉽게 다양한 주류 정보를 탐색할 수 있도록, 사용자 맞춤형 추천 기능과 정보 제공을 동시에 구현

---

## 🔧 기술 스택

| 분야 | 기술 |
|------|------|
| Language | Java, HTML/CSS |
| Backend | Spring Boot, JPA |
| DB | MariaDB |
| Frontend | Thymeleaf, Bootstrap |
| Infra | AWS Lightsail, RDS |
| Tools | Git, GitHub, Notion |

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

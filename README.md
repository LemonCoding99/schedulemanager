# Schedule Manager  

## 1. 프로젝트 소개(OverView)
이 프로젝트는 java17을 사용하여 필수기능과 도전기능으로 기능을 확장하며 발전시킨 일정 관리 앱 입니다.  
현재 문서는 필수기능까지를 기준으로 작성되었으며. 클래스를 활용하여 제작되었습니다.  
필수 기능에서는 기본적인 일정 생성, 일정 조회, 일정 수정, 일정삭제 기능을 수행할 수 있습니다.  
도전 기능에서는 댓글을 생성하고 일정단건 조회를 댓글을 포함하여 응답하도록 업그레이드시키고 유저의 입력에대한 검증을 수행하는 기능이 추가됩니다.

## 2. 개발 기간(Period)
2025.11/04~2025/11/06

## 3. 개발 환경(Environment)
- 개발 언어: Java
- Jdk 버전: 17
- IntelliJ IDEA, POSTMAN

## 4. 구현한 기능(Feature)
### 1) 필수 기능
|기능|구현내용|
|----|--------|
|일정 생성|사용자가 입력한 일정의 제목, 내용, 이름, 비밀번호를 입력받고 저장합니다.|
|일정 전체조회| 입력된 일정을 전체 조회합니다. 조회시 비밀번호는 포함되지 않으며 작성한 시간, 수정한 시간이 추가되어 수정일 기준 내림차순으로 조회됩니다. 이름을 추가로 입력할 경우 해당 이름의 일정만 조회됩니다.
|일정 단건조회|사용자가 입력한 Id값을 기준으로 일정을 조회합니다.|
|일정 수정| 사용자가 입력한 Id값의 일정을 수정합니다. 제목, 작성자명만 수정할 수 있습니다.|
|일정 삭제| 사용자가 입력한 Id값의 일정을 삭제합니다.|


### 2) 도전 기능
|기능|구현내용|
|----|--------|
추후 추가예정


## 5. 프로젝트 구조(Project Structure)
<img width="615" height="571" alt="image" src="https://github.com/user-attachments/assets/efd406d5-d106-4f6f-8a33-d8e2301f576d" />

## 6. 사용 방법(Usage)
1) IntelliJ IDEA를 실행합니다.
2) 프로젝트 폴더(schedulemanager)를 엽니다.
3) 우측 상단의 'RUN'버튼을 클릭하여 실행합니다.
4) POSTMAN에서 8080 포트의 로컬주소를 입력합니다. (http://localhost:8080/schedules)
   |기능|포스트맨 입력방법|
   |----|----------------|
   |일정 생성|POST를 선택하고 http://localhost:8080/schedules 입력 후 body에 입력 후 실행|
   |일정 전체조회|GET을 선택하고 http://localhost:8080/schedules 입력 후 실행|
   |일정 이름별 전체조회|GET을 선택하고 http://localhost:8080/schedules?이름 입력 후 실행|
   |일정 단건조회| GET을 선택하고 http://localhost:8080/schedules/id번호 입력 후 실행|
   |일정 수정| PUT을 선택하고 http://localhost:8080/schedules/id번호 입력 후 body에 수정하려는 내용 입력 후 실행
   |일정 삭제| DELETE을 선택하고 http://localhost:8080/schedules/id번호 입력 후 실행|

## 7. 구현 예시(Example)
API 명세서에서 확인 가능합니다.
https://documenter.getpostman.com/view/40951575/2sB3WquLbP

ERD 구조  
<img width="628" height="332" alt="image" src="https://github.com/user-attachments/assets/eaf7f6b2-349d-409c-8d7f-62eeece43f82" />




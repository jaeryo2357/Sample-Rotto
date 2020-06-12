# LottoLike

## 배포 버전 
 * **2.1**  -  2020/01/30
 * **3.4**  -  2020/04/11

### 3.4 기능

  * 로또 번호 추첨
  
  * ~~로또 회차별 당첨번호 확인~~
  
  * ~~지금까지 나온 번호 중 **순위 집산**~~
  
  * 매주 번호목록 등수 계산
     1. SQLite를 사용하여 매주 추첨 번호 저장/ 계산
 
  * QR코드 인식
  
  * ~~매주 알람 기능**~~
     1. AlarmManger로 구현
     2. 기기 별로 알람이 취소되는 현상 생김
    
### 3.4 Bug

  * 로또 회차를 가져오는 Api의 인증서 만료로 앱의 로직이 꼬임
  
  * 기기 별 알람이 불 규칙하므로 오류 발생

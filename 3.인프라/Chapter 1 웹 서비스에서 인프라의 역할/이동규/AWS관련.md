## AWS S3 vs EBS vs EFS

1. [Amazon Simple Storage Service(S3)클라우드에서의 확장 가능한 스토리지](https://aws.amazon.com/ko/s3/?nc2=h_m1)
	- Amazon S3는 객체 저장소이며 사용자 파일 및 백업을 대량으로 저장하는 데 적합
	- 데이터를 계층 구조 없이 객체로 저장
	- Amazon S3의 객체는 고유 한 식별자 (키)와 연결되어 어디서나 웹 요청을 통해 액세스 할 수 있음
	- EBS 및 EFS보다 느림
	- 백업 저장에 적합
***Amazon S3는 확장 가능하고 내구성과 가용성이 높으며 공개적으로 액세스 할 수있는 데이터 저장소***
2. [Amazon Elastic Block Store(EBS)EC2 블록 스토리지 볼륨](https://aws.amazon.com/ko/ebs/?nc2=h_m1)
	- Amazon EBS는 가상 시스템의 드라이브 용 저장소
	- 데이터를 동일한 크기의 블록으로 저장하고 기존 파일 시스템과 유사한 계층을 통해 구성
	- EBS는 Amazon S3와 같은 **독립형 스토리지** 서비스가 아니라 Amazon EC2와 함께 사용.
	- Amazon EBS는 다른 EC2 인스턴스에만 볼륨을 연결
	- S3와 EFS보다 빠름
	- Amazon EBS에는 세 가지 유형의 볼륨이 있음.
	- 1. 범용 (SSD) 볼륨 
-- SQL 또는 Oracle 데이터베이스와 같은 많은 읽기 및 쓰기 작업에 적절
	- 2. 프로비저닝 된 IOPS (SSD) 볼륨 
-- 볼륨 용량에 관계없이 요청시 읽기 / 쓰기 작업을 구매
	- 3. 자기 볼륨(HDD) 
-- Amazon EC2의 테스트 및 개발 환경에서 사용할 수있는 저렴한 비용의 볼륨 

4. [Amazon Elastic File System(EFS)EC2를 위한 완전관리형 파일 시스템](https://aws.amazon.com/ko/efs/?nc2=h_m1)
	
	- EC2 사용자에게 확장 가능한 스토리지를 제공(마운트)
	- 확장성이 뛰어난 저장소와 비교적 빠른 출력이 필요한 응용 프로그램에 적합
	- Amazon EFS는 자동으로 확장 가능
	- S3보다 빠르며 EBS보다 느림
	

## Route53

- AWS에서 제공하는 DNS 웹서비스

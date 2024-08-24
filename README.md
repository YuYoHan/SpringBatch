# Spring Batch

Spring Batch는 대량의 데이터 처리를 위한 경량화된 프레임워크로, 반복적인 작업을 수행하는 일괄 처리(Batch Processing) 작업을 효율적으로 처리할 수 있는 기능을 제공한다. 대용량 데이터 처리나 주기적인 업무 처리 등을 효율적으로 처리할 수 있고, 대용량 데이터 처리에 적합한 분산 방식의 처리를 지원한다.

## Spring Batch의 특징
Spring Batch는 많은 양의 데이터를 효율적으로 처리할 수 있으며, 다양한 기능을 제공한다. 대용량 데이터 처리, 트랜잭션 관리, 재시도 기능 등이 이에 해당된다.

### 대용량 데이터 처리
Spring Batch는 방대한 양의 데이터를 처리할 수 있다. 데이터 처리 작업을 분산 처리할 수 있어서, 대용량 데이터 처리에 적합하다.

### 트랜잭션 관리
Spring Batch는 트랜잭션 관리를 지원한다. 데이터 처리 중 실패한 작업은 롤백하여 데이터 일관성을 유지할 수 있다.

### 재시도 기능
Spring Batch는 작업 중 실패한 경우, 작업을 재시도할 수 있는 기능을 제공한다. 또한, 재시도 횟수를 설정할 수 있다.

## Spring Batch 실사례
Spring Batch를 사용하면 이전에는 수동으로 처리했던 작업을 자동화할 수 있다. 예를 들어, 한 고객이 매일 수천 건의 주문을 입력하는 경우, 이러한 주문 데이터를 처리하는 일괄 처리 작업을 자동화할 수 있다. 이를 위해 Spring Batch를 사용하여 데이터를 일괄 처리하고, 처리 결과를 데이터베이스에 저장할 수 있다. 이를 통해 데이터 처리 시간과 인력 비용을 절약할 수 있다.

또한, Spring Batch를 사용하여 대용량 데이터를 처리하는 경우, 데이터 처리 작업을 분산 처리할 수 있어서 데이터 처리 시간을 대폭 줄일 수 있다. 예를 들어, 수백만 건의 데이터를 처리해야 하는 경우, 이러한 데이터를 처리하는 데에는 많은 시간이 소요된다. 그러나 Spring Batch를 사용하여 데이터 처리 작업을 분산 처리하면, 데이터 처리 시간을 대폭 줄일 수 있다.

### 예시
Spring Batch를 사용하여 오전 10시에 실행하는 배치작업을 구현하는 프로젝트를 만들어보자.
- Spring Batch 프로젝트를 생성. 이때, Spring Boot를 사용하여 프로젝트를 생성하면 편리하다.
- 배치 작업을 처리하는 Step을 구현. 이때, Tasklet 혹은 Chunk 방식을 선택하여 구현할 수 있다.
  - Tasklet 방식은 하나의 트랜잭션에서 수행하는 단순한 작업을 의미. 예를 들어, 파일을 읽어서 데이터를 처리하는 작업을 수행할 수 있다.
  - Chunk 방식은 트랜잭션 범위 내에서 Chunk 단위로 데이터를 읽어 처리하는 방식이다. 예를 들어, 대량의 데이터를 처리하는 작업을 수행할 수 있다.
- Step을 구현한 후에는 Job을 구현. Job은 하나 이상의 Step을 가지며, 하나의 배치 작업을 나타낸다. Job을 실행하기 위해서는 JobLauncher를 통해 Job을 실행해야 한다.
- 배치 작업을 실행하는 스케줄러를 구현. Spring에서는 Quartz 스케줄러를 사용하여 스케줄링 작업을 수행할 수 있다. Spring Batch 프로젝트를 사용하면, 매일 오전 10시에 배치 작업을 자동으로 실행할 수 있다.

---
# 블로그
[스프링 배치](https://velog.io/@zxzz45/series/Spring-Batch) <br/>
[노션](https://www.notion.so/Spring-Batch-f4d7ba194de445759d9aa1408fa203a6)

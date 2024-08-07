
# Drathing (Draw + Thing)

사용자에게 랜덤하게 주제를 할당하고 해당 주제에 대한 그림을 그려서 업로드하는 웹 사이트 


작업기간: 2023.11.01 ~ 2023.12.31


기획 의도: 기본서 완독 및 기초 강의를 수료한 후 CRUD programing을 연습하기 위해, 제가 좋아하는 그림과 관련된 웹 사이트를 제작하게 되었습니다. &nbsp;

----
### 사용 기술

STS3, JSP, HTML5, CSS3, MySQL, MyBatis, JavaScript , AWS 

---


### 주요 기능 

:one: 랜덤 주제 할당: 사용자에게 랜덤하게 주제를 할당합니다. 할당된 주제는 사용자가 그림을 그릴 내용을 결정하는 데 도움이 됩니다.

:two: 그림 그리기: 할당된 주제에 대해서 간단한 그리기 도구와 색상 팔레트를 사용하여 그림을 작성할 수 있습니다.&nbsp;

3️⃣ 그림 업로드: 그림을 완성한 후 사용자는 해당 그림을 업로드할 수 있습니다. 업로드한 그림은 다른 사용자들에게 공개됩니다. &nbsp;

:four: 사용자 간 상호작용: 사용자들은 서로의 그림을 볼 수 있고, 좋아요를 누르거나 댓글을 달아 다른 사용자들과 소통할 수 있습니다.&nbsp;

----

### 시연 영상

<img src="https://github.com/gahuileeee/drathing/assets/141610403/2ab1d247-8ccd-4dab-9c83-092e9f73b5a5" width="700px">

---


### 프로젝트를 통해 학습하게 된 내용

✏️user가 로그인을 하면 Cookie에 이를 저장하여 관리하였습니다. 그리고 user가 로그인을 요청할 때, 요청 page 를 session 에 저장하여 redirect를 관리하였습니다.&nbsp;
이를 통해 cookie와 session 개념을 익힐 수 있었습니다. 또한 아무 값이나 session에 저장하게 되면 server 부담이 늘어나게 되니, &nbsp;
어느 시점에서 session을 시작하고, 어떻게 종료하면 좋을지를 생각하며 session 관리의 중요성을 알 수 있었습니다. &nbsp;

✏️기본 CRUD programing을 학습할 수 있었습니다. 처음에는 요령 없이 순수 JDBC 만으로 작업을 하였습니다. connection을 난발하고 이를 close 하지 않아 프로그램이 여러 차례 종료되기도 하였으나, 오히려 그래서 기본 원리를 학습할 수 있었습니다. 그 이후 프로젝트를 완성한 후 method에 하드코딩 했던 JDBC connection code를 method화 하여 클린 코드로 향상시키는 법과, myBatis를 학습한 후 이 프로젝트에 적용하여 기존 프로그램에 새로운 기술을 접목하는 법을 배울 수 있었습니다.

✏️개발 기초를 이해하게 되었습니다. 사실 기초 강의를 듣기만 하였을 때는 MVC 패턴도 제건 어렵기만 하였습니다. &nbsp;
하지만 controller에 요청주소를 보내면, 올바른 view를 보내는 것부터 시작하여 점차 model을 통해 controller와 view에서 data를 주고받으며 MVC 패턴을 이해할 수 있었습니다. &nbsp;
뿐만 아니라 여러 error들을 마주하며, 기본적으로 clean&rebuild 하는 법과 console을 찍어 method 흐름을 확인하는 법, context root , port 등 개발에 필요한 기초 사항들을  &nbsp;
자연스럽게 접하고 이해할 수 있었습니다. 처음에는 오류가 생기면 당황스러웠지만, 이제는 차분히 오류 메세지를 읽어가며 오류가 야기된 코드를 찾거나, 찍은 log를 바탕으로 &nbsp;
오류 method를 발견하고 고칠 수 있게 되었습니다. &nbsp;

✏️Canvas.js를 사용할 수 있게 되었습니다. 그림 그리기 구현을 Canvas.js로 구현하였는데, 처음에는 겨우 기본 코드만 프로젝트에 적용할 수 있었습니다. &nbsp;
하지만 프로젝트를 지속하며 코드 해석력이 향상되었고, Canvas.js의 기본 코드를 분석하여 나중에는 검은선을 그리는 것이 아닌 색을 바꾸고, 크기를 조절하고, 지우개 기능까지 넣을 수 있었습니다.  &nbsp;
이 경험으로 앞으로 다른 api 등을 사용할 때 프로젝트에 적용하고 응용하는 능력이 향상 될 것으로 기대됩니다.  &nbsp;



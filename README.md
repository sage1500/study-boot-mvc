# study-boot-mvc

Spring Boot + Spring MVC + Thymeleaf によるサンプルアプリケーションを作成する。

## 参考

### Macchinetta
Spring Boot を使っていないが、
大部分は Macchinetta Server Framework の Thymeleaf版のガイドラインが参考になる。

- Macchinetta Server Framework (1.x) Development Guideline
    - https://macchinetta.github.io/server-guideline-thymeleaf/current/ja/

なお、内容的には TERASOLUNA Server Framework のガイドラインと同じ内容である。
TERASOLUNA の方は JSP にため、Macchinetta の方が参考になる部分が多い。

- TERASOLUNA Server Framework for Java (5.x) Development Guideline
    - http://terasolunaorg.github.io/guideline/5.7.0.RELEASE/ja/index.html

特に参考にする章。

- 2.1. Macchinetta Server Framework (1.x)のスタック
- 2.2. Spring MVCアーキテクチャ概要
- 2.3. はじめてのSpring MVCアプリケーション
- 2.4. アプリケーションのレイヤ化
- 3.2. ドメイン層の実装
- 3.3. インフラストラクチャ層の実装
- 3.4. アプリケーション層の実装
- 4.1. テンプレートエンジン(Thymeleaf)
- 4.x. ※上記から参照されている各章

## TODO
1. 実装
	1. コードリスト

## メモ

- 3.4.1.3.3. リクエストとハンドラメソッドのマッピング
    - https://macchinetta.github.io/server-guideline-thymeleaf/current/ja/ImplementationAtEachLayer/ApplicationLayer.html#controller-mapping-policy-sampleapp-mapping-design-label    
- 4.7. メッセージ管理
    - https://macchinetta.github.io/server-guideline-thymeleaf/current/ja/ArchitectureInDetail/WebApplicationDetail/MessageManagement.html
- 4.12. Thymeleafにおける画面レイアウト
    - https://macchinetta.github.io/server-guideline-thymeleaf/current/ja/ArchitectureInDetail/WebApplicationDetail/TemplateLayout.html


## 起動方法
- production での起動例
    ```
    > java -jar .\modules\demo-web\target\demo-web-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
    ```

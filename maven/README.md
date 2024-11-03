# 安装maven

 ```js
// maven
// 下载完之后解压,设置环境变量
    MAVEN_HOME = D:\Program Files\apache-maven-3.6.3

    %MAVEN_HOME%\bin;
    
    
    
// 验证是否安装成功
    mvn -v

// 修改maven本地仓库地址
    <localRepository>E:\apache-maven-3.8.6\repository</localRepository>


// 配置阿里云镜像

<!-- 阿里云仓库 -->
<mirror>
    <id>aliyunmaven</id>
    <mirrorOf>central</mirrorOf>
    <name>阿里云公共仓库</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>



// 在下方 设置jdk
<!-- java版本 -->
<profile>
    <id>jdk-1.8</id>
    <activation>
        <activeByDefault>true</activeByDefault>
        <jdk>1.8</jdk>
    </activation>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
    </properties>
</profile>


// 配置完成，win+R运行cmd，输入 mvn help:system 测试，配置成功则本地仓库会出现下载的jar包


```

# 安装 tomcat

```js
// 下载zip
// 解压之后
// 配置环境变量
CATALINA_HOME
// path
%MAVEN_HOME%\bin;


```

# 安装IDEA配置maven

```js

```




pipeline {
    agent any

    stages {
        stage('pull code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'd24b95e3-5437-447b-b3c1-810b03e91ccf', url: 'git@github.com:Wenxiuheng/web-test.git']]])
            }
        }
        stage('checking code') {
            steps {
                script {
                    // 引入sonarqube-scanner工具
                    scannerHome = tool 'sonar-scanner-4.5.0.2216-linux'
                }
                // 引入sonarqube的服务器环境
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
        stage('bulid code') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
    post {
      always {
        emailext (
            subject: '构建通知：${PROJECT_NAME} - Build # ${BUILD_NUMBER} - ${BUILD_STATUS}!',
            body: '${FILE,path="email.html"}',
            to: '632989681@qq.com,wenxiuheng_0716@163.com'
        )
      }
    }
}
